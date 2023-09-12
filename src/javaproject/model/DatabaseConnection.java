package javaproject.model;
import java.sql.*;

//用于数据库连接和释放
public class DatabaseConnection {
    //数据库连接
    public Connection getConn() throws Exception{
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  //注册驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_system?serverTimezone=UTC", "root", "307652");
            System.out.println("数据库连接成功");
        }
        catch (Exception e){
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        finally {
            return conn;
        }
    }
    //数据库释放
    public void closeConn(ResultSet rs, Statement stmt, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
