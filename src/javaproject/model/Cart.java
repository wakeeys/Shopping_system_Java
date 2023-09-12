package javaproject.model;

import java.util.ArrayList;

public class Cart implements Product{
    public ArrayList<Integer> ID;
    public ArrayList<String> name;
    public ArrayList<String> number;
    public ArrayList<Integer> sum;

    public Cart(){
        this.ID=new ArrayList<>();
        this.name=new ArrayList<>();
        this.number=new ArrayList<>();
        this.sum=new ArrayList<>();
    }

    public void init(String name,String number, String ID, String sum) { }
}
