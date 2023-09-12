package javaproject.boundary;

import javaproject.control.*;
import java.lang.reflect.Array;
import java.util.*;
import javaproject.model.*;

public class ShoppingBoundary implements Boudary{
    public int selection;
    public ShoppingControl shopCon=new ShoppingControl();
    public Cart cart=new Cart();

    public void allDisplay() throws Exception{   //显示进行的操作
        System.out.println("可以选择的功能如下:");
        System.out.println("  1、添加商品到购物车");
        System.out.println("  2、从购物车中移除商品");
        System.out.println("  3、修改购物车中内容");
        System.out.println("  4、查看购物车中内容");
        System.out.println("  5、付款");
        System.out.println("  6、退出该功能");
        System.out.print("请输入选择的功能:");
    }

    public void readSelection(){
        Scanner reader=new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void comAllDisplay() throws Exception{    //  显示所有商品
        shopCon.allSearch();
    }

    public void cartDisplay(){  //显示购物车内容
        System.out.println("商品编号\t\t\t\t商品名称\t\t\t\t商品型号\t\t\t\t商品购买量");
        for (int i=0;i<cart.ID.size();i++){
            System.out.print(String.format("%-20s", cart.ID.get(i)));
            System.out.print(String.format("%-20s", cart.name.get(i)));
            System.out.print(String.format("%-20s", cart.number.get(i)));
            System.out.println(String.format("%-20s", cart.sum.get(i)));
        }
    }

    public void addComCart() throws Exception{       //将商品加入购物车
        Scanner reader=new Scanner(System.in);
        System.out.print("请输入商品编号:");
        int ID=reader.nextInt();
        String temp=reader.nextLine();
        System.out.print("请输入购买数量:");
        int sum=reader.nextInt();
        temp=reader.nextLine();
        cart = shopCon.addToCart(this.cart, ID, sum);
        System.out.println("添加成功，购物车现有商品如下:");
        cartDisplay();
    }

    public void delComCart(){       //将商品从购物车中移除
        Scanner reader=new Scanner(System.in);
        System.out.print("请输入移除的商品的编号:");
        int ID=reader.nextInt();
        String temp=reader.nextLine();
        if (warningPrompt().equals("no")){   //确认是否移除商品
            return;
        }
        else {
            cart = shopCon.delInCart(this.cart, ID);
            System.out.println("移除成功，购物车现有商品如下:");
            cartDisplay();
        }
    }

    public void modifyComCart(){       //修改购物车中信息
        Scanner reader=new Scanner(System.in);
        System.out.print("请输入修改的商品的编号:");
        int ID=reader.nextInt();
        String temp=reader.nextLine();
        System.out.print("请输入修改后商品的数量:");
        int sum=reader.nextInt();
        temp=reader.nextLine();
        cart = shopCon.modifyInCart(this.cart, ID, sum);
        System.out.println("修改成功，购物车现有商品如下:");
        cartDisplay();
    }

    public String warningPrompt(){    //警告提示
        System.out.println("是否真的从购物车中删除该商品？删除后无法恢复，若删除请输入yes来确认删除，不删除输入no.");
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
