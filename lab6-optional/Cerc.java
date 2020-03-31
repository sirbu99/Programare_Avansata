package com.company;

import java.awt.*;

public class Cerc extends Frame {
    public Cerc(Graphics2D g,int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
    }
}
