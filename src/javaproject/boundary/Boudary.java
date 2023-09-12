package javaproject.boundary;

public interface Boudary {
    void allDisplay() throws Exception;  //页面主要内容显示

    void readSelection();   //读入选择的功能

    void exit();        //退出该功能提示

    void mistake();     //错误输入提示
}
