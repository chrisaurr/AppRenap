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
public class ConsultasVecindad extends ConexionBd{
    
    public boolean registrar (Vecindad ven){
        PreparedStatement ps = null;
        Connection con = obtenerConexion();
        
        String sql = "INSERT INTO Vecindad (idVecindad, municipio, "
                + " departamento) VALUES "
                + "(?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ven.getIdVecindad());
            ps.setString(2, ven.getMunicipio());
            ps.setString(3, ven.getDepartamento());
            
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
