/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Osvezi extends Thread{
    private ServerForma sf;

    public Osvezi(ServerForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        while (true) {            
            sf.osvezi();
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Osvezi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
