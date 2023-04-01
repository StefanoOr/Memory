package memoryv2.memory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Paolo
 */
public class CaricatoreImg {
    BufferedImage img;
     
    public BufferedImage loadImg(String file){
        try {
            System.out.println("load");
            img=ImageIO.read(getClass().getResource(file));
            
            
        } catch (IOException ex) {
            System.out.println("errore load img");

        }
        
        return img;
    }
    
   
    
}
