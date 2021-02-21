package kz.aitu.oop.practice.assignment4;

import jdk.jshell.spi.SPIResolutionException;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database
{
    public static void insert()
    {
        Scanner in = new Scanner(System.in);

        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "ict05";

        System.out.println("Customer or Project (1 or 2)");

        int decision = in.nextInt();

        if(decision == 1)
        {
            try
            {
                System.out.println("Select type of employee,  CEO | Developer | Tester:");

                String type = in.next();

                if (type.equals("CEO"))
                {
                    CEO ceo = new CEO();

                    System.out.println("First name: ");
                    String firstName = in.next();
                    ceo.setFirstName(firstName);

                    System.out.println("Second name: ");
                    String secondName = in.next();
                    ceo.setSecondName(secondName);

                    System.out.println("Gender: ");
                    String gender = in.next();
                    ceo.setGender(gender);

                    System.out.println("Age:");
                    int age = in.nextInt();
                    ceo.setAge(age);

                    System.out.println("Salary:");
                    int salary = in.nextInt();
                    ceo.setSalary(salary);

                    Connection connection = DriverManager.getConnection(URL, username, password);
                    String INSERT = "INSERT INTO ceo(project_id, firstName, secondName, age, salary) VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(INSERT);

                    System.out.println("Project ic: ");

                    int id = in.nextInt();

                    statement.setInt(1, id);
                    statement.setString(2, ceo.getFirstName());
                    statement.setString(3, ceo.getSecondName());
                    statement.setInt(4, ceo.getAge());
                    statement.setInt(5, ceo.getSalary());

                    int executeUpdate = statement.executeUpdate();
                }
                if (type.equals("Developer"))
                {
                    Connection connection = DriverManager.getConnection(URL, username, password);

                    Developer developer = new Developer();

                    System.out.println("First name: ");
                    String firstName = in.next();
                    developer.setFirstName(firstName);

                    System.out.println("Second name: ");
                    String secondName = in.next();
                    developer.setSecondName(secondName);

                    System.out.println("Gender: ");
                    String gender = in.next();
                    developer.setGender(gender);

                    System.out.println("Age: ");
                    int age = in.nextInt();
                    developer.setAge(age);

                    System.out.println("Salary: ");
                    int salary = in.nextInt();
                    developer.setSalary(salary);

                    System.out.println("Developer category, *senior* , *middle* , *junior*");
                    String category = in.next();
                    developer.setCategory(category);

                    System.out.println("Developer side, *backend*, *frontend*, *full-stack*");
                    String side = in.next();
                    developer.setDeveloperSide(side);

                    String INSERT = "INSERT INTO developer(project_id, salary, category, developerSide, firstname, secondname) VALUES(?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(INSERT);
                    System.out.println("Project id: ");
                    int id = in.nextInt();
                    statement.setInt(1, id);
                    statement.setInt(2, developer.getSalary());
                    statement.setString(3, developer.getCategory());
                    statement.setString(4, developer.getDeveloperSide());
                    statement.setString(5, developer.getFirstName());
                    statement.setString(6, developer.getSecondName());

                    int executeUpdate = statement.executeUpdate();
                }
                if (type.equals("Tester")) {
                    Connection connection = DriverManager.getConnection(URL, username, password);
                    Tester tester1 = new Tester("Alisa", "Alexandrovna", "female", 22, 7800, "QA");
                    Tester tester = new Tester();

                    System.out.println("First name: ");
                    String firstName = in.next();
                    tester.setFirstName(firstName);

                    System.out.println("Second name: ");
                    String secondName = in.next();
                    tester.setSecondName(secondName);

                    System.out.println("Gender: ");
                    String gender = in.next();
                    tester.setGender(gender);

                    System.out.println("Age: ");
                    int age = in.nextInt();
                    tester.setAge(age);

                    System.out.println("Salary:");
                    int salary = in.nextInt();
                    tester.setSalary(salary);

                    System.out.println("Testing type: qa, engineer");
                    String typeTesting = in.next();
                    tester.setType(typeTesting);

                    String INSERT1 = "INSERT INTO tester(project_id, salary, typetester, firstname, secondname) VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(INSERT1);
                    System.out.println("Project id: ");
                    int id = in.nextInt();
                    statement.setInt(1, id);
                    statement.setInt(2, tester.getSalary());
                    statement.setString(3, tester.getType());
                    statement.setString(4, tester.getFirstName());
                    statement.setString(5, tester.getSecondName());

                    statement.executeUpdate();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(decision == 2)
        {
            try{
                Connection connection = DriverManager.getConnection(URL, username, password);
                Project project = new Project();

                System.out.println("Write title of project: ");
                String projectTitle = in.next();
                project.setDescription(projectTitle);

                System.out.println("Write direct and indirect costs of Project:");

                System.out.println("Direct: ");
                int directCost = in.nextInt();
                project.setDirect(directCost);

                System.out.println("Indirect: ");
                int indirectCost = in.nextInt();
                project.setIndirect(indirectCost);

                String INSERT = "INSERT INTO project(title, directcost, indirectcost) VALUES(?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(INSERT);
                statement.setString(1, project.getDescription());
                statement.setInt(2, (int)project.getDirect());
                statement.setInt(3, (int)project.getIndirect());

                statement.executeUpdate();
            }
            catch(SQLException exception)
            {
                exception.printStackTrace();
            }
        }
    }

    public static void select() {
        try {
            Scanner in = new Scanner(System.in);
            String URL = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "ict05";

            Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement();

            String SELECT = "SELECT * from project";
            ResultSet resultProject = statement.executeQuery(SELECT);

            System.out.println("Projects in DATABASE: ");
            while(resultProject.next())
            {
                int projectId = resultProject.getInt(1);
                String decsription = resultProject.getString(2);
                int direct = resultProject.getInt(3);
                int indirect = resultProject.getInt(4);

                System.out.println("id: " + projectId);
                System.out.println("title: " + decsription);
                System.out.println("direct cost: " + direct);
                System.out.println("indirect cost: " + indirect);
                System.out.println();
            }

            System.out.println();

            String SELECTCEO = "SELECT * FROM ceo";
            ResultSet resultCEO = statement.executeQuery(SELECTCEO);

            while(resultCEO.next())
            {
                int ceoId = resultCEO.getInt(1);
                int projectId = resultCEO.getInt(2);
                String firstName = resultCEO.getString(3);
                String secondName = resultCEO.getString(4);
                int age = resultCEO.getInt(5);
                int salary = resultCEO.getInt(6);

                System.out.println("ceo id: " + ceoId);
                System.out.println("project id: " + projectId);
                System.out.println("first name: " + firstName);
                System.out.println("second name: " + secondName);
                System.out.println("age: " + age);
                System.out.println("salary: " + salary);
                System.out.println();
            }

            String SELECTDEVELOPER = "SELECT * FROM developer";
            ResultSet resultDeveloper = statement.executeQuery(SELECTDEVELOPER);

            while(resultDeveloper.next())
            {
                int developerId = resultDeveloper.getInt(1);
                int projectId = resultDeveloper.getInt(2);
                int salary = resultDeveloper.getInt(3);
                String category = resultDeveloper.getString(4);
                String developerside = resultDeveloper.getString(5);
                String firstName = resultDeveloper.getString(6);
                String secondName = resultDeveloper.getString(7);

                System.out.println("developer id: " + developerId);
                System.out.println("project id: " + projectId);
                System.out.println("first name: " + firstName);
                System.out.println("second name: " + secondName);
                System.out.println("salary: " + salary);
                System.out.println("category: " + category);
                System.out.println("developer side: " + developerside);
                System.out.println();
            }

            String SELECTTESTER = "SELECT * FROM tester";
            ResultSet resultTester = statement.executeQuery(SELECTTESTER);
            System.out.println();
            while(resultTester.next())
            {
                int testerId = resultTester.getInt(1);
                int projectId = resultTester.getInt(2);
                int salary = resultTester.getInt(3);
                String typetester = resultTester.getString(4);
                String firstName = resultTester.getString(5);
                String secondName = resultTester.getString(6);

                System.out.println("tester id: " + testerId);
                System.out.println("project id: " + projectId);
                System.out.println("first name: " + firstName);
                System.out.println("second name: " + secondName);
                System.out.println("salary: " + salary);
                System.out.println("tester type: " + typetester);
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void delete()
    {
        Scanner in = new Scanner(System.in);
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "ict05";

        try
        {
            Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Table name? ceo | developer | tester ");
            String tableName = in.nextLine();
            System.out.println("ID employee: ");
            int id = in.nextInt();
            if(tableName.equals("ceo"))
            {
                String DELETE = "DELETE from ceo where ceo_id = ?";
                PreparedStatement statement = connection.prepareStatement(DELETE);
                statement.setInt(1, id);
            }
            else if(tableName.equals("developer"))
            {
                String DELETE = "DELETE from developer where developer_id = ?";
                PreparedStatement statement = connection.prepareStatement(DELETE);
                statement.setInt(1, id);
            }
            else if(tableName.equals("tester"))
            {
                String DELETE = "DELETE from tester where tester_id = ?";
                PreparedStatement statement = connection.prepareStatement(DELETE);
                statement.setInt(1, id);

            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("IT Project menu: ");

        boolean switching = false;
        int choice = 0;

        while (choice >= 1 && choice <= 4 || !switching)
        {
            try {

                System.out.println("1 insert into statement");
                System.out.println("2 select statement");
                System.out.println("3 delete statement");
                System.out.println("4 quit of program");

                System.out.println();

                choice = in.nextInt();

                switch (choice)
                {
                    case 1:
                        insert();
                        break;
                    case 2:
                        select();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Error !, make correct decision (1-4)");
                }

                switching = true;

            } catch (InputMismatchException e)
            {
                System.out.println("Please input an integer");
                System.out.println("Required int, instead of: " + in.nextLine());
            }
        }
    }
}
