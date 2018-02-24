package com.didacusabella.mobilesolutions.payment;

import com.didacusabella.mobilesolutions.entities.Payment;
import java.util.List;

/**
 *
 * @author diego
 * Database Access Object pattern for Payment Table
 */
public interface PaymentDao {
  
  /**
   * Get the payment type by id
   * @param id the id of payment
   * @return a Payment instance
   */
  Payment getPayment(int id);
  
  /**
   * get all payments
   * @return all possible payments
   */
  List<Payment> getAllPayments();
  
  /**
   * Add a new type of Payment
   * @param payment the new payment
   * @return true if the payment was addedd successfully
   */
  boolean addPayment(Payment payment);
  
  /**
   * Update an existing payment
   * @param payment the payment to update
   * @return true if the update was successfully
   */
  boolean updatePayment(Payment payment);
  
  /**
   * Delete a type of payment
   * @param id the id of payment
   * @return true if the payment was removed successfully
   */
  boolean deletePayment(int id);
}
