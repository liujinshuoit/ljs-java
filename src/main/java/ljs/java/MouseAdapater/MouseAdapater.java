package ljs.java.MouseAdapater;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: LJS
 * @Date: 2023/8/10 17:29
 */


public class MouseAdapater {
    JButton btn01=new JButton("自己取点");
    MyFrame myframe;
    public static void main(String[] args) {
        MouseAdapater mouseAdapater = new MouseAdapater();
        mouseAdapater.init();
    }
    public void init(){
        myframe=new MyFrame();
        //可见性
        myframe.setVisible(true);
        //边界大小设置
        myframe.setBounds(200, 200, 760, 480);
        //按钮采用流式布局，默认居中，不设置，按钮会布满整个myframe
        myframe.setLayout(new FlowLayout());
        //设置按钮布局
        btn01.setBounds(200, 5, 150, 30);
        myframe.add(btn01);
        //设置退出
        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //添加鼠标监听器 按钮嵌套myframe
        btn01.addMouseListener(new MouseAdapter() {
            @Override//按钮
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getSource().equals(btn01)){
                    myframe.addMouseListener(new MouseAdapter() {
                        @Override//myframe
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            if(e.getSource().equals(myframe)){
                                //自定义函数将绘制的点坐标加到集合中
                                addPoint(new Point(e.getX(),e.getY()));
                                //重新刷新，不然只能画一个点
                                myframe.repaint();
                            }
                        }
                    });
                }

            }
        });
    }
    public void addPoint(Point point){
        myframe.P1.add(point);
    }
}
