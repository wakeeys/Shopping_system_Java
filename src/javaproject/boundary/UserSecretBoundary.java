package javaproject.boundary;

import javaproject.control.*;
import javaproject.model.*;
import java.util.*;

public class UserSecretBoundary implements Boudary{
    public String name;
    public int selection;
    public String secret;
    UserSecretControl secretManage=new UserSecretControl();

    public void allDisplay() throws Exception{
        System.out.println("可以选择的功能如下:");
        System.out.println("  1、修改自身密码");
        System.out.println("  2、重置自身密码");
        System.out.println("  3、退出该功能");
        System.out.print("请输入选择的功能:");
    }

    public void readSelection(){
        Scanner reader = new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void readSecret() throws Exception{               //修改自身密码
        System.out.print("请输入修改后的密码:");
        Scanner reader = new Scanner(System.in);
        this.secret = reader.nextLine();
        secretManage.modifySecret(this.name, this.secret);
        System.out.println("修改密码成功!");
    }

    public void readSecretName() throws Exception{              //重置自身密码
        secretManage.resetSecret(this.name, "00");
        System.out.println("重置密码成功!");
    }

    public void exit(){
        System.out.println("退出该功能成功");
    }

    public void mistake(){
        System.out.println("您输入的选项不正确，请重新输入.");
    }

    public UserSecretBoundary(String name){
        this.name = name;
    }
}
