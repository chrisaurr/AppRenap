/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class ConsultasMunicipio extends ConexionBd{
    
    public ArrayList<Municipio> obtenerMuniDeDepa(int munici){
        //PreparedStatement ps = null;
        
        Connection con = obtenerConexion();
        Statement stmt;
        ResultSet rs = null;
        ArrayList<Municipio> listaMunicipio = new ArrayList<>();
        
        
        String sql ="select * from Municipio where idDepartamento='"+munici+"'";

       
         try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               Municipio muni = new Municipio();
               muni.setIdMunicipio(rs.getInt("idMunicipio"));
               muni.setDescripcion(rs.getString("descripcion"));
               muni.setIdDepartamento(rs.getInt("idDepartamento"));
               listaMunicipio.add(muni);
               //return true;
              
           }
           
            //return false;
            //return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            //return false;
        } finally{
            try {
                
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
            return listaMunicipio;
            
        }
    }
}
