package gr.codehub.cicd.model;

import gr.codehub.cicd.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testGetId() {
        Employee employee = new Employee(1, "Alice", 60000);
        assertEquals(1, employee.getId(), "Employee ID should match");
    }

    @Test
    public void testGetName() {
        Employee employee = new Employee(2, "Bob", 40000);
        assertEquals("Bob", employee.getName(), "Employee name should match");
    }

    @Test
    public void testGetSalary() {
        Employee employee = new Employee(3, "Charlie", 25000);
        assertEquals(25000, employee.getSalary(), "Employee salary should match");
    }

    @Test
    public void testGetTaxAmountHighSalary() {
        Employee employee = new Employee(1, "Alice", 60000);
        double expectedTax = 60000 * 0.45;
        assertEquals(expectedTax, employee.getTaxAmount(), "Tax for salary >= 50000 should be 45%");
    }

    @Test
    public void testGetTaxAmountMediumSalary() {
        Employee employee = new Employee(2, "Bob", 35000);
        double expectedTax = 35000 * 0.35;
        assertEquals(expectedTax, employee.getTaxAmount(), "Tax for salary >= 30000 should be 35%");
    }

    @Test
    public void testGetTaxAmountLowSalary() {
        Employee employee = new Employee(3, "Charlie", 25000);
        double expectedTax = 25000 * 0.25;
        assertEquals(expectedTax, employee.getTaxAmount(), "Tax for salary < 30000 should be 25%");
    }
}
