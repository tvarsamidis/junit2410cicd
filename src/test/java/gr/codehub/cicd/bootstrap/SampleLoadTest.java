package gr.codehub.cicd.bootstrap;

import gr.codehub.cicd.service.DatabaseService;
import gr.codehub.cicd.service.DatabaseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

public class SampleLoadTest {

    @Mock
    private DatabaseService dbServiceMock;  // Mocking the DatabaseService interface

    @InjectMocks
    private SampleLoad sampleLoad;  // This will inject the mock into SampleLoad

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    // TODO update tests
    public void testLoadSampleData() {
        // Call the method that should invoke clearDatabase
        sampleLoad.loadSampleData();

        // Verify that clearDatabase() was called
        //verify(dbServiceMock, times(1)).clearDatabase();
        verify(dbServiceMock).clearDatabase();

        // Verify other interactions if necessary
        // For example, verify that saveEmployee was called for each employee
        // verify(dbServiceMock, atLeastOnce()).saveEmployee(any());
        verify(dbServiceMock, atLeast(5)).saveEmployee(any());
    }
}
