package com.employee;

public class Employee {

    private int empID;
    private  String fName;
    private String lName;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public Employee() {
    }

    public int getEmpID() {
        return empID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
