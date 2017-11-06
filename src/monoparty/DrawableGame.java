
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DrawableGame extends Game implements DrawableInterface{

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveTo(int absX, int absY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveBy(int dX, int dY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVelocityX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVelocityY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVelocity(double dvX, double dvY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(Color theColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics pen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
/*


import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JButton;
//import javax.swing.JLabel;

/**
 *
 * @author NoEntiendo Members: Michael Iula, Jeremy Peacock, Daniel Gauthier, Michael Tyler, Cassie Archetto, Jesus Lopez
 */
/*
public class DrawingIt extends JPanel{
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
    //The current row of the the player(0-3)
    private int playerRow;
    //The current row of the bot (0-3)
    private int botRow;
    //The current spot of the the player(0-8)
    private int playerSport;
    //The current spot of the bot (0-8)
    private int botSpot;
    //If the game is playing
    private boolean gamePlay = true;
    //array of x postions
    private int[] xPositions;
    //array of y positons
    private int[] yPositions;
    private final int spaceSize = 20;
    DrawingIt()
    {
        //The player
        thePlayer = new DrawablePlayer(100,100, Color.GREEN);
        //Player Velocity
        thePlayer.setVelocity(1, 0);
        //The computer player
        theBot = new DrawablePlayer(200,100,Color.RED);
        myFont = new Font("Times New Roman",Font.PLAIN,28);
        //The posible y positions
        xPositions = new int[36]; 
        //The possible xPositions
        yPositions = new int[36];
        //First row
        for (int i = 0; i < 9; i++)
        {
        xPositions[i] = 10;
        yPositions[i] = i * 20;
        }
        //second row
        for (int i = 10; i < 8; i++)
        {
        xPositions[i] = 10;
        yPositions[i] = i * 20;
        }
        //third row
        for (int i = 19; i < 26; i++)
        {
        xPositions[i] = 10;
        yPositions[i] = 10;
        }
        //fourth row
        for (int i = 27; i < 36; i++)
        {
        xPositions[i] = 10;
        yPositions[i] = i * 20;
        }
        //Buttons
        //Testing adding to player location;
        addOneToSpace = new JButton("Add");
    }
    
    @Override
    public void paintComponent(Graphics pen)
    {
        //Paint over because Windows
        super.paintComponent(pen);
        //Draw the player
        thePlayer.draw(pen);
        //Game going
        gamePlay = true;
        //theBot.draw(pen);
        pen.setColor(Color.BLACK);
        pen.setFont(myFont);
        pen.drawString("Welcome to MonoParty", 360, 450);
        //After game play update player location
        //theBot.moveTo(playerLocaton(theBot));
    }
    
    public void playGame() throws InterruptedException
    {
        theButtons();
        //Create a timer
        int timer = 0;
        //Get local time
        LocalDateTime time = LocalDateTime.now();
        //Get the second of the local time
        int sec = time.getSecond();
        
        //While the timer is less than 1
        while(timer < 2)
        {
            //move the object
            thePlayer.move();
            //get the time again
            time = LocalDateTime.now();
            //paint the scene again
            repaint();
            //System.out.print(myBall.toString());
            //If the seconds don't match, time must have been a second
            if(time.getSecond() != sec)
            {
               //Increment the timer
               timer++;
            }
            //Set the sec to the new "current" second
            sec = time.getSecond();
            //Sleep to slow the animation down a bit
            Thread.sleep(10);
        }
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
*/
