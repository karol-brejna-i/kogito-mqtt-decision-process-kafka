package org.demo.rsotf.model;

public class CustomerMovement {
    private String id;
    private double x;
    private double y;
    private int ts;

    private String seenIn;
    
    // Jackson likes this for deserialization
    public CustomerMovement() {
    }
    
    public CustomerMovement(String id, int x, int y, int ts) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getSeenIn() {
        return seenIn;
    }

    public void setSeenIn(String seenIn) {
        this.seenIn = seenIn;
    }

    public String toString() {
        return "id: " + id + ", x = " + x + ", y = " + y + ", ts = " + ts + ", seenIn = " + seenIn;
    }
}