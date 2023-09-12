package javaproject.boundary;

import javaproject.control.*;
import java.util.*;
import javaproject.model.*;

public class RegisterBoundary implements Boudary{
    public int seleciton;
    public String name;
    public String phone;
    public String secret;
    public String mail;
    public RegisterControl registerCon=new RegisterControl();

    public void allDisplay() throws Exception{
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入注册的用户名(用户名不小于5个字符)：");
        this.name = reader.nextLine();
        System.out.print("请输入注册的密码(密码不少于8个字符，且必须包含数字，大写小写字母，标点符号):");
        this.secret = reader.nextLine();
        System.out.print("请输入注册的电话号:");
        this.phone = reader.nextLine();
        System.out.print("请输入注册的邮箱:");
        this.mail = reader.nextLine();
    }

    public int registerJudge() throws Exception{    //注册合法性判断
        User use=new User();
        int temp = registerCon.Judge(this.name,this.secret);
        registerDisplay(temp);
        if (temp == 0) {
            use.init(name,phone,mail,secret);
            registerCon.addUserInfo(use);
        }
        return temp;
    }

    public void registerDisplay(int flag){  //注册成功与失败的显示
        if (flag==0){
            System.out.println("注册成功!请使用刚注册的账号密码登录");
        }
        else {
            System.out.println("注册失败，用户名和密码不符合规范");
        }
    }

    public void readSelection(){ }

    public void exit(){ }

    public void mistake(){ }
}
