package ljs.java.robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;
/**
 * 机器人
 * @Author: LJS
 * @Date: 2023/8/10 17:13
 */
public class AutoRobot {
    public static void main(String[] args) throws Exception {
        /* 局部变量 */
        // 机器人对象
        Robot robot = new Robot();
        // 计数器
        int countMove = 0;
        /* 机器人随机鼠标操作 */
        while(true){
            Thread.sleep(1*1000);
            countMove++;
            System.out.println("机器人第" + countMove + "次操作开始=======================");
            System.out.println("鼠标随机移动");
            mouseMove(robot);
            System.out.println("鼠标点击");
            mousePress(robot);
            System.out.println("鼠标释放");
            mouseRelease(robot);
            System.out.println("机器人第" + countMove + "次操作结束=======================");
        }
    }

    /* 鼠标移动 */
    public static void mouseMove(Robot robot) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        Random random = new Random();
        int x = (int)p.getX();
        int y = (int)p.getY();
        try {
            robot = new Robot();
            robot.mouseMove(x+random.nextInt(100)-50,y+random.nextInt(100)-50);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /* 鼠标点击 */
    public static void mousePress(Robot robot) {
        robot.mousePress(InputEvent.BUTTON1_MASK);
    }

    /* 鼠标释放 */
    public static void mouseRelease(Robot robot) {
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /* 鼠标滚动 */
    public static void mouseWheel(Robot robot) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        Random random = new Random();
        double x = p.getX();
        double y = p.getY();
        try {
            robot = new Robot();
            robot.mouseMove(400+random.nextInt(100),400+random.nextInt(100));
            robot.mousePress(InputEvent.BUTTON1_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
