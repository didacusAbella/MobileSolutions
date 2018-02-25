package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.admin.AdminManager;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author Domenico Antonio Tropeano on 23/02/2018 at 16:16
 * @project MobileSolutions
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminManagerTest {
    private AdminManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = AdminManager.getInstance();
    }

    @Test
    public void test2GetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    @Test
    public void test3Login() {
        assertTrue(manager.login("gestore", "gestore"));
    }
    @Test
    public void test4GetAdminByUsername(){
        assertEquals(manager.getAdminByUsername("gestore").getFirstName(),"Mario");
    }
}
