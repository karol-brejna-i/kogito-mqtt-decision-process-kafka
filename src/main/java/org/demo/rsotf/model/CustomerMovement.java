package org.demo.rsotf.model;

public class CustomerMovement {
    private String id;
    private int x;
    private int y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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