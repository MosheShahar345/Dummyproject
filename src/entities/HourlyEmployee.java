package entities;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private int hours; // stores the employee's hours
    private float wage; // stores the employee's wage

    // Constructor that takes in all fields
    public HourlyEmployee(String firstName, String lastName, int id, int hours, float wage) {
        super(firstName, lastName, id);
        setHours(hours);
        setWage(wage);
    }

    // Default constructor that sets all fields to 0 or empty strings
    public HourlyEmployee() {
        super();
        wage = 0;
        hours = 0;
    }

    // Getters and setters for the fields
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        // Check that hours is non-negative
        if (hours < 0)
            throw new IllegalArgumentException("Hours cannot be negative");
        this.hours = hours;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        // Check that wage is positive
        if (wage <= 0)
            throw new IllegalArgumentException("Wage must be positive");
        this.wage = wage;
    }

    // Override toString() method to return a string representation of the object
    @Override
    public String toString() {
        final String s = super.toString() +
                "HourlyEmployee{" +
                "hours=" + hours +
                ", wage=" + wage +
                '}';
        return s;
    }

    // Override equals() method to compare two HourlyEmployee objects for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return hours == that.hours && Float.compare(that.wage, wage) == 0;
    }

    // Override hashCode() method to return a hash code for the object
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hours, wage);
    }

    // Implement earnings() method to calculate the employee's earnings
    @Override
    public double earnings() {
        return wage * hours;
    }
}