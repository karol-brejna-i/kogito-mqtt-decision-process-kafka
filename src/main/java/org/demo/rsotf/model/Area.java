package org.demo.rsotf.model;

public class Area {

    private int x0, y0, x1, y1;

    public Area(int x0, int y0, int x1, int y1) {
        if (x0 <= x1) {
            this.x0 = x0; this.x1 = x1;
        } else {
            this.x0 = x1; this.x1 = x0;
        }

        if (y0 <= y1) {
            this.y0 = y0; this.y1 = y1;
        } else {
            this.y0 = y1; this.y1 = y0;
        }
    }

    public boolean contains(int x,  int y) {
        return x0 <= x && x <= x1 && y0 <= y && y <= y1 ;
    }
}
