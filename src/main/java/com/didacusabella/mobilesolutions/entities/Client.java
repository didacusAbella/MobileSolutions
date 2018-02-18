package com.didacusabella.mobilesolutions.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author diego
 * Entity that maps <i>client</i>
 */
public class Client {

    private int id;
    @NotNull
    @Size(min = 4, max = 45)
    private String name, lastName, address, cap, city,
            mobilePhone, username, password, email;
    private String telPhone, fax;
    @NotNull
    private String taxCode;
    @NotNull
    @Size(min = 1, max = 3)
    private String province;

    public Client() {
        super();
    }

    public Client(String name, String lastName, String taxCode,
                  String address, String cap, String city, String province, String telPhone,
                  String mobilePhone, String fax, String username, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.taxCode = taxCode;
        this.address = address;
        this.cap = cap;
        this.city = city;
        this.province = province;
        this.telPhone = telPhone;
        this.mobilePhone = mobilePhone;
        this.fax = fax;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", lastName=" + lastName
                + ", taxCode=" + taxCode + ", address=" + address + ", cap=" + cap +
                ", city=" + city + ", province=" + province + ", telPhone=" + telPhone +
                ", mobilePhone=" + mobilePhone + ", fax=" + fax + ", username=" + username +
                ", password=" + password + '}';
    }


}
