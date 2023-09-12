package javaproject.control;

import javaproject.boundary.Boudary;
import javaproject.model.*;
import java.sql.*;

public class CommodityManagementControl implements ManageControl {
    String name;
    String id;

    public void allSearch() throws Exception{    //获取所有商品信息
        DatabaseConnection db=new DatabaseConnection(); //连接数据库
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from commodity");
        System.out.println("商品编号\t\t\t\t商品名称\t\t\t\t生产厂家\t\t\t\t生产日期\t\t\t\t型号\t\t\t进货价\t\t\t零售价\t\t\t剩余数量:");
        while (rs.next()) {
            System.out.print(String.format("%-20s",rs.getString("ID"))+String.format("%-20s", rs.getString("name")));
            System.out.print(String.format("%-20s",rs.getString("manufacturer"))+String.format("%-20S",rs.getString("time")));
            System.out.println(String.format("%-15s",rs.getString("number"))+String.format("%-15s",rs.getString("cost")+"元")+String.format("%-17s",rs.getString("price")+"元")+String.format("%-15s",rs.getString("sum")+"个"));
        }
        db.closeConn(rs,stmt,conn);
    }

    public int delComInfo(String comId) throws Exception{      //删除商品信息
        int flag=1;
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select ID from commodity");//查询操作
        while (rs.next()) {
            if (rs.getString("ID").equals(comId) ){
                flag=0;     //匹配成功
            }
        }
        stmt.executeUpdate("delete from commodity where ID="+"'"+comId+"'");    //删除操作
        db.closeConn(rs,stmt,conn);
        return flag;
    }

    public int oneSearch(String comId) throws Exception{    //商品信息查询
        int flag=1;
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from commodity");//查询操作
        while (rs.next()) {
            if (rs.getString("ID").equals(comId) ){
                flag=0;     //匹配成功
                System.out.println("商品编号\t\t\t\t商品名称\t\t\t\t生产厂家\t\t\t\t生产日期\t\t\t\t型号\t\t\t进货价\t\t\t零售价\t\t\t剩余数量:");
                System.out.print(String.format("%-20s",rs.getString("ID"))+String.format("%-20s", rs.getString("name")));
                System.out.print(String.format("%-20s",rs.getString("manufacturer"))+String.format("%-20S",rs.getString("time")));
                System.out.println(String.format("%-15s",rs.getString("number"))+String.format("%-15s",rs.getString("cost")+"元")+String.format("%-17s",rs.getString("price")+"元")+String.format("%-15s",rs.getString("sum")+"个"));
            }
        }
        db.closeConn(rs,stmt,conn);
        return flag;
    }

    public void addComInfo(Commodity com) throws Exception{      //添加商品信息
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        String sql="insert into commodity(ID,name,manufacturer,time,number,cost,price,sum) values("+"'"+com.ID+"'";
        sql=sql+",'"+com.name+"'"+",'"+com.manufacturer+"'"+",'"+com.time+"'"+",'"+com.number+"'"+",'"+com.cost+"'"+",'"+com.price+"'"+",'"+com.sum+"'"+")";
        stmt.executeUpdate(sql);//增加操作
        db.closeConn(null,stmt,conn);
    }

    public int modifyComInfo(String comId, String  comName, String comInfo) throws Exception{  //修改商品信息
        int flag=1;
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from commodity");
        while (rs.next()) {
            if (rs.getString("ID").equals(comId) ){
                flag=0;     //匹配成功
            }
        }
        String sql="update commodity set "+comName+"="+"'"+comInfo+"'"+" where ID="+"'"+comId+"'";  //修改操作
        stmt.executeUpdate(sql);
        db.closeConn(rs,stmt,conn);
        return flag;
    }

}
