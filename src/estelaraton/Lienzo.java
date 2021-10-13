/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estelaraton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 *
 * @author Jorge Santana
 */
public class Lienzo extends JPanel {
    
    private Point points[];
    private Color backgroundColor = Color.WHITE;
    private Color foregroundColor = Color.GREEN;
    private boolean mouseIn;
    private int pos;

    public Lienzo() {
        points = new Point[6];
        Arrays.fill(points, new Point(-10,-10));
        mouseIn = false;
        pos = 0;
    }

    
    public void addPoint(Point p) {
        mouseIn = true;
        for(int i = pos; i > 0; i--) {
            points[i] = points[i-1];
        }
        points[0] = new Point(p.x, p.y);
        pos++;
        if(pos == 6) {
            pos = 0;
        }
        this.repaint();
    }
     
    public void setBackgroundColor(int ind) {
        switch(ind) {
            case 0:
                backgroundColor = Color.WHITE;
                break;
            case 1:
                backgroundColor = Color.RED;
                break;
            case 2:
                backgroundColor = Color.YELLOW;
                break;
            case 3:
                backgroundColor = Color.BLUE;
                break;
        }
    }
    
    public void setForegroundColor(int ind) {
        switch(ind) {
            case 0:
                foregroundColor = Color.GREEN;
                break;
            case 1:
                foregroundColor = Color.CYAN;
                break;
            case 2:
                foregroundColor = Color.ORANGE;
                break;
            case 3:
                foregroundColor = Color.MAGENTA;
                break;
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(backgroundColor);
        this.setForeground(foregroundColor);
        if(mouseIn) {
            for (int i = 0; i < 6; i++) {
                g.fillOval(points[i].x, points[i].y, 10, 10);
            }
        }
    }
    
    public void cleanLienzo() {
        mouseIn = false;
        Arrays.fill(points, new Point(-10,-10));
        pos = 0;
        this.repaint();
    }
}
