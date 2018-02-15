package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.entities.Payment;
import com.didacusabella.mobilesolutions.payment.PaymentManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author diego
 */
public class PaymentManagerTest {
  
  private PaymentManager manager;
  
  @Before
  public void setUp() throws SQLException {
    this.manager = PaymentManager.getInstance();
  }

  /**
   * Test of getInstance method, of class PaymentManager.
   */
  @Test
  public void testGetInstance() throws Exception {
    assertNotNull(this.manager);
  }

  /**
   * Test of getPayment method, of class PaymentManager.
   */
  @Test
  public void testGetPayment() {
    Payment payment = this.manager.getPayment(1);
    assertNotNull(payment);
    assertEquals("paypal", payment.getName());
  }

  /**
   * Test of getAllPayments method, of class PaymentManager.
   */
  @Test
  public void testGetAllPayments() {
    List<Payment> list = this.manager.getAllPayments();
    assertNotNull(list);
    assertTrue(list.size() >= 1);
  }

  /**
   * Test of addPayment method, of class PaymentManager.
   */
  @Test
  public void testAddPayment() {
    Payment payment = new Payment("postpay", 15.78);
    assertTrue(this.manager.addPayment(payment));
  }

  /**
   * Test of updatePayment method, of class PaymentManager.
   */
  @Test
  public void testUpdatePayment() {
    Payment payment = new Payment("postpay", 10.98);
    payment.setId(2);
    assertTrue(this.manager.updatePayment(payment));
  }

  /**
   * Test of deletePayment method, of class PaymentManager.
   */
  @Test
  public void testDeletePayment() {
    assertTrue(this.manager.deletePayment(2));
  }

  /**
   * Test of mapRow method, of class PaymentManager.
   */
  @Test
  public void testMapRow() throws Exception {

  }
  
}
