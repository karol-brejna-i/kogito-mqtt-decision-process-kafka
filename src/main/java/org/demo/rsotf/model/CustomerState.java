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
    @Deprecated
    private CustomerStateType state = CustomerStateType.UNKNOWN;

    // how many steps in given state
    private int inStateCnt;

    // when the state begun (timestamp)
    private int inStateSince;

    // number of moves in current sequence (regardless the state)
    private int sequenceCnt;

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
        this.sequenceCnt = 1;
    }

    public CustomerState(String id, CustomerStateType state, int x, int y, int ts, String lastSeenIn, int lastSeenAt, int inStateCnt, int inStateSince, int sequenceCnt) {
        this(id, state, x, y, ts);
        this.lastSeenIn = lastSeenIn;
        this.lastSeenAt = lastSeenAt;
        this.inStateCnt = inStateCnt;
        this.inStateSince = inStateSince;
        this.sequenceCnt = sequenceCnt;
    }

    public void incStateCnt() {
        this.inStateCnt += 1;
    }

    public void resetStateCnt() {
        this.inStateSince = ts;
        this.inStateCnt = 0;
    }

    public int getInStateSince() {
        return inStateSince;
    }

    public void setInStateSince(int inStateSince) {
        this.inStateSince = inStateSince;
    }

    public int getSequenceCnt() {
        return sequenceCnt;
    }

    public void setSequenceCnt(int sequenceCnt) {
        this.sequenceCnt = sequenceCnt;
    }

    public void incSequenceCnt() {
        System.out.println("incrementing sequence cnt");
        this.sequenceCnt += 1;
    }

    public void updateLastLocation(CustomerMovement cm) {
        System.out.println("Update customer location with " + cm);
        this.lastSeenIn = cm.getSeenIn();
        this.lastSeenAt = cm.getTs();

        this.x = cm.getX();
        this.y = cm.getY();
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
                ", sequenceCnt=" + sequenceCnt +
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

    public int getInStateCnt() {
        return inStateCnt;
    }

    public void setInStateCnt(int inStateCnt) {
        this.inStateCnt = inStateCnt;
    }
}