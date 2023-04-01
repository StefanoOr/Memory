/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv1.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import memoryv1.console.CasellaMemory;

/**
 *
 * @author Paolo
 */
public class BottoneCasella extends JButton {
   static boolean casellaCliccabile=true;
    static CasellaMemory casellaInMemoria;
    CasellaMemory casella;
    
    MemoryGrafico campo;
    Timer tempo;

    public BottoneCasella(CasellaMemory casella, MemoryGrafico campo) {
        super();
        this.campo = campo;
        this.casella = casella;
//
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(casellaCliccabile){
                casella.setVisible();
                System.out.println("Reso visibile casella " + casella.getTextPosizione());

                if (casellaInMemoria == null) {

                    casellaInMemoria = casella;
                    casellaInMemoria.bottone = BottoneCasella.this;

                    System.out.println("impostato CasellaMemoria " + casellaInMemoria.getTextPosizione());

                } else if (casella.getContenuto() == casellaInMemoria.getContenuto()) {
                  
                    System.out.println("contenuto uguale casellaMemoria, " + casella.getTextPosizione() + " vs " + casellaInMemoria.getTextPosizione());

                    casella.inGioco = false;
                    casellaInMemoria.inGioco = false;
                    casellaInMemoria.bottone.repaint();
                    casellaInMemoria = null;
                    casellaCliccabile=true;

                } else {

                    System.out.println("contenuto  diverso casellaMemoria, " + casella.getTextPosizione() + " vs " + casellaInMemoria.getTextPosizione());
                    tempo = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            casella.setNotVisible();
                            casellaInMemoria.setNotVisible();
                            casellaInMemoria.bottone.repaint();
                            casellaInMemoria = null;

                            System.out.println("action finita");
                            repaint();
                            casellaCliccabile=true;
                            tempo.stop();
                            

                        }
                    });

                    tempo.start();
                    casellaCliccabile=false;
                }
                System.out.println("action finita");
            }
        }
        }
        );
    }

    @Override
    public String getText() {

        if (casella == null) {
            return "";
        }
        return casella.toString();
    }

}
