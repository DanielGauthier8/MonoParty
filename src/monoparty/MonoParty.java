/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;

/**
 *  
 * @author NoEntiendo Members: Michael Iula, Jeremy Peacock, Daniel Gauthier, Michael Tyler, Cassie Archetto, Jesus Lopez
 */
public class MonoParty {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws InterruptedException
    {
        JFrame projectWindow = new JFrame(); //Create window
        projectWindow.setSize(1024, 800); // width x height 
        projectWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close action
        projectWindow.setTitle("MonoParty"); //Title
        // This is the panel for this Lab
        DrawingPanel playPanel = new DrawingPanel(); 
        //Add the pannel
        projectWindow.add(playPanel); 
        
        //Make the window visable
        projectWindow.setVisible(true); 
        playPanel.playGame();
    }
    
}
