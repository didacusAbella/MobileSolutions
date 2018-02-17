package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 14/02/2018 at 10:58
 * @project MobileSolutions
 */
public class AdminManager implements AdminDAO, Mappable<Admin> {
    private static AdminManager adminManager = null;
    private final Connection dbConnection;
    private static Logger adminManagerLogger = Logger.getLogger(AdminManager.class.getName());

    public AdminManager(Connection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    public static AdminManager getInstance() throws SQLException {
        if (adminManager == null) {
            adminManager = new AdminManager(Database.getConnection());
            return adminManager;
        } else
            return adminManager;
    }


    @Override
    public boolean login(String username, String password) {
        try {
            PreparedStatement ps = this.dbConnection.prepareStatement(QUERY_GET_ADMIN_BY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next() && rs.getString("password").equals(password)) {
                return true;
            }
        } catch (SQLException ex) {
            adminManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        try {
            PreparedStatement ps = this.dbConnection.prepareStatement(QUERY_GET_ADMIN_BY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException ex) {
            adminManagerLogger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static final String QUERY_GET_ADMIN_BY_ID = "SELECT t FROM mobilesolutions.admin WHERE id=?";
    private static final String QUERY_GET_ADMIN_BY_USERNAME = "SELECT * FROM mobilesolutions.admin WHERE username=?";

    @Override
    public Admin mapRow(ResultSet rs) throws SQLException {
        Admin returnAdmin = new Admin();
        returnAdmin.setId(rs.getInt("id"));
        returnAdmin.setFirstName(rs.getString("firstName"));
        returnAdmin.setLastName(rs.getString("lastName"));
        returnAdmin.setPassword(rs.getString("password"));
        returnAdmin.setUsername(rs.getString("username"));
        return returnAdmin;
    }
}