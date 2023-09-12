package javaproject.boundary;

import java.util.*;
import javaproject.control.PayControl;
import javaproject.model.*;

public class PayBoundary implements Boudary{
    public int selection;
    public String name;
    public PayControl payCon=new PayControl();

    public void allDisplay() throws Exception{
        System.out.println("请选择支付的方式并付款:");
        System.out.println("   1、支付宝");
        System.out.println("   2、微信");
        System.out.println("   3、建设银行卡");
        System.out.println("   4、退出支付，继续购物");
        System.out.print("请选择选项:");
    }

    public void readSelection(){
        Scanner reader=new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void payExecute(Cart cart) throws Exception{  //结账后,修改商品表中数据
        payCon.comPayModify(cart, this.name);
        System.out.println("支付成功!");
    }

    public void exit(){
        System.out.println("退出支付成功，请继续购物");
    }

    public void mistake(){
        System.out.println("您输入的选项不正确，请重新进行支付.");
    }

    public PayBoundary(String name){
        this.name=name;
    }
}
