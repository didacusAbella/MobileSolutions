package com.didacusabella.mobilesolutions.customException;

/**
 * @author Domenico Antonio Tropeano on 18/02/2018 at 14:36
 * @project MobileSolutions
 */
public class UsernameAlreadyExistException extends Exception {
    public UsernameAlreadyExistException() {
        super("Username already Exist");
    }
}
