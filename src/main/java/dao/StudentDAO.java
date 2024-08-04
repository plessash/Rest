
package dao;

import connectDB.ConnectionDB;
//import model.Coordinator;
import model.Course;
import model.Student;
import model.CourseStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends ConnectionDB {
    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students" + "  (name, coordinator_id) VALUES "
            + " (?, ?);";
    private static final String SELECT_STUDENT_BY_ID = "select id,name,coordinator_id from students where id =?";
    private static final String SELECT_ALL_STUDENTS = "select * from students";
    private static final String SELECT_ALL_COURSES = "select * from courses";
    //private static final String SELECT_COORDINATOR = "select * from coordinator";
    private static final String SELECT_ALL_COURSE_STUDENT = "select * from courseStudent";
    private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?;";
    private static final String UPDATE_STUDENTS_SQL = "update students set name = ?, coordinator_id =? where id = ?;";

    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENTS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getCoordinator_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int coordinator_id = rs.getInt("coordinator_id");
                student = new Student(id, name, coordinator_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }
    public List<Student> selectAllStudents() {

        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int coordinator_id = rs.getInt("coordinator_id");
                students.add(new Student(id, name, coordinator_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }
    public List<Course> selectAllCourses() {

        List<Course> courses = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String course = rs.getString("course");
                courses.add(new Course(id, course));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return courses;
    }
    public List<CourseStudent> selectAllCourseStudent() {

        List<CourseStudent> courseStudent = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSE_STUDENT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int course_id = rs.getInt("course_id");
                int student_id = rs.getInt("student_id");
                courseStudent.add(new CourseStudent(id, course_id, student_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return courseStudent;
    }
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getCoordinator_id());
            statement.setInt(3, student.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
