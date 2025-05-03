/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroer;

import baza.DBB;
import java.util.List;
import model.Obaveznik;
import model.Prijava;
import model.VrstaNep;

/**
 *
 * @author USER
 */
public class Kontroler {
    private DBB dbb;
    
    private static Kontroler instance;

    private Kontroler() {
    dbb=new DBB();
    }

    public static Kontroler getInstance() {
        if(instance==null)
            instance=new Kontroler();
        return instance;
    }

    public List<Obaveznik> vratiPodneli() {
        return dbb.vratiPodneli();
    }

    public List<Prijava> vratiprijave(Obaveznik o) {
        return dbb.vratiprijave(o);
    }

    public List<VrstaNep>  vrati_vr() {
        return dbb.vrati_vr();
    }

    public Obaveznik login(Obaveznik obaveznik) {
        return dbb.login(obaveznik);
    }

    public boolean sacuvaj(List<Prijava> list) {
        return dbb.sacuvaj(list);
    }
    
}
