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
public class ConsultasLimitacion extends ConexionBd{
    
    public ArrayList<Limitacion> obtenerLimitacion(){
        //PreparedStatement ps = null;
        
        Connection con = obtenerConexion();
        Statement stmt;
        ResultSet rs = null;
        ArrayList<Limitacion> listaLimitacion = new ArrayList<>();
        
        
        String sql ="select * from Limitacion";

       
         try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               Limitacion limit = new Limitacion();
               limit.setIdLimitacion(rs.getInt("idLimitacion"));
               limit.setDescripcion(rs.getString("descripcion"));
               listaLimitacion.add(limit);
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
            return listaLimitacion;
            
        }
    }
}
