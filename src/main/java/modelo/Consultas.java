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
public class Consultas extends ConexionBd{
    
    public boolean registrar (Persona per){
        PreparedStatement ps = null;
        Connection con = obtenerConexion();
        
        String sql = "INSERT INTO Persona (idDpi, primerNombre, segundoNombre,"
                + " otrosNombres, primerApellido, segundoApellido, apellidoCasada, "
                + "genero, estadoCivil, idPais, idProfesion, idLimitacion, idCapacidad, idCedula, "
                + "idVecindad, idfeDeEdad, nombreUsual, identificacion) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getIdDpi());
            ps.setString(2, per.getPrimerNom());
            ps.setString(3, per.getSegundoNom());
            ps.setString(4, per.getOtroNom());
            ps.setString(5, per.getPrimerApe());
            ps.setString(6, per.getSegundoApe());
            ps.setString(7, per.getCasadaApe());
            ps.setString(8, per.getGenero());
            ps.setString(9, per.getEstadoCivil());
            ps.setInt(10, per.getIdPais());
            ps.setInt(11, per.getIdProfesion());
            ps.setInt(12, per.getIdLimitaciones());
            ps.setString(13, per.getIdCapacidad());
            ps.setString(14, per.getIdCedula());
            ps.setString(15, per.getIdVecindad());
            ps.setString(16, per.getIdFeDeEdad());
            ps.setString(17, per.getNombreUsual());
            ps.setString(18, per.getIdentificacion());
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
