package gr.codehub.cicd.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinancialSummaryDTOTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a FinancialSummaryDTO object with some test data
        double totalSalary = 100000.00;
        double totalTax = 20000.00;
        double totalAmount = 120000.00;

        FinancialSummaryDTO summary = new FinancialSummaryDTO(totalSalary, totalTax, totalAmount);

        // Assert the values using the getters
        assertEquals(totalSalary, summary.getTotalSalaryPayments(), "Total salary payments should match the constructor value");
        assertEquals(totalTax, summary.getTotalTaxPayments(), "Total tax payments should match the constructor value");
        assertEquals(totalAmount, summary.getTotalAmountSpent(), "Total amount spent should match the constructor value");
    }

    @Test
    public void testDefaultConstructor() {
        // Test the default constructor
        FinancialSummaryDTO summary = new FinancialSummaryDTO();

        // Assert that the default values are 0.0
        assertEquals(0.0, summary.getTotalSalaryPayments(), "Default total salary payments should be 0.0");
        assertEquals(0.0, summary.getTotalTaxPayments(), "Default total tax payments should be 0.0");
        assertEquals(0.0, summary.getTotalAmountSpent(), "Default total amount spent should be 0.0");
    }

    @Test
    public void testToString() {
        // Create a FinancialSummaryDTO object
        double totalSalary = 100000.00;
        double totalTax = 20000.00;
        double totalAmount = 120000.00;
        FinancialSummaryDTO summary = new FinancialSummaryDTO(totalSalary, totalTax, totalAmount);

        // Expected string output
        // Assert that the toString() method returns the expected string
        assertTrue(summary.toString().contains("totalSalaryPayments=100000"), "toString() should return the correct formatted string");
        assertTrue(summary.toString().contains("totalTaxPayments=20000"), "toString() should return the correct formatted string");
        assertTrue(summary.toString().contains("totalAmountSpent=120000"), "toString() should return the correct formatted string");

    }
}
