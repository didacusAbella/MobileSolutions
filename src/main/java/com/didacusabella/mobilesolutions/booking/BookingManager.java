package com.didacusabella.mobilesolutions.booking;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author didacusabella
 */
public class BookingManager implements Mappable<Booking>, BookingDao {

    private final Connection dbConnection;
    private static BookingManager bookingManager = null;
    private static Logger bookingManagerLogger = Logger.getLogger(BookingManager.class.getName());
    private static final String READ_BOOKING = "SELECT * FROM mobilesolutions.booking WHERE username=?;";
    private static final String CREATE_BOOKING = "INSERT INTO mobilesolutions.booking "
            + "(product, username, datetime, quantity) VALUES (?, ?, ?, ?);";
    private static final String REMOVE_PRODUCT = "DELETE FROM mobilesolutions.booking WHERE username=? AND product=?;";
    private static final String CLEAN_BOOKING = "DELETE FROM mobilesolutions.booking WHERE username=?;";
    private static final String CHECK_BOOKING = "SELECT * FROM mobilesolutions.booking WHERE username=? AND product=?";
    private static final String INCREASE_QUANTITY = "UPDATE `mobilesolutions`.`booking` SET `quantity`=? WHERE `username`=? AND`product`=?;";

    private BookingManager(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


    public static BookingManager getInstance() throws SQLException {
        if (bookingManager == null) {
            bookingManager = new BookingManager(Database.getConnection());
            return bookingManager;
        } else
            return bookingManager;
    }


    @Override
    public Booking mapRow(ResultSet rs) throws SQLException {
        Booking mappedBooking = new Booking();
        mappedBooking.setUsername(rs.getInt("username"));
        mappedBooking.setProductID(rs.getInt("product"));
        mappedBooking.setQuantity(rs.getInt("quantity"));
        mappedBooking.setDate(rs.getTimestamp("datetime"));
        return mappedBooking;
    }

    @Override
    public List<Booking> getBooking(int username) {
        try {
            PreparedStatement stmt = this.dbConnection.prepareStatement(READ_BOOKING);
            stmt.setInt(1, username);
            List<Booking> bookings = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookings.add(this.mapRow(rs));
            }
            rs.close();
            stmt.close();
            return bookings;
        } catch (SQLException ex) {
            bookingManagerLogger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean addBooking(Booking booking) {
        try {
            PreparedStatement stmt1 = this.dbConnection.prepareStatement(CHECK_BOOKING);
            stmt1.setInt(1, booking.getUsername());
            stmt1.setInt(2, booking.getProductID());
            ResultSet rs = stmt1.executeQuery();
            if (rs.isBeforeFirst()) {

            } else {
                PreparedStatement stmt2 = this.dbConnection.prepareStatement(INCREASE_QUANTITY);
                stmt2.setInt(1, booking.getQuantity());
                stmt2.setInt(2, booking.getUsername());
                stmt2.setInt(3, booking.getProductID());
                return stmt2.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement stmt = this.dbConnection.prepareStatement(CREATE_BOOKING);
            stmt.setInt(1, booking.getProductID());
            stmt.setInt(2, booking.getUsername());
            stmt.setTimestamp(3, booking.getDate());
            stmt.setInt(4, booking.getQuantity());
            int insertSuccess = stmt.executeUpdate();
            if (insertSuccess == 1) {
                this.dbConnection.commit();
                stmt.close();
                return true;
            }
        } catch (SQLException ex) {
            bookingManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeBooking(int product, int username) {
        try {
            PreparedStatement stmt = this.dbConnection.prepareStatement(REMOVE_PRODUCT);
            stmt.setInt(1, username);
            stmt.setInt(2, product);
            int deletedProduct = stmt.executeUpdate();
            if (deletedProduct == 1) {
                this.dbConnection.commit();
                stmt.close();
                return true;
            }
        } catch (SQLException ex) {
            bookingManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeAllBookings(int username) {
        try {
            PreparedStatement stmt = this.dbConnection.prepareStatement(CLEAN_BOOKING);
            stmt.setInt(1, username);
            int deletedProducts = stmt.executeUpdate();
            if (deletedProducts >= 1) {
                this.dbConnection.commit();
                stmt.close();
                return true;
            }
        } catch (SQLException ex) {
            bookingManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
