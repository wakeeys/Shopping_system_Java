package javaproject.boundary;

import javaproject.control.*;
import java.util.*;
import javaproject.model.*;

public class CommodityManagementBoundary implements Boudary{
    public int selection;
    public CommodityManagementControl comManageCon = new CommodityManagementControl();

    public void allDisplay() throws Exception{
        System.out.println("可以选择的功能如下:");
        System.out.println("  1、列出所有商品信息");
        System.out.println("  2、删除商品信息");
        System.out.println("  3、查询商品信息");
        System.out.println("  4、添加商品信息");
        System.out.println("  5、修改商品信息");
        System.out.println("  6、退出该功能");
        System.out.print("请输入选择的功能:");
    }

    public void readSelection(){
        Scanner reader=new Scanner(System.in);
        this.selection = reader.nextInt();
        String temp = reader.nextLine();
    }

    public void comAllDisplay() throws Exception{   //显示所有商品信息
        comManageCon.allSearch();
    }

    public void delComInfo() throws Exception{           //删除某个商品信息
        System.out.print("请输入删除的商品的ID:");
        Scanner reader=new Scanner(System.in);
        String comId = reader.nextLine();
        String sel = this.warningPrompt();
        if (sel.equals("no")){
            System.out.println("取消删除成功.");
        }
        int temp = comManageCon.delComInfo(comId);
        if (temp == 0){
            System.out.println("删除商品信息成功");
        }
        else {
            System.out.println("删除商品信息失败，可能是商品ID输入有误");
        }
    }

    public void comOneDisplay() throws Exception{        //显示单个商品信息
        System.out.print("请输入需查询的商品的ID:");
        Scanner reader=new Scanner(System.in);
        String comId = reader.nextLine();
        int temp = comManageCon.oneSearch(comId);
        if (temp == 1){
            System.out.println("商品查询失败，可能是商品ID输入有误");
        }
    }

    public void comAddInfo() throws Exception{           //添加商品信息
        Commodity com=new Commodity();
        com.init("","","","");
        comManageCon.addComInfo(com);
        System.out.println("商品信息添加成功");
    }

    public void comModifyInfo() throws Exception{        //修改商品信息
        Scanner reader=new Scanner(System.in);
        System.out.print("请输入要修改的商品的ID:");
        String comId = reader.nextLine();
        System.out.print("请输入要修改的商品的信息名称:");
        String comName=reader.nextLine();
        System.out.print("请输入修改的商品信息值:");
        String comInfo=reader.nextLine();
        int temp = comManageCon.modifyComInfo(comId, comName, comInfo);
        if (temp == 1){
            System.out.println("商品信息修改失败，可能是商品ID输入有误");
        }
    }

    public String warningPrompt(){        //警告提示
        System.out.println("是否真的删除该商品信息？删除后无法恢复，若删除请输入yes来确认删除，不删除输入no.");
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
