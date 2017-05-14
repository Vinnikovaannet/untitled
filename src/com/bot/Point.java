package com.bot;

import javax.swing.*;
import java.awt.*;


public class Point extends JPanel {
    public int x;
    public int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    Point(double x, double y){
        this.x= (int)x;
        this.y=(int)y;
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,0,3,3);
        g.setColor(Color.red);
    }
    boolean isSame(Point point) {
        return (x == point.x && y == point.y);
    }
}
