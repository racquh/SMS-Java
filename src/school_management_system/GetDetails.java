/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author virgo
 */
public class GetDetails {
    
    private static PreparedStatement ps = null;
    private static final Connection conn = MyConnection.Connect();
    private static ResultSet rs = null;
    
    static String admin;
    
    static String Username;
    
    public static void getAdmCount(){
        try{
        String sql = "select count(AccessType) from employees where AccessType = 'Admin' ";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        if(rs.next()){
             admin = rs.getString("count(AccessType)");
            //new MainS().lblAdminCount.setText(admin);
        }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    
    public static void main(String args[]){
        getAdmCount();
    }
}
