package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 14/02/2018 at 10:58
 * @project MobileSolutions
 */
public class AdminManager implements AdminDAO {
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
            PreparedStatement ps = this.dbConnection.prepareStatement(queryGetAdmin);
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

    public static final String queryGetAdmin = "SELECT t FROM mobilesolutions.admin WHERE username=?";
}