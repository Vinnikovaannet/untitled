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
        Rectangle q = g.getClipBounds();

        Point centre = new Point(q.width / 2, q.height / 2);

        Point converted = convertPoint(this, centre);
        g.drawOval(converted.x - 5, converted.y - 5, 10, 10);
        g.fillOval(converted.x - 5, converted.y - 5, 10, 10);
        g.setColor(Color.red);
    }

    public Point convertPoint(Point old, Point centre)
    {
        return new Point(centre.x + old.x, centre.y - old.y);
    }

    boolean isSame(Point point) {
        return (x == point.x && y == point.y);
    }
}
