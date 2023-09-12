package javaproject.control;

import javaproject.model.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PayControl {
    public void comPayModify(Cart cart,String name) throws Exception{   //修改数据库商品剩余数量和用户消费总金额
        DatabaseConnection db=new DatabaseConnection();
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs=null;
        for (int i=0;i<cart.ID.size();i++){
            rs = stmt.executeQuery("select sum,price from commodity where ID="+"'"+Integer.toString(cart.ID.get(i))+"'");
            rs.next();
            int sum=rs.getInt("sum");
            float price=rs.getFloat("price");

            rs = stmt.executeQuery("select money,history from users where name="+"'"+name+"'");
            rs.next();
            float money=rs.getFloat("money");
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String time = date.format(formatter);
            String his = null;
            if (rs.getString("history")==null) {
                his = time + "&" + cart.name.get(i) + "&" + cart.number.get(i) + ",";
            }
            else {
                his = rs.getString("history") + time + "&" + cart.name.get(i) + "&" + cart.number.get(i) + ",";
            }

            String sql="update commodity set sum="+Integer.toString(sum-cart.sum.get((i)))+" where ID="+"'"+Integer.toString(cart.ID.get(i))+"'";  //修改操作
            stmt.executeUpdate(sql);
            sql="update users set money="+Float.toString(money+price*cart.sum.get(i))+" where name="+"'"+name+"'";  //修改操作
            stmt.executeUpdate(sql);
            sql="update users set history="+"'"+his+"'"+" where name="+"'"+name+"'";
            stmt.executeUpdate(sql);
        }
        db.closeConn(rs,stmt,conn);
    }
}
