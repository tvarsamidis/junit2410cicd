package gr.codehub.cicd;

import gr.codehub.cicd.dto.FinancialSummaryDTO;
import gr.codehub.cicd.model.Employee;
import gr.codehub.cicd.service.DatabaseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MainTest {

    private DatabaseServiceImpl databaseServiceImpl;

    @BeforeEach
    void setUp() {
        // Mocking the DatabaseServiceImpl to return predefined employee data
        databaseServiceImpl = Mockito.mock(DatabaseServiceImpl.class);
    }

    @Test
    void testFinancialSummaryDTO() {
        // Create sample employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 55000),
                new Employee(2, "Bob", 45000),
                new Employee(3, "Charlie", 25000)
        );

        // Mock the DatabaseServiceImpl's behavior
        when(databaseServiceImpl.findAllEmployees()).thenReturn(employees);

        // Test the calculation of the financial summary
        FinancialSummaryDTO summary = Main.getFinancialSummaryDTO(employees);

        // Assert the totals
        assertEquals(135000, summary.getTotalSalaryPayments());
        assertEquals(40500, summary.getTotalTaxPayments());
        assertEquals(175500, summary.getTotalAmountSpent());
    }

    @Test
    void testAverageAmountSpent() {
        // Create sample employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 55000),
                new Employee(2, "Bob", 45000),
                new Employee(3, "Charlie", 25000)
        );

        // Calculate total amount spent
        double totalAmountSpent = 175500; // from previous test

        // Test the average amount spent
        double average = Main.getAverageAmountSpent(totalAmountSpent, employees.size());

        // Assert the average
        assertEquals(58500, average);
    }
}