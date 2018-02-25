package com.didacusabella.mobilesolutions.booking;

import com.didacusabella.mobilesolutions.entities.Booking;

import java.util.List;

/**
 *
 * @author diego
 * Database Access Pattern for Booking entity
 */
public interface BookingDao {
  
  /**
   * Get the booking of a specific client
   * @param username the id of the client
   * @return the booking of the user
   */
  List<Booking> getBooking(int username);
  /**
   * Add a product to the booking
   * @param booking the booking object
   * @return true if the product was addedd successfully
   */
  boolean addBooking(Booking booking);
  
  /**
   * Remove a specific product from the booking of a specific client
   * @param product
   * @param username
   * @return 
   */
  boolean removeBooking(int product, int username);
  
  /**
   * Remove all products of a specific client from booking
   * @param username the id of the client
   * @return true if the products are removed successfully
   */
  boolean removeAllBookings(int username);
  
}
