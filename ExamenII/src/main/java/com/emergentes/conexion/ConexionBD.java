
package com.emergentes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionBD {
    static public String url ="jdbc:mysql://localhost:3306/bd_biblioteca";
    static public String usuario ="root";
    static public String password ="";
    static public String driver ="com.mysql.jdbc.Driver";
    //com.mysql.cj.jdbc.Driver
    
    protected Connection conn = null;
    //CONSTRUCTOR
    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException  e){
            System.out.println("Error a la conexion"+ e.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion: "+ ex.getMessage());
        }
    }
}
