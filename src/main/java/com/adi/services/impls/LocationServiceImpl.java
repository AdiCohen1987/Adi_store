package com.adi.services.impls;

import com.adi.dataModel.impl.DestinationsToHomeBaseDataModelImpl;
import com.adi.dataModel.interfaces.DestinationsToHomeBaseDataModel;
import com.adi.persistence.gateways.interfaces.AircraftRepositoryGateway;
import com.adi.persistence.gateways.interfaces.AirlineRepositoryGateway;
import com.adi.persistence.gateways.interfaces.LocationRepositoryGateway;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.model.AirlineLocations;
import com.adi.services.interfaces.LocationService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.lucene.spatial.util.GeoDistanceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Autowired
    private AirlineRepositoryGateway airlineRepositoryGateway;

    @Autowired
    private LocationRepositoryGateway locationRepositoryGateway;

    @Autowired
    private AircraftRepositoryGateway aircraftRepositoryGateway;

    @Override
    public AirlineLocations addLocation(AirlineLocations airlineLocation, Long airlineId) {
        airlineRepositoryGateway.getAirlineById(airlineId);
        return locationRepositoryGateway.save(airlineLocation);
    }

    @Override
    public List<AirlineLocations> getAllLocationsByAirline(Long airlineId) {
        return locationRepositoryGateway.getDistinctByAirlineId(airlineId);
    }

    @Override
    public List<DestinationsToHomeBaseDataModel> getDestinationsToHomeBase(Long airlineId) {
        AirlineLocations airlineHomeLocation = getAirlineHomeLocation(airlineId);
        List<AirlineLocations> destinations = locationRepositoryGateway.getDistinctByAirlineId(airlineId).stream().filter(distinctByKey(AirlineLocations::getLocationName)).collect(Collectors.toList());
        List<DestinationsToHomeBaseDataModel> listOfDestinationsToHomeBase = new ArrayList<>();
        double homeAltitude = airlineHomeLocation.getAltitude();
        double homeLongitude = airlineHomeLocation.getLongitude();
        for (AirlineLocations location : destinations) {
            double haversinRes = (GeoDistanceUtils.haversin(homeAltitude, homeLongitude, location.getAltitude(), location.getLongitude()))/1000;
            listOfDestinationsToHomeBase.add(new DestinationsToHomeBaseDataModelImpl(location.getLocationName(), haversinRes));
        }
        return listOfDestinationsToHomeBase;
    }

    @Override
    public List<String> getAvailableDestinations(Long airlineId) {
        List<AirlineAircrafts> airlineAircrafts = aircraftRepositoryGateway.getAirlineAircrafts(airlineId);
        List<DestinationsToHomeBaseDataModel> listOfDestinationsToHomeBase = getDestinationsToHomeBase(airlineId);
        List<String> listOfAvailableDestinations = new ArrayList<>();
        int maxDist = getMaxDist(airlineAircrafts);
        for (DestinationsToHomeBaseDataModel destination : listOfDestinationsToHomeBase) {
            if (maxDist >= destination.getDistanceFromHomeBase()) {
                listOfAvailableDestinations.add(destination.getLocationName());
            }
        }
        return listOfAvailableDestinations;
    }

    private int getMaxDist(List<AirlineAircrafts> airlineAircrafts) {
        return airlineAircrafts.stream().max(Comparator.comparingInt(AirlineAircrafts::getMaxDistance)).get().getMaxDistance();
    }

    private AirlineLocations getAirlineHomeLocation(Long airlineId) {
        Airline airline = airlineRepositoryGateway.getAirlineById(airlineId);
        return locationRepositoryGateway.getByAirlineIdAndLocationName(airlineId, airline.getHomeBaseName());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }


}
