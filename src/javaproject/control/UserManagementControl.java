package javaproject.control;

import javaproject.boundary.Boudary;
import javaproject.model.*;
import java.sql.*;
import java.util.*;

public class UserManagementControl implements ManageControl {
    String use[]=new String[2];
    String le[]={"铜牌","银牌","金牌"};

    public void allSearch() throws Exception{    //列出所有用户信息
        DatabaseConnection db=new DatabaseConnection(); //连接数据库
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        System.out.println("ID号\t\t\t\t姓名\t\t\t\t用户级别\t\t\t\t注册时间\t\t\t\t累计消费金额\t\t\t用户手机号\t\t\t用户邮箱");
        while (rs.next()) {
            System.out.print(String.format("%-20s", rs.getString("id"))+String.format("%-20s", rs.getString("name")));
            System.out.print(String.format("%-19s", le[rs.getInt("level")-1])+String.format("%-20s", rs.getString("time")));
            System.out.println(String.format("%-20s", rs.getString("money"))+String.format("%-20s", rs.getString("phone"))+String.format("%-20s", rs.getString("mail")));
        }
        db.closeConn(rs,stmt,conn);
    }

    public int delUserInfo(String userName) throws Exception{      //删除用户信息
        int flag=1;
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from users");//查询操作
        while (rs.next()) {
            if (rs.getString("name").equals(userName) ){
                flag=0;     //匹配成功
            }
        }
        stmt.executeUpdate("delete from users where name="+"'"+userName+"'");
        db.closeConn(rs,stmt,conn);
        return flag;
    }

    public int oneSearch(String userSign) throws Exception{    //用户信息查询
        String res[]=new String[2];
        res[0]="name";
        res[1]="ID";
        int flag=1,cnt=0;
        if (userSign.length()<5 && userSign.matches("\\d+")){   //长度小于5且全是数字，则为ID,否则是用户名
            this.use[1]=userSign;
            cnt = 1;
        }
        else {
            this.use[0] = userSign;
        }

        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");//查询操作
        while (rs.next()) {
            if (rs.getString(res[cnt]).equals(this.use[cnt]) ){
                flag=0;     //匹配成功
                System.out.println("ID号\t\t\t\t姓名\t\t\t\t用户级别\t\t\t\t注册时间\t\t\t\t累计消费金额\t\t\t用户手机号\t\t\t用户邮箱");
                System.out.print(String.format("%-20s", rs.getString("id"))+String.format("%-20s", rs.getString("name")));
                System.out.print(String.format("%-19s", le[rs.getInt("level")-1])+String.format("%-20s", rs.getString("time")));
                System.out.println(String.format("%-20s", rs.getString("money"))+String.format("%-20s", rs.getString("phone"))+String.format("%-20s", rs.getString("mail")));
            }
        }
        db.closeConn(rs,stmt,conn);
        return flag;
    }
}
