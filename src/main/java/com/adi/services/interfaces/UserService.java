package com.adi.services.interfaces;

import org.apache.tomcat.util.net.openssl.ciphers.Encryption;

public interface UserService {
    void validateRole(Long userId);
}
