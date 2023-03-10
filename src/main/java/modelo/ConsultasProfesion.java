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
public class ConsultasProfesion extends ConexionBd{
    
    public ArrayList<Profesion> obtenerProfesion(){
        //PreparedStatement ps = null;
        
        Connection con = obtenerConexion();
        Statement stmt;
        ResultSet rs = null;
        ArrayList<Profesion> listaProfesion = new ArrayList<>();
        
        
        String sql ="select * from Profesion";

       
         try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               Profesion profesion = new Profesion();
               profesion.setIdProfesion(rs.getInt("idProfesion"));
               profesion.setDescripcion(rs.getString("descripcion"));
               listaProfesion.add(profesion);
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
            return listaProfesion;
            
        }
    }
  }
