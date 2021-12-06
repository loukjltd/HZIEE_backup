import java.sql.SQLException;
import java.sql.*;

public class Example {
    public static void main(String[] args) throws SQLException {
        Statement newSta, newSta2;
        PreparedStatement newPrepSta = null;
        ResultSet newRst, newRst2;
        Connection newConn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userinfo";
            String username = "root";
            String password = "root";
            newConn = DriverManager.getConnection(url, username, password);

            newSta = newConn.createStatement();
            newSta2 = newConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlSelectLang = "SELECT * FROM basicinfo";
            String sqlInsertLang = "INSERT INTO basicinfo(username, password, sex, age)" + "VALUES(?,?,?,?)";
            newPrepSta = newConn.prepareStatement(sqlInsertLang);
            newRst = newSta.executeQuery(sqlSelectLang);
            newRst2 = newSta2.executeQuery(sqlSelectLang);
            newPrepSta.setString(1, "sean");
            newPrepSta.setString(2, "123");
            newPrepSta.setString(3, "male");
            newPrepSta.setInt(4, 22);
            newPrepSta.executeUpdate();
            System.out.println("userNo userName password sex age");
            System.out.print("第2条数据的username值为：");
            newRst2.absolute(2);
            System.out.println(newRst2.getString("username"));
            System.out.print("第1条数据的username值为：");
            newRst2.beforeFirst();
            newRst2.next();
            System.out.println(newRst2.getString("username"));
            System.out.print("第4条数据的username值为：");
            newRst2.afterLast();
            newRst2.previous();
            System.out.println(newRst2.getString("username"));
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
        } finally {
            if (newPrepSta != null) {
                try {
                    newPrepSta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (newConn != null) {
                try {
                    newConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
