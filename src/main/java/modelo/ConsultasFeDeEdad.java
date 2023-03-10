/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Chris
 */
public class ConsultasFeDeEdad extends ConexionBd{
    
     public boolean registrar (FeDeEdad feDeEdad){
        PreparedStatement ps = null;
        Connection con = obtenerConexion();
        
        String sql = "INSERT INTO feDeEdad (idfeDeEdad, fecha, municipio, departamento,"
                + " pais, libro, folio, partida) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, feDeEdad.getIdFeDeEdad());
            ps.setDate(2, feDeEdad.getFecha());
            ps.setString(3, feDeEdad.getMunicipio());
            ps.setString(4, feDeEdad.getDepartamento());
            ps.setString(5, feDeEdad.getPais());
            ps.setString(6, feDeEdad.getLibro());
             ps.setString(7, feDeEdad.getFolio());
            ps.setString(8, feDeEdad.getPartida());
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
