package org.demo.rsotf.model;

public enum CustomerStateType {
    UNKNOWN("UNKNOWN"),
    BROWSING("BROWSING"),
    FOCUSED("FOCUSED");

    public final String label;

    CustomerStateType(String label) {
        this.label = label;
    }
}
