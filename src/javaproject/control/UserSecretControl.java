package javaproject.control;

import javaproject.model.*;
import java.sql.*;

public class UserSecretControl implements SecretControl{
    String name;
    String secret;
    public void modifySecret(String name, String newSecret) throws Exception{     //修改密码
        StringProcess sp=new StringProcess();
        newSecret = sp.calc(newSecret);
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并修改密码
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        String sql="update users set secret="+"'"+newSecret+"'"+" where name='"+name+"' ";
        stmt.executeUpdate(sql);
        db.closeConn(null,stmt,conn);
    }

    public int resetSecret(String userName, String secret) throws Exception{  //重置密码
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并重置密码
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name,mail from users");    //查询用户名在哪
        while (rs.next()) {
            //匹配成功
            if (rs.getString("name").equals(userName)){
                StringProcess sp=new StringProcess();
                String userSecret=sp.randGenerate();    //随机生成密码
                sp.mailSend(userSecret, rs.getString("mail"));    //发送密码到指定邮箱
                userSecret = sp.calc(userSecret);
                String sql="update users set secret="+"'"+userSecret+"'"+" where name='"+userName+"' ";
                stmt.executeUpdate(sql);
                break;
            }
        }
        db.closeConn(rs,stmt,conn);
        return 0;
    }
}
