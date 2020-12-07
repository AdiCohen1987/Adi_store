package com.adi.services.impls;

import com.adi.persistence.model.Airline;
import com.adi.persistence.repo.AirlineRepository;
import com.adi.services.interfaces.AirlineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineManagementServiceImpl implements AirlineManagementService {

    @Autowired
    private AirlineRepository airlineRepository;


    //private LocationRepository locationRepository;

    //private AirlineLocationsRepository airlineLocationsRepository;

    @Override
    public Airline addNewAirline(Airline newAirline) {
        return airlineRepository.save(newAirline);
    }

    @Override
    public List<String> getAirlinesWithCurrentBudget() {
        Iterable<Airline> airlines = airlineRepository.findAll();
        List<String> airlinesWithBudget = new ArrayList<>();
        airlines.forEach(item -> {
            airlinesWithBudget.add(getAirlineWithBudgetString(item));
        });
        return airlinesWithBudget;
    }

    private String getAirlineWithBudgetString(Airline item) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Airline: ").append(item.getName()).append(" id: ").append(item.getId()).append(" current budget is: ").append(item.getCurrentBudget()).toString();
    }


}
