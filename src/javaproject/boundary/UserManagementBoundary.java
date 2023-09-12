package javaproject.boundary;

import javaproject.control.*;
import java.util.*;

public class UserManagementBoundary implements Boudary{
    public int selection;
    public UserManagementControl userManageCon = new UserManagementControl();

    public void allDisplay() throws Exception{
        System.out.println("可以选择的功能如下:");
        System.out.println("  1、列出所有客户信息");
        System.out.println("  2、删除客户信息");
        System.out.println("  3、查询客户信息");
        System.out.println("  4、退出该功能");
        System.out.print("请输入选择的功能:");
    }

    public void readSelection() {
        Scanner reader=new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void userAllDisplay() throws Exception{   //显示所有客户信息
        userManageCon.allSearch();
    }

    public void delUserInfo() throws Exception{      //删除某个客户信息
        System.out.print("请输入删除的客户用户名:");
        Scanner reader=new Scanner(System.in);
        String userName = reader.nextLine();
        String sel = this.warningPrompt();
        if (sel.equals("no")){
            System.out.println("取消删除成功.");
        }
        int temp = userManageCon.delUserInfo(userName);
        if (temp == 0){
            System.out.println("删除用户信息成功");
        }
        else {
            System.out.println("删除用户信息失败，可能是用户名输入有误");
        }
    }

    public void userOneDisplay() throws Exception{   //显示单个客户信息
        System.out.print("请输入需查询的客户的用户名或ID:");
        Scanner reader=new Scanner(System.in);
        String userSign = reader.nextLine();
        int temp = userManageCon.oneSearch(userSign);
        if (temp == 1){
            System.out.println("用户查询失败，可能是用户名或ID输入有误");
        }
    }

    public String warningPrompt(){    //警告提示
        System.out.println("是否真的删除该商品信息？删除后无法恢复，若删除请输入yes来确认删除，不删除输入no.");
        System.out.print("请进行删除选择:");
        Scanner reader=new Scanner(System.in);
        String sel = reader.nextLine();
        return sel;
    }

    public void exit(){
        System.out.println("退出该功能成功");
    }

    public void mistake(){
        System.out.println("您输入的选项不正确，请重新输入.");
    }

}
