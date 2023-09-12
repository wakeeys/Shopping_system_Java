package javaproject.model;

import javaproject.boundary.*;

public class Client implements Person{
    String name;

    public void logIn() throws Exception{
        UserMainBoundary mainPageBound=new UserMainBoundary();  //  建立主页面
        while(true){
            mainPageBound.allDisplay();
            mainPageBound.readSelection();
            if (mainPageBound.selection == 1){    //密码管理
                UserSecretBoundary usSecretBound=new UserSecretBoundary(this.name);    //建立密码管理页面
                usSecretBound.allDisplay();
                usSecretBound.readSelection();
                if (usSecretBound.selection == 1){    //修改自身密码
                    usSecretBound.readSecret();
                }
                else if (usSecretBound.selection == 2){   //重置自身密码
                    usSecretBound.readSecretName();
                }
                else if (usSecretBound.selection == 3){
                    usSecretBound.exit();
                }
                else {
                    usSecretBound.mistake();
                }
            }
            else if (mainPageBound.selection==2){   //购物
                boolean flag=true;
                while(flag){
                    ShoppingBoundary shopBound=new ShoppingBoundary();  //建立购物页面
                    shopBound.comAllDisplay();
                    while(true){
                        shopBound.allDisplay();
                        shopBound.readSelection();
                        if (shopBound.selection==1){        //添加商品到购物车
                            shopBound.addComCart();
                        }
                        else if (shopBound.selection==2){   //从购物车中移除商品
                            shopBound.delComCart();
                        }
                        else if (shopBound.selection==3){   //修改购物车中内容
                            shopBound.modifyComCart();
                        }
                        else if (shopBound.selection==4){   //查看购物车中内容
                            shopBound.cartDisplay();
                        }
                        else if (shopBound.selection==5){   //付款
                            PayBoundary payBound=new PayBoundary(this.name);
                            payBound.allDisplay();
                            payBound.readSelection();
                            if (payBound.selection==1 || payBound.selection==2 || payBound.selection==3) {
                                payBound.payExecute(shopBound.cart);
                                break;
                            }
                            else if (payBound.selection==4){
                                payBound.exit();
                                continue;
                            }
                            else {
                                payBound.mistake();
                            }
                        }
                        else if (shopBound.selection==6){   //退出该功能
                            shopBound.exit();
                            flag=false;
                            break;
                        }
                        else {
                            shopBound.mistake();
                        }
                    }
                }
            }
            else if (mainPageBound.selection==3){   //查看购物历史记录
                ShoppingHistoryBoundary shopHisBound=new ShoppingHistoryBoundary(this.name);
                shopHisBound.allDisplay();
            }
            else if (mainPageBound.selection==4){
                break;
            }
            else {
                System.out.println("您输入的选项不正确，请重新输入.");
            }
        }
    }

    public Client(String name){
        this.name=name;
    }
}
