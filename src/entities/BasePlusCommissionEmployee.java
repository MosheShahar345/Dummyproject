package entities;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private float baseSalary; // stores the employee's base salary

    // constructor that initializes all the fields
    public BasePlusCommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission, float baseSalary) {
        // call the superclass constructor to initialize the inherited fields
        super(firstName, lastName, id, grossSales, commission);
        // set the base salary
        setBaseSalary(baseSalary);
    }

    // default constructor that initializes the fields to their default values
    public BasePlusCommissionEmployee() {
        // call the superclass default constructor
        super();
        // set the base salary to 0
        baseSalary = 0;
    }

    // getter for the base salary
    public float getBaseSalary() {
        return baseSalary;
    }

    // setter for the base salary, with validation to ensure it is a positive value
    public void setBaseSalary(float baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Base salary must be positive");
        this.baseSalary = baseSalary;
    }

    // override the superclass's toString method to include the base salary
    @Override
    public String toString() {
        final String s = super.toString() +
                "BasePlusCommissionEmployee{" +
                "baseSalary=" + baseSalary +
                '}';
        return s;
    }

    // override the superclass's earnings method to include the base salary in the calculation
    @Override
    public double earnings() {
        return baseSalary + (getCommission() / 100.0) * getGrossSales();
    }
}

