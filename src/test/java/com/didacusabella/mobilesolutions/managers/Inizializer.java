package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Domenico Antonio Tropeano on 22/02/2018 at 10:11
 * @project MobileSolutions
 */
public class Inizializer {
    public static void main(String[] args) {
        Database.isDebug(true);
        clearDB();
        initAdmin();
        initClient();
        initSmartphone();
    }

    private static void initSmartphone() {
        try {
            Connection connection = Database.getConnection();
            for (String s : INIT_SMARTPHONE) {
                System.out.println(s);
                PreparedStatement preparedStatement = connection.prepareStatement(s);
                preparedStatement.execute();
            }
            connection.commit();
            Database.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initClient() {
        try {
            Connection connection = Database.getConnection();
            for (String s : INIT_CLIENT) {
                System.out.println(s);
                PreparedStatement preparedStatement = connection.prepareStatement(s);
                preparedStatement.execute();
            }
            connection.commit();
            Database.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initAdmin() {
        try {
            Connection connection = Database.getConnection();
            for (String s : INIT_ADMIN) {
                System.out.println(s);
                PreparedStatement preparedStatement = connection.prepareStatement(s);
                preparedStatement.execute();
            }
            connection.commit();
            Database.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void clearDB() {
        try {
            Connection connection = Database.getConnection();
            for (String s : DROP_ALL_DATA) {
                System.out.println(s);
                PreparedStatement preparedStatement = connection.prepareStatement(s);
                preparedStatement.executeUpdate();
            }
            connection.commit();
            Database.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String[] DROP_ALL_DATA = {"DELETE FROM sale;", "DELETE FROM booking;", "DELETE FROM shipment;",
            "DELETE FROM payments;", "DELETE FROM smartphone;", "DELETE FROM admin;", "DELETE FROM client;"};
    private static final String[] INIT_ADMIN = {"INSERT INTO `testingdb5`.`admin` (`username`, `password`, `firstName`, `lastName`) VALUES ('gestore', 'gestore', 'Mario', 'Rossi');",
            "INSERT INTO `testingdb5`.`admin` (`username`, `password`, `firstName`, `lastName`) VALUES ('admin', 'admin', 'Lucia', 'Bianchi');"};
    private static final String[] INIT_CLIENT = {"INSERT INTO `testingdb5`.`client` (`name`, `last_name`, `tax_code`, `address`, `cap`, `city`, `province`, `tel_phone`, `mobile_phone`, `fax`, `username`, `password`, `email`) VALUES ('Domenico', 'Tropeano', 'TRPDNC95M01A509H', 'Via Tropeani 24', '83010', 'Grottolella', 'Av', '0825702375', '3395000044', '0825702375', 'oromis', 'P@ssw0rd', 'dtropeano@hotmail.it');",
            "INSERT INTO `testingdb5`.`client` (`name`, `last_name`, `tax_code`, `address`, `cap`, `city`, `province`, `tel_phone`, `mobile_phone`, `fax`, `username`, `password`, `email`) VALUES ('Mario', 'Rossi', 'FFJFKVKF555', 'Via Roma', '82554', 'Roma', 'RM', '082571552', '5855668855', '58855225', 'umber', 'umber', 'umber@umber.it');"};
    private static final String[] INIT_SMARTPHONE={"INSERT INTO `testingdb5`.`smartphone` (`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('Samsung', 'S8', '5.2', 'Android ', '2.0Ghz quad Core', '8', '64', '1', '1', '20', '800', '20');\n" +
            "INSERT INTO `testingdb5`.`smartphone` (`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('Apple', 'Iphone X', '5.3', 'iOS', '2.1 Octacore', '4', '256', '1', '1', '12', '1400', '200');",
            "INSERT INTO `testingdb5`.`smartphone` (`id`, `brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('18', 'Samsung', 'S8', '5.2', 'Android ', '2.0Ghz quad Core', '8', '64', '1', '1', '20', '800', '20');"};
}
