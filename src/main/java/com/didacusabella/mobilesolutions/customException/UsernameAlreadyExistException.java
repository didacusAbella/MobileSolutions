package com.didacusabella.mobilesolutions.customException;

/**
 * @author Domenico Antonio Tropeano on 18/02/2018 at 14:36
 * @project MobileSolutions
 */
public class UsernameAlreadyExistException extends Exception {
  
    /**
     * Create a new custom exception if the username already exist
     */
    public UsernameAlreadyExistException() {
        super("Username already Exist");
    }
}
