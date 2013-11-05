/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import DTO.objecte.*;
import client.Client;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Stefan Dietrich
 */
public class KartenInfoCtrl {

    private DTOVeranstaltung _veranstaltung;
    private DTOKategorieInformation _kategorie;
    private DTOKategorieKarte _Kategoriekarten;
    private DTOKundenDaten _kunde;
    private Client _client;

    public KartenInfoCtrl(int veranstaltungID, int kategorieID, Client client) {
        _client = client;
        _veranstaltung = client.getVeranstaltungByID(kategorieID);
        _kategorie = client.getKategorieInfo(kategorieID);
        _Kategoriekarten = _client.getAlleFreieKartenNachKategorie(new DTOKategorienAuswaehlen(_kategorie.getId()));
    }

    public TableModel getKartenInfo() {
        return null;
    }

    public DTOVeranstaltung getVeranstaltung() {
        return _veranstaltung;
    }

    public DTOKategorieInformation getKategorie() {
        return _kategorie;
    }

    public boolean checkKundennummer(String text) {
        if (text != null) {
            return false;
        } else {
            int id = 0;
            boolean isNumber = true;
            try {
                id = Integer.parseInt(text);
            } catch (Exception e) {
                _kunde = null;
                isNumber = false;
            }
            if (isNumber) {
                try {
                    _kunde = _client.getKundendatenNachID(id);
                } catch (Exception ex) {
                    _kunde = null;
                }
            } else {
                _kunde = null;
            }
            if (_kunde != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public DTOKundenDaten getKunde() {
        return _kunde;
    }

    public TableModel getKartenInfoModel() {
        Object[][] ob = new Object[_Kategoriekarten.getDTOKarten().size()][5];
        for (int i = 0; i < _Kategoriekarten.getDTOKarten().size(); i++) {
            DTOKarte k = _Kategoriekarten.getDTOKarten().get(i);
            ob[i][0] = false;
            ob[i][1] = k.getID();
            ob[i][2] = k.getReihe();
            ob[i][3] = k.getPlatz();
            ob[i][4] = false;
        }
        return (new DefaultTableModel(
                ob,
                new String[]{
            "Auswählen", "KartenID", "Reihe", "Sitzplatz", "Ermäßigt"
        }) {
            Class[] types = new Class[]{
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public void kartenBestellen(List<Object[]> bestellteKarten) {
        List<DTOKarteBestellen> karten = new LinkedList<>();
        int kundenID = -1;
        if (_kunde != null) {
            kundenID = _kunde.getId();
        }
        for (Object[] o : bestellteKarten) {

            karten.add(new DTOKarteBestellen((int) o[1], kundenID, (boolean) o[4]));
        }
        _client.verkaufSpeichern(karten);

        updateController();
    }

    public void kartenReservieren(List<Object[]> reservierteKarten) {
        List<DTOKarteReservieren> karten = new LinkedList<>();
        int kundenID = -1;
        if (_kunde != null) {
            kundenID = _kunde.getId();
        }
        for (Object[] o : reservierteKarten) {

            karten.add(new DTOKarteReservieren((int) o[1], kundenID, (boolean) o[4]));
        }
        _client.reservierungSpeichern(karten);

        updateController();
    }

    private void deleteKundenInfo() {
        _kunde = null;
    }

    private void updateController() {
        _kategorie = _client.getKategorieInfo(_kategorie.getId());
        _Kategoriekarten = _client.getAlleFreieKartenNachKategorie(new DTOKategorienAuswaehlen(_kategorie.getId()));
    }

    public void cancelClicked() {
       deleteKundenInfo();
       MainGuiCtrl.KarteCancel(_veranstaltung.getID());
    }
}
