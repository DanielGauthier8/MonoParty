

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

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
    //Font variable
    private final Font myFont;
    //Button to throw the heaviest button
    private final JButton addOneToSpace;
    DrawingPanel()
    {
    //The player
        thePlayer = new DrawablePlayer(100,100, Color.GREEN);
        //The computer player
        theBot = new DrawablePlayer(200,100,Color.RED);
        myFont = new Font("Times New Roman",Font.PLAIN,28);
        //Buttons
        //Testing adding to player location
        addOneToSpace = new JButton("Add");
    }
    
    @Override
    public void paintComponent(Graphics pen)
    {
        
        //Paint over because Windows
        super.paintComponent(pen);
        //Draw the player
        thePlayer.draw(pen);
        //The bot
        //theBot.draw(pen);
        pen.setColor(Color.BLACK);
        pen.setFont(myFont);
        pen.drawString("MonoParty", 360, 450);
        //After game play update player location
        //theBot.moveTo(playerLocaton(theBot));
    }
    
    public void playGame() throws InterruptedException
    {
        theButtons();
    }
    
    private Point playerLocaton(DrawablePlayer thatPlayer)
    {
        Point thePoint = new Point();
        thePlace = thatPlayer.getPlace();
        if(thePlace >= 10)
        {
            thePoint.x = (thePlace*100) + 100;
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
    //Listen for clicks
    private class ButtonListener implements ActionListener
        {
            //When a button is clicked the command is put in this method
            @Override
            public void actionPerformed(ActionEvent buttonClick) 
            {
                //Put the command in a String
                String command = buttonClick.getActionCommand();
                //See if the button 1 was clicked and has books in it
                if(command.equals("Add"))
                {
                    thePlayer.changeScoreBy(1);
                    thePlayer.moveTo(playerLocaton(thePlayer));
                }
                //Draw the book according to what is being clicked on
                repaint();
            }
        }
    private void theButtons()
    {
        //Use the button listener object
        ButtonListener listener = new ButtonListener();
        //Give the value of the button to be sent to method
        addOneToSpace.setActionCommand("Add");
        //Listen for the click
        addOneToSpace.addActionListener(listener);
        //Draw the button
        add(addOneToSpace);
    }
}
