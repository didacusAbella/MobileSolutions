package com.didacusabella.mobilesolutions.client;


import com.didacusabella.mobilesolutions.UsernameAlreadyExistException;
import com.didacusabella.mobilesolutions.database.Database;
import com.didacusabella.mobilesolutions.database.Mappable;
import com.didacusabella.mobilesolutions.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author diego Class that handle client table
 */
public class ClientManager implements Mappable<Client>, ClientDao {

    private static ClientManager clientManager = null;
    private final Connection dbConnection;
    private static Logger clientManagerLogger = Logger.getLogger(ClientManager.class.getName());
    private static final String GET_ID_CLIENT = "SELECT id FROM mobilesolutions.client WHERE username=?";
    private static final String CREATE_CLIENT = "INSERT INTO mobilesolutions.client"
            + " (name, last_name, tax_code, address, cap, city, province, tel_phone, "
            + "mobile_phone, fax, username, password, email) VALUES (?, ?, ?, ?, "
            + "?, ?, ?, ? , ?, ?, ?, ?, ?);";

    private static final String UPDATE_CLIENT = "UPDATE mobilesolutions.client SET name=?, "
            + "last_name=?, tax_code=?, address=?, cap=?, city=?, province=?, "
            + "tel_phone=?, mobile_phone=?, fax=?, username=?, password=?, email=? WHERE id=?;";

    private static final String READ_CLIENTS = "SELECT * FROM mobilesolutions.client;";
    private static final String DELETE_CLIENT = "DELETE FROM mobilesolutions.client WHERE id=?;";
    private static final String READ_CLIENT = "SELECT * FROM mobilesolutions.client WHERE id=?;";
    private static final String LOGIN_CLIENT = "SELECT * FROM mobilesolutions.client"
            + " WHERE username=? AND password=?;";

    private ClientManager(Connection connection) {
        super();
        this.dbConnection = connection;
    }


    public static ClientManager getInstance() throws SQLException {
        if (clientManager == null) {
            clientManager = new ClientManager(Database.getConnection());
            return clientManager;
        } else
            return clientManager;
    }

    @Override
    public Client mapRow(ResultSet rs) throws SQLException {
        Client returnClient = new Client();
        returnClient.setId(rs.getInt("id"));
        returnClient.setName(rs.getString("name"));
        returnClient.setLastName(rs.getString("last_name"));
        returnClient.setTaxCode(rs.getString("tax_code"));
        returnClient.setAddress(rs.getString("address"));
        returnClient.setCap(rs.getString("cap"));
        returnClient.setCity(rs.getString("city"));
        returnClient.setProvince(rs.getString("province"));
        returnClient.setTelPhone(rs.getString("tel_phone"));
        returnClient.setMobilePhone(rs.getString("mobile_phone"));
        returnClient.setFax(rs.getString("fax"));
        returnClient.setUsername(rs.getString("username"));
        returnClient.setPassword(rs.getString("password"));
        returnClient.setEmail(rs.getString("email"));
        return returnClient;
    }

    @Override
    public Client getClient(int id) {
        try {
            PreparedStatement stmt = dbConnection.prepareStatement(READ_CLIENT);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Client cl = null;
            if (rs.next()) {
                cl = mapRow(rs);
            }
            return cl;
        } catch (SQLException ex) {
            clientManagerLogger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        try {
            List<Client> clients = new ArrayList<>();
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(READ_CLIENTS);
            while (rs.next()) {
                clients.add(mapRow(rs));
            }
            return clients;
        } catch (SQLException ex) {
            clientManagerLogger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insertClient(Client client) throws UsernameAlreadyExistException {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(CREATE_CLIENT);
            if (getInstance().getClient(client.getId()) != null) {
                throw new UsernameAlreadyExistException();
            } else {
                statement.setString(1, client.getName());
                statement.setString(2, client.getLastName());
                statement.setString(3, client.getTaxCode());
                statement.setString(4, client.getAddress());
                statement.setString(5, client.getCap());
                statement.setString(6, client.getCity());
                statement.setString(7, client.getProvince());
                statement.setString(8, client.getTelPhone());
                statement.setString(9, client.getMobilePhone());
                statement.setString(10, client.getFax());
                statement.setString(11, client.getUsername());
                statement.setString(12, client.getPassword());
                statement.setString(13, client.getEmail());
                int insertionSuccess = statement.executeUpdate();
                if (insertionSuccess == 1) {
                    this.dbConnection.commit();
                    return true;
                }
            }
        } catch (SQLException ex) {
            clientManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteClient(int id) {
        try {
            PreparedStatement stmt = dbConnection.prepareStatement(DELETE_CLIENT);
            stmt.setInt(1, id);
            int deleteSuccess = stmt.executeUpdate();
            if (deleteSuccess == 1) {
                this.dbConnection.commit();
                return true;
            }
        } catch (SQLException ex) {
            clientManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        try {
            PreparedStatement statement = this.dbConnection.prepareStatement(UPDATE_CLIENT);
            statement.setString(1, client.getName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getTaxCode());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getCap());
            statement.setString(6, client.getCity());
            statement.setString(7, client.getProvince());
            statement.setString(8, client.getTelPhone());
            statement.setString(9, client.getMobilePhone());
            statement.setString(10, client.getFax());
            statement.setString(11, client.getUsername());
            statement.setString(12, client.getPassword());
            statement.setString(13, client.getEmail());
            statement.setInt(14, client.getId());
            int updateSuccess = statement.executeUpdate();
            if (updateSuccess == 1) {
                this.dbConnection.commit();
                return true;
            }
        } catch (SQLException ex) {
            clientManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        try {
            PreparedStatement ps = this.dbConnection.prepareStatement(LOGIN_CLIENT);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            clientManagerLogger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Return the id associated with the username
     *
     * @param username
     * @return {@code client} if is ok, {@code null} if this client doesn't exist.
     */
    @Override
    public Client getClient(String username) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(GET_ID_CLIENT);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
