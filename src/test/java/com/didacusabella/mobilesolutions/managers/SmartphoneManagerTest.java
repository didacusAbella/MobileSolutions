package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Smartphone;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 16:35
 * @project MobileSolutions
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmartphoneManagerTest {

    private SmartphoneManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = SmartphoneManager.getInstance();
    }

    /**
     * Test of getInstance method, of class SmartphoneManager.
     */
    @Test
    public void test2GetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    @Test
    public void test3AddSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setId(10);
        smartphone.setBrand("Huaweeei");
        smartphone.setModel("P15 LITE");
        smartphone.setDisplayInch("5.2");
        smartphone.setOs("Android");
        smartphone.setCpu("Snapdragon 4.5Ghz");
        smartphone.setRam(4);
        smartphone.setBluetooth(true);
        smartphone.setLte(true);
        smartphone.setCamera(12);
        smartphone.setQuantity(100);
        smartphone.setPrice(180);
        manager.addSmartphone(smartphone);
        assertEquals(manager.getSmartphoneByID(10).getBrand(), "Huaweeei");
    }

    @Test
    public void test4GetAllSmartphone() {
        assertEquals(manager.getAllSmartphone().size(), 3);
    }


    @Test
    public void test5GetSmartphoneByID() {
        assertEquals(manager.getSmartphoneByID(1).getBrand(), "Samsung");
    }

    @Test
    public void test6SmartphoneOUT() {
        assertEquals(manager.getSmartphoneOUT(25).size(), 1);
    }

    @Test
    public void test7EditSmartphone() {
        Smartphone smartphone = manager.getSmartphoneByID(2);
        int oldValue = smartphone.getQuantity();
        smartphone.setQuantity(oldValue + 1);
        manager.editSmartphone(smartphone);
        assertEquals(manager.getSmartphoneByID(2).getQuantity(), oldValue + 1);
    }

    @Test
    public void test8DeleteSmartphone() {
        manager.deleteSmartphone(10);
        assertEquals(manager.getSmartphoneByID(10), null);
    }


}
