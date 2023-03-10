/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Chris
 */
public class Capacidad {

    /**
     * @return the idCapacidad
     */
    public String getIdCapacidad() {
        return idCapacidad;
    }

    /**
     * @param idCapacidad the idCapacidad to set
     */
    public void setIdCapacidad(String idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    /**
     * @return the ofcialActivo
     */
    public boolean isOfcialActivo() {
        return ofcialActivo;
    }

    /**
     * @param ofcialActivo the ofcialActivo to set
     */
    public void setOfcialActivo(boolean ofcialActivo) {
        this.ofcialActivo = ofcialActivo;
    }

    /**
     * @return the sabeLeer
     */
    public boolean isSabeLeer() {
        return sabeLeer;
    }

    /**
     * @param sabeLeer the sabeLeer to set
     */
    public void setSabeLeer(boolean sabeLeer) {
        this.sabeLeer = sabeLeer;
    }

    /**
     * @return the sabeEscribir
     */
    public boolean isSabeEscribir() {
        return sabeEscribir;
    }

    /**
     * @param sabeEscribir the sabeEscribir to set
     */
    public void setSabeEscribir(boolean sabeEscribir) {
        this.sabeEscribir = sabeEscribir;
    }
    private String idCapacidad;
    private boolean ofcialActivo;
    private boolean sabeLeer;
    private boolean sabeEscribir;
}
