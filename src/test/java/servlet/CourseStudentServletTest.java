
package servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CourseStudentServletTest {
    @Mock
    CourseStudentServlet newCourseStudentServlet;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void init() {
        assertEquals(null, newCourseStudentServlet.getInitParameterNames());
    }

    @Test
    void doGet() {
        assertEquals(null, newCourseStudentServlet.getServletName());
    }
    @Test
    void remoteServiceReturnInit() {
        when(newCourseStudentServlet.getInitParameterNames()).thenReturn(null);
    }
    @Test
    void remoteServiceReturnDoGet() {
        when(newCourseStudentServlet.getServletName()).thenReturn(null);
    }
    @Test
    void verificationInit() {
        newCourseStudentServlet.init();
        verify(newCourseStudentServlet).init();
    }

    @Test
    void verificationDoGet() {
        newCourseStudentServlet.getServletName();
        verify(newCourseStudentServlet).getServletName();
    }
}
