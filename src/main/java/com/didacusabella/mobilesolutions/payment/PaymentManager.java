package com.didacusabella.mobilesolutions.payment;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class PaymentManager implements PaymentDao, Mappable<Payment> {
  
  private final Connection dbConnection;
  private static PaymentManager paymentManager = null;
  private static final Logger PAYMENT_LOGGER = Logger.getLogger(PaymentManager.class.getName());
  private static final String READ_PAYMENT = "SELECT * FROM payments WHERE id=?;";
  private static final String READ_PAYMENTS = "SELECT * FROM payments;";
  private static final String CREATE_PAYMENT = "INSERT INTO payments (name, price) VALUES (?, ?);";
  private static final String UPDATE_PAYMENT = "UPDATE payments SET name=?, price=? WHERE id=?";
  private static final String DELETE_PAYMENT = "DELETE FROM payments WHERE id=?";

  private PaymentManager(Connection dbConnection) {
    this.dbConnection = dbConnection;
  }
  
  
  public static PaymentManager getInstance() throws SQLException{
    if(paymentManager == null){
      paymentManager = new PaymentManager(Database.getConnection());
      return paymentManager;
    }else
      return paymentManager;
  }

  @Override
  public Payment getPayment(int id) {
    try {
      PreparedStatement ps = this.dbConnection.prepareStatement(READ_PAYMENT);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      Payment payment = null;
      if(rs.next()){
        payment = mapRow(rs);
      }
      return payment;
      } catch (SQLException ex) {
      PAYMENT_LOGGER.log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public List<Payment> getAllPayments() {
    try {
      Statement stm = this.dbConnection.createStatement();
      List<Payment> payments = new ArrayList<>();
      ResultSet rs = stm.executeQuery(READ_PAYMENTS);
      while(rs.next()){
        payments.add(mapRow(rs));
      }
      return payments;
    } catch (SQLException ex) {
      PAYMENT_LOGGER.log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public boolean addPayment(Payment payment) {
    try {
      PreparedStatement ps = this.dbConnection.prepareStatement(CREATE_PAYMENT);
      ps.setString(1, payment.getName());
      ps.setDouble(2, payment.getPrice());
      int insertSuccess = ps.executeUpdate();
      if(insertSuccess == 1){
        this.dbConnection.commit();
        ps.close();
        return true;
      }
    } catch (SQLException ex) {
      PAYMENT_LOGGER.log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean updatePayment(Payment payment) {
    try {
      PreparedStatement ps = this.dbConnection.prepareStatement(UPDATE_PAYMENT);
      ps.setString(1, payment.getName());
      ps.setDouble(2, payment.getPrice());
      ps.setInt(3, payment.getId());
      int updateSuccess = ps.executeUpdate();
      if(updateSuccess == 1){
        this.dbConnection.commit();
        ps.close();
        return true;
      }
    } catch (SQLException ex) {
      PAYMENT_LOGGER.log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean deletePayment(int id) {
    try {
      PreparedStatement ps = this.dbConnection.prepareStatement(DELETE_PAYMENT);
      ps.setInt(1, id);
      int deleteSuccess = ps.executeUpdate();
      if(deleteSuccess == 1){
        this.dbConnection.commit();
        ps.close();
        return true;
      }
    } catch (SQLException ex) {
      PAYMENT_LOGGER.log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public Payment mapRow(ResultSet rs) throws SQLException {
    Payment mappedPayment = new Payment();
    mappedPayment.setId(rs.getInt("id"));
    mappedPayment.setName(rs.getString("name"));
    mappedPayment.setPrice(rs.getDouble("price"));
    return mappedPayment;
  }
  
  
  
}
