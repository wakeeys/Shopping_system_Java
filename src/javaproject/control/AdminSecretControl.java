package javaproject.control;
import javaproject.model.*;
import java.sql.*;
import javaproject.boundary.*;

public class AdminSecretControl implements SecretControl{
    public void modifySecret(String name, String newSecret) throws Exception{     //修改密码
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并修改密码
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        String sql="update users set secret="+"'"+newSecret+"'"+" where name='admin' ";
        stmt.executeUpdate(sql);
        db.closeConn(null,stmt,conn);
    }

    public int resetSecret(String userName, String userSecret) throws Exception{  //重置密码
        int flag=1;
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并重置密码
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from users");//查询用户名在哪
        while (rs.next()) {
            //匹配成功
            if (rs.getString("name").equals(userName)){
                flag=0;
                String sql="update users set secret="+"'"+userSecret+"'"+" where name='"+userName+"' ";
                stmt.executeUpdate(sql);
                break;
            }
        }
        db.closeConn(rs,stmt,conn);

        return flag;
    }
}
