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
public class ConsultasDepartamento extends ConexionBd{
    
    public ArrayList<Departamento> obtenerDepartamento(){
        //PreparedStatement ps = null;
        
        Connection con = obtenerConexion();
        Statement stmt;
        ResultSet rs = null;
        ArrayList<Departamento> listaDepartamento = new ArrayList<>();
        
        
        String sql ="select * from Departamento";

       
         try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               Departamento dep = new Departamento();
               dep.setIdDepartamento(rs.getInt("idDepartamento"));
               dep.setDescripcion(rs.getString("descripcion"));
               dep.setIdPais(rs.getInt("idPais"));
               listaDepartamento.add(dep);
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
            return listaDepartamento;
            
        }
    }
    
    public ArrayList<Departamento> obtenerDepaDePais(int idPais){
        //PreparedStatement ps = null;
        
        Connection con = obtenerConexion();
        Statement stmt;
        ResultSet rs = null;
        ArrayList<Departamento> listaDepartamento = new ArrayList<>();
        
        
        String sql ="select * from Departamento where idPais='"+idPais+"'";

       
         try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               Departamento dep = new Departamento();
               dep.setIdDepartamento(rs.getInt("idDepartamento"));
               dep.setDescripcion(rs.getString("descripcion"));
               dep.setIdPais(rs.getInt("idPais"));
               listaDepartamento.add(dep);
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
            return listaDepartamento;
            
        }
    }
}
