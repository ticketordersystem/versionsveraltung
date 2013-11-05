/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import DTO.objecte.DTOKarteBestellen;
import DTO.objecte.DTOKarteReservieren;
import DTO.objecte.DTOKategorieInformation;
import DTO.objecte.DTOKategorieKarte;
import DTO.objecte.DTOKategorienAuswaehlen;
import DTO.objecte.DTOKundenDaten;
import DTO.objecte.DTOVeranstaltung;
import DTO.objecte.DTOVeranstaltungAnzeigen;
import DTO.objecte.DTOVeranstaltungInformation;
import DTO.objecte.DTOVeranstaltungSuchen;
import controller.RMIControllerInterface;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {

    RMIControllerInterface stub;

    public Client() {
        startClient();
    }

    private void startClient() {

        try {
            stub = (RMIControllerInterface) Naming.lookup("rmi://localhost/RMIControllerObject");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public DTOKategorieKarte getAlleFreieKartenNachKategorie(DTOKategorienAuswaehlen kat) {
        DTOKategorieKarte x = null;
        try {
            x = stub.getAlleFreieKartenNachKategorie(kat);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return x;
    }

    public ArrayList<DTOKategorieInformation> getKategorieInfoVonVeranstaltung(DTOVeranstaltungAnzeigen v) {
        ArrayList<DTOKategorieInformation> x = null;
        try {
            x = stub.getKategorieInfoVonVeranstaltung(v);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return x;
    }

    public ArrayList<DTOKundenDaten> getKundenListNachNachname(String nachname){
        ArrayList<DTOKundenDaten> x = null;
        try {
            x = stub.getKundenListNachNachname(nachname);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return x;
    }

    public DTOKundenDaten getKundendatenNachID(int id){
        DTOKundenDaten x = null;
        try {
            x = stub.getKundendatenNachID(id);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return x;
    }

    public void karteKaufen(DTOKarteBestellen karteDTO) {
        try {
            stub.karteKaufen(karteDTO);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

    }

    public void reservierungSpeichern(List<DTOKarteReservieren> karten){
        try {
            stub.reservierungSpeichern(karten);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public ArrayList<DTOVeranstaltungInformation> sucheVeranstaltungenNachKrieterien(Date d, String ort, String kuenstler) {
        ArrayList<DTOVeranstaltungInformation> x = null;
        try {
            //x = stub.sucheVeranstaltungenNachKrieterien(d, ort, kuenstler);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return x;
    }

    public void verkaufSpeichern(List<DTOKarteBestellen> karten) {
        try {
            stub.verkaufSpeichern(karten);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public DTOKategorieInformation getKategorieInfo(int id) {
        DTOKategorieInformation x = null;
        try {
            x = stub.getKategorieInfo(id);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return x;

    }

    public DTOVeranstaltung getVeranstaltungByID(int kategorieID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
