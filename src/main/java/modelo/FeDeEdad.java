/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

//import java.util.Date;


/**
 *
 * @author Chris
 */
public class FeDeEdad {

    /**
     * @return the idFeDeEdad
     */
    public String getIdFeDeEdad() {
        return idFeDeEdad;
    }

    /**
     * @param idFeDeEdad the idFeDeEdad to set
     */
    public void setIdFeDeEdad(String idFeDeEdad) {
        this.idFeDeEdad = idFeDeEdad;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the Municipio
     */
    public String getMunicipio() {
        return Municipio;
    }

    /**
     * @param Municipio the Municipio to set
     */
    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    /**
     * @return the Departamento
     */
    public String getDepartamento() {
        return Departamento;
    }

    /**
     * @param Departamento the Departamento to set
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the libro
     */
    public String getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(String libro) {
        this.libro = libro;
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the partida
     */
    public String getPartida() {
        return partida;
    }

    /**
     * @param partida the partida to set
     */
    public void setPartida(String partida) {
        this.partida = partida;
    }
    private String idFeDeEdad;
    private Date fecha;
    private String Municipio;
    private String Departamento;
    private String pais;
    private String libro;
    private String folio;
    private String partida;
}
