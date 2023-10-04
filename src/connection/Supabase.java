/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author david
 */
public class Supabase{

    private final String url = "jdbc:postgresql://db.kdrrfuetkiaezvuzipwc.supabase.co:5432/postgres?user=postgres&password=D@vidP!pe3110";
    private static Supabase INSTANCE;
    private Connection connection;

    private Supabase() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Supabase getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new Supabase();
        }
        return INSTANCE;
    }       

    public Connection getConnection() {
        return connection;
    }        
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */

    /**
     * @param args the command line arguments
     */
}