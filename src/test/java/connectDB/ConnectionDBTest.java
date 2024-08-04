package connectDB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ConnectionDBTest {
    @Mock
    ConnectionDB newConnectionDB;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getConnection() {
        assertEquals(null, newConnectionDB.getConnection());
    }
    @Test
    void remoteServiceReturnConnection() {
        when(newConnectionDB.getConnection()).thenReturn(null);
        assertEquals(null, newConnectionDB.getConnection());
    }
    @Test
    void verificationConnection() {
        newConnectionDB.getConnection();
        verify(newConnectionDB).getConnection();
    }
}