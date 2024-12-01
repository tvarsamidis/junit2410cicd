package gr.codehub.cicd.bootstrap;

import gr.codehub.cicd.bootstrap.SampleLoad;
import gr.codehub.cicd.service.DatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

public class SampleLoadTest {

    @Mock
    private DatabaseService databaseServiceImpl;  // Mocking the DatabaseService interface

    @InjectMocks
    private SampleLoad sampleLoad;  // This will inject the mock into SampleLoad

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    // TODO update tests
    public void testLoadSampleData() {
//        // Call the method that should invoke clearDatabase
//        SampleLoad.loadSampleData();
//
//        // Verify that clearDatabase() was called
//        verify(databaseServiceImpl, times(1)).clearDatabase();
//
//        // Verify other interactions if necessary
//        // For example, verify that saveEmployee was called for each employee
//        verify(databaseServiceImpl, times(10)).saveEmployee(any());
    }
}
