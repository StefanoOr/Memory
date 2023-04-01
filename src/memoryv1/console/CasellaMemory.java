/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv1.console;

import memoryv1.grafico.BottoneCasella;

/**
 *
 * @author Paolo
 */
public class CasellaMemory {

    MappaMemory mappa;
    final int riga;
    final int colonna;
    public boolean contiene;
    public int contenuto;
    public boolean inGioco=true;
    public BottoneCasella bottone;
    public boolean isVisible;

    public int getContenuto() {
        return contenuto;
    }

    public CasellaMemory(MappaMemory mappa, int riga, int colonna) {
        this.mappa = mappa;
        this.riga = riga;
        this.colonna = colonna;
    }
 
    public String getTextPosizione(){
        
        return "("+riga+", "+colonna+", contenuto="+getContenuto()+")";
    }
    
    public void setVisible() {
        isVisible = true;

    }

    public void setNotVisible() {
        isVisible = false;
    }

    @Override
    public String toString() {
        if (!inGioco) {
            return " ";
        } else {
            if (!isVisible) {
                return "X";
            } else {
                return "" + contenuto;
            }
        }
    }

    public boolean contieneNumero() {

        if (contiene) {
            return true;
        } else {

            return false;
        }

    }

}
