package entities;

import java.util.Objects;

// define an abstract class for an employee
public abstract class Employee {

    private String firstName; // stores the employee's first name
    private String lastName; // stores the employee's last name
    private int id; // stores the employee's id number

    // define getters for the employee's name and ID
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    // define setters for the employee's name and ID
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // set the employee's ID, but throw an exception if it's negative
    public void setId(int id) {
        if (id < 0)
            throw new IllegalArgumentException();
        this.id = id;
    }

    // define a constructor to initialize an employee with a name and ID
    public Employee(String firstName, String lastName, int id) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
    }

    // define a default constructor that initializes an employee with a default name and ID
    public Employee() {
        this("plony", "almony", 0);
    }

    // define a toString method to return a string representation of an employee object
    @Override
    public String toString() {
        return "entities.Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    // define an equals method to check if two employee objects are equal based on their name and ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    // define a hashCode method to generate a hash code for an employee object based on their name and ID
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    // define an abstract method to calculate an employee's earnings
    public abstract double earnings();
}