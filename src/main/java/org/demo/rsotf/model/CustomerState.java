package org.demo.rsotf.model;

public class CustomerState {
    private String id;
    private int x;
    private int y;
    private int ts;

    // Where he was previously
    private String lastSeenIn;

    // When previous location was observed
    private int lastSeenAt;

    // current customer state
    private CustomerStateType state = CustomerStateType.UNKNOWN;

    // how many steps in given state
    private int inStateCnt;

    // when the state begun (timestamp)
    private int inStateSince;

    // Jackson likes this for deserialization
    public CustomerState() {
    }

    public CustomerState(String id, CustomerStateType state, int x, int y, int ts) {
        this.id = id;
        this.state = state;
        this.x = x;
        this.y = y;
        this.ts = ts;
        this.inStateSince = ts;
        this.inStateCnt = 1;
    }

    public CustomerState(String id, CustomerStateType state, int x, int y, int ts, String lastSeenIn, int lastSeenAt, int inStateCnt, int inStateSince) {
        this(id, state, x, y, ts);
        this.lastSeenIn = lastSeenIn;
        this.lastSeenAt = lastSeenAt;
        this.inStateCnt = inStateCnt;
        this.inStateSince = inStateSince;
    }

    public void update(CustomerMovement cm) {
        System.out.println("Update customer location with " + cm);
        this.lastSeenIn = cm.getSeenIn();
        this.lastSeenAt = cm.getTs();

        this.x = cm.getX();
        this.y = cm.getY();

    }

    public void startBrowsingState(int ts) {
        System.out.println("===========================> Customer starts browsing...");
        this.state = CustomerStateType.BROWSING;
        this.inStateSince = ts;
        this.inStateCnt = 1;

    }

    @Override
    public String toString() {
        return "CustomerState{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", ts=" + ts +
                ", lastSeenIn='" + lastSeenIn + '\'' +
                ", lastSeenAt=" + lastSeenAt +
                ", state=" + state +
                ", inStateCnt=" + inStateCnt +
                ", inStateSince=" + inStateSince +
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

    public void setState(CustomerStateType state) {
        this.state = state;
    }

    public CustomerStateType getState() {
        return state;
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

    public int getInStateCnt() {
        return inStateCnt;
    }

    public void setInStateCnt(int inStateCnt) {
        this.inStateCnt = inStateCnt;
    }
}