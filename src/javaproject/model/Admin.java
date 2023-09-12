package javaproject.model;

import javaproject.boundary.*;

public class Admin implements Person{
    public void logIn() throws Exception{
        boolean flag=true;
        AdminMainBoundary mainPageBound=new AdminMainBoundary();  //  建立主页面
        while(true){
            mainPageBound.allDisplay();
            mainPageBound.readSelection();
            if (mainPageBound.selection == 1){    //密码管理
                AdminSecretBoundary adSecretBound=new AdminSecretBoundary();    //建立密码管理页面
                adSecretBound.allDisplay();
                adSecretBound.readSelection();
                if (adSecretBound.selection == 1){    //修改自身密码
                    adSecretBound.readSecret();
                }
                else if (adSecretBound.selection == 2){   //重置用户密码
                    adSecretBound.readSecretName();
                }
                else if (adSecretBound.selection == 3){
                    adSecretBound.exit();
                }
                else {
                    adSecretBound.mistake();
                }
            }
            else if (mainPageBound.selection==2){
                UserManagementBoundary userManageBound=new UserManagementBoundary();    //建立用户管理页面
                userManageBound.allDisplay();
                userManageBound.readSelection();
                if (userManageBound.selection == 1){    //列出所有客户信息
                    userManageBound.userAllDisplay();
                }
                else if (userManageBound.selection == 2){   //删除客户信息
                    userManageBound.delUserInfo();
                }
                else if (userManageBound.selection == 3){   //查询单个客户信息
                    userManageBound.userOneDisplay();
                }
                else if (userManageBound.selection == 4){
                    userManageBound.exit();
                }
                else {
                    userManageBound.mistake();
                }
            }
            else if (mainPageBound.selection==3){
                CommodityManagementBoundary comManageBound=new CommodityManagementBoundary();    //建立商品管理页面
                comManageBound.allDisplay();
                comManageBound.readSelection();
                if (comManageBound.selection == 1){    //列出所有商品信息
                    comManageBound.comAllDisplay();
                }
                else if (comManageBound.selection == 2){   //删除商品信息
                    comManageBound.delComInfo();
                }
                else if (comManageBound.selection == 3){   //查询单个商品信息
                    comManageBound.comOneDisplay();
                }
                else if (comManageBound.selection == 4){   //添加商品信息
                    comManageBound.comAddInfo();
                }
                else if (comManageBound.selection == 5){   //修改商品信息
                    comManageBound.comModifyInfo();
                }
                else if (comManageBound.selection == 6){
                    comManageBound.exit();
                }
                else {
                    comManageBound.mistake();
                }
            }
            else if (mainPageBound.selection==4){
                break;
            }
            else {
                System.out.println("您输入的选项不正确，请重新输入.");
            }
        }
    }
}
