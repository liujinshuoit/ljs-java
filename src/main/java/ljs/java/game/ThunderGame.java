package ljs.java.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Author: LJS
 * @Date: 2023/3/28 14:52
 */
public class ThunderGame extends JFrame {

    public static void main(String[] args) {
        new ThunderGame();
    }

    static final int WIDTH = 600;   // 窗口宽度
    static final int HEIGHT = 800;  // 窗口高度

    private JPanel panel;
    private Player player;
    private Enemy enemy;

    public ThunderGame() {
        setTitle("雷电游戏");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

        player = new Player();
        player.setLocation(WIDTH/2, HEIGHT-100);
        panel.add(player);

        enemy = new Enemy();
        enemy.setLocation(WIDTH/2, 50);
        panel.add(enemy);

        setVisible(true);

        startGame();
    }

    public void startGame() {
        while (true) {
            player.move();       // 玩家移动
            enemy.move();        // 敌人移动

            if (player.isHit(enemy)) {  // 判断玩家是否被敌人击中
                gameOver();
                break;
            }

            try {
                Thread.sleep(10);  // 休眠10毫秒
            } catch (Exception e) {}
        }
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "游戏结束！");
        System.exit(0);
    }

}

class Player extends JLabel {
    private final int STEP = 5;  // 玩家每次移动的步长

    public Player() {
        setIcon(new ImageIcon("player.png"));  // 设置玩家图标
        setSize(50, 50);
    }

    public void move() {
        Point p = getLocation();

        if (p.x > 0 && p.x < ThunderGame.WIDTH-50) {  // 玩家在窗口内移动
            if (KeyBoard.isLeft()) {
                setLocation(p.x - STEP, p.y);
            } else if (KeyBoard.isRight()) {
                setLocation(p.x + STEP, p.y);
            }
        }
    }

    public boolean isHit(Enemy enemy) {
        Rectangle rect1 = new Rectangle(getLocation(), getSize());
        Rectangle rect2 = new Rectangle(enemy.getLocation(), enemy.getSize());
        return rect1.intersects(rect2);  // 判断玩家和敌人是否相交
    }
}

class Enemy extends JLabel {
    private final int SPEED = 3;  // 敌人的下落速度

    public Enemy() {
        setIcon(new ImageIcon("enemy.png"));  // 设置敌人图标
        setSize(50, 50);
    }

    public void move() {
        Point p = getLocation();
        setLocation(p.x, p.y + SPEED);  // 敌人向下移动
        if (p.y > ThunderGame.HEIGHT) {
            setLocation(p.x, 0);   // 敌人超出窗口底部时返回顶部
        }
    }
}

class KeyBoard {
    private static boolean left, right;

    public static void keyDown(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }

    public static void keyUp(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }

    public static boolean isLeft() {
        return left;
    }

    public static boolean isRight() {
        return right;
    }
}
