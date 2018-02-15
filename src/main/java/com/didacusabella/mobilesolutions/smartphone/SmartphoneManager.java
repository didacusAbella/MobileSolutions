package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Smartphone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 11:51
 * @project MobileSolutions
 */
public class SmartphoneManager implements Mappable<Smartphone>, SmartphoneDAO {
    private static SmartphoneManager smartphoneManager = null;
    private final Connection dbConnection;
    private static Logger smartphoneManagerLogger = Logger.getLogger(SmartphoneManager.class.getName());

    public SmartphoneManager(Connection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    public static SmartphoneManager getInstance() throws SQLException {
        if (smartphoneManager == null) {
            smartphoneManager = new SmartphoneManager(Database.getConnection());
            return smartphoneManager;
        } else
            return smartphoneManager;
    }

    @Override
    public boolean addSmartphone(Smartphone smartphone) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(queryAddSmartphone);
            statement.setString(1, smartphone.getBrand());
            statement.setString(2, smartphone.getModel());
            statement.setString(3, smartphone.getDisplayInch());
            statement.setString(4, smartphone.getOs());
            statement.setString(5, smartphone.getCpu());
            statement.setInt(6, smartphone.getRam());
            statement.setBoolean(7, smartphone.isBluetooth());
            statement.setBoolean(8, smartphone.isLte());
            statement.setInt(9, smartphone.getCamera());
            statement.setDouble(10, smartphone.getPrice());
            statement.setInt(11, smartphone.getQuantity());
            int insertionSuccess = statement.executeUpdate();
            if (insertionSuccess == 1) {
                this.dbConnection.commit();
                return true;
            }
        } catch (SQLException e) {
            smartphoneManagerLogger.log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Smartphone> getAllSmartphone() {
        try {
            List<Smartphone> returnSmartphones = new ArrayList<>();

            PreparedStatement statement = dbConnection.prepareStatement(queryGetAllSmarphone);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnSmartphones.add(mapRow(rs));
            }
            return returnSmartphones;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Smartphone> getSmartphoneOUT(int min) {
        try {
            List<Smartphone> returnSmartphoneOut = new ArrayList<>();
            PreparedStatement statement = dbConnection.prepareStatement(queryGetSmartphoneOUT);
            statement.setInt(1, min);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnSmartphoneOut.add(mapRow(rs));
            }
            return returnSmartphoneOut;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteSmartphone(int id) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(queryDeleteSmartphone);
            statement.setInt(1, id);
            int deleteSuccess = statement.executeUpdate();
            if (deleteSuccess == 1) {
                this.dbConnection.commit();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editSmartphone(Smartphone sm) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(queryUpdateSmartphone);
            statement.setString(1, sm.getBrand());
            statement.setString(2, sm.getModel());
            statement.setString(3, sm.getDisplayInch());
            statement.setString(4, sm.getOs());
            statement.setString(5, sm.getCpu());
            statement.setInt(6, sm.getRam());
            statement.setInt(7, sm.getInternal_storage());
            statement.setBoolean(8, sm.isBluetooth());
            statement.setBoolean(9, sm.isLte());
            statement.setInt(10, sm.getCamera());
            statement.setDouble(11, sm.getPrice());
            statement.setInt(12, sm.getQuantity());
            statement.setInt(13, sm.getId());
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
    public Smartphone mapRow(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Smartphone returnSmartphone = new Smartphone();
            returnSmartphone.setBrand(rs.getString("brand"));
            returnSmartphone.setModel(rs.getString("model"));
            returnSmartphone.setDisplayInch(rs.getString("displayInch"));
            returnSmartphone.setOs(rs.getString("os"));
            returnSmartphone.setCpu(rs.getString("cpu"));
            returnSmartphone.setRam(rs.getInt("ram"));
            returnSmartphone.setInternal_storage(rs.getInt("internal_storage"));
            returnSmartphone.setBluetooth(rs.getBoolean("bluetooth"));
            returnSmartphone.setLte(rs.getBoolean("LTE"));
            returnSmartphone.setCamera(rs.getInt("camera"));
            returnSmartphone.setPrice(rs.getDouble("price"));
            returnSmartphone.setQuantity(rs.getInt("quantity"));
            return returnSmartphone;
        }
        return null;
    }

    private static String queryAddSmartphone = "INSERT INTO `mobilesolutions`.`smartphone` (`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static String queryDeleteSmartphone = "DELETE FROM `mobilesolutions`.`smartphone` WHERE `id`=?;";
    private static String queryGetSmartphoneOUT = "SELECT t.brand FROM mobilesolutions.smartphone t WHERE t.quantita=?";
    private static String queryGetAllSmarphone = "SELECT t.brand FROM mobilesolutions.smartphone t";
    private static String queryUpdateSmartphone = "UPDATE mobilesolutions.client SET brand=?,model=?," +
            "displayInch=?,os=?,cpu=?,ram=?,internal_storage=?,bluetooth=?," +
            "LTE=?,camera=?,price=?,quantity=? WHERE id=?;";


}
