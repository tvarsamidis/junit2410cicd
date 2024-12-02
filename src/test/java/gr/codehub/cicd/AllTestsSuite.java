package gr.codehub.cicd;

import gr.codehub.cicd.bootstrap.SampleLoadTest;
import gr.codehub.cicd.dto.FinancialSummaryDTOTest;
import gr.codehub.cicd.model.EmployeeTest;
import gr.codehub.cicd.service.DatabaseServiceTest;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        EmployeeTest.class,
        FinancialSummaryDTOTest.class,
        SampleLoadTest.class,
        DatabaseServiceTest.class,
        MainTest.class,
})
@IncludeClassNamePatterns(".*Test") // Includes all classes whose name ends with "Test"
public class AllTestsSuite {
    // No need for any methods in the suite class. It just groups the tests together.
}