package servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CourseServletTest {
    @Mock
    CourseServlet newCourseServlet;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void init() {
        assertEquals(null, newCourseServlet.getInitParameterNames());
    }

    @Test
    void doGet() {
        assertEquals(null, newCourseServlet.getServletName());
    }
    @Test
    void remoteServiceReturnInit() {
        when(newCourseServlet.getInitParameterNames()).thenReturn(null);
    }
    @Test
    void remoteServiceReturnDoGet() {
        when(newCourseServlet.getServletName()).thenReturn(null);
    }
    @Test
    void verificationInit() {
        newCourseServlet.init();
        verify(newCourseServlet).init();
    }
    @Test
    void verificationDoGet() {
        newCourseServlet.getServletName();
        verify(newCourseServlet).getServletName();
    }
}