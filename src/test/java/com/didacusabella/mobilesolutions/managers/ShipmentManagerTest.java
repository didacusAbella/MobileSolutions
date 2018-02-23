package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Shipment;
import com.didacusabella.mobilesolutions.shipment.ShipmentManager;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author Domenico Antonio Tropeano on 23/02/2018 at 15:58
 * @project MobileSolutions
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShipmentManagerTest {
    private ShipmentManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = ShipmentManager.getInstance();
    }

    @Test
    public void test2GetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    @Test

    public void test3GetShipmentByID() {
        assertEquals(manager.getShipmentByID(1).getName(), "GLS");
    }

    @Test

    public void test4GetAllShipment() {
        assertEquals(manager.getAllShipment().size(), 2);
    }

    @Test

    public void test5AddShipment() {
        int beforeSize = manager.getAllShipment().size();
        Shipment shipment = new Shipment();
        shipment.setId(3);
        shipment.setName("Bartolini");
        shipment.setDayRange("1-2");
        shipment.setPrice(15);
        manager.addShipment(shipment);
        assertTrue(manager.getAllShipment().size() > beforeSize);
    }

    @Test

    public void test6UpdateShipment() {
        Shipment shipment = manager.getShipmentByID(3);
        shipment.setPrice(1);
        manager.updateShipment(shipment);
        assertTrue(manager.getShipmentByID(3).getPrice() == 1);
    }

    @Test

    public void test7DeleteShipment() {
        int beforeSize = manager.getAllShipment().size();
        manager.deleteShipment(3);
        assertTrue(manager.getAllShipment().size() < beforeSize);
    }

}
