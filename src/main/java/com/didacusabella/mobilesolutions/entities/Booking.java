package com.didacusabella.mobilesolutions.entities;

import java.sql.Timestamp;

/**
 *
 * @author diego
 * Entity that maps <i>booking</i> table
 */
public class Booking {
  
  private int product, username,quantity;
  private Timestamp date;

  public Booking() {
    super();
  }
  
  

  public Booking(int product, int username, int quantity, Timestamp date) {
    this.product = product;
    this.username = username;
    this.quantity = quantity;
    this.date = date;
  }

  public int getProduct() {
    return product;
  }

  public void setProduct(int product) {
    this.product = product;
  }

  public int getUsername() {
    return username;
  }

  public void setUsername(int username) {
    this.username = username;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Booking{" + "product=" + product + ", username=" + username + 
            ", quantity=" + quantity + ", date=" + date + '}';
  }
  
  
  
}
