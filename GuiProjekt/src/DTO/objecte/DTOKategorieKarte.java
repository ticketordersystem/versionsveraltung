/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

import java.util.List;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class DTOKategorieKarte {
List<DTOKarte>  DTOKarten;

    public DTOKategorieKarte(List<DTOKarte> DTOKarten) {
        this.DTOKarten = DTOKarten;
    }

    public List<DTOKarte> getDTOKarten() {
        return DTOKarten;
    }

    public void setDTOKarten(List<DTOKarte> DTOKarten) {
        this.DTOKarten = DTOKarten;
    }


}
