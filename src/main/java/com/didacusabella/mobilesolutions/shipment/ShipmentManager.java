package com.didacusabella.mobilesolutions.shipment;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Shipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 15:35
 * @project MobileSolutions
 */
public class ShipmentManager implements Mappable<Shipment>, ShipmentDAO {

    private final Connection dbConnection;
    private static ShipmentManager shipmentManager = null;
    private static Logger shipmentManagerLogger = Logger.getLogger(ShipmentManager.class.getName());

    public ShipmentManager(Connection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    public static ShipmentManager getInstance() throws SQLException {
        if (shipmentManager == null) {
            shipmentManager = new ShipmentManager(Database.getConnection());
            return shipmentManager;
        } else
            return shipmentManager;
    }

    @Override
    public Shipment mapRow(ResultSet rs) throws SQLException {
        Shipment shipment = new Shipment();
        shipment.setId(rs.getInt("id"));
        shipment.setName(rs.getString("name"));
        shipment.setDayRange(rs.getString("dayRange"));
        shipment.setPrice(rs.getDouble("price"));
        return shipment;
    }

    @Override
    public boolean addShipment(Shipment shipment) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_ADD_SHIPMENT);
            statement.setString(1, shipment.getName());
            statement.setDouble(2, shipment.getPrice());
            statement.setString(3, shipment.getDayRange());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Shipment getShipmentByID(int id) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_GET_SHIPMENT_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Shipment returnShipment = null;
            if (rs.next()) {
                returnShipment = mapRow(rs);
            }
            return returnShipment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Shipment> getAllShipment() {
        try {
            List<Shipment> returnShipments = new ArrayList<>();
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_GET_ALL_SHIPMENT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnShipments.add(mapRow(rs));
            }
            return returnShipments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateShipment(Shipment shipment) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_UPDATE_SHIPMENT);
            statement.setString(1, shipment.getName());
            statement.setDouble(2, shipment.getPrice());
            statement.setString(3, shipment.getDayRange());
            statement.setInt(4, shipment.getId());
            int updateSuccess = statement.executeUpdate();
            if (updateSuccess == 1) {
                this.dbConnection.commit();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteShipment(int id) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_DELETE_SHIPMENT);
            statement.setInt(1, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static final String QUERY_DELETE_SHIPMENT = "DELETE FROM `mobilesolutions`.`shipment` WHERE `id`=?;";
    public static final String QUERY_UPDATE_SHIPMENT = "UPDATE mobilesolutions.shipment SET name=?,price=?,dayRange=? WHERE id=?;";
    public static final String QUERY_GET_ALL_SHIPMENT = "SELECT * FROM mobilesolutions.shipment";
    public static final String QUERY_GET_SHIPMENT_BY_ID = "SELECT * FROM mobilesolutions.shipment WHERE id=?";
    public static final String QUERY_ADD_SHIPMENT = "INSERT INTO `mobilesolutions`.`shipment` ( `name`, `price`, `dayRange`) VALUES ( ?, ?, ?);";
}
