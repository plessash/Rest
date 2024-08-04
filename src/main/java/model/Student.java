package model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int coordinator_id;
    private List<Course> courses; //ManyToMany

    public Student(String name, int coordinator_id) {
    }

    public Student(int id, String name, int coordinator_id) {
        this.id = id;
        this.name = name;
        this.coordinator_id = coordinator_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoordinator_id() {
        return coordinator_id;
    }

    public void setCoordinator_id(int coordinator_id) {
        this.coordinator_id = coordinator_id;
    }

}
