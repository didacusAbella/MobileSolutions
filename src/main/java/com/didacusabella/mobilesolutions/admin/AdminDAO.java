package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.entities.Admin;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 10:39
 * @project MobileSolutions
 */
public interface AdminDAO {

    /**
     * Login an admin into the syste,
     * @param username the username of the admin
     * @param password the password of the admin
     * @return true if the admin is registered to system. False otherwise
     */
    boolean login(String username, String password);
    
    /**
     * Retrieve an username by his username
     * @param username the username of the admin
     * @return an Admin instance
     */
    Admin getAdminByUsername(String username);
}
