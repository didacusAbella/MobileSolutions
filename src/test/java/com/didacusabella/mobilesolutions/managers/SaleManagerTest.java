package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Sale;
import com.didacusabella.mobilesolutions.sale.SaleManager;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleManagerTest {
    private SaleManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = SaleManager.getInstance();
    }

    @Test
    public void test2GetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    @Test
    public void test3GetAllSaleForClient() {
        List<Sale> allsale = manager.getAllSaleForClient(1);
        assertTrue(allsale.size() == 2);
    }

    @Test
    public void test4BuyProduct() {
        int beforeSize = manager.getAllSaleForClient(2).size();
        Sale sl = new Sale();
        sl.setProduct(1);
        sl.setUsername(2);
        sl.setDate(new Timestamp(System.currentTimeMillis()));
        sl.setShipmentType(1);
        sl.setPaymentType(1);
        sl.setQuantity(2);
        sl.setPrice(150);
        manager.buyProduct(sl);
        assertTrue(beforeSize < manager.getAllSaleForClient(2).size());
    }

}
