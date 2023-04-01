/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv1.grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import memoryv1.console.CasellaMemory;
import memoryv1.console.MappaMemory;

/**
 *
 * @author Paolo
 */
public class MemoryGrafico {

    MappaMemory mappa;
    private JFrame frame;

    public JPanel main1 = new JPanel();
    public JPanel panelloMappa;
    JLabel player = new JLabel();
   

    public MemoryGrafico() {
        init();
    }

    private void init() {

        frame = new JFrame("Muori");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setAlwaysOnTop(true);

        JMenuBar menu = new JMenuBar();
        

        JMenu file = new JMenu("File");

        file.add(new JMenuItem(new AbstractAction("Ricomincia") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));
        menu.add(file);
        frame.setJMenuBar(menu);

        frame.setContentPane(main1);
        nuovaPartita();

    }

    public void nuovaPartita() {
        int righeNuovaMappa = 4;
        int colonneNuovaMappa = 4;

        if (mappa != null) {
            //usa i valori della mappa esistente(ad esempio il reset)
            righeNuovaMappa = mappa.righe;
            colonneNuovaMappa = mappa.colonne;
        }

        setMappa(new MappaMemory(righeNuovaMappa, colonneNuovaMappa));
        getMappa().stampaMappa(
                true);
        panelloMappa = new JPanel(new GridLayout(righeNuovaMappa, colonneNuovaMappa));

        main1.add(panelloMappa, BorderLayout.CENTER);

        for (int riga = 0; riga < righeNuovaMappa; riga++) {
            for (int colonna = 0; colonna < colonneNuovaMappa; colonna++) {
                panelloMappa.add(new BottoneCasella(getMappa().getCasella(riga, colonna), this));
            }
        }
        main1.revalidate();
    }

    public void start() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MemoryGrafico gioco = new MemoryGrafico();
        gioco.start();
    }

    public void setMappa(MappaMemory mappa) {
        this.mappa = mappa;
    }

    public MappaMemory getMappa() {
        return mappa;
    }

    public JFrame getFrame() {
        return frame;
    }

}
