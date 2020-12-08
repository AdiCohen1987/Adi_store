package com.adi.persistence.repo;

import com.adi.persistence.model.AirlineLocations;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirlineLocationsRepository extends CrudRepository<AirlineLocations, Long> {

    List<AirlineLocations> getDistinctByLocationName(String locationName);

    List<AirlineLocations> getDistinctByAirlineId(Long id);

}
