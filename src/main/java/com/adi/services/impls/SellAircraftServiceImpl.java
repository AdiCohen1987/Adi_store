package com.adi.services.impls;

import com.adi.configuration.errorHandling.BadRequestException;
import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.dataModel.impl.SellAircraftDataModelImpl;
import com.adi.dataModel.interfaces.SellAircraftDataModel;
import com.adi.persistence.AirlineRepositoryGateway;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.repo.AirlineAircarftsRepository;
import com.adi.services.interfaces.SellAircraftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.*;

@Service
public class SellAircraftServiceImpl implements SellAircraftService {

    @Autowired
    private AirlineRepositoryGateway airlineRepositoryGateway;

    @Autowired
    private AirlineAircarftsRepository airlineAircarftsRepository;

    final static double PRICE_TIME_FACTOR = 0.02;

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Override
    public SellAircraftDataModel sellAircraft(Long sellerAirlineId, Long buyerAirlineId, Long aircraftId) {

        LOGGER.info("retrieve AircraftId: {}, sellerId: {}, buyerId: {}", aircraftId, sellerAirlineId, buyerAirlineId);
        Optional<AirlineAircrafts> optionalAirlineAircraft;
        try {
            optionalAirlineAircraft = airlineAircarftsRepository.findById(aircraftId);
            if (optionalAirlineAircraft.isPresent()) {
                throw new EntityNotFoundException("Aircraft with id: " + aircraftId + "not found");
            }
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB);
        }

        Airline sellerAirline= airlineRepositoryGateway.getAirlineById(sellerAirlineId);
        Airline buyerAirline= airlineRepositoryGateway.getAirlineById(buyerAirlineId);

        SellAircraftDataModel sellAircraftDataModel = sellAircraft(optionalAirlineAircraft, sellerAirline, buyerAirline);
        return sellAircraftDataModel;
    }


    private SellAircraftDataModel sellAircraft(Optional<AirlineAircrafts> optionalAirlineAircraft, Airline seller, Airline buyer) {
        AirlineAircrafts updatedAircraft = optionalAirlineAircraft.get();
        double sellPrice = calculateSellPrice(updatedAircraft);
        if (buyer.getCurrentBudget() < sellPrice) {
            throw new BadRequestException(NOT_ENOUGH_FUNDS);
        }
        updateAirlinesData(seller, buyer, sellPrice);
        updateAircraftDetails(updatedAircraft, buyer);
        return new SellAircraftDataModelImpl(updatedAircraft.getAircraftName(), seller.getName(), buyer.getName(), seller.getCurrentBudget(), buyer.getCurrentBudget(), sellPrice);
    }

    private void updateAircraftDetails(AirlineAircrafts updatedAircraft, Airline buyer) {
        updatedAircraft.setAirlineId(buyer.getId());
        AirlineAircrafts result;
        try {
            result = airlineAircarftsRepository.save(updatedAircraft);
        } catch (Exception e) {
            throw new DBException(ERROR_SAVING_TO_DB);
        }
        LOGGER.info("updated aircarft: {}", result);

    }

    private void updateAirlinesData(Airline seller, Airline buyer, double sellPrice) {
        buyer.setCurrentBudget(buyer.getCurrentBudget() - sellPrice);
        seller.setCurrentBudget(seller.getCurrentBudget() - sellPrice);
        Airline sellerRes  = airlineRepositoryGateway.saveAirline(seller);
        Airline buyerRes = airlineRepositoryGateway.saveAirline(buyer);;
        LOGGER.info("updated seller: {}, updated buyer: {}", sellerRes, buyerRes);
    }

    private double calculateSellPrice(AirlineAircrafts updatedAircraft) {
        return updatedAircraft.getPrice() * calculateMonthsPassed(updatedAircraft.getServiceMonth(), updatedAircraft.getServiceYear()) * PRICE_TIME_FACTOR;
    }

    private int calculateMonthsPassed(int serviceMonth, int serviceYear) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (serviceYear < localDate.getYear()) {
            return ((localDate.getYear() - serviceYear - 1) * 12 + 12 - serviceMonth + localDate.getMonthValue());
        } else {
            return localDate.getMonthValue() - serviceMonth;
        }
    }


}
