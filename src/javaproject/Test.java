package javaproject;

import javaproject.boundary.*;
import javaproject.model.*;
import javaproject.control.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        boolean flag=true;
        HomePageBoundary homePageBound=new HomePageBoundary();   //首页的建立
        homePageBound.homeWelcome();
        while(flag) {
            homePageBound.allDisplay();
            homePageBound.readSelection();
            if (homePageBound.selection == 1){    //登录
                LogInBoundary logInBound=new LogInBoundary();   //登录界面建立
                int temp=1;
                while(temp==1){
                    logInBound.allDisplay();
                    temp = logInBound.controlExecute();
                    logInBound.logInDisplay(temp, logInBound.logInCon.cnt);
                    if (temp == 0){                //登录成功
                        if (logInBound.name.equals("admin")){
                            Admin ad=new Admin();
                            ad.logIn();
                            break;
                        }
                        else {
                            Client cl=new Client(logInBound.name);
                            cl.logIn();
                            break;
                        }
                    }
                    if (logInBound.logInCon.cnt == 5){
                        break;
                    }
                }
            }
            else if (homePageBound.selection == 2){   //注册
                RegisterBoundary registerBound=new RegisterBoundary();  //注册界面建立
                while(true){
                    registerBound.allDisplay();
                    int temp = registerBound.registerJudge();
                    if (temp!=1) break;
                }
            }
            else if (homePageBound.selection == 3){    //退出系统
                homePageBound.exit();
                flag=false;
            }
            else{
                homePageBound.mistake();
            }
        }
    }
}




