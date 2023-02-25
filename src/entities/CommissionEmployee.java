package entities;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private float grossSales; // stores the employee's gross sales
    private int commission; // stores the employee's commission rate

    // constructor that initializes all the fields
    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission) {
        // call the superclass constructor to initialize the inherited fields
        super(firstName, lastName, id);
        // set the gross sales and commission rate
        setGrossSales(grossSales);
        setCommission(commission);
    }

    // default constructor that initializes the fields to their default values
    public CommissionEmployee() {
        // call the superclass default constructor
        super();
        // set the gross sales and commission rate to 0
        grossSales = 0;
        commission = 0;
    }

    // getter for the gross sales
    public float getGrossSales() {
        return grossSales;
    }

    // setter for the gross sales, with validation to ensure it is a positive value
    public void setGrossSales(float grossSales) {
        if (grossSales <= 0)
            throw new IllegalArgumentException("Gross sales must be positive");
        this.grossSales = grossSales;
    }

    // getter for the commission rate
    public int getCommission() {
        return commission;
    }

    // setter for the commission rate, with validation to ensure it is a non-negative value
    public void setCommission(int commission) {
        if (commission < 0)
            throw new IllegalArgumentException("Commission rate cannot be negative");
        this.commission = commission;
    }

    // override the superclass's toString method to include the gross sales and commission rate
    @Override
    public String toString() {
        final String s = super.toString() +
                "CommissionEmployee{" +
                "grossSales=" + grossSales +
                ", commission=" + commission +
                '}';
        return s;
    }

    // override the superclass's equals method to compare all the fields of the object
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(that.grossSales, grossSales) == 0 && commission == that.commission;
    }

    // override the superclass's hashCode method to include all the fields of the object
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grossSales, commission);
    }

    // calculate the employee's earnings based on the gross sales and commission rate
    @Override
    public double earnings() {
        return (commission / 100.0) * grossSales;
    }
}