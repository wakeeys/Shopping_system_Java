package javaproject.boundary;

import javaproject.control.*;
import java.util.Scanner;

public class HomePageBoundary implements Boudary{
    public int selection;

    public void homeWelcome(){
        System.out.println("欢迎进入购物系统！");
    }

    public void allDisplay() throws Exception{
        System.out.println("请选择登录或者注册：1、登录   2、注册   3、退出系统");
        System.out.print("请输入选择的功能:");
    }

    public void readSelection(){
        Scanner reader = new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void exit(){
        System.out.println("已退出购物系统!");
    }

    public void mistake(){
        System.out.println("您输入的选项不正确，请重新输入.");
    }
}
