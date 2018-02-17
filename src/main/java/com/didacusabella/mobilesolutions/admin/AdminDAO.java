package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.entities.Admin;
import com.didacusabella.mobilesolutions.entities.Client;
import com.didacusabella.mobilesolutions.entities.Sale;
import com.didacusabella.mobilesolutions.entities.Smartphone;

import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 10:39
 * @project MobileSolutions
 */
public interface AdminDAO {


    boolean login(String username, String password);

    Admin getAdminByUsername(String username);
}
