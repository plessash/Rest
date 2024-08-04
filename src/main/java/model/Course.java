package model;

import java.util.List;

public class Course {
    private int id;
    private String course;
    private List<Student> students;

    public Course() {
    }

    public Course(int id, String course) {
        this.id = id;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
