/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv2.memory;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author Paolo
 */
public class Mappa {

    public final cartaMemory[][] caselle;
     public cartaMemory memoriaCarta;
    public final int righe;
    public final int colonne;
    public final Dimension dimensione = new Dimension(156, 213);
    CaricatoreImg caricatore;
    BufferedImage[] img;
    
  

    public Mappa(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        caselle = new cartaMemory[righe][colonne];
        caricaImg();
        popolaCaselle();

    }

    private void popolaCaselle() {
        int contatore = 1;
        int contatoreDelContatore = 0;
        int r;
        int c;

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.println("ciao");
                caselle[i][j]=new cartaMemory(i, j, dimensione,img[0]);
                
                System.out.println("ciao1");
            }

        }
        while (righe * colonne / 2+1 > contatore) {
            r = numberRandom(0, righe);
            c = numberRandom(0, colonne);
            if (caselle[r][c].img == null) {
                caselle[r][c].img = img[contatore];
                contatoreDelContatore++;
                if (contatoreDelContatore == 2) {
                    contatoreDelContatore = 0;
                    contatore++;
                }

            }

        }

    }

    public void draw(Graphics g) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                caselle[i][j].draw(g);
            }

        }

    }

    private void caricaImg() {
        img = new BufferedImage[7];
        caricatore = new CaricatoreImg();
        img[0]=caricatore.loadImg("/img/Card.png");
        img[1] = caricatore.loadImg("/img/CardIgnoto_1.png");
        img[2] = caricatore.loadImg("/img/CardLore.png");
        img[3] = caricatore.loadImg("/img/CardStefano.png");
        img[4] = caricatore.loadImg("/img/CardS.png");
        img[5] = caricatore.loadImg("/img/CardB.png");
        img[6]=caricatore.loadImg("/img/CardNicolas.png");
        
    }

    private int numberRandom(int min, int max) {

        int numeroRandom = (int) (Math.random() * (max - min));

        return numeroRandom;
    }
}
