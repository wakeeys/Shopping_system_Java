package javaproject.control;

import javaproject.model.*;
import java.sql.*;
import java.util.*;

public class ShoppingHistoryControl {
    public ArrayList<ArrayList<String>> historyDisplay(String name) throws Exception{
        String history="";
        DatabaseConnection db=new DatabaseConnection(); //连接数据库并查询
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        while (rs.next()) {
            if (rs.getString("name").equals(name)){
                history=rs.getString("history");
                break;
            }
        }
        db.closeConn(rs,stmt,conn);

        StringProcess sp=new StringProcess();
        ArrayList<ArrayList<String>> res=sp.stringSlice(history);
        return res;
    }
}
