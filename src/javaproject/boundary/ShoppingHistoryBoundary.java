package javaproject.boundary;

import javaproject.control.*;
import javaproject.model.StringProcess;

import java.util.ArrayList;

public class ShoppingHistoryBoundary implements Boudary{
    int selection;
    String name;
    public ShoppingHistoryControl shopHisCon=new ShoppingHistoryControl();

    public void allDisplay() throws Exception{   //显示所有历史记录
        ArrayList<ArrayList<String>> res=shopHisCon.historyDisplay(this.name);
        System.out.println("时间\t\t\t\t商品\t\t\t\t型号");
        for (ArrayList<String> i:res){
            for (String j:i){
                System.out.print(String.format("%-20s",j));
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public void readSelection(){ }

    public void exit(){ }

    public void mistake(){ }

    public ShoppingHistoryBoundary(String name){
        this.name=name;
    }
}
