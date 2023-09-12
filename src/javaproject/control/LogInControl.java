package javaproject.control;

import javaproject.boundary.*;
import javaproject.model.*;
import java.sql.*;

//登录界面控制器
public class LogInControl {
    public String name;
    public String secret;
    public int cnt;

    public int functionExecute() throws Exception{   //比较账户密码是否匹配，不同结果有不同的返回类型
        int flag=1; //1是账户或密码错误，0是正确

        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name,secret from users");//查询操作
        while (rs.next()) {
            if (rs.getString("name").equals(this.name) && (rs.getString("secret").equals(this.secret))){
                flag=0;     //匹配成功
            }
        }
        db.closeConn(rs,stmt,conn);

        if (flag==1 && !this.name.equals("admin")) {
            cnt++;
        }
        return flag;
    }

}
