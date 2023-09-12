package javaproject.model;

import java.sql.*;
import java.time.*;
import java.time.format.*;

public class User implements Product{
    public int ID;
    public String name;
    public int level;
    public String time;
    public float money;
    public String phone;
    public String mail;
    public String secret;

    public void init(String name, String phone, String mail, String secret){
        StringProcess sp=new StringProcess();
        this.name=name;
        this.phone=phone;
        this.mail=mail;
        this.secret=sp.calc(secret);
    }

    public User() throws Exception{
        DatabaseConnection db=new DatabaseConnection(); //获取ID值
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select ID from users");
        while (rs.next()) {
            int temp=rs.getInt("ID");
            if (temp>=this.ID) this.ID=temp;
            this.ID+=1;
        }
        db.closeConn(rs,stmt,conn);
        this.level=1;
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.time = date.format(formatter);
        this.money=0;
    }
}
