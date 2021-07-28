package org.demo.rsotf.model;

/**
 * Represents message sent to MQTT when customer is browsing.
 */
public class CustomerBrowsing {
    /** Customer id */
    private String id;
    /** Event timestamp (unix time) */
    private int ts;
    /** Last known customer location - x */
    private float x;
    /** Last known customer location - y */
    private float y;
    /** Last known customer location - department (if known) */
    private String department;

    public CustomerBrowsing(String id, int ts, float x, float y, String department) {
        this.id = id;
        this.ts = ts;
        this.x = x;
        this.y = y;
        this.department = department;
    }

    @Override
    public String toString() {
        return "CustomerBrowsing{" +
                "id=" + id +
                ", ts=" + ts +
                ", x=" + x +
                ", y=" + y +
                ", department='" + department + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static CustomerBrowsing fromCustomerState(CustomerState state) {
        return new CustomerBrowsing(state.getId(), state.getTs(), state.getX(), state.getY(), state.getLastSeenIn());
    }
}
