/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;
import java.sql.Date;

/**
 *
 * @author Chris
 */
public class Dpi {

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
     * @return the emision
     */
    public Date getEmision() {
        return emision;
    }

    /**
     * @param emision the emision to set
     */
    public void setEmision(Date emision) {
        this.emision = emision;
    }

    /**
     * @return the vencimiento
     */
    public Date getVencimiento() {
        return vencimiento;
    }

    /**
     * @param vencimiento the vencimiento to set
     */
    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    /**
     * @return the mrz2
     */
    public String getMrz2() {
        return mrz2;
    }

    /**
     * @param mrz2 the mrz2 to set
     */
    public void setMrz2(String mrz2) {
        this.mrz2 = mrz2;
    }

    /**
     * @return the noSerie
     */
    public String getNoSerie() {
        return noSerie;
    }

    /**
     * @param noSerie the noSerie to set
     */
    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    /**
     * @return the fotografia
     */
    public FileInputStream getFotografia() {
        return fotografia;
    }

    /**
     * @param fotografia the fotografia to set
     */
    public void setFotografia(FileInputStream fotografia) {
        this.fotografia = fotografia;
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
    private Date emision;
    private Date vencimiento;
    private String mrz2;
    private String noSerie;
    private FileInputStream fotografia;
    private int longitudBytes;

    public Dpi(String idDpi, Date emision, Date vencimiento, String mrz2, String noSerie, FileInputStream fotografia, int longitudBytes) {
        this.idDpi = idDpi;
        this.emision = emision;
        this.vencimiento = vencimiento;
        this.mrz2 = mrz2;
        this.noSerie = noSerie;
        this.fotografia = fotografia;
        this.longitudBytes = longitudBytes;
    }

    public Dpi() {
    }
}
