package org.demo.rsotf.model;

public class CustomerState {
    private String id;
    private double x;
    private double y;
    private int ts;

    // Where he was previously
    private String lastSeenIn;

    // When previous location was observed
    private int lastSeenAt;

    // current customer state
    @Deprecated
    private CustomerStateType state = CustomerStateType.UNKNOWN;

    private int focusCounter;
    private int stepCounter;

    // Jackson likes this for deserialization
    public CustomerState() {
    }

    public CustomerState(String id, CustomerStateType state, double x, double y) {
        this.id = id;
        this.state = state;
        this.x = x;
        this.y = y;
        this.ts = ts;
        this.focusCounter = 0;
        this.stepCounter = 0;
    }

    public CustomerState(String id, CustomerStateType state, double x, double y, int ts, String lastSeenIn,
            int lastSeenAt) {
        this(id, state, x, y);
        this.lastSeenIn = lastSeenIn;
        this.lastSeenAt = lastSeenAt;
        this.focusCounter = 0;
        this.stepCounter = 0;
    }

    public void updateLastLocation(CustomerMovement cm) {
        this.lastSeenIn = cm.getSeenIn();
        this.lastSeenAt = cm.getTs();

        this.x = cm.getX();
        this.y = cm.getY();
    }

    @Override
    public String toString() {
        return "CustomerState{" + "id='" + id + '\'' + ", x=" + x + ", y=" + y + ", ts=" + ts + ", lastSeenIn='"
                + lastSeenIn + '\'' + ", lastSeenAt=" + lastSeenAt + ", state=" + state + ", focusCounter="
                + focusCounter + ", stepCounter=" + stepCounter + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
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

    @Deprecated
    public CustomerStateType getState() {
        return state;
    }

    @Deprecated
    public void setState(CustomerStateType state) {
        this.state = state;
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

    public int getFocusCounter() {
        return focusCounter;
    }

    public void setFocusCounter(int focusCounter) {
        this.focusCounter = focusCounter;
    }

    public void incFocusCounter() {
        this.focusCounter++;
    };

    public int getStepCounter() {
        return stepCounter;
    }

    public void setStepCounter(int stepCounter) {
        this.stepCounter = stepCounter;
    }

    public void incStepCounter() {
        this.stepCounter++;
    }
}