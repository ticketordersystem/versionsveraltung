/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import DTO.objecte.DTOKategorieInformation;
import DTO.objecte.DTOVeranstaltung;
import DTO.objecte.DTOVeranstaltungAnzeigen;
import controller.RMIControllerInterface;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Stefan Dietrich
 */
public class VeranstaltungKategorieCtrl {
    
    private DTOVeranstaltung _veranstaltung;
    private RMIControllerInterface _ctrl;
    private ArrayList<DTOKategorieInformation> _kategorien;
    
    
    public VeranstaltungKategorieCtrl(DTOVeranstaltung veranstaltung, RMIControllerInterface ctrl)
    {
        _veranstaltung = veranstaltung;
        _ctrl = ctrl;
        _kategorien = _ctrl.getKategorieInfoVonVeranstaltung(new DTOVeranstaltungAnzeigen(_veranstaltung.getID()));
    }
    
    
    public DTOVeranstaltung getVeranstaltung()
    {
        return _veranstaltung;
    }
    
    

    public TableModel getKategorieInfoModel() {
        Object[][] ob = new Object[_kategorien.size()][4];
        for (int i = 0; i < _kategorien.size(); i++) {
            ob[i][0] = _kategorien.get(i).getId();
            ob[i][1] = _kategorien.get(i).getName();
            ob[i][2] = _kategorien.get(i).getPreis()+"€";
            ob[i][3] =_kategorien.get(i).getFreieplätze();
        }
        return (new DefaultTableModel(
                ob,
                new String[]{
            "KAtegorieID", "Kategoriename", "Kategoriepreis", "Freie Plätze"
        }) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public void selectKategorie(int id) {
       DTOKategorieInformation selectedKategorie =  _ctrl.getKategorieInfo(id);
       //TODO: Weiterverarbeitung des Objekts
    }
}
