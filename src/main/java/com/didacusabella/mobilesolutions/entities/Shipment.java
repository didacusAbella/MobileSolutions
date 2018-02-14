/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.didacusabella.mobilesolutions.entities;

/**
 *
 * @author diego
 * Entity that map <i>shipment</i>
 */
public class Shipment {
  
  private int id;
  private String name, dayRange;
  private double price;

  public Shipment() {
    super();
  }

  public Shipment(int id, String name, String dayRange, double price) {
    this.id = id;
    this.name = name;
    this.dayRange = dayRange;
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

  public String getDayRange() {
    return dayRange;
  }

  public void setDayRange(String dayRange) {
    this.dayRange = dayRange;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Shipment{" + "id=" + id + ", name=" + name + ", dayRange=" +
            dayRange + ", price=" + price + '}';
  }
  
  
}
