package javaproject.control;

import javaproject.model.*;
import java.sql.*;

public class RegisterControl {

    public int  Judge(String name, String secret){  //判断账号密码合法
        int flag=1;
        if (name.length()>=5 && secret.length()>=8){
            boolean containsUpperCase = secret.matches(".*[A-Z].*"); // 判断是否包含大写字母
            boolean containsLowerCase = secret.matches(".*[a-z].*"); // 判断是否包含小写字母
            boolean containsDigit = secret.matches(".*\\d.*"); // 判断是否包含数字
            boolean containsPunctuation = secret.matches(".*\\p{Punct}.*"); // 判断是否包含标点符号
            if (containsUpperCase && containsLowerCase && containsDigit && containsPunctuation) {
                flag = 0;
            }
        }
        return flag;
    }

    public void addUserInfo(User use) throws Exception{ //向数据库增加用户信息
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        String sql="insert into users(ID,name,level,time,money,phone,mail,secret) values("+"'"+use.ID+"'";
        sql=sql+",'"+use.name+"'"+",'"+use.level+"'"+",'"+use.time+"'"+",'"+use.money+"'"+",'"+use.phone+"'"+",'"+use.mail+"'"+",'"+use.secret+"'"+")";
        stmt.executeUpdate(sql);                        //增加操作
        db.closeConn(null,stmt,conn);
    }
}
