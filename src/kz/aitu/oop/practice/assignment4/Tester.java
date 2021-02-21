package kz.aitu.oop.practice.assignment4;

public class Tester extends Employee {
    private int salary;
    private String type;

    public Tester(String firstName, String secondName, String gender, int age, int salary, String type)
    {
        super(firstName, secondName, gender, age);
        this.salary = salary;
        this.type = type;
    }
    public Tester()
    {

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString()
    {
        return "Tester[" + super.toString() +
                ", salary=" + getSalary() +
                ", type=" + getType() +
                ']';
    }
}
