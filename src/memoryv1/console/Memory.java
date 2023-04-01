/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryv1.console;

import memoryv1.console.MappaMemory;
import memoryv1.console.CasellaMemory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * fase 1
 *
 * @author Paolo
 */
public class Memory {

    public int r = 4;
    public int c = 4;
    public int i = 0;
    MappaMemory mappa;
    CasellaMemory casellainMemoria;

    /**
     * @param args the command line arguments
     *
     */
    public void start() throws IOException {
        mappa = new MappaMemory(r, c);
        mappa.stampaMappa();
        CasellaMemory casellaInput;

        while (true) {
            casellaInput = chiediInput();

            processaInput(casellaInput);
            mappa.stampaMappa();

        }
    }

    public void processaInput(CasellaMemory casella) {
        casella.setVisible();
        if (casellainMemoria == null) {
            System.out.println("null");
            casellainMemoria = casella;

        } else if (casella.getContenuto() == casellainMemoria.getContenuto()) {
            System.out.println("controllo true");

            casella.setVisible();
            casella.inGioco = true;
            casellainMemoria.inGioco = true;
            casellainMemoria = null;

        } else {
            
            
            System.out.println("controllo false");
            casella.setNotVisible();
            casellainMemoria.setNotVisible();
            casellainMemoria = null;

        }

    }

    public static void main(String[] args) throws IOException {
        Memory gioco = new Memory();
        gioco.start();
    }

    private CasellaMemory chiediInput() throws IOException {
//ritorna la  casella  della mappa   alla posizione  decisa dal giocatore.... bich fanculo il sistema
        InputStreamReader ncp = new InputStreamReader(System.in);
        BufferedReader brr = new BufferedReader(ncp);

        System.out.print("Inserisci la riga :");
        String input = brr.readLine();
        Integer rigainput = convertInt(input);

        System.out.print("Inserisci la colonna :");
        input = brr.readLine();
        Integer colonnainput = convertInt(input);

        if (rigainput == null || colonnainput == null) {
            System.out.println("Inserisci un numero");
            return chiediInput();

        }

        if (rigainput < 0 || colonnainput < 0 || rigainput > r - 1 || colonnainput > c - 1) {

            return chiediInput();
        } else {

            System.out.println("Inserisci un numero");
            return mappa.caselle[rigainput][colonnainput];

        }

    }

    public static Integer convertInt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (Exception e) {
            return null;
        }
    }

}
