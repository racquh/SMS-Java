/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;


import java.sql.*;
import javax.swing.*;
public class MyConnection {
    
    public static Connection Connect(){
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management_system","root","");
            return conn;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
    
    public static void main(String args[]){
        Connect();
    }
}
