package model;

public class CourseStudent {
    private int id;
    private int course_id;
    private int student_id;

    public CourseStudent() {
    }

    public CourseStudent(int id, int course_id, int student_id) {
        this.id = id;
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
