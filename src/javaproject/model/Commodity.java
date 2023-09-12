package javaproject.model;

import java.util.*;
import java.text.*;

public class Commodity implements Product{
    public int ID;
    public String name;
    public String manufacturer;
    public String time;
    public String number;
    public float cost;
    public float price;
    public int sum;

    public void init(String name,String manufacturer, String time, String number){
        Scanner reader=new Scanner(System.in);
        System.out.print("请输入ID号:");
        this.ID=reader.nextInt();
        String temp=reader.nextLine();
        System.out.print("请输入商品名:");
        this.name=reader.nextLine();
        System.out.print("请输入生产厂家:");
        this.manufacturer=reader.nextLine();
        System.out.print("请输入日期(格式：***-*-*):");
        this.time=reader.nextLine();
        System.out.print("请输入商品型号:");
        this.number=reader.nextLine();
        System.out.print("请输入进货价:");
        this.cost=reader.nextFloat();
        System.out.print("请输入零售价:");
        this.price=reader.nextFloat();
        System.out.print("请输入商品总数:");
        this.sum=reader.nextInt();
    }
}
