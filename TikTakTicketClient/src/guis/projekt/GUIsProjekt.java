/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guis.projekt;

import GUI.KartenInfo;
import GUIController.KartenInfoCtrl;
import DTO.objecte.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Stefan Dietrich
 */
public class GUIsProjekt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DTOKarte k1 = new DTOKarte(1, "a", 1);
        DTOKarte k2 = new DTOKarte(2, "a", 2);
        List<DTOKarte> karten = new LinkedList<>();
        karten.add(k1);
        karten.add(k2);
        DTOKategorieKarte kategoriekarte = new DTOKategorieKarte(karten);
        
        
        
        
        DTOVeranstaltung v = new DTOVeranstaltung(1, "Testveranstaltung", "Dornbirn", new Date(), true);
        DTOKategorieInformation k = new DTOKategorieInformation(1, "Kategorie1", new BigDecimal(22.24), 5, 20);
       // KartenInfoCtrl ctrl = new KartenInfoCtrl(v, k, kategoriekarte);
       //KartenInfo info = new KartenInfo(ctrl);
       
    }
    
    
}
