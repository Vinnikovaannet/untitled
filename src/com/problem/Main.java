package com.problem;

import com.bot.Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
  /*      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Line> lines = new ArrayList<>();
        ArrayList<Point> points = new ArrayList<>();
        String s = in.readLine();
        boolean sameLines = false;
        while(!(s==null || s.equals("stop"))) {
            StringTokenizer tokenizer = new StringTokenizer(s);
            Line line = new Line(
                    Double.parseDouble(tokenizer.nextToken()),
                    Double.parseDouble(tokenizer.nextToken()),
                    Double.parseDouble(tokenizer.nextToken())
            );
            for (Line line1 : lines) {
                    if(line.isSame(line1)) {
                        sameLines = true;
                        break;
                    }
            }
            if(sameLines){
                System.out.println("INFINITY");
                break;
            }
            lines.add(line);
            s = in.readLine();
        }
        if(!sameLines){
            for (Line line1 : lines) {
                for (Line line2 : lines) {
                    if(line2.isSame(line1)) {
                        break;
                    }
                    Point point = line1.cross(line2);
                    boolean same = false;
                    if(point!=null) {
                        for (Point point1 : points) {
                            if (point1.isSame(point)) {
                                same = true;
                            }
                        }
                        if (!same) {
                            points.add(point);
                        }
                    }
                }
            }
            System.out.println(points.size());
        }
    }*/
    }

}
