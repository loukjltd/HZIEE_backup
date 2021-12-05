import java.sql.SQLException;
import java.sql.*;

public class Example {
    public static void main(String[] args) throws SQLException {
        Statement newSta = null;
        ResultSet newRst = null;
        Connection newConn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userinfo";
            String username = "root";
            String password = "root";
            newConn = DriverManager.getConnection(url, username, password);
            newSta = newConn.createStatement();
            String sqlLang = "select * from basicinfo";
            newRst = newSta.executeQuery(sqlLang);
            System.out.println("userNo userName password sex age");
            while (newRst.next()) {
                int userNo = newRst.getInt("userno");
                String userName = newRst.getString("username");
                String userPassword = newRst.getString("password");
                String userSex = newRst.getString("sex");
                int userAge = newRst.getInt("age");
                System.out.println(userNo + userName + userPassword + userSex + userAge);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
