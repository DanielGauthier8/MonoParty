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
     * @throws java.lang.InterruptedException
     */
public static void main(String[] args) throws InterruptedException
    {
        JFrame introWindow = new JFrame(); //Create window
        introWindow.setSize(1280, 720); // width x height 
        introWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close action
        introWindow.setTitle("MonoParty"); //Title
        // This is the panel for this Lab
        BoardPanel introPanel = new BoardPanel(); 
        //Add the pannel
        introWindow.add(introPanel); 
        
        //Make the window visable
        introWindow.setVisible(true); 
        
        
        JFrame projectWindow = new JFrame(); //Create window
        projectWindow.setSize(1280, 720); // width x height 
        projectWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close action
        projectWindow.setTitle("MonoParty"); //Title
        // This is the panel for this Lab
        BoardPanel playPanel = new BoardPanel(); 
        //Add the pannel
        projectWindow.add(playPanel); 
        
        //Make the window visable
        projectWindow.setVisible(true); 
        playPanel.playGame();
    }
}
