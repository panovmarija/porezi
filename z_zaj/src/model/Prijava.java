/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Prijava implements Serializable{
    private int id;
    private String adresa, mestonep;
    private boolean mestopr;
    private int broj, godina;
    private Date dpk;
    private double p;
    private Date dpp;
    private Obaveznik o;
    private VrstaNep v;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMestonep() {
        return mestonep;
    }

    public void setMestonep(String mestonep) {
        this.mestonep = mestonep;
    }

    public boolean isMestopr() {
        return mestopr;
    }

    public void setMestopr(boolean mestopr) {
        this.mestopr = mestopr;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public Date getDpk() {
        return dpk;
    }

    public void setDpk(Date dpk) {
        this.dpk = dpk;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public Date getDpp() {
        return dpp;
    }

    public void setDpp(Date dpp) {
        this.dpp = dpp;
    }

    public Obaveznik getO() {
        return o;
    }

    public void setO(Obaveznik o) {
        this.o = o;
    }

    public VrstaNep getV() {
        return v;
    }

    public void setV(VrstaNep v) {
        this.v = v;
    }

    public Prijava() {
    }

    public Prijava(int id, String adresa, String mestonep, boolean mestopr, int broj, int godina, Date dpk, double p, Date dpp, Obaveznik o, VrstaNep v) {
        this.id = id;
        this.adresa = adresa;
        this.mestonep = mestonep;
        this.mestopr = mestopr;
        this.broj = broj;
        this.godina = godina;
        this.dpk = dpk;
        this.p = p;
        this.dpp = dpp;
        this.o = o;
        this.v = v;
    }
    
}
