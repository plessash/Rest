
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoordinatorTest {
    @Mock
    Student newCoordinator;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getId() {
        assertEquals(0, newCoordinator.getId());
    }
    @Test
    void getName() {
        assertEquals(null, newCoordinator.getName());
    }
    @Test
    void getCoordinator_id() {
        assertEquals(0, newCoordinator.getCoordinator_id());
    }
    @Test
    void remoteServiceReturnId() {
        when(newCoordinator.getId()).thenReturn(1);
        assertEquals(1, newCoordinator.getId());
    }
    @Test
    void remoteServiceReturnName() {
        when(newCoordinator.getName()).thenReturn("Sergey");
        assertEquals("Sergey", newCoordinator.getName());
    }
    @Test
    void verificationId() {
        newCoordinator.getId();
        verify(newCoordinator).getId();
    }
    @Test
    void verificationName() {
        newCoordinator.getName();
        verify(newCoordinator).getName();
    }
    @Test
    void verificationCoordinator_id() {
        newCoordinator.getCoordinator_id();
        verify(newCoordinator).getCoordinator_id();
    }
    @Test
    void verificationSetCoordinator() {
        newCoordinator.setId(1);
        newCoordinator.setName("Sergey");
        newCoordinator.setCoordinator_id(1);
        verify(newCoordinator).setId(1);
        verify(newCoordinator).setName("Sergey");
        verify(newCoordinator).setCoordinator_id(1);
    }
    @Test
    void verificationCoordinatorOther() {
        assertEquals(null, newCoordinator.getName());
        verify(newCoordinator, times(1)).getName();
        verify(newCoordinator, atLeast(1)).getName();
        verify(newCoordinator, atMost(3)).getName();
        verify(newCoordinator, only()).getName();
    }
}
