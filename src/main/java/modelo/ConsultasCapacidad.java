/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Chris
 */
public class ConsultasCapacidad extends ConexionBd{
    
    public boolean registrar (Capacidad cap){
        PreparedStatement ps = null;
        Connection con = obtenerConexion();
        
        String sql = "INSERT INTO Capacidad (idCapacidad, oficialActivo, sabeLeer, "
                + " sabeEscribir) VALUES "
                + "(?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cap.getIdCapacidad());
            ps.setBoolean(2, cap.isOfcialActivo());
            ps.setBoolean(3, cap.isSabeLeer());
            ps.setBoolean(4, cap.isSabeEscribir());
           
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
