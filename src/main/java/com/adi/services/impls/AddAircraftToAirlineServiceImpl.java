package com.adi.services.impls;

import com.adi.dataModel.interfaces.NewAirlineAircraftDataModel;
import com.adi.persistence.gateway.interfaces.AirlineRepositoryGateway;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.repo.AirlineAircarftsRepository;
import com.adi.services.interfaces.AddAircraftToAirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class AddAircraftToAirlineServiceImpl implements AddAircraftToAirlineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Autowired
    private AirlineRepositoryGateway airlineRepositoryGateway;

    @Autowired
    private AirlineAircarftsRepository airlineAircarftsRepository;

    @Override
    public AirlineAircrafts addAircraftToAirline(NewAirlineAircraftDataModel airlineAircraftDataModel, Long airlineId) {
        airlineRepositoryGateway.getAirlineById(airlineId);
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int serviceMonth = airlineAircraftDataModel.getServiceMonth() == null ? localDate.getMonthValue() : airlineAircraftDataModel.getServiceMonth();
        int serviceYear = airlineAircraftDataModel.getServiceYear() == null ? localDate.getYear() : airlineAircraftDataModel.getServiceYear();
        AirlineAircrafts result = airlineAircarftsRepository.save(new AirlineAircrafts(airlineId, airlineAircraftDataModel.getAircraftName(), airlineAircraftDataModel.getPrice(), airlineAircraftDataModel.getMaxDistance(), serviceMonth, serviceYear));
        LOGGER.debug("updated AirlineLocation: {}", result.getAircraftName());
        return result;
    }
}
