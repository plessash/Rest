
package servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServletTest {
    @Mock
    StudentServlet newStudentServlet;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void init() {
        assertEquals(null, newStudentServlet.getInitParameterNames());
    }
    @Test
    void doGet() {
        assertEquals(null, newStudentServlet.getServletName());
    }
    @Test
    void remoteServiceReturnInit() {
        when(newStudentServlet.getInitParameterNames()).thenReturn(null);
    }
    @Test
    void remoteServiceReturnDoGet() {
        when(newStudentServlet.getServletName()).thenReturn(null);
    }
    @Test
    void verificationInit() {
        newStudentServlet.init();
        verify(newStudentServlet).init();
    }
    @Test
    void verificationDoGet() {
        newStudentServlet.getServletName();
        verify(newStudentServlet).getServletName();
    }
}
