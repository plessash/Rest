
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CourseTest {
    @Mock
    Course newCourse;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getId() {
        assertEquals(0, newCourse.getId());
    }
    @Test
    void getCourse() {
        assertEquals(null, newCourse.getCourse());
    }
    @Test
    void remoteServiceReturnId() {
        when(newCourse.getId()).thenReturn(1);
        assertEquals(1, newCourse.getId());
    }
    @Test
    void remoteServiceReturnCourse() {
        when(newCourse.getCourse()).thenReturn("Java");
        assertEquals("Java", newCourse.getCourse());
    }
    @Test
    void verificationId() {
        newCourse.getId();
        verify(newCourse).getId();
    }
    @Test
    void verificationCourse() {
        newCourse.getCourse();
        verify(newCourse).getCourse();
    }
    @Test
    void verificationSetCourse() {
        newCourse.setId(1);
        newCourse.setCourse("Java");
        verify(newCourse).setId(1);
        verify(newCourse).setCourse("Java");
    }
}
