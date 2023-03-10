/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Chris
 */
public class Profesion {

    /**
     * @return the idProfesion
     */
    public int getIdProfesion() {
        return idProfesion;
    }

    /**
     * @param idProfesion the idProfesion to set
     */
    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesion() {
    }

    public Profesion(int idProfesion, String descripcion) {
        this.idProfesion = idProfesion;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
    
    private int idProfesion;
    private String descripcion;
}
