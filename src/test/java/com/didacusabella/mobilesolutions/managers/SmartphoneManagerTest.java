package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Smartphone;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

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

    @Test
    public void testAddSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Huaweeei");
        smartphone.setModel("P15 LITE");
        smartphone.setDisplayInch("5.2");
        smartphone.setOs("Android");
        smartphone.setCpu("Snapdragon 4.5Ghz");
        smartphone.setRam(4);
        smartphone.setInternal_storage(32);
        smartphone.setBluetooth(true);
        smartphone.setLte(true);
        smartphone.setCamera(12);
        smartphone.setQuantity(100);
        smartphone.setPrice(180);
        assertTrue(manager.addSmartphone(smartphone));
    }

    @Test
    public void testGetAllSmartphone() {
        List<Smartphone> result = null;
        result = manager.getAllSmartphone();
        assertNotNull(result);
    }

    @Test
    public void testDeleteSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Meizu");
        smartphone.setModel("F9 45 f");
        smartphone.setDisplayInch("5.2");
        smartphone.setOs("Android");
        smartphone.setCpu("Snapdragon 4.5Ghz");
        smartphone.setRam(4);
        smartphone.setInternal_storage(32);
        smartphone.setBluetooth(true);
        smartphone.setLte(true);
        smartphone.setCamera(12);
        smartphone.setQuantity(100);
        smartphone.setPrice(180);
        manager.addSmartphone(smartphone);
        assertTrue(manager.deleteSmartphone(12));
    }

    @Test
    public void testGetSmartphoneByID() {
        assertEquals(manager.getSmartphoneByID(1).getModel(), "S");
    }

    @Test
    public void testSmartphoneOUT() {
        assertTrue(manager.getSmartphoneOUT(2).size() > 0);
    }

    @Test
    public void testEditSmartphone() {
        Smartphone smartphone = manager.getSmartphoneByID(2);
        int oldValue = smartphone.getQuantity();
        smartphone.setQuantity(oldValue + 1);
        manager.editSmartphone(smartphone);
        assertEquals(manager.getSmartphoneByID(2).getQuantity(), oldValue + 1);
    }


}
