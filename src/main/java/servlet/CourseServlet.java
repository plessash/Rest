
package servlet;

import dao.StudentDAO;
import model.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                default:
                    listCourse(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Course> listCourse = studentDAO.selectAllCourses();
        request.setAttribute("listCourse", listCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
        dispatcher.forward(request, response);
    }
}
