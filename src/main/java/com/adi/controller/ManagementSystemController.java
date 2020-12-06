package com.adi.controller;

import com.adi.persistence.model.Airline;
import com.adi.services.interfaces.AirlineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagementSystemController {

    @Autowired
    private AirlineManagementService airlineManagementService;

    @PostMapping("/airline")
    ResponseEntity<Airline> newEmployee(@RequestBody Airline newAirline) {
        return new ResponseEntity<>(airlineManagementService.addNewAirline(newAirline), HttpStatus.CREATED);

    }

    @GetMapping("/airlines")
    ResponseEntity<List<String>> getAirlinesWithCurrentBudget() {
        return new ResponseEntity<>(airlineManagementService.getAirlinesWithCurrentBudget(), HttpStatus.OK);
    }

//    // Single item
//
//    @GetMapping("/employees/{id}")
//    Employee one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException(id));
//    }
//
//    @PutMapping("/employees/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }
//
//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}

