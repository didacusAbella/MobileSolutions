/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.booking.BookingManager;
import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.entities.Booking;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;


import static org.junit.Assert.*;

/**
 * @author diego
 */
public class BookingManagerTest {

    private BookingManager manager;

    @Before
    public void setUp() throws SQLException {
        this.manager = BookingManager.getInstance();
    }

    /**
     * Test of getInstance method, of class BookingManager.
     */
    @Test
    public void testGetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    /**
     * Test of mapRow method, of class BookingManager.
     */
    @Test
    public void testMapRow() throws Exception {

        PreparedStatement stmt = Database.getConnection().prepareStatement(READ_BOOKING);
        stmt.setString(1, "ciao");
    }

    /**
     * Test of getBooking method, of class BookingManager.
     */
    @Test
    public void testGetBooking() {
        List<Booking> list = this.manager.getBooking(2);
        assertEquals(2, list.size());
    }

    /**
     * Test of addBooking method, of class BookingManager.
     */
    @Test
    public void testAddBooking() {
        Booking booking = new Booking(2, 2, 5, new Timestamp(Calendar.getInstance().getTime().getTime()));
        assertTrue(this.manager.addBooking(booking));
    }

    /**
     * Test of removeBooking method, of class BookingManager.
     */
    @Test
    public void testRemoveBooking() {
        assertTrue(this.manager.removeBooking(2, 2));
    }

    /**
     * Test of removeAllBookings method, of class BookingManager.
     */
    @Test
    public void testRemoveAllBookings() {
        assertTrue(this.manager.removeAllBookings(2));
    }

    private static final String READ_BOOKING = "SELECT * FROM mobilesolutions.booking WHERE username=?;";
}
