package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Point> points = new ArrayList<>();
    private static ArrayList<Line> lines = new ArrayList<>();

    public void createGUI() {
        final JFrame frame = new JFrame("Testframe");
        frame.setPreferredSize(new Dimension(700, 700));
        JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250, 700));
        final Panel pointpane = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

        JLabel addPointwithCoords = new JLabel("Добавить прямую по коэффициентам");
        addPointwithCoords.setBounds(2, 2, 300, 25);
        butPanel.add(addPointwithCoords);
        JLabel addRandomLines = new JLabel("Добавить рандомное количество прямых");
        addRandomLines.setBounds(2, 50, 300, 25);
        butPanel.add(addRandomLines);
        JLabel A = new JLabel("A:");
        A.setBounds(2, 25, 15, 25);
        butPanel.add(A);
        JLabel B = new JLabel("B:");
        B.setBounds(45, 25, 15, 25);
        butPanel.add(B);
        JLabel C = new JLabel("C:");
        C.setBounds(88, 25, 15, 25);
        butPanel.add(C);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2, 70, 30, 25);
        butPanel.add(N);
        final JTextField a = new JTextField();
        a.setBounds(17, 25, 25, 25);
        butPanel.add(a);
        final JTextField b = new JTextField();
        b.setBounds(60, 25, 25, 25);
        butPanel.add(b);
        final JTextField c = new JTextField();
        c.setBounds(103, 25, 25, 25);
        butPanel.add(c);
        final JTextField n = new JTextField();
        n.setBounds(35, 70, 25, 25);
        butPanel.add(n);


        JButton button1 = new JButton("Добавить прямую");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int A = (!a.getText().equals("") ? Integer.parseInt(a.getText()) : 0);
                int B = (!b.getText().equals("") ? Integer.parseInt(b.getText()) : 0);
                int C = (!c.getText().equals("") ? Integer.parseInt(c.getText()) : 0);
                int N = (!n.getText().equals("") ? Integer.parseInt(n.getText()) : 0);
                if (A != 0 || B != 0) {
                    Line b = new Line(A, B, C);
                    lines.add(b);
//                    b.setBounds(b.x, b.y, b.x + 3, b.y + 3);
                    b.setBounds(0, 0, 500, 700);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                } else {
                    if (N > 0) {
                        for (int i = 0; i < N; i++) {
                            Line b = new Line(10 * (Math.random() - 0.5),
                                    (Math.random() - 0.5) * 10,
                                    (Math.random() - 0.5) * 600);
                            lines.add(b);
                            b.setBounds(0, 0, 500, 700);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });
        button1.setBounds(2, 100, 160, 40);
        butPanel.add(button1);

        final JLabel answerL = new JLabel("Ответ:");
        answerL.setBounds(2, 550, 300, 25);
        butPanel.add(answerL);

        final JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (points.size() > 0) {
                    int index = points.size() - 1;
                    Point point = points.remove(index);
                    pointpane.remove(point);
                    pointpane.repaint();
                    pointpane.revalidate();
                }
                while (lines.size() > 0) {
                    int index = lines.size() - 1;
                    Line line = lines.remove(index);
                    pointpane.remove(line);
                    pointpane.repaint();
                    pointpane.revalidate();
                }
                answerL.setText("Ответ: ");
            }
        });


        button2.setBounds(2, 150, 160, 40);
        butPanel.add(button2);

        final JButton button3 = new JButton("Вывести количество точек");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Line line1 : lines) {
                    for (Line line2 : lines) {
                        if (line2.isSame(line1)) {
                            break;
                        }
                        Point point = line1.cross(line2);
                        boolean same = false;
                        if (point != null) {
                            for (Point point1 : points) {
                                if (point1.isSame(point)) {
                                    same = true;
                                }
                            }
                            if (!same) {
                                points.add(point);
                                pointpane.add(point);
                            }
                        }

                    }
                }
                pointpane.revalidate();
                pointpane.repaint();
                System.out.println(points.size());
                answerL.setText("Ответ: " + points.size());
            }
        });


        button3.setBounds(2, 500, 200, 40);
        butPanel.add(button3);

        JButton button4 = new JButton("Загрузить из файла");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                button2.doClick();

                try {
                    br = new BufferedReader(new FileReader("input.txt"));
                    int n = nextInt();
                    for (int i = 0; i < n; i++)
                    {
                        Line b = new Line(Math.random() * 20 * (Math.random() - 0.5),
                                (Math.random() - 0.5) * Math.random() * 20,
                                (Math.random() - 0.5) * Math.random() * 600);
                        lines.add(b);
                        b.setBounds(0, 0, 500, 700);
                        pointpane.add(b);
                        pointpane.revalidate();
                        pointpane.repaint();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        button4.setBounds(2, 300, 200, 40);
        butPanel.add(button4);

        JButton button5 = new JButton("Загрузить в файл");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                button3.doClick();
                try {
                    out = new PrintWriter("output.txt");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                out.println(points.size());
                out.close();
            }
        });

        button5.setBounds(2, 350, 200, 40);
        butPanel.add(button5);

        panel.add(pointpane, BorderLayout.CENTER);
        panel.add(butPanel, BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void Start()
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
    public static void main(String[] args) {
        new Main().Start();
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

}
