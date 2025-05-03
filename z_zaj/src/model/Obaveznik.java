/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class Obaveznik implements Serializable{
    private int id;
    private String ime, prez, jmbg, user, pass, telefon;

    public Obaveznik() {
    }

    @Override
    public String toString() {
        return ime+" "+prez;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Obaveznik other = (Obaveznik) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return Objects.equals(this.pass, other.pass);
    }

    public Obaveznik(int id, String ime, String prez, String jmbg, String user, String pass, String telefon) {
        this.id = id;
        this.ime = ime;
        this.prez = prez;
        this.jmbg = jmbg;
        this.user = user;
        this.pass = pass;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrez() {
        return prez;
    }

    public void setPrez(String prez) {
        this.prez = prez;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
   
}
