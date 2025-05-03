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
public class KlijentZah implements Serializable{
    private int op;
    private Object par;

    public KlijentZah() {
    }

    public KlijentZah(int op, Object par) {
        this.op = op;
        this.par = par;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Object getPar() {
        return par;
    }

    public void setPar(Object par) {
        this.par = par;
    }
    
}
