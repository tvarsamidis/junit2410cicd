package gr.codehub.cicd.bootstrap;

import gr.codehub.cicd.Main;
import gr.codehub.cicd.dto.FinancialSummaryDTO;
import gr.codehub.cicd.model.Employee;
import gr.codehub.cicd.service.DatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SampleLoadTest {

    @Mock
    private DatabaseService dbServiceMock; // Mock the interface

    private List<Employee> employees; // Common employees list for all tests

    @BeforeEach
    void setUp() {
        // Initialize Mockito annotations
        // MockitoAnnotations.openMocks(this);

        // Initialize the common employees list
        employees = Arrays.asList(
                new Employee(1, "Alice", 55000),
                new Employee(2, "Bob", 45000),
                new Employee(3, "Charlie", 25000)
        );
    }


    @Test
    // TODO update tests
    public void testLoadSampleData() {
        // Call the method that should invoke clearDatabase
        SampleLoad sampleLoad = new SampleLoad(dbServiceMock);
        sampleLoad.loadSampleData();

        // Verify that clearDatabase() was called
        //verify(dbServiceMock, times(1)).clearDatabase();
//        verify(dbServiceMock).clearDatabase();

        // Verify other interactions if necessary
        // For example, verify that saveEmployee was called for each employee
        // verify(dbServiceMock, atLeastOnce()).saveEmployee(any());
  //      verify(dbServiceMock, atLeast(5)).saveEmployee(any());
        // Mock the DatabaseService behavior
        when(dbServiceMock.findAllEmployees()).thenReturn(employees);

        // Test the calculation of the financial summary
        FinancialSummaryDTO summary = Main.getFinancialSummaryDTO(dbServiceMock.findAllEmployees());

        // Assert the totals
        assertEquals(125000, summary.getTotalSalaryPayments());
        assertEquals(46750, summary.getTotalTaxPayments());
        assertEquals(171750, summary.getTotalAmountSpent());
    }
}
