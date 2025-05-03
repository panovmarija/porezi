/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trnasfer;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class ServerOdg implements Serializable{
    private int op;
    private Object odg;

    public ServerOdg() {
    }

    public ServerOdg(int op, Object odg) {
        this.op = op;
        this.odg = odg;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Object getOdg() {
        return odg;
    }

    public void setOdg(Object odg) {
        this.odg = odg;
    }
    
}
