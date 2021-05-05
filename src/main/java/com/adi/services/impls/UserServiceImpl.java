package com.adi.services.impls;

import com.adi.configuration.errorHandling.UnAuthorizedException;
import com.adi.persistence.gateways.interfaces.SystemIdentityRepositoryGateway;
import com.adi.persistence.model.User;
import com.adi.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SystemIdentityRepositoryGateway systemIdentityRepositoryGateway;

    final String OWNER_ROLE = "owner";

    @Override
    public void validateRole(Long userId) {
        User user = systemIdentityRepositoryGateway.findById(userId);
        if (!user.getRole().equalsIgnoreCase(OWNER_ROLE)) {
            throw new UnAuthorizedException("user is not authorized");
        }
    }
}
