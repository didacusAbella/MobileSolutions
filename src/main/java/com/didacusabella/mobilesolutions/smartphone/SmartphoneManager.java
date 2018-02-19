package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Smartphone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
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
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_ADD_SMARTPHONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, smartphone.getBrand());
            statement.setString(2, smartphone.getModel());
            statement.setString(3, smartphone.getDisplayInch());
            statement.setString(4, smartphone.getOs());
            statement.setString(5, smartphone.getCpu());
            statement.setInt(6, smartphone.getRam());
            statement.setInt(7, smartphone.getInternalStorage());
            statement.setBoolean(8, smartphone.isBluetooth());
            statement.setBoolean(9, smartphone.isLte());
            statement.setInt(10, smartphone.getCamera());
            statement.setDouble(11, smartphone.getPrice());
            statement.setInt(12, smartphone.getQuantity());
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

            PreparedStatement statement = dbConnection.prepareStatement(QUERY_GET_ALL_SMARTPHONE);
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
    public Smartphone getSmartphoneByID(int id) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_GET_SMARTPHONE);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Smartphone> getSmartphoneOUT(int min) {
        try {
            List<Smartphone> returnSmartphoneOut = new ArrayList<>();
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_GET_SMARTPHONE_OUT);
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
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_DELETE_SMARTPHONE);
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
            PreparedStatement statement = dbConnection.prepareStatement(QUERY_UPDATE_SMARTPHONE);
            statement.setString(1, sm.getBrand());
            statement.setString(2, sm.getModel());
            statement.setString(3, sm.getDisplayInch());
            statement.setString(4, sm.getOs());
            statement.setString(5, sm.getCpu());
            statement.setInt(6, sm.getRam());
            statement.setInt(7, sm.getInternalStorage());
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
        Smartphone returnSmartphone = new Smartphone();
        returnSmartphone.setId(rs.getInt("id"));
        returnSmartphone.setBrand(rs.getString("brand"));
        returnSmartphone.setModel(rs.getString("model"));
        returnSmartphone.setDisplayInch(rs.getString("displayInch"));
        returnSmartphone.setOs(rs.getString("os"));
        returnSmartphone.setCpu(rs.getString("cpu"));
        returnSmartphone.setRam(rs.getInt("ram"));
        returnSmartphone.setInternalStorage(rs.getInt("internal_storage"));
        returnSmartphone.setBluetooth(rs.getBoolean("bluetooth"));
        returnSmartphone.setLte(rs.getBoolean("LTE"));
        returnSmartphone.setCamera(rs.getInt("camera"));
        returnSmartphone.setPrice(rs.getDouble("price"));
        returnSmartphone.setQuantity(rs.getInt("quantity"));
        return returnSmartphone;
    }
    
  @Override
  public List<Smartphone> search(String brand) {
      try {
        List<Smartphone> smartphones = new ArrayList<>();
        PreparedStatement ps = this.dbConnection.prepareStatement(QUERY_SEARCH_SMARTPHONE);
        ps.setString(1, brand);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          smartphones.add(mapRow(rs));
        }
        return smartphones;
      } catch (SQLException ex) {
        smartphoneManagerLogger.log(Level.SEVERE, null, ex);
      }
    return null;
  }

  @Override
  public List<Smartphone> advancedSearch(Map<String, String[]> criterias) {
      try {
        StringJoiner queryBuilder = new StringJoiner(" AND ", "SELECT * FROM mobilesolutions.smartphone WHERE ", ";");
        criterias.forEach((param, value) -> {
          queryBuilder.add(param.concat("=").concat(value[0]));
        });
        PreparedStatement ps = this.dbConnection.prepareStatement(queryBuilder.toString());
        List<Smartphone> smartphones = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          smartphones.add(mapRow(rs));
        }
        return smartphones;
      } catch (SQLException ex) {
        smartphoneManagerLogger.log(Level.SEVERE, null, ex);
      }
      return null;
  }

    private static final String QUERY_GET_SMARTPHONE = "SELECT * FROM mobilesolutions.smartphone WHERE id=?";
    private static final String QUERY_ADD_SMARTPHONE = "INSERT INTO `mobilesolutions`.`smartphone` (`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_DELETE_SMARTPHONE = "DELETE FROM `mobilesolutions`.`smartphone` WHERE `id`=?;";
    private static final String QUERY_GET_SMARTPHONE_OUT = "SELECT * FROM mobilesolutions.smartphone  WHERE quantity<=?";
    private static final String QUERY_GET_ALL_SMARTPHONE = "SELECT * FROM mobilesolutions.smartphone ";
    private static final String QUERY_UPDATE_SMARTPHONE = "UPDATE mobilesolutions.smartphone SET brand=?,model=?," +
            "displayInch=?,os=?,cpu=?,ram=?,internal_storage=?,bluetooth=?," +
            "LTE=?,camera=?,price=?,quantity=? WHERE id=?;";
    private static final String QUERY_SEARCH_SMARTPHONE = "SELECT * FROM mobilesolutions.smartphone WHERE brand=?;";


}
