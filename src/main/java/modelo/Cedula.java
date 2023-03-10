/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Chris
 */
public class Cedula {

    /**
     * @return the idCedula
     */
    public String getIdCedula() {
        return idCedula;
    }

    /**
     * @param idCedula the idCedula to set
     */
    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    /**
     * @return the noCedula
     */
    public String getNoCedula() {
        return noCedula;
    }

    /**
     * @param noCedula the noCedula to set
     */
    public void setNoCedula(String noCedula) {
        this.noCedula = noCedula;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    private String idCedula;
    private String noCedula;
    private String municipio;
    private String departamento;
}
