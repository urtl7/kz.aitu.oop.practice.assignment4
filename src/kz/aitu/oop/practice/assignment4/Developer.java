package kz.aitu.oop.practice.assignment4;

public class Developer extends Employee
{
    private int salary;
    private String category;
    private String developerSide;

    public Developer(String firstName, String secondName, String gender, int age, int salary, String category, String developerSide)
    {
        super(firstName, secondName, gender, age);
        this.salary = salary;
        this.category = category;
        this.developerSide = developerSide;
    }
    public Developer()
    {

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeveloperSide() {
        return developerSide;
    }

    public void setDeveloperSide(String developerSide) {
        this.developerSide = developerSide;
    }

    @Override
    public String toString() {
        return "Developer[" + super.toString() +
                ", salary=" + getSalary() +
                ", category='" + getCategory() +
                ", developer side=" + getDeveloperSide() +
                ']';
    }
}

