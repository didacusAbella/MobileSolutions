package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Payment;
import com.didacusabella.mobilesolutions.payment.PaymentManager;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author diego
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaymentManagerTest {

    private PaymentManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = PaymentManager.getInstance();
    }

    /**
     * Test of getInstance method, of class PaymentManager.
     */
    @Test
    public void test2GetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    /**
     * Test of getPayment method, of class PaymentManager.
     */
    @Test
    public void test3GetPayment() {
        Payment payment = this.manager.getPayment(1);
        assertEquals("Paypal", payment.getName());
    }

    /**
     * Test of getAllPayments method, of class PaymentManager.
     */
    @Test
    public void test4GetAllPayments() {
        List<Payment> list = this.manager.getAllPayments();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
    }

    /**
     * Test of addPayment method, of class PaymentManager.
     */
    @Test
    public void test5AddPayment() {
        Payment payment = new Payment("postpay", 15.78);
        assertTrue(this.manager.addPayment(payment));
    }

    /**
     * Test of updatePayment method, of class PaymentManager.
     */
    @Test
    public void test6UpdatePayment() {
        Payment payment = manager.getPayment(1);
        payment.setName("postpay");
        manager.updatePayment(payment);
        assertEquals(manager.getPayment(1).getName(), "postpay");
    }

    /**
     * Test of deletePayment method, of class PaymentManager.
     */
    @Test
    public void test7DeletePayment() {
        assertTrue(this.manager.deletePayment(1));
    }

    /**
     * Test of mapRow method, of class PaymentManager.
     */
    @Test
    public void testMapRow() throws Exception {

    }

}
