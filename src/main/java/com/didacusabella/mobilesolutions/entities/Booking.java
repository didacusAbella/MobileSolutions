package com.didacusabella.mobilesolutions.entities;

import java.sql.Timestamp;

/**
 * @author diego
 * Entity that maps <i>booking</i> table
 */
public class Booking {

    private int productID, username, quantity;
    private Timestamp date;
    private String productName;
    private Double price;

    public Booking() {
        super();
    }


    public Booking(int productID, int username, int quantity, Timestamp date) {
        this.productID = productID;
        this.username = username;
        this.quantity = quantity;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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
        return "Booking{" +
                "productID=" + productID +
                ", username=" + username +
                ", quantity=" + quantity +
                ", date=" + date +
                ", productName='" + productName + '\'' +
                '}';
    }
}
