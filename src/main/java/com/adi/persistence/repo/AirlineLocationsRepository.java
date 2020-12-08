package com.adi.persistence.repo;

import com.adi.persistence.model.AirlineLocations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AirlineLocationsRepository extends CrudRepository<AirlineLocations, Long> {

    List<AirlineLocations> getDistinctByAirlineIdIs(Long id);

    AirlineLocations getByAirlineIdAndLocationName(Long id,String locationName);



}

