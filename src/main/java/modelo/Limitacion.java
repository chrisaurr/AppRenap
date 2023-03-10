/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Chris
 */
public class Limitacion {

    /**
     * @return the idLimitacion
     */
    public int getIdLimitacion() {
        return idLimitacion;
    }

    /**
     * @param idLimitacion the idLimitacion to set
     */
    public void setIdLimitacion(int idLimitacion) {
        this.idLimitacion = idLimitacion;
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

    public Limitacion() {
    }

    public Limitacion(int idLimitacion, String descripcion) {
        this.idLimitacion = idLimitacion;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
    
    private int idLimitacion;
    private String descripcion;
}
