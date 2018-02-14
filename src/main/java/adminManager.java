import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Domenico Antonio Tropeano on 14/02/2018 at 10:58
 * @project MobileSolutions
 */
public class adminManager {
    private static String queryGetSmartphone = "SELECT t.brand FROM mobilesolutions.smartphone t WHERE t.id='1'";

    public static void main(String[] args) {
        try {
            Connection c = Database.getConnection();
            PreparedStatement psGetSmartphone = null;
            psGetSmartphone = c.prepareStatement(queryGetSmartphone);
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

}
