

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author NoEntiendo Members: Michael Iula, Jeremy Peacock, Daniel Gauthier, Michael Tyler, Cassie Archetto, Jesus Lopez
 */

public class DrawingPanel extends JPanel{
    //Student to be used
    private DrawablePlayer thePlayer;
    //The bot
    private DrawablePlayer theBot;
    //The location
    private int thePlace;
    DrawingPanel()
    {
    //The player
        thePlayer = new DrawablePlayer(100,100, Color.GREEN);
        //The computer player
        theBot = new DrawablePlayer(200,100,Color.RED);
    }
    
    @Override
    public void paintComponent(Graphics pen)
    {
        //Draw the player
        thePlayer.draw(pen);
        //The bot
        theBot.draw(pen);
        
        
        
        
        //After game play update player location
        thePlayer.moveTo(playerLocaton(thePlayer));
        theBot.moveTo(playerLocaton(theBot));
    }
    
    private Point playerLocaton(DrawablePlayer thatPlayer)
    {
        Point thePoint = new Point();
        thePlace = thatPlayer.getPlace();
        if(thePlace >= 10)
        {
            thePoint.x = thePlace + 10;
            thePoint.y = 100; 
        }
        else if(thePlace >= 20)
        {
            thePoint.x = thePlace;
            thePoint.y = 1000;  
        }
        if(thePlace >= 30)
        {
            thePoint.x = thePlace;
            thePoint.y = thePlace;
        }
        else
        {
            thePoint.x = thePlace;
            thePoint.y = thePlace; 
        }
        return thePoint;
    }
}
