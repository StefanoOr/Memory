/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv2.memory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Paolo
 */
public class PaneMemory extends JPanel implements MouseListener {

    Mappa mappa;
    Timer tempo;

    public PaneMemory() {
        iniziaGioco();

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        mappa.draw(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        boolean c = true;
        long timer = System.currentTimeMillis();
        System.out.println(e.getPoint());

        int x = e.getX() / mappa.dimensione.width;
        int y = e.getY() / mappa.dimensione.height;
        if (mappa.caselle[y][x].getVisible()) {
            if (mappa.caselle[y][x].cliccabile) {
                mappa.caselle[y][x].setCliccabile(false);

                repaint();

                if (mappa.memoriaCarta == null) {
                    mappa.memoriaCarta = mappa.caselle[y][x];

                } else if (mappa.caselle[y][x].img == mappa.memoriaCarta.img) {

                    mappa.caselle[y][x].setVisible(false);
                    mappa.memoriaCarta.setVisible(false);

                    mappa.memoriaCarta = null;
                    System.out.println("uguale");

                } else {
                    System.out.println("diverso");
                    tempo = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mappa.caselle[y][x].setCliccabile(true);
                            mappa.memoriaCarta.setCliccabile(true);
                            mappa.memoriaCarta = null;
                            repaint();
                            tempo.stop();
                        }
                    });
                    tempo.start();

                }
            } else {
                System.out.println("carta gia cliccata");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void iniziaGioco() {
        mappa = new Mappa(4, 3);

    }

}
