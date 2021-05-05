package com.adi.persistence.gateways.interfaces;

import com.adi.persistence.model.User;

public interface SystemIdentityRepositoryGateway {

    User findById(Long userId);
}


