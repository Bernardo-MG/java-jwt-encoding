
package com.bernardomg.jwt.springframework.security.web.test.config.factory;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public final class UserDets {

    public static final UserDetails credentialsExpired() {
        return new User(UserDetailsConstants.USERNAME, UserDetailsConstants.PASSWORD, true, true, false, true,
            List.of());
    }

    public static final UserDetails disabled() {
        return new User(UserDetailsConstants.USERNAME, UserDetailsConstants.PASSWORD, false, true, true, true,
            List.of());
    }

    public static final UserDetails enabled() {
        return new User(UserDetailsConstants.USERNAME, UserDetailsConstants.PASSWORD, true, true, true, true,
            List.of());
    }

    public static final UserDetails expired() {
        return new User(UserDetailsConstants.USERNAME, UserDetailsConstants.PASSWORD, true, false, true, true,
            List.of());
    }

    public static final UserDetails locked() {
        return new User(UserDetailsConstants.USERNAME, UserDetailsConstants.PASSWORD, true, true, true, false,
            List.of());
    }

    private UserDets() {
        super();
    }

}
