package com.employee;
import java.sql.*;

public class Employeefunctions {

        public void createemployee (Connection conn , Employee employee) throws SQLException {

            //System.out.println("Employee" + employee.getEmpID());

            PreparedStatement ps = null;

            String query ;
            query = "insert into employee value(?,?,?,?)";
            try{
                 ps = conn.prepareStatement(query);
                 ps.setInt(1,employee.getEmpID());
                 ps.setString(2, employee.getfName());
                 ps.setInt(3, employee.getAge());
                 ps.setString(4,employee.getlName());
                int i = ps.executeUpdate();
                if (i != 0) {
                    System.out.println("Inserted");
                } else {
                    System.out.println("not Inserted");
                }
            }catch (Exception e ) {
                e.printStackTrace();
            }

        }


        public void read(Connection conn)throws SQLException {
            Employeemain e = new Employeemain();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from employee");
            while(rs.next()){
                System.out.println("Employee Id : " + rs.getInt("id") + ", FirstName : " + rs.getString("firstname") + ", Age : " + rs.getInt("age") +",LastName : " + rs.getString("lastname") );
            }
        }


        public void update(Connection conn, Employee employee)throws SQLException
            {
                PreparedStatement ps = null;
                String query ;
                query = "update employee set age=?, firstname=? ,lastname=? where id=?";
                try {
                    ps = conn.prepareStatement(query);
                    ps.setInt(4,employee.getEmpID() );
                    ps.setString(2,employee.getfName() );
                    ps.setInt(1,employee.getAge() );
                    ps.setString(3,employee.getlName() );
                    int i = ps.executeUpdate();
                    if (i != 0) {
                        System.out.println("updated");
                    } else {
                        System.out.println("not updated");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }


        public void delete (Connection conn, Employee employee)throws SQLException
        {
            PreparedStatement ps = null;
            String query ;
            query = "delete from employee where id=?";
            try {
                ps = conn.prepareStatement(query);
                ps.setInt(1, employee.getEmpID());

                int i = ps.executeUpdate();
                if (i != 0) {
             System.out.println("successfully deleted the employee details");
                } else {
                    System.out.println("employee details not deleted");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }