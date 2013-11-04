/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class DTOKarte {
    private int ID;
    private String reihe;
    private int platz;

    public DTOKarte(int ID, String reihe, int platz) {
        this.ID = ID;
        this.reihe = reihe;
        this.platz = platz;
    }

    public int getID() {
        return ID;
    }

    public String getReihe() {
        return reihe;
    }

    public int getPlatz() {
        return platz;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setReihe(String reihe) {
        this.reihe = reihe;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }
    


}
