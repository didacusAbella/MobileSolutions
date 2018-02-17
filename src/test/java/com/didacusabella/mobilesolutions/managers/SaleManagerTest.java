package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Sale;
import com.didacusabella.mobilesolutions.sale.SaleManager;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Domenico Antonio Tropeano on 16/02/2018 at 12:07
 * @project MobileSolutions
 */
public class SaleManagerTest {
    private SaleManager manager;

    @Before
    public void setUp() throws SQLException {
        this.manager = SaleManager.getInstance();
    }

    /**
     * Test of getInstance method, of class SmartphoneManager.
     */
    @Test
    public void testGetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    @Test
    public void testGetAllSaleForClient() {
        List<Sale> allsale = manager.getAllSaleForClient(1);
        assertNotNull(allsale);
    }

    @Test
    public void testBuyProduct() {
        Sale sl = new Sale();
        sl.setProduct(1);
        sl.setUsername(2);
        sl.setDate(new Timestamp(System.currentTimeMillis()));
        sl.setShipmentType(1);
        sl.setPaymentType(1);
        sl.setQuantity(2);
        sl.setPrice(150);
        assertTrue(manager.buyProduct(sl));
    }
}
