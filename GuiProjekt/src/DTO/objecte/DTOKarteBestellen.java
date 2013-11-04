/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class DTOKarteBestellen {
    private int kartenID;
    private int kundenID;
    private boolean ermaessigt;

    public DTOKarteBestellen(int kartenID, int kundenID, boolean ermaessigt) {
        this.kartenID = kartenID;
        this.kundenID = kundenID;
        this.ermaessigt = ermaessigt;
    }

    public int getKartenID() {
        return kartenID;
    }

    public int getKundenID() {
        return kundenID;
    }

    public boolean isErmaessigt() {
        return ermaessigt;
    }

    public void setKartenID(int kartenID) {
        this.kartenID = kartenID;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }

    public void setErmaessigt(boolean ermaessigt) {
        this.ermaessigt = ermaessigt;
    }
    


}
