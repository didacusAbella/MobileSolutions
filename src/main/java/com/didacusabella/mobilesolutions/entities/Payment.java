package com.didacusabella.mobilesolutions.entities;

/**
 *
 * @author diego
 * Entity class that map <i>payment</i> table
 */
public class Payment {
  
  private int id;
  private String name;
  private double price;

  public Payment() {
    super();
  }

  public Payment(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Payment{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
  }
  
  
}
