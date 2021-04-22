package org.demo.rsotf.model;

public class CustomerLocation {
    private String id;
    private int x;
    private int y;
    private int ts;

    // Where he was previously
    private String lastSeenIn;

    // When previous location was observed
    private int lastSeenAt;

    private int cnt;

    // Jackson likes this for deserialization
    public CustomerLocation() {
    }

    public CustomerLocation(String id, int x, int y, int ts) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.ts = ts;
    }

    public CustomerLocation(String id, int x, int y, int ts, String lastSeenIn, int lastSeenAt, int cnt) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.ts = ts;
        this.lastSeenIn = lastSeenIn;
        this.lastSeenAt = lastSeenAt;
        this.cnt = cnt;
    }

    public void update(CustomerMovement cm) {
        System.out.println("Update customer location with " + cm);
        this.lastSeenIn = cm.getSeenIn();
        this.lastSeenAt = cm.getTs();

        this.x = cm.getX();
        this.y = cm.getY();

    }

    @Override
    public String toString() {
        return "CustomerLocation{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", ts=" + ts +
                ", lastSeenIn=" + lastSeenIn +
                ", lastSeenAt=" + lastSeenAt +
                ", cnt=" + cnt +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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

    public String getLastSeenIn() {
        return lastSeenIn;
    }

    public void setLastSeenIn(String lastSeenIn) {
        this.lastSeenIn = lastSeenIn;
    }

    public int getLastSeenAt() {
        return lastSeenAt;
    }

    public void setLastSeenAt(int lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}