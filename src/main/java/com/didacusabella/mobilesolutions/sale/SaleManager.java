package com.didacusabella.mobilesolutions.sale;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 12:44
 * @project MobileSolutions
 */
public class SaleManager implements SaleDAO, Mappable<Sale> {
    private static SaleManager saleManager = null;
    private final Connection dbConnection;
    private static Logger saleManagerLogger = Logger.getLogger(SaleManager.class.getName());

    public SaleManager(Connection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    public static SaleManager getInstance() throws SQLException {
        if (saleManager == null) {
            saleManager = new SaleManager(Database.getConnection());
            return saleManager;
        } else
            return saleManager;
    }


    @Override
    public Sale mapRow(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Sale returnSale = new Sale();
            returnSale.setUsername(rs.getInt("username"));
            returnSale.setProduct(rs.getInt("product"));
            returnSale.setDate(rs.getTimestamp("datetime"));
            returnSale.setPaymentType(rs.getInt("paymentType"));
            returnSale.setShipmentType(rs.getInt("paymentType"));
            returnSale.setPrice(rs.getDouble("price"));
            returnSale.setQuantity(rs.getInt("quantity"));
            return returnSale;
        }
        return null;
    }

    @Override
    public List<Sale> getAllSaleForClient(int clientID) {
        try {
            List<Sale> returnSales = new ArrayList<>();
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_GET_ALL_SALE_FOR_USER);
            statement.setInt(1, clientID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnSales.add(mapRow(rs));
            }
            rs.close();
            statement.close();
            return returnSales;
        } catch (SQLException e) {
            saleManagerLogger.log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean buyProduct(Sale sl) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_BUY_PRODUCT);
            statement.setInt(1, sl.getProduct());
            statement.setInt(2, sl.getUsername());
            statement.setTimestamp(3, sl.getDate());
            statement.setInt(4, sl.getQuantity());
            statement.setDouble(5, sl.getPrice());
            statement.setInt(6, sl.getShipmentType());
            statement.setInt(7, sl.getPaymentType());
            int insertionSuccess = statement.executeUpdate();
            if (insertionSuccess == 1) {
                this.dbConnection.commit();
                statement.close();
                return true;
            }
        } catch (SQLException e) {
            saleManagerLogger.log(Level.SEVERE, null, e);
        }
        return false;
    }

    private static final String QUERY_GET_ALL_SALE_FOR_USER = "SELECT * FROM sale  WHERE username=?";
    private static final String QUERY_BUY_PRODUCT = "INSERT INTO sale (`product`, username, datetime, " +
            "quantity, price, shipmentType, `paymentType`) VALUES (?, ?, ?, ?, ?, ?, ?);";

}
