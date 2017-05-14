package com.bot;


import sun.security.ssl.Debug;

import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {
    private double a,b,c;


    Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    boolean isParallel(Line line){
        if(a==0){
            return line.a == 0;
        } else {
            if(line.a == 0){
                return false;
            }
            double k1 = b/a, k2 = line.b/line.a;
            return k1 == k2;
        }
    }

    boolean isSame(Line line){
        if(!isParallel(line)){
            return false;
        }
        if(a == 0){
            return c/b == line.c/line.b;
        } else {
            return c/a == line.c/line.a;
        }
    }

    Point cross(Line line)//
    {
        double zn = det (a, b, line.a, line.b);
        if(zn*zn<0.0000000001)
            return null;
        return new Point(- det (c, b, line.c, line.b) / zn, - det (a, c, line.a, line.c) / zn);
    }

    static double det (double a, double b, double c, double d)//
    {
        return a * d - b * c;
    }

    public Point convertPoint(Point old, Point centre)
    {
        return new Point(centre.x + old.x, centre.y - old.y);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        Rectangle q = g.getClipBounds();
        Point centre = new Point(q.width / 2, q.height / 2);
        if (b == 0)
        {
            Point first = convertPoint(new Point(-c / a, -q.height), centre);
            Point second = convertPoint(new Point(-c / a, q.height), centre);
            g.drawLine(first.x, first.y, second.x, second.y);
        }
        else
        {
            Point first = convertPoint(new Point(-q.width, q.width * a / b - c / b), centre);
            Point second = convertPoint(new Point(q.width, -q.width * a / b - c / b), centre);
            g.drawLine(first.x, first.y, second.x, second.y);
        }

        g.setColor(Color.green);

        centre = new Point(q.width / 2, q.height / 2);
        g.setColor(Color.BLACK);
        g.drawLine(0, centre.y, q.width, centre.y);
        g.drawLine(centre.x, 0, centre.x, q.height);
    }

}
