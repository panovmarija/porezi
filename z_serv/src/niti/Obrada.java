/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Obaveznik;
import model.Prijava;
import transfer.ServerOdg;
import trnasfer.KlijentZah;

/**
 *
 * @author USER
 */
public class Obrada extends Thread{
    private Socket s;

    public Obrada(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        KlijentZah kz;
        while ((kz=procitaj())!=null) {            
            ServerOdg so=new ServerOdg();
            switch (kz.getOp()) {
                case operacije.Operacije.vrati_vr:
                    so.setOdg(kontroer.Kontroler.getInstance().vrati_vr());
                    posalji(so);
                    break;
                case operacije.Operacije.login:
                    so.setOdg(kontroer.Kontroler.getInstance().login((Obaveznik)kz.getPar()));
                    posalji(so);
                    break;
                case operacije.Operacije.sacuvaj:
                    so.setOdg(kontroer.Kontroler.getInstance().sacuvaj((List<Prijava>)kz.getPar()));
                    posalji(so);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        ugasiS();
    }
    
    public KlijentZah procitaj()
    {
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (KlijentZah) ois.readObject();
        } catch (IOException ex) {
            System.out.println("klijent odvezan /gasenje forme /pad mreze");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void posalji(ServerOdg so)
    {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ugasiS()
    {
        if(s!=null &&!s.isClosed())
        {
            try {
                s.close();
                System.out.println(s.isClosed());
            } catch (IOException ex) {
                Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
