package com.adi.services.impls;

import com.adi.dataModel.interfaces.NewAirlineDataModel;
import com.adi.persistence.gateways.interfaces.AirlineRepositoryGateway;
import com.adi.persistence.gateways.interfaces.LocationRepositoryGateway;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineLocations;
import com.adi.services.interfaces.AirlineManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineManagementServiceImpl implements AirlineManagementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Autowired
    private AirlineRepositoryGateway airlineRepositoryGateway;

    @Autowired
    private LocationRepositoryGateway locationRepositoryGateway;

    @Override
    public Airline addNewAirline(NewAirlineDataModel airlineDataModel) {
        Airline airlineResult = airlineRepositoryGateway.saveAirline(new Airline(airlineDataModel.getAirlineName(), airlineDataModel.getInitialBudget(), airlineDataModel.getInitialBudget(), airlineDataModel.getHomeBaseName()));
        locationRepositoryGateway.save(new AirlineLocations(airlineResult.getId(), airlineResult.getName(), airlineDataModel.getHomeBaseName(), airlineDataModel.getAltitude(), airlineDataModel.getLongitude()));
        return airlineResult;
    }

    @Override
    public List<String> getAirlinesWithCurrentBudget() {
        List<String> result = createAirlineWithBudgetList(airlineRepositoryGateway.findAll());
        LOGGER.debug("updated airlines With Budgets: {}", result);
        return result;
    }

    private List<String> createAirlineWithBudgetList(Iterable<Airline> airlines) {
        List<String> airlinesWithBudget = new ArrayList<>();
        airlines.forEach(item -> {
            airlinesWithBudget.add(getAirlineWithBudgetString(item));
        });
        return airlinesWithBudget;
    }

    private String getAirlineWithBudgetString(Airline item) {
        return "Airline: " + item.getName() + " id: " + item.getId() + " current budget is: " + item.getCurrentBudget();
    }


}
