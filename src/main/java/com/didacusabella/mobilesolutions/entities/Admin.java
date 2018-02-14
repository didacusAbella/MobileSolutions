package com.didacusabella.mobilesolutions.entities;

/**
 *
 * @author diego
 * Entity mapping of <i>admin</i> table
 */
public class Admin {
  
  private int id;
  private String username, lastName, firstName, password;

  public Admin() {
    super();
  }
  
  public Admin(int id, String username, String lastName, String firstName, String password) {
    this.id = id;
    this.username = username;
    this.lastName = lastName;
    this.firstName = firstName;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Admin{" + "id=" + id + ", username=" + username + ", lastName=" + lastName + ", firstName=" + firstName + ", password=" + password + '}';
  }
  
  
  
}
