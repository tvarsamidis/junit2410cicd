package gr.codehub.cicd.service;

import gr.codehub.cicd.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  // JUnit 5 extension for Mockito
public class DatabaseServiceTest {

    @Mock
    private DatabaseService dbServiceMock;

    @BeforeEach
    public void setup() {
 //       MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee(1, "Alice", 55000);

        // Call saveEmployee
        dbServiceMock.saveEmployee(employee);

        // Verify that saveEmployee was called once with the correct employee object
        verify(dbServiceMock, times(1)).saveEmployee(employee);
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = new Employee(1, "Alice", 55000);
        when(dbServiceMock.findEmployeeById(1)).thenReturn(employee);

        // Call findEmployeeById and verify the return value
        Employee foundEmployee = dbServiceMock.findEmployeeById(1);
        assertNotNull(foundEmployee);
        assertEquals(1, foundEmployee.getId());
        assertEquals("Alice", foundEmployee.getName());
    }

    @Test
    public void testFindAllEmployees() {
        Employee employee1 = new Employee(1, "Alice", 55000);
        Employee employee2 = new Employee(2, "Bob", 45000);
        when(dbServiceMock.findAllEmployees()).thenReturn(List.of(employee1, employee2));

        // Call findAllEmployees and verify the return value
        List<Employee> employees = dbServiceMock.findAllEmployees();
        assertNotNull(employees);
        assertEquals(2, employees.size());
        assertTrue(employees.contains(employee1));
        assertTrue(employees.contains(employee2));
    }

    @Test
    public void testFindEmployeeByName() {
        Employee employee1 = new Employee(1, "Alice", 55000);
        Employee employee2 = new Employee(2, "Bob", 45000);
        when(dbServiceMock.findEmployeeByName("Alice")).thenReturn(List.of(employee1));

        // Call findEmployeeByName and verify the return value
        List<Employee> foundEmployees = dbServiceMock.findEmployeeByName("Alice");
        assertNotNull(foundEmployees);
        assertEquals(1, foundEmployees.size());
        assertTrue(foundEmployees.contains(employee1));
    }

    @Test
    public void testClearDatabase() {
        // Call clearDatabase
        dbServiceMock.clearDatabase();

        // Verify that clearDatabase was called once
        verify(dbServiceMock, times(1)).clearDatabase();
    }
}
