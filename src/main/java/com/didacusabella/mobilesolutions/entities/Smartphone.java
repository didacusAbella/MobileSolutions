package com.didacusabella.mobilesolutions.entities;

/**
 * @author didacusAbella
 * entity class that map <i>smartphone</i> table
 */
public class Smartphone {

    private int id, quantity, ram, internal_storage, camera;
    private String brand, model, displayInch, os, cpu;
    private boolean bluetooth, lte;
    private double price;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, int quantity, int ram, int internal_storage, int camera,
                      String brand, String model, String displayInch, String os, String cpu,
                      boolean bluetooth, boolean lte, double price) {
        this.id = id;
        this.quantity = quantity;
        this.ram = ram;
        this.internal_storage = internal_storage;
        this.camera = camera;
        this.brand = brand;
        this.model = model;
        this.displayInch = displayInch;
        this.os = os;
        this.cpu = cpu;
        this.bluetooth = bluetooth;
        this.lte = lte;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getInternal_storage() {
        return internal_storage;
    }

    public void setInternal_storage(int internal_storage) {
        this.internal_storage = internal_storage;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplayInch() {
        return displayInch;
    }

    public void setDisplayInch(String displayInch) {
        this.displayInch = displayInch;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isLte() {
        return lte;
    }

    public void setLte(boolean lte) {
        this.lte = lte;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", ram=" + ram +
                ", internal_storage=" + internal_storage +
                ", camera=" + camera +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayInch='" + displayInch + '\'' +
                ", os='" + os + '\'' +
                ", cpu='" + cpu + '\'' +
                ", bluetooth=" + bluetooth +
                ", lte=" + lte +
                ", price=" + price +
                '}';
    }
}
