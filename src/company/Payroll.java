package company;

import entities.Employee;

public class Payroll {
    public static void main(String[] args) {

        // Creating an array of three employees
        Employee[] employees = new Employee[3];

        try {
            // Instantiating three different types of employees
            employees[0] = new entities.HourlyEmployee("Moshe", "Shahar", 2121, 30, 50.5f);
            employees[1] = new entities.CommissionEmployee("Aharon", "Katz", 1212, 60, 15);
            employees[2] = new entities.BasePlusCommissionEmployee("Ross", "Geller", 1111, 40, 15, 50.5f);
        }
        // Catching an IllegalArgumentException in case one of the inputs is invalid
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        // Iterating over the employees array and printing their details and earnings
        for (Employee employee : employees)
        {
            System.out.println(employee);
            System.out.print("Earnings of " + employee.getFirstName() + " " + employee.getLastName() + ": ");
            // Checking if the current employee is an instance of BasePlusCommissionEmployee
            if(employee instanceof entities.BasePlusCommissionEmployee)
                System.out.println(employee.earnings() + employee.earnings() * 0.1); // add 10% from the employee's earnings
            else
                System.out.println(employee.earnings());
        }
    }
}