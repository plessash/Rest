package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CourseStudentTest {
    @Mock
    CourseStudent newCourseStudent;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getId() {
        assertEquals(0, newCourseStudent.getId());
    }
    @Test
    void getСourse_id() {
        assertEquals(0, newCourseStudent.getStudent_id());
    }
    @Test
    void getStudent_id() {
        assertEquals(0, newCourseStudent.getStudent_id());
    }
    @Test
    void remoteServiceReturnId() {
        when(newCourseStudent.getId()).thenReturn(1);
        assertEquals(1, newCourseStudent.getId());
    }
    @Test
    void remoteServiceReturnCourse_id() {
        when(newCourseStudent.getCourse_id()).thenReturn(1);
        assertEquals(1, newCourseStudent.getCourse_id());
    }
    @Test
    void remoteServiceReturnStudent_id() {
        when(newCourseStudent.getStudent_id()).thenReturn(1);
        assertEquals(1, newCourseStudent.getStudent_id());
    }
    @Test
    void verificationId() {
        newCourseStudent.getId();
        verify(newCourseStudent).getId();
    }
    @Test
    void verificationCourse_id() {
        newCourseStudent.getCourse_id();
        verify(newCourseStudent).getCourse_id();
    }
    @Test
    void verificationStudent_id() {
        newCourseStudent.getStudent_id();
        verify(newCourseStudent).getStudent_id();
    }
    @Test
    void verificationSetCourseStudent() {
        newCourseStudent.setId(1);
        newCourseStudent.setCourse_id(1);
        newCourseStudent.setStudent_id(1);
        verify(newCourseStudent).setId(1);
        verify(newCourseStudent).setCourse_id(1);
        verify(newCourseStudent).setStudent_id(1);
    }
}