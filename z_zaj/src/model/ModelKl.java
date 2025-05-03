/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelKl extends AbstractTableModel{
private List<Prijava>l;
private String []kol=new String []{"Adresa", "Mesto", "Mesto prebvališta", "Lista nepokretnosti","Godina izgradnje","Pocetak koriscenja", "Povrsina","Vrsta nepokretnosti"};

    public ModelKl(List<Prijava> l) {
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
        Prijava o=l.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getAdresa();
            case 1:
                return o.getMestonep();
            case 2:
                return o.isMestopr();
            case 3:
                return o.getBroj();
            case 4:
                return o.getGodina();
            case 5:
                if (o.getDpk()==null )return "";
                return new SimpleDateFormat("dd.MM.yyyy.").format(o.getDpk());
            case 6:
                return o.getP();
            case 7:
                return o.getV();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==2)
            return Boolean.class;
        return String.class;
    }
    
    

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }
    
    public List<Prijava> getL() {
        return l;
    }
    
}
