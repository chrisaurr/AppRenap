/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chris
 */
public class ConsultasPais extends ConexionBd{
    
    public ArrayList<Pais> obtenerPais(){
        //PreparedStatement ps = null;
        
        Connection con = obtenerConexion();
        Statement stmt;
        ResultSet rs = null;
        ArrayList<Pais> listaPais = new ArrayList<>();
        
        
        String sql ="select * from Pais";

       
         try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               Pais paises = new Pais();
               paises.setIdPais(rs.getInt("idPais"));
               paises.setDescripcion(rs.getString("descripcion"));
               listaPais.add(paises);
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
            return listaPais;
            
        }
    }
}
