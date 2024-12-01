package gr.codehub.cicd.bootstrap;

import gr.codehub.cicd.model.Employee;
import gr.codehub.cicd.service.DatabaseService;
import gr.codehub.cicd.service.DatabaseServiceImpl;

import java.util.List;

public class SampleLoad {
    private static DatabaseService dbService = new DatabaseServiceImpl();

    public static DatabaseService loadSampleData() {
        clearDatabase();
        dbService.saveEmployee(new Employee(1, "Alice", 55000));
        dbService.saveEmployee(new Employee(2, "Bob", 45000));
        dbService.saveEmployee(new Employee(3, "Charlie", 25000));
        dbService.saveEmployee(new Employee(4, "David", 60000));
        dbService.saveEmployee(new Employee(5, "Eve", 32000));
        dbService.saveEmployee(new Employee(6, "Frank", 29000));
        dbService.saveEmployee(new Employee(7, "Grace", 37000));
        dbService.saveEmployee(new Employee(8, "Hannah", 49000));
        dbService.saveEmployee(new Employee(9, "Ivan", 41000));
        dbService.saveEmployee(new Employee(10, "Jack", 28000));
        return dbService;
    }

    private static void clearDatabase() {
        dbService.clearDatabase();
    }

    public static DatabaseService getDatabaseService() {
        return dbService;
    }
}