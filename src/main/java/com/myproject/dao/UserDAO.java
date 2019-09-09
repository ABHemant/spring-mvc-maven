package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.myproject.entity.User;


public class UserDAO {
	
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
     
    public void insertUser(User user) throws ClassNotFoundException {  
        String sql = "INSERT INTO user(userid,username,password) VALUES(?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1,user.getUserid());  
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getPassword()); 
            pstmt.executeUpdate();
            System.out.println("Data Successfully inserted");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    public String fetchUserById(String username) throws ClassNotFoundException{
    	 
        String sql = "SELECT * FROM user where username='"+username+"';";
        String password="null";
          
        try {
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
                         
            // loop through the result set  
            while (rs.next()) {               
                password=rs.getString("password");
                return password;
            }        
            
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }      
        return password;
    }
    
   /*public static void main(String[] args) throws ClassNotFoundException {  
    	   
        User user = new User();   
        user.setUserid(2);
        user.setUsername("Yuvraj");
        user.setPassword("yuvi1234");
        
        UserDAO dao=new UserDAO();
        //dao.insertUser(user);
       
        String pass=dao.fetchUserById("dhoni");
        System.out.print(pass);
    }*/
    
    
}
