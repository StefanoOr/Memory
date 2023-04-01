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
 * // * @author Paolo
 */
class cartaMemory {

    public int riga;
    public int colonna;
    Dimension dimensione;
     public boolean cliccabile=true;
     private boolean visible=true;
    public BufferedImage img;
    private BufferedImage imgCoperta;

    public cartaMemory(int riga, int colonna, Dimension dimensione, BufferedImage img) {
        this.riga = riga;
        this.colonna = colonna;
        this.dimensione = dimensione;
        this.imgCoperta = img;
        this.img = null;

    }

    void draw(Graphics g) {
        if(visible){
        if (cliccabile) {
            g.drawImage(imgCoperta, colonna * dimensione.width+5, riga * dimensione.height, null);
        } else {
            g.drawImage(img, colonna * dimensione.width+5, riga * dimensione.height, null);
        }
    }else{
            
        }
    }
    public void setCliccabile(boolean click) {
        cliccabile = click;
    }

    public boolean getCliccabile() {
        return cliccabile;
    }

    void setVisible(boolean b) {
       visible=b;
    }
    boolean getVisible(){
        return visible;
    }
}
