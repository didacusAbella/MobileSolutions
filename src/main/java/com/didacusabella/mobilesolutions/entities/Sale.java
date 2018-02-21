
package com.didacusabella.mobilesolutions.entities;

import java.sql.Timestamp;

/**
 * @author diego
 * Entity that maps <i>sale</i>
 */
public class Sale {

    private int product, username, quantity, shipmentType, paymentType;
    private Timestamp date;
    private double price;
    private String productName;

    public Sale() {
        super();
    }


    public Sale(int product, int username, int quantity, int shipmentType,
                int paymentType, Timestamp date, double price) {
        this.product = product;
        this.username = username;
        this.quantity = quantity;
        this.shipmentType = shipmentType;
        this.paymentType = paymentType;
        this.date = date;
        this.price = price;
    }

    public int getProduct() {
        return product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public int getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(int shipmentType) {
        this.shipmentType = shipmentType;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void injectBooking(Booking booking) {
        this.username = booking.getUsername();
        this.product = booking.getProductID();
        this.quantity = booking.getQuantity();

    }

    @Override
    public String toString() {
        return "Sale{" + "product=" + product + ", username=" + username +
                ", quantity=" + quantity + ", shipmentType=" + shipmentType +
                ", paymentType=" + paymentType + ", date=" + date + ", price=" +
                price + '}';
    }


}
