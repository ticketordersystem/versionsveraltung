/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

import java.util.Date;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class DTOVeranstaltung {
    
    private int ID;
    private String Vname;
    private String VOrt;
    private Date date;
    private boolean ermaessigt;

    public DTOVeranstaltung(int ID, String Vname, String VOrt, Date date, boolean ermaessigt) {
        this.ID = ID;
        this.Vname = Vname;
        this.VOrt = VOrt;
        this.date = date;
        this.ermaessigt = ermaessigt;
    }

    public int getID() {
        return ID;
    }

    public String getVname() {
        return Vname;
    }

    public String getVOrt() {
        return VOrt;
    }

    public Date getDate() {
        return date;
    }

    public boolean isErmaessigt() {
        return ermaessigt;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setVname(String Vname) {
        this.Vname = Vname;
    }

    public void setVOrt(String VOrt) {
        this.VOrt = VOrt;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setErmaessigt(boolean ermaessigt) {
        this.ermaessigt = ermaessigt;
    }

    
    
}
