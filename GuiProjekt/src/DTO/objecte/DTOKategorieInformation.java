/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

import java.math.BigDecimal;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class DTOKategorieInformation {
  private int id;
  private String name;
  private  BigDecimal preis;
  int freieplätze;
  int ermaessigung;

    public DTOKategorieInformation(int id, String name, BigDecimal preis, int freieplätze, int ermaessigung) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.freieplätze = freieplätze;
        this.ermaessigung = ermaessigung;
    }

    public int getFreieplätze() {
        return freieplätze;
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public int getErmaessigung() {
        return ermaessigung;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public void setFreieplätze(int freieplätze) {
        this.freieplätze = freieplätze;
    }

    
    public void setErmaessigung(int ermaessigung) {
        this.ermaessigung = ermaessigung;
    }

  
  
}
