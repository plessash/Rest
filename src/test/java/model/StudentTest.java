package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentTest {
    @Mock
    Student newStudent;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getId() {
        assertEquals(0, newStudent.getId());
    }
    @Test
    void getName() {
        assertEquals(null, newStudent.getName());
    }
    @Test
    void getCoordinator_id() {
        assertEquals(0, newStudent.getCoordinator_id());
    }
    @Test
    void remoteServiceReturnId() {
        when(newStudent.getId()).thenReturn(1);
        assertEquals(1, newStudent.getId());
    }
    @Test
    void remoteServiceReturnName() {
        when(newStudent.getName()).thenReturn("Ivan");
        assertEquals("Ivan", newStudent.getName());
    }
    @Test
    void verificationId() {
        newStudent.getId();
        verify(newStudent).getId();
    }
    @Test
    void verificationName() {
        newStudent.getName();
        verify(newStudent).getName();
    }
    @Test
    void verificationCoordinator_id() {
        newStudent.getCoordinator_id();
        verify(newStudent).getCoordinator_id();
    }
    @Test
    void verificationSetStudent() {
        newStudent.setId(1);
        newStudent.setName("Ivan");
        newStudent.setCoordinator_id(1);
        verify(newStudent).setId(1);
        verify(newStudent).setName("Ivan");
        verify(newStudent).setCoordinator_id(1);
    }
    @Test
    void verificationStudentOther() {
        assertEquals(null, newStudent.getName());
        verify(newStudent, times(1)).getName();
        verify(newStudent, atLeast(1)).getName();
        verify(newStudent, atMost(3)).getName();
        verify(newStudent, only()).getName();
    }
}