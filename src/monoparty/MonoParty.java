/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.FileInputStream;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
//import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;

/**
 *  
 * @author NoEntiendo Members: Michael Iula, Jeremy Peacock, Daniel Gauthier, Michael Tyler, Cassie Archetto, Jesus Lopez
 */
public class MonoParty {
    //Sets window size
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;

    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
public static void main(String[] args) throws InterruptedException, IOException
    {
        JFrame introWindow = new JFrame(); //Create window
        introWindow.setSize(1280, 720); // width x height 
        introWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close action
        introWindow.setTitle("MonoParty"); //Title
        // This is the panel for this Lab
        BoardPanel introPanel = new BoardPanel();
        JFrame projectWindow = new JFrame(); //Create window
        projectWindow.setSize(1284, 760); // width x height 
        projectWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close action
        projectWindow.setTitle("MonoParty"); //Title
        // This is the panel for this Lab
        BoardPanel playPanel = new BoardPanel(); 
        //Add the pannel
        projectWindow.add(playPanel); 
        
        //Make the window visable
        projectWindow.setVisible(true); 
        projectWindow.setResizable(false);
        // open the sound file as a Java input stream
        String sound = "C:\\Users\\danoe\\Documents\\NetBeansProjects\\MonoParty\\src\\monoParty.wav";
    
        InputStream in = new FileInputStream(sound);

        // create an audiostream from the inputstream
        AudioStream audioStream;
        audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}
