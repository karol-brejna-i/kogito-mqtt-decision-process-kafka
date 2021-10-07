package org.demo.rsotf.model;

@Deprecated
public enum CustomerStateType {
    UNKNOWN("UNKNOWN"),
    BROWSING("BROWSING"),
    IN_DEPARTMENT("IN_DEPARTMENT"),
    FOCUSED("FOCUSED");

    public final String label;

    CustomerStateType(String label) {
        this.label = label;
    }
}
