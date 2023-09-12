package javaproject.boundary;

import java.util.*;

public class AdminMainBoundary implements Boudary{
    public int selection;

    public void allDisplay() throws Exception{
        System.out.println("可以选择的功能如下:");
        System.out.println("  1、密码管理");
        System.out.println("  2、客户管理");
        System.out.println("  3、商品管理");
        System.out.println("  4、退出登录");
        System.out.print("请输入选择的功能:");
    }

    public void readSelection(){
        Scanner reader=new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void exit(){ }

    public void mistake(){ }
}
