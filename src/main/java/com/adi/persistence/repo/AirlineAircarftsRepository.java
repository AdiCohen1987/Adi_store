package com.adi.persistence.repo;

import com.adi.persistence.model.AirlineAircrafts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirlineAircarftsRepository extends CrudRepository<AirlineAircrafts, Long> {

    List<AirlineAircrafts> findAllByAirlineId(Long id);
}
