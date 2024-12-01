package gr.codehub.cicd.service;

import gr.codehub.cicd.model.Employee;
import gr.codehub.cicd.service.DatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseServiceTest {

    @Mock
    private DatabaseService databaseService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee(1, "Alice", 55000);

        // Call saveEmployee
        databaseService.saveEmployee(employee);

        // Verify that saveEmployee was called once with the correct employee object
        verify(databaseService, times(1)).saveEmployee(employee);
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = new Employee(1, "Alice", 55000);
        when(databaseService.findEmployeeById(1)).thenReturn(employee);

        // Call findEmployeeById and verify the return value
        Employee foundEmployee = databaseService.findEmployeeById(1);
        assertNotNull(foundEmployee);
        assertEquals(1, foundEmployee.getId());
        assertEquals("Alice", foundEmployee.getName());
    }

    @Test
    public void testFindAllEmployees() {
        Employee employee1 = new Employee(1, "Alice", 55000);
        Employee employee2 = new Employee(2, "Bob", 45000);
        when(databaseService.findAllEmployees()).thenReturn(List.of(employee1, employee2));

        // Call findAllEmployees and verify the return value
        List<Employee> employees = databaseService.findAllEmployees();
        assertNotNull(employees);
        assertEquals(2, employees.size());
        assertTrue(employees.contains(employee1));
        assertTrue(employees.contains(employee2));
    }

    @Test
    public void testFindEmployeeByName() {
        Employee employee1 = new Employee(1, "Alice", 55000);
        Employee employee2 = new Employee(2, "Bob", 45000);
        when(databaseService.findEmployeeByName("Alice")).thenReturn(List.of(employee1));

        // Call findEmployeeByName and verify the return value
        List<Employee> foundEmployees = databaseService.findEmployeeByName("Alice");
        assertNotNull(foundEmployees);
        assertEquals(1, foundEmployees.size());
        assertTrue(foundEmployees.contains(employee1));
    }

    @Test
    public void testClearDatabase() {
        // Call clearDatabase
        databaseService.clearDatabase();

        // Verify that clearDatabase was called once
        verify(databaseService, times(1)).clearDatabase();
    }
}
