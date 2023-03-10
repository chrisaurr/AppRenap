/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;

/**
 *
 * @author Chris
 */
public class Huella {

    /**
     * @return the idDpi
     */
    public String getIdDpi() {
        return idDpi;
    }

    /**
     * @param idDpi the idDpi to set
     */
    public void setIdDpi(String idDpi) {
        this.idDpi = idDpi;
    }

    /**
     * @return the mano
     */
    public String getMano() {
        return mano;
    }

    /**
     * @param mano the mano to set
     */
    public void setMano(String mano) {
        this.mano = mano;
    }

    /**
     * @return the dedo
     */
    public String getDedo() {
        return dedo;
    }

    /**
     * @param dedo the dedo to set
     */
    public void setDedo(String dedo) {
        this.dedo = dedo;
    }

    /**
     * @return the huella
     */
    public FileInputStream getHuella() {
        return huella;
    }

    /**
     * @param huella the huella to set
     */
    public void setHuella(FileInputStream huella) {
        this.huella = huella;
    }

    /**
     * @return the longitudBytes
     */
    public int getLongitudBytes() {
        return longitudBytes;
    }

    /**
     * @param longitudBytes the longitudBytes to set
     */
    public void setLongitudBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }
    private String idDpi;
    private String mano;
    private String dedo;
    private FileInputStream huella;
    private int longitudBytes;
}
