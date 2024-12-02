package gr.codehub.cicd;

import gr.codehub.cicd.dto.FinancialSummaryDTO;
import gr.codehub.cicd.model.Employee;
import gr.codehub.cicd.service.DatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  // JUnit 5 extension for Mockito
public class MainTest {

    @Mock
    private DatabaseService databaseService; // Mock the interface

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
    void testFinancialSummaryDTO() {
        // Mock the DatabaseService behavior
        when(databaseService.findAllEmployees()).thenReturn(employees);

        // Test the calculation of the financial summary
        FinancialSummaryDTO summary = Main.getFinancialSummaryDTO(databaseService.findAllEmployees());

        // Assert the totals
        assertEquals(125000, summary.getTotalSalaryPayments());
        assertEquals(46750, summary.getTotalTaxPayments());
        assertEquals(171750, summary.getTotalAmountSpent());
    }

    @Test
    void testAverageAmountSpent() {
        // Calculate total amount spent
        double totalAmountSpent = 175500; // from previous test

        // Test the average amount spent
        double average = Main.getAverageAmountSpent(totalAmountSpent, employees.size());

        // Assert the average
        assertEquals(58500, average);
    }
}
