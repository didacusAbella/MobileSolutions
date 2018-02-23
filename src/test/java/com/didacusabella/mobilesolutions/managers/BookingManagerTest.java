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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author diego & Domenico Antonio Tropeano
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingManagerTest {

    private BookingManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = BookingManager.getInstance();
    }

    /**
     * Test of getInstance method, of class BookingManager.
     */
    @Test
    public void test2GetInstance() throws Exception {
        assertNotNull(this.manager);
    }

    /**
     * Test of mapRow method, of class BookingManager.
     */
    @Test
    public void test3MapRow() throws Exception {
        PreparedStatement stmt = Database.getConnection().prepareStatement(READ_BOOKING);
        stmt.setString(1, "oromis");
        ResultSet rs = stmt.executeQuery();
        assertEquals(rs.getRow(), 2);
    }

    /**
     * Test of getBooking method, of class BookingManager.
     */
    @Test
    public void test4GetBooking() {
        List<Booking> list = this.manager.getBooking(2);
        assertEquals(2, list.size());
    }

    /**
     * Test of addBooking method, of class BookingManager.
     */
    @Test
    public void test5AddBooking() {
        int sizeBefore = manager.getBooking(2).size();
        Booking booking = new Booking(2, 2, 5, new Timestamp(Calendar.getInstance().getTime().getTime()));
        assertTrue(sizeBefore < manager.getBooking(2).size());
    }

    /**
     * Test of removeBooking method, of class BookingManager.
     */
    @Test
    public void test6RemoveBooking() {
        int sizeBefore = manager.getBooking(2).size();
        assertTrue(this.manager.removeBooking(2, 2));
        assertTrue(sizeBefore < manager.getBooking(2).size());
    }

    /**
     * Test of removeAllBookings method, of class BookingManager.
     */
    @Test
    public void test7RemoveAllBookings() {
        assertTrue(this.manager.removeAllBookings(2));
        assertTrue(manager.getBooking(2).size() == 0);

    }

    private static final String READ_BOOKING = "SELECT * FROM mobilesolutions.booking WHERE username=?;";
}
