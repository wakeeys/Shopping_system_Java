package javaproject.boundary;

import javaproject.control.AdminSecretControl;
import javaproject.model.StringProcess;

import java.util.Scanner;

public class AdminSecretBoundary implements Boudary{
    public int selection;
    public String secret;
    AdminSecretControl secretManage=new AdminSecretControl();

    public void allDisplay() throws Exception{
        System.out.println("可以选择的功能如下:");
        System.out.println("  1、修改自身密码");
        System.out.println("  2、重置用户密码");
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
        secretManage.modifySecret("000", this.secret);
        this.modifyDisplay();
    }

    public void readSecretName() throws Exception{              //重置用户密码
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入需要重置密码的用户名:");
        String userName = reader.nextLine();
        System.out.print("请输入重置的密码:");
        String userSecret = reader.nextLine();
        StringProcess sp=new StringProcess();
        userSecret=sp.calc(userSecret);
        int temp = secretManage.resetSecret(userName, userSecret);
        this.resetDisplay(temp);
    }

    public void modifyDisplay(){            //密码修改是否成功显示
        System.out.println("修改密码成功!");
    }

    public void resetDisplay(int flag){     //密码重置是否成功显示
        if (flag==1){
            System.out.println("重置密码不成功，可能是没有此用户名");
        }
        else{
            System.out.println("重置密码成功!");
        }
    }

    public void exit(){
        System.out.println("退出该功能成功");
    }

    public void mistake(){
        System.out.println("您输入的选项不正确，请重新输入.");
    }
}
