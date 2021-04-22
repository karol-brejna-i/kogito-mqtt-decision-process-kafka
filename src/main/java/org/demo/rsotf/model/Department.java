package org.demo.rsotf.model;

public class Department {
    private String id;
    private Area area;
    private String description;

    public Department() {
    }

    public Department(String id, Area area, String description) {
        this.id = id;
        this.area = area;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
