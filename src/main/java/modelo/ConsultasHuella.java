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
public class ConsultasHuella extends ConexionBd{
    
     public boolean registrar (Huella huella){
        PreparedStatement ps = null;
        Connection con = obtenerConexion();
        
        String sql = "INSERT INTO Huella (idDpi, mano, dedo, "
                + " huella) VALUES "
                + "(?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, huella.getIdDpi());
            ps.setString(2, huella.getMano());
            ps.setString(3, huella.getDedo());
            ps.setBlob(4, huella.getHuella(), huella.getLongitudBytes());
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
