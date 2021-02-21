package kz.aitu.oop.practice.assignment4;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project {
    private ArrayList<Employee> projectEmployeeList = new ArrayList<Employee>();
    private String description;
    private long direct;
    private long indirect;

    public Project()
    {}
    public Project(ArrayList<Employee> projectEmployeeList, String description, int direct, int indirect)
    {
        this.projectEmployeeList = projectEmployeeList;
        this.description = description;
        this.direct = direct;
        this.indirect = indirect;
    }

    public ArrayList<Employee> getProjectEmployeeList() {
        return projectEmployeeList;
    }

    public void setProjectEmployeeList(ArrayList<Employee> projectEmployeeList) {
        this.projectEmployeeList = projectEmployeeList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String title) {
        this.description = description;
    }

    public long getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public long getIndirect() {
        return indirect;
    }

    public void setIndirect(int indirect) {
        this.indirect = indirect;
    }

    public void addStaff(Employee customer)
    {
        projectEmployeeList.add(customer);
    }

    public void removeStaff(String customerName)
    {
        for(int i = 0; i < projectEmployeeList.size(); i++)
        {
            if(projectEmployeeList.get(i).getFirstName().equals(customerName))
            {
                System.out.println("Removed employee #" + (i) + " , first name: " + customerName);
                projectEmployeeList.remove(i);
            }
            else if(projectEmployeeList.get(i).getSecondName().equals(customerName))
            {
                projectEmployeeList.remove(i);
                System.out.println("Removed employee #" + (i) + ", last name: " + customerName);
            }
        }
    }

    public void printAllStaff()
    {
        System.out.println("Staff list: ");
        if(projectEmployeeList.size() == 0)
        {
            System.out.println("Empty list of staff !");
        }
        else
        {
            for(Employee staff : projectEmployeeList)
            {
                System.out.println(staff.toString());
                System.out.println("-*-*-*-*-*-*-*-*-*-");
            }
        }
    }

    public double getTotalCost()
    {
        System.out.print("Cost of Project: " + this.getDescription() + ":");
        return getDirect() + getIndirect();
    }

    public String toString()
    {
        String staffList = "";
        for(Employee staffMember : projectEmployeeList)
        {
            staffList = staffList + "\n" + staffMember;
        }
        return "Project[" +
                "description=" + getDescription() + '\'' +
                ", direct cost=" + getDirect() +
                ", indirect cost=" + getIndirect() +
                ']' +" Employees in project: " + "\n" + staffList;
    }

}
