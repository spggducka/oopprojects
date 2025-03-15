/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycuahangbanh;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class database {

    public static Connection connectDB() {
        try{
            Class.forName("com.mysql.jbdc.Driver");
            Connection connect = DriverManager.getConnection("jbdc:mysql://localhost/backery/","root","Ducanh251205@");
            return connect;
            
            
            
            
        }catch(Exception e){e.printStackTrace();} 
        return null;

    }

}
