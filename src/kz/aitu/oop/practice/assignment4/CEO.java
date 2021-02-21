package kz.aitu.oop.practice.assignment4;

public class CEO extends Employee{
    private int salary;

    public CEO(String firstName, String secondName, String gender, int age, int salary)
    {
        super(firstName, secondName, gender, age);
        this.salary = salary;
    }
    public CEO()
    {

    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString()
    {
        return "Ceo[" + super.toString() +
                ", salary=" + getSalary() +
                ']';
    }
}
