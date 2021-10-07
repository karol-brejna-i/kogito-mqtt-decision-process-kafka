package org.demo.rsotf.model;

public class CustomerFocus {
    private String id;
    private int ts;
    private String dep;

    public CustomerFocus() {
    }

    public CustomerFocus(String id, int ts, String dep) {
        this.id = id;
        this.ts = ts;
        this.dep = dep;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTs() {
        return this.ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getDep() {
        return this.dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "CustomerFocus{" + "id='" + this.id + '\'' + ", ts=" + this.ts + ", dep=" + this.dep + '}';
    }
}
