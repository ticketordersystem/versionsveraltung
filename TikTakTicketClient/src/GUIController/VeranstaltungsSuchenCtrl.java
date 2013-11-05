
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import DTO.objecte.*;
import client.Client;
import controller.RMIControllerInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Monika
 */
public class VeranstaltungsSuchenCtrl {
//    //ALT
//    private DTOVeranstaltung veranstaltung;
//    private DTOVeranstaltungInfoList veranstInfoList;
//    private DTOVeranstaltungSuchen veranstaltungSuchen;   
//    private RMIControllerInterface rmiCtrl;
//    private DTOVeranstaltungAnzeigen veranstId;

    //Neu
    private ArrayList<DTOVeranstaltungInformation> _veranstaltungen = new ArrayList<>();
    private Client _client;

    public VeranstaltungsSuchenCtrl(Client client) {
         _client = client;
        _veranstaltungen = _client.sucheVeranstaltungenNachKrieterien(null, null, null);
    }

    public void searchingForEvents(String date, String place, String artist) {
        Date d = null;
        try {
            SimpleDateFormat sdfToDate = new SimpleDateFormat("dd.MM.yyyy");
            d = sdfToDate.parse(date);
        } catch (Exception e) {
        }
        System.out.println(d);
        _veranstaltungen = _client.sucheVeranstaltungenNachKrieterien(d, place, artist);
    }

    public void VeranstaltungAnzeigen(int vId) {
       MainGuiCtrl.VeranstaltungAusgewaehlt(vId);
    }

    public TableModel getVeranstaltungInfoModel() {
        Object[][] ob = new Object[_veranstaltungen.size()][5];
        for (int i = 0; i < _veranstaltungen.size(); i++) {
            DTOVeranstaltungInformation ev = _veranstaltungen.get(i);
            ob[i][0] = ev.getD();
            ob[i][1] = ev.getName();
            ob[i][2] = ev.getOrt();
            ob[i][3] = ev.getKuenstler();
            ob[i][4] = ev.getId();
        }
        return (new DefaultTableModel(ob, new String[]{
            "Datum", "Name", "Ort", "Künstler", "Id"
        }) {
            Class[] types = new Class[]{
                java.util.Date.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public void CancelClicked() {
        MainGuiCtrl.VeranstaltungCancel();
    }
}
