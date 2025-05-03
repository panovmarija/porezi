/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelServ extends AbstractTableModel{
private List<Obaveznik>l;
private String []kol=new String []{"PoreskiObveznikID", "Ime", "Prezime", "JMBG","Telefon"};

    public ModelServ(List<Obaveznik> l) {
        this.l = l;
    }

    @Override
    public int getRowCount() {
        return l.size();
    }

    @Override
    public int getColumnCount() {
        return kol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obaveznik o=l.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getId();
            case 1:
                return o.getIme();
            case 2:
                return o.getPrez();
            case 3:
                return o.getJmbg();
            case 4:
                return o.getTelefon();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }
    
    public List<Obaveznik> getL() {
        return l;
    }
    
}
