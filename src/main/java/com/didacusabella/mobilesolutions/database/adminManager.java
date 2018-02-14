package com.didacusabella.mobilesolutions.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Domenico Antonio Tropeano on 14/02/2018 at 10:58
 * @project MobileSolutions
 */
public class adminManager {

    public static void main(String[] args) {
        try {
            Connection c = Database.getConnection();
            PreparedStatement psGetSmartphone = null;
            psGetSmartphone = c.prepareStatement(queryGetSmartphoneByID);
            ResultSet rs = psGetSmartphone.executeQuery();
            if (!rs.isBeforeFirst()) {
                throw new SQLException();
            }
            while (rs.next()) {
                System.out.println(rs.getString("brand"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static String queryGetSmartphoneByID = "SELECT t.brand FROM mobilesolutions.smartphone t WHERE t.id=?";
    private static String queryCheckGetUser = "SELECT t FROM mobilesolutions.client t WHERE t.username=? ";
    private static String queryCheckGetAdmin = "SELECT t FROM mobilesolutions.admin t WHERE t.username=? ";
    private static String querySignup = "INSERT INTO `mobilesolutions`.`client` (`name`, `last_name`, `tax_code`, `address`, `cap`, `city`, `province`, `tel_phone`, `mobile_phone`, `fax`, `username`, `password`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static String queryDeleteAccount = "DELETE FROM `mobilesolutions`.`client` WHERE `id`=?;";
    private static String queryAddProductToCart = "INSERT INTO `mobilesolutions`.`booking` (`product`, `username`, `datetime`, `quantity`) VALUES (?, ?, ?, ?);";
    private static String queryBuyProduct = "INSERT INTO `mobilesolutions`.`sale` (`product`, `username`, `datetime`, `quantity`, `price`, `shipmentType`, `paymentType`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    //gestore
    private static String queryAddSmartphone = "INSERT INTO `mobilesolutions`.`smartphone` (`brand`, `model`, `displayInch`, `os`, `cpu`, `ram`, `internal_storage`, `bluetooth`, `LTE`, `camera`, `price`, `quantity`) VALUES ('?', '?', '?', '', '?', '?', '?', '?', '?', '?', '?', '?');";
    private static String queryDeleteSmartphone = "DELETE FROM `mobilesolutions`.`smartphone` WHERE `id`=?;";
    private static String queryGetAllClients = "SELECT * FROM mobilesolutions.client * ";
    private static String queryGetSmartphoneOUT = "SELECT t.brand FROM mobilesolutions.smartphone t WHERE t.quantita=?";
    private static String queryEditSmartphone="";


}
