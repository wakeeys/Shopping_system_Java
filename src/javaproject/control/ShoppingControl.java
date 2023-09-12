package javaproject.control;

import javaproject.model.*;
import java.sql.*;

public class ShoppingControl implements ManageControl{
    public void allSearch() throws Exception{     //显示所有商品信息
        DatabaseConnection db=new DatabaseConnection();
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from commodity");
        System.out.println("商品编号\t\t\t\t商品名称\t\t\t\t生产厂家\t\t\t\t生产日期\t\t\t\t型号\t\t\t零售价\t\t\t剩余数量:");
        while (rs.next()) {
            System.out.print(String.format("%-20s",rs.getString("ID"))+String.format("%-20s", rs.getString("name")));
            System.out.print(String.format("%-20s",rs.getString("manufacturer"))+String.format("%-20S",rs.getString("time")));
            System.out.println(String.format("%-15s",rs.getString("number"))+String.format("%-17s",rs.getString("price")+"元")+String.format("%-15s",rs.getString("sum")+"个"));
        }
        db.closeConn(rs,stmt,conn);
    }

    public Cart addToCart(Cart cart,int ID,int sum) throws Exception{      //向购物车加入商品
        DatabaseConnection db=new DatabaseConnection();
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from commodity");
        while (rs.next()) {
            if (rs.getString("ID").equals(Integer.toString(ID))){   //将商品加入购物车
                cart.ID.add(ID);
                cart.name.add(rs.getString("name"));
                cart.number.add(rs.getString("number"));
                cart.sum.add(sum);
                break;
            }
        }
        db.closeConn(rs,stmt,conn);
        return cart;
    }

    public Cart delInCart(Cart cart, int ID){   //从购物车中移除商品
        for (int i=0;i<cart.ID.size();i++){
            if (ID==cart.ID.get(i)){
                cart.ID.remove(i);
                cart.name.remove(i);
                cart.sum.remove(i);
                cart.number.remove(i);
                break;
            }
        }
        return cart;
    }

    public Cart modifyInCart(Cart cart, int ID, int sum){   //修改购物车中商品数量
        for (int i=0;i<cart.ID.size();i++){
            if (sum<=0 &&ID==cart.ID.get(i)){
                cart.ID.remove(i);
                cart.name.remove(i);
                cart.sum.remove(i);
                cart.number.remove(i);
                break;
            }
            else if (sum>0 &&ID==cart.ID.get(i)){
                cart.sum.set(i,sum);
                break;
            }
        }
        return cart;
    }

    public int oneSearch(String comId) throws Exception{
        return 0;
    }
}
