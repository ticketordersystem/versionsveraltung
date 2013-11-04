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
public class DTOVeranstaltungInformation {

   private Date d;
   private String ort;
   private String kuenstler;
   private int id;

    public DTOVeranstaltungInformation(Date d, String ort, String kuenstler, int id) {
        this.d = d;
        this.ort = ort;
        this.kuenstler = kuenstler;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Date getD() {
        return d;
    }

    public String getOrt() {
        return ort;
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }
    
    
	
}
