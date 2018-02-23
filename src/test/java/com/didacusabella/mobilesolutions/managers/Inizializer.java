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
        populator(INIT_ADMIN);
        populator(INIT_CLIENT);
        populator(INIT_SMARTPHONE);
        populator(INIT_PAYMENTS);
        populator(INIT_SHIPMENT);
        populator(INIT_BOOKING);
        populator(INIT_SALES);

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

    private static void populator(String[] initStuff) {
        try {
            Connection connection = Database.getConnection();
            for (String s : initStuff) {
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

    private static final String[] DROP_ALL_DATA = {"DELETE FROM sale;", "DELETE FROM booking;", "DELETE FROM shipment;",
            "DELETE FROM payments;", "DELETE FROM smartphone;", "DELETE FROM admin;", "DELETE FROM client;"};
    private static final String[] INIT_ADMIN = {"INSERT INTO `testingdb5`.`admin` (`username`, `password`, `firstName`, `lastName`) VALUES ('gestore', 'gestore', 'Mario', 'Rossi');",
            "INSERT INTO `testingdb5`.`admin` (`username`, `password`, `firstName`, `lastName`) VALUES ('admin', 'admin', 'Lucia', 'Bianchi');"};
    private static final String[] INIT_CLIENT = {"INSERT INTO `testingdb5`.`client` (`id`,`name`, `last_name`, `tax_code`, `address`, `cap`, `city`, `province`, `tel_phone`, `mobile_phone`, `fax`, `username`, `password`, `email`) VALUES ('1','Domenico', 'Tropeano', 'TRPDNC95M01A509H', 'Via Tropeani 24', '83010', 'Grottolella', 'Av', '0825702375', '3395000044', '0825702375', 'oromis', 'umber', 'dtropeano@hotmail.it');",
            "INSERT INTO `testingdb5`.`client` (`id`,`name`, `last_name`, `tax_code`, `address`, `cap`, `city`, `province`, `tel_phone`, `mobile_phone`, `fax`, `username`, `password`, `email`) VALUES ('2','Mario', 'Rossi', 'FFJFKVKF555', 'Via Roma', '82554', 'Roma', 'RM', '082571552', '5855668855', '58855225', 'umber', 'umber', 'umber@umber.it');"};
    private static final String[] INIT_SMARTPHONE = {"INSERT INTO `testingdb5`.`smartphone` (`id`,`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('1','Samsung', 'S8', '5.2', 'Android ', '2.0Ghz quad Core', '8', '64', '1', '1', '20', '800', '20');",
            "INSERT INTO `testingdb5`.`smartphone` (`id`,`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('2','Apple', 'Iphone X', '5.3', 'iOS', '2.1 Octacore', '4', '256', '1', '1', '12', '1400', '200');",
            "INSERT INTO `testingdb5`.`smartphone` (`id`, `brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('3', 'Samsung', 'S9', '5.2', 'Android ', '2.0Ghz quad Core', '8', '64', '1', '1', '20', '800', '20');"};
    private static final String[] INIT_SHIPMENT = {"INSERT INTO `testingdb5`.`shipment` (`id`,`name`, `price`, `dayRange`) VALUES ('2','SDA', '12', '5-6');",
            "INSERT INTO `testingdb5`.`shipment` (`id`,`name`, `price`, `dayRange`) VALUES ('1','GLS', '15', '3-4');"};
    private static final String[] INIT_PAYMENTS = {"INSERT INTO `testingdb5`.`payments` (`id`,`name`, `price`) VALUES ('1','Paypal', '2');",
            "INSERT INTO `testingdb5`.`payments` (`id`,`name`, `price`) VALUES ('2','Bancomat', '5');"};
    private static final String[] INIT_BOOKING = {"INSERT INTO `testingdb5`.`booking` (`product`, `username`, `datetime`, `quantity`) VALUES ('1', '2', '2018-02-18 03:56:37', '2');",
            "INSERT INTO `testingdb5`.`booking` (`product`, `username`, `datetime`, `quantity`) VALUES ('2', '1', '2018-02-18 03:56:37', '5');",
            "INSERT INTO `testingdb5`.`booking` (`product`, `username`, `datetime`, `quantity`) VALUES ('1', '1', '2018-02-18 03:56:37', '1');"};
    private static final String[] INIT_SALES = {"INSERT INTO `testingdb5`.`sale` (`product`, `username`, `datetime`, `quantity`, `price`, `shipmentType`, `paymentType`) VALUES ('1', '1', '2018-02-18 03:56:37', '1', '200', '1', '1');",
            "INSERT INTO `testingdb5`.`sale` (`product`, `username`, `datetime`, `quantity`, `price`, `shipmentType`, `paymentType`) VALUES ('1', '2', '2018-02-18 03:56:37', '2', '400', '2', '2');",
            "INSERT INTO `testingdb5`.`sale` (`product`, `username`, `datetime`, `quantity`, `price`, `shipmentType`, `paymentType`) VALUES ('2', '1', '2018-02-18 03:56:37', '3', '600', '1', '2');"};
}
