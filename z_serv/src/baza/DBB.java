/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

/**
 *
 * @author USER
 */
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Obaveznik;
import model.Prijava;
import model.Vrsta;
import model.VrstaNep;

public class DBB {

    public List<Obaveznik> vratiPodneli() {

        List<Obaveznik> l = new LinkedList<>();
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3316/prosoftjun21", "root", "root");) {
            conn.setAutoCommit(true);
            String u = "SELECT *\n"
                    + "FROM poreskiobveznik p join poreskaprijava pp on(p.poreskiobveznikid=pp.poreskiobveznikid)";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                Obaveznik o = new Obaveznik(rs.getInt("poreskiobveznikid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("jmbg"), rs.getString("korisnickoime"), rs.getString("lozinka"), rs.getString("telefon"));
                if(!l.contains(o))
                l.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Prijava> vratiprijave(Obaveznik o) {
        List<Prijava> l = new LinkedList<>();
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3316/prosoftjun21", "root", "root");) {
            conn.setAutoCommit(true);
            String u = "SELECT *\n"
                    + "FROM poreskaprijava pp join vrstanepokretnosti v on(v.vrstanepokretnostiid=pp.vrstanepokretnostiid)\n"
                    + "WHERE poreskiobveznikid="+o.getId();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                 VrstaNep v=new VrstaNep(rs.getInt("v.vrstanepokretnostiid"), rs.getString("v.nazivvrstenepokretnosti"), rs.getString("poreskagrupa"));
                Prijava p=new Prijava(rs.getInt("poreskaprijavaid"), rs.getString("adresa"), rs.getString("mestonepokretnosti"),
                        rs.getBoolean("mestoprebivalista"), rs.getInt("brojlistanepokretnosti"), rs.getInt("godinaizgradnje"), 
                        rs.getDate("datumpocetkakoriscenja")==null?null:new java.util.Date(rs.getDate("datumpocetkakoriscenja").getTime()), rs.getDouble("povrsina")
                        , rs.getDate("datumpodnosenjaprijave")==null?null:new java.util.Date(rs.getDate("datumpodnosenjaprijave").getTime()), o, v);
                l.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<VrstaNep> vrati_vr() {
        List<VrstaNep> l = new LinkedList<>();
        try  {
             String u = "select * from vrstanepokretnosti ";
            Statement s = Konekcija.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                 VrstaNep v=new VrstaNep(rs.getInt("vrstanepokretnostiid"), rs.getString("nazivvrstenepokretnosti"), rs.getString("poreskagrupa"));
                 l.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public Obaveznik login(Obaveznik obaveznik) {
        try  {
             String u = "SELECT *\n"
                    + "FROM poreskiobveznik p ";
            Statement s = Konekcija.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                Obaveznik o = new Obaveznik(rs.getInt("poreskiobveznikid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("jmbg"), rs.getString("korisnickoime"), rs.getString("lozinka"), rs.getString("telefon"));
                if(o.equals(obaveznik))return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obaveznik;
    }

    public boolean sacuvaj(List<Prijava> list) {
 
         try  {
             String u = "insert into poreskaprijava (adresa, mestonepokretnosti, mestoprebivalista, brojlistanepokretnosti, godinaizgradnje, datumpocetkakoriscenja, povrsina, datumpodnosenjaprijave, poreskiobveznikid, vrstanepokretnostiid) values(?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = Konekcija.getInstance().getConn().prepareStatement(u);
            for(Prijava p:list)
            {
                ps.setString(1, p.getAdresa());
                ps.setString(2, p.getMestonep());
                ps.setBoolean(3, p.isMestopr());
                ps.setInt(4, p.getBroj());
                ps.setInt(5, p.getGodina());
                ps.setDate(6, new Date(p.getDpk().getTime()));
                ps.setDouble(7, p.getP());
                ps.setDate(8, new Date(p.getDpp().getTime()));
                ps.setInt(9, p.getO().getId());
                ps.setInt(10, p.getV().getId());
                ps.addBatch();
            }
            ps.executeBatch();
            Konekcija.getInstance().getConn().commit();
         } catch (SQLException ex) {
             try {
                 Konekcija.getInstance().getConn().rollback();
             } catch (SQLException ex1) {
                 Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex1);
             }
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
