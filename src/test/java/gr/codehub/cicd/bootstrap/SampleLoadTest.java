package gr.codehub.cicd.bootstrap;

import gr.codehub.cicd.service.DatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SampleLoadTest {

    @Mock
    private DatabaseService dbServiceMock;  // Mocking the DatabaseService interface

    @InjectMocks
    private SampleLoad sampleLoad;  // This will inject the mock into SampleLoad

    @BeforeEach
    void setup() {
        // MockitoAnnotations.openMocks(this);  // Initialize mocks, superseded by ExtendWith
    }

    @Test
    void testLoadSampleData() {
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


