/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Chris
 */
public class Vecindad {

    /**
     * @return the idVecindad
     */
    public String getIdVecindad() {
        return idVecindad;
    }

    /**
     * @param idVecindad the idVecindad to set
     */
    public void setIdVecindad(String idVecindad) {
        this.idVecindad = idVecindad;
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
    
    private String idVecindad;
    private String municipio;
    private String departamento;
    
    
}
