/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv2.memory;

import javax.swing.JFrame;

/**
 *
 * @author Paolo
 */
public class Memory {
    PaneMemory pane= new PaneMemory();

    public Memory() {
    JFrame frame= new JFrame();
    frame.setContentPane(pane);
    frame.addMouseListener(pane);
    frame.setSize(600,600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
    
    public static void main(String[] args) {
        Memory gioco=new Memory();
        
    }
}
