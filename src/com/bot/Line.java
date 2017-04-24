package com.bot;

import javax.swing.*;
import java.awt.*;

public class Line  extends JPanel {
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

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,0,3,3);
        g.setColor(Color.red);
    }

}
