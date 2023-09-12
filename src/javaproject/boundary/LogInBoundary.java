package javaproject.boundary;

import javaproject.control.*;
import java.util.*;
import javaproject.model.*;

//登录界面显示
public class LogInBoundary implements Boudary{
    public String name;
    public String secret;
    public LogInControl logInCon = new LogInControl();

    public void allDisplay() throws Exception{
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入用户名：");
        this.name = reader.nextLine();
        System.out.print("请输入密码:");
        this.secret = reader.nextLine();
        logInCon.name=this.name;
    }

    public int controlExecute() throws Exception {
        StringProcess sp=new StringProcess();
        if (this.secret.equals("ynuadmin")) {
            logInCon.secret="ynuadmin";
        }
        else {
            logInCon.secret=sp.calc(this.secret);
        }
        return logInCon.functionExecute();
    }

    public void logInDisplay(int flag,int cnt){  //登录成功与失败的显示
        if (cnt==5){    //5次锁定
            System.out.println("用户名或密码已输错5次，账户被锁定，请退出系统.");
        }
        else if (flag==0){
            System.out.println("登录成功!您已进入购物系统");
        }
        else {
            System.out.println("登录失败，请重新输入用户名和密码!");
        }
    }

    public void readSelection(){ }

    public void exit(){ }

    public void mistake(){ }
}
