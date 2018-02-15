package com.didacusabella.mobilesolutions.payment;

import com.didacusabella.mobilesolutions.entities.Payment;
import java.util.List;

/**
 *
 * @author diego
 */
public interface PaymentDao {
  
  Payment getPayment(int id);
  List<Payment> getAllPayments();
  boolean addPayment(Payment payment);
  boolean updatePayment(Payment payment);
  boolean deletePayment(int id);
}
