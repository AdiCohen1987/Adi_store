package com.adi.persistence.gateways.impl;

import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.persistence.gateways.interfaces.SystemIdentityRepositoryGateway;
import com.adi.persistence.model.User;
import com.adi.persistence.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;

@Service
public class SystemIdentityRepositoryGatewayImpl implements SystemIdentityRepositoryGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemIdentityRepositoryGatewayImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser;
        try {
            optionalUser = userRepository.findById(userId);
            if (!optionalUser.isPresent()) {
                throw new EntityNotFoundException("User with id: " + userId + " not found");
            }
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB + " " + e.getLocalizedMessage());
        }
        LOGGER.debug("retrieved user id from db: {}", userId);
        return optionalUser.get();
    }

}
