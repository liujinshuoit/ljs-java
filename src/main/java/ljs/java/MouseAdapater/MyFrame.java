package ljs.java.MouseAdapater;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * @Author: LJS
 * @Date: 2023/8/10 17:30
 */

class MyFrame extends JFrame {
    ArrayList<Point> P1=new ArrayList<>();
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //将存在P1中的点画出来
        for(int i=0;i<P1.size();i++){
            g.fillOval(P1.get(i).x,P1.get(i).y,10,10);
        }
    }
}
