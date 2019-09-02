package com.packagename.myapp.spring.login;

import org.springframework.stereotype.Service;

/**
 * This DummyLoginService is responsible for authenticating an user.
 * Be careful with this class because it is only a dummy. This class does not provide
 * any serious login management.
 */
@Service
public class DummyLoginService {

    public DummyLoginService(){
    }

    /**
     * Check for dummy authentication of a user.
     *
     * @param userid The username of the client
     * @param password The password of the client
     * @return  True if the username equals the password
     */
    public boolean authenticate(final String userid, final String password)
    {
        return userid.equals(password);
    }

}
