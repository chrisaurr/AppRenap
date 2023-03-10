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
public class ConsultasDpi extends ConexionBd{
    
    public boolean registrar (Dpi dpi){
        PreparedStatement ps = null;
        Connection con = obtenerConexion();
        
        String sql = "INSERT INTO Dpi (idDpi, emision, vencimiento, mrz2,"
                + " noSerie, fotografia) VALUES "
                + "(?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dpi.getIdDpi());
            ps.setDate(2, dpi.getEmision());
            ps.setDate(3, dpi.getVencimiento());
            ps.setString(4, dpi.getMrz2());
            ps.setString(5, dpi.getNoSerie());
            ps.setBlob(6, dpi.getFotografia(), dpi.getLongitudBytes());
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
