/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import GUI.*;
import client.Client;

/**
 *
 * @author Stefan Dietrich
 */
public class MainGuiCtrl {

    private static VeranstaltungSuchen _veranstaltungSuchen;
    private static VeranstaltungKategorie _veranstaltungKategorie;
    private static KartenInfo _kartenInfo;
    private static KartenInfoCtrl _kartenInfoCtrl;
    private static VeranstaltungKategorieCtrl _veranstaltungKategorieCtrl;
    private static VeranstaltungsSuchenCtrl _veranstaltungSuchenCtrl;
    private static Client _client;

    public static void VeranstaltungAusgewaehlt(int veranstaltungID) {
        _veranstaltungSuchen.setVisible(false);
        _veranstaltungKategorie = new VeranstaltungKategorie(getVeranstaltungKategorieCtrl(veranstaltungID));
        _veranstaltungSuchen.Quit();
        _veranstaltungSuchen = null;
    }

    public static void KategorieAusgewählt(int veranstaltungID, int kategorieID) {
        _veranstaltungKategorie.setVisible(false);
        _kartenInfo = new KartenInfo(getKartenInfoCtrl(veranstaltungID, kategorieID));
        _veranstaltungKategorie.Quit();
        _veranstaltungKategorie = null;
    }

    public static void KategorieCancel() {
        _veranstaltungKategorie.setVisible(false);
        _veranstaltungSuchen = new VeranstaltungSuchen(getVeranstaltungSuchenCtrl());
        _veranstaltungKategorie.Quit();
        _veranstaltungKategorie = null;
    }

    public static void KarteCancel(int veranstaltungID) {
        _kartenInfo.setVisible(false);
        _veranstaltungKategorie = new VeranstaltungKategorie(getVeranstaltungKategorieCtrl(veranstaltungID));
        _kartenInfo.Quit();
        _kartenInfo = null;
    }

    public static void VeranstaltungCancel() {
        _veranstaltungSuchen.setVisible(false);
        _veranstaltungSuchen.Quit();
        _veranstaltungSuchen = null;
        System.exit(0);
    }

    public static void main(String[] args) {
        _client = new Client();
        _veranstaltungSuchen = new VeranstaltungSuchen(getVeranstaltungSuchenCtrl());
    }

    public static VeranstaltungsSuchenCtrl getVeranstaltungSuchenCtrl() {
        if (_veranstaltungSuchenCtrl == null) {
            _veranstaltungSuchenCtrl = new VeranstaltungsSuchenCtrl(_client);
        }
        return _veranstaltungSuchenCtrl;
    }

    public static VeranstaltungKategorieCtrl getVeranstaltungKategorieCtrl(int id) {
        if (_veranstaltungKategorieCtrl == null) {
            _veranstaltungKategorieCtrl = new VeranstaltungKategorieCtrl(id, _client);
        }
        return _veranstaltungKategorieCtrl;
    }

    public static KartenInfoCtrl getKartenInfoCtrl(int veranstaltungID, int kategorieID) {
        if (_kartenInfoCtrl == null) {
            _kartenInfoCtrl = new KartenInfoCtrl(veranstaltungID, kategorieID, _client);
        }
        return _kartenInfoCtrl;
    }
}
