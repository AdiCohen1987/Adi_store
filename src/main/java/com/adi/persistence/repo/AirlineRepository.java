package com.adi.persistence.repo;

import com.adi.persistence.model.Airline;
import org.springframework.data.repository.CrudRepository;

public interface AirlineRepository extends CrudRepository<Airline, Long> {
}
