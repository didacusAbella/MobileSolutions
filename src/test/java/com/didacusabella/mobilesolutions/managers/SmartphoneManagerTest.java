package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Client;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 16:35
 * @project MobileSolutions
 */
public class SmartphoneManagerTest {
    private SmartphoneManager manager;

    @Before
    public void setUp() throws SQLException {
        this.manager = SmartphoneManager.getInstance();
    }

    /**
     * Test of getInstance method, of class SmartphoneManager.
     */
    @Test
    public void testGetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    public void testAddSmartphone(){

    }


}
