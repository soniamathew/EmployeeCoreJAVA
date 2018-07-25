package com.employee;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;
import java.sql.Statement;
import com.employee.Employeefunctions;
public class Employeemain {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/Employee"; //update connection string
        String user = "root";//add your db user id here
        String password = "password";//add your db password here

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  conn;
    }
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        conn = getConnection();

        int i,age,id;
        String firstname,lastname;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println(" EMPLOYEE DETAILS");
        System.out.println();
        System.out.println("Press : \n1)for creating a new employee \n2)for reading the employee deatils \n3)update the emloyee details \n4) delete employee details ");
        System.out.println("Entrer choice : ");
        i = Integer.parseInt(br.readLine());

        Employee emp = new Employee();
        Employeefunctions empf = new Employeefunctions();

            switch (i) {
                case 1:
                    System.out.println("Enter employee details");
                    System.out.println("Enter id");
                    emp.setEmpID(Integer.parseInt(br.readLine()));
                    System.out.println("Enter age");
                    emp.setAge(Integer.parseInt(br.readLine()));
                    System.out.println("Enter firstname");
                    emp.setfName(br.readLine());
                    System.out.println("Enter lastname");
                    emp.setlName(br.readLine());
                    empf.createemployee(conn, emp);

                    break;

                case 2:
                    empf.read(conn);
                    break;

                case 3:
                    System.out.println("Enter the id of the employee whoese details are to be updated");
                    emp.setEmpID(Integer.parseInt(br.readLine()));
                    System.out.println("Enter the details to be updated:");
                    System.out.println("Enter the change in age:");
                    emp.setAge(Integer.parseInt(br.readLine()));
                    System.out.println("Enter the change in first name:");
                    emp.setfName(br.readLine());
                    System.out.println("Enter the change in lastname:");
                    emp.setlName(br.readLine());

                    empf.update(conn, emp);
                    break;

                case 4:
                    System.out.println("Enter the id of the employee to be deleted");
                    emp.setEmpID(Integer.parseInt(br.readLine()));
                    empf.delete(conn, emp);
                    break;

                default:
                    System.out.println("wrong choice");
            }
        }

}