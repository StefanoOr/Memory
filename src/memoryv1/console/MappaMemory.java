/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv1.console;

import java.awt.image.BufferedImage;
import memoryv1.console.CasellaMemory;
import javax.swing.ImageIcon;

/**
 *
 * @author Paolo
 */
public class MappaMemory {

    final CasellaMemory[][] caselle;
    public final int righe;
    public final int colonne;
  
    
    public CasellaMemory casellaInMemoria;

    public MappaMemory(int righe, int colonne) {
        this.colonne = colonne;
        this.righe = righe;
        caselle = new CasellaMemory[righe][colonne];
        popolaCampo();
    }

    public void stampaMappa() {
        stampaMappa(false);
    }

    public void stampaMappa(boolean vedi) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {

                System.out.print(caselle[i][j] + " ");

            }
            System.out.println("");
        }
    }

    private void popolaCampo() {

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                caselle[i][j] = new CasellaMemory(this, i, j);

            }
        }
        int i = 1;
        int contatore = 0;
        int c=0;
        System.out.println("prpp");
        while (i < righe*colonne/2) {
              c++;
            if (contatore == 2) {
                i++;
                contatore = 0;
            }

            CasellaMemory casella = caselle[numberRandom(0, righe)][numberRandom(0, colonne)];
            if (!casella.contieneNumero()) {
                casella.contenuto = i;
                casella.contiene = true;
                System.out.println(casella.contiene + "+" + casella.contenuto);
                contatore++;
            }
        }
        System.out.println(c);
    }

    public static int numberRandom(int min, int max) {

        int numeroRandom = (int) (Math.random() * (max - min));

        return numeroRandom;
    }

    public CasellaMemory getCasella(int riga, int colonna) {
        return caselle[riga][colonna];
    }
}
