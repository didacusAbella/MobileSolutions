package com.didacusabella.mobilesolutions.entities;

/**
 *
 * @author diego
 * Entity that maps <i>client</i>
 */
public class Client {
  
  private int id;
  private String name, last_name, tax_code, address, cap, city, province, 
          tel_phone, mobile_phone, fax, username, password;

  public Client() {
    super();
  }
  
  

  public Client(int id, String name, String last_name, String tax_code, String address, 
          String cap, String city, String province, String tel_phone, String mobile_phone, 
          String fax, String username, String password) {
    this.id = id;
    this.name = name;
    this.last_name = last_name;
    this.tax_code = tax_code;
    this.address = address;
    this.cap = cap;
    this.city = city;
    this.province = province;
    this.tel_phone = tel_phone;
    this.mobile_phone = mobile_phone;
    this.fax = fax;
    this.username = username;
    this.password = password;
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

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getTax_code() {
    return tax_code;
  }

  public void setTax_code(String tax_code) {
    this.tax_code = tax_code;
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

  public String getTel_phone() {
    return tel_phone;
  }

  public void setTel_phone(String tel_phone) {
    this.tel_phone = tel_phone;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public void setMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
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
    return "Client{" + "id=" + id + ", name=" + name + ", last_name=" + last_name 
            + ", tax_code=" + tax_code + ", address=" + address + ", cap=" + cap +
            ", city=" + city + ", province=" + province + ", tel_phone=" + tel_phone +
            ", mobile_phone=" + mobile_phone + ", fax=" + fax + ", username=" + username +
            ", password=" + password + '}';
  }
  
  
  
}
