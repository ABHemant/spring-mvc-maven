package com.myproject.initialise;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateUserTable {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/EMPDB.db";
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"  
                + " userid integer PRIMARY KEY,\n"  
                + " username text ,\n"
                + " password text \n"
                + ");";
        
         
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);
            System.out.println("\n Table Created Successsfully");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        createNewTable();  
    }  
   
}  