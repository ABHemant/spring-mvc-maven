package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.myproject.entity.Employee;

public class EmployeeDAO {
	
	private Connection connect() throws ClassNotFoundException {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/EMPDB.db";  
        Connection conn = null;  
        try {
        	Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    } 
	
	 public void insertEmployee(Employee employee) throws ClassNotFoundException {  
	        String sql = "INSERT INTO employees(id,firstname,lastname,address) VALUES(?,?,?,?)";  
	   
	        try{  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setInt(1,employee.getId());  
	            pstmt.setString(2,employee.getFirstname());
	            pstmt.setString(3,employee.getLastname());
	            pstmt.setString(4,employee.getAddress());
	            System.out.println("Employee Data successfully Interted into database");
	            pstmt.executeUpdate();
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }
	 
	 public ArrayList<Employee> getAllEmployees() throws ClassNotFoundException{
		 
	        String sql = "SELECT * FROM employees";
	        ArrayList<Employee> employeeList=new ArrayList<>();
	        Employee employee=new Employee();
	          
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);
	            
	              
	            // loop through the result set  
	            while (rs.next()) {
	            	employee.setId(rs.getInt("id"));
	            	employee.setFirstname(rs.getString("firstname"));
	            	employee.setLastname(rs.getString("lastname"));
	            	employee.setAddress(rs.getString("address"));
	            	employeeList.add(employee);            	
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        } 
	        	        
	       return employeeList;
	    }  
	 
	 
}
