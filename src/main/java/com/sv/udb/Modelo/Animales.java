/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Modelo;

/**
 *
 * @author Luis
 */
public class Animales {
    int codi_sere ,codi_sere_refe;
    String nomb_sere,desc_sere,nomb_sere_refe;

    public Animales() {
    }

    public Animales(int codi_sere_refe,String nomb_sere, String desc_sere)
    {
        this.nomb_sere = nomb_sere;
        this.desc_sere = desc_sere;
        this.codi_sere_refe = codi_sere_refe;
    }

    public Animales(String nomb_sere,String desc_sere, String nomb_sere_refe, int codi_sere) {
        this.nomb_sere = nomb_sere;
        this.nomb_sere_refe = nomb_sere_refe;
        this.desc_sere = desc_sere;
        this.codi_sere = codi_sere;
    }

    public String getNomb_sere_refe() {
        return nomb_sere_refe;
    }

    public void setNomb_sere_refe(String nomb_sere_refe) {
        this.nomb_sere_refe = nomb_sere_refe;
    }

    @Override
    public String toString() {
        return nomb_sere;
    }

    public int getCodi_sere() {
        return codi_sere;
    }

    public void setCodi_sere(int codi_sere) {
        this.codi_sere = codi_sere;
    }

    public int getCodi_sere_refe() {
        return codi_sere_refe;
    }

    public void setCodi_sere_refe(int codi_sere_refe) {
        this.codi_sere_refe = codi_sere_refe;
    }

    public String getNomb_sere() {
        return nomb_sere;
    }

    public void setNomb_sere(String nomb_sere) {
        this.nomb_sere = nomb_sere;
    }

    public String getDesc_sere() {
        return desc_sere;
    }

    public void setDesc_sere(String desc_sere) {
        this.desc_sere = desc_sere;
    }
}
