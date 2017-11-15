import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;

/**
 *
 * @author NoEntiendo Members: Michael Iula, Jeremy Peacock, Daniel Gauthier, Michael Tyler, Cassie Archetto, Jesus Lopez
 */

public class BoardPanel extends JPanel implements MouseListener
{
    //The Game
    /*
    private int lastX, lastY; // To keep the mouse location
    private DrawableGame theDrawableGame;
    private BoardSpaces spaces;
    private Player player;
    //*/
    int theX;
    DrawableButton startButton = new DrawableButton(theX + 1000, 590,  "Start");
    DrawableButton easyButton = new DrawableButton(theX + 550, 110,-10, "Easy");
    DrawableButton mediumButton = new DrawableButton(theX + 550, 160,-10, "Medium");
    DrawableButton hardButton = new DrawableButton(theX + 550, 210, -10,"Hard");
    DrawableButton characterOneButton = new DrawableButton(theX + 110, 110, "Johnny G");
    DrawableButton characterTwoButton = new DrawableButton(theX + 110, 160, 30, "Patricia Maximum");
    DrawableButton characterThreeButton = new DrawableButton(theX + 110, 210, "Brad Brown");
    DrawableButton characterFourButton = new DrawableButton(theX + 110, 260, 20, "Manny Pianomouth");
    DrawableButton loadButton = new DrawableButton(theX + 950, 300, 35, "Load Previous Game");
    
    static String INCPOINTS = "You’ve landed on a *POINTS* space. You gained 5 point.";
    static String DECPOINTS = "Oh no! You’ve landed on a *DEDUCTION*  space. You lose 5 points.";
    static String MATCH = "In this mini-game, you will be trying to find the matches in the flipped over cards on the screen."
      + "If you click on two different cards and pictures under the cards are the exact same, you have found a match and earn a point."
      + "If the pictures do not match, the cards will flip back over. The mini-game will end when the timer stops."
      + "The number of points earned will be added to the overall score.";
    static String PONG = " ";
    static String DODGER = "This is a single player game. In this mini-game, objects will fall from the top of the screen to the bottom."
      + "You will have to avoid being hit by the fallen objects. The timer will give you *30* seconds to dodge as many objects as you can."
      + "When the timer ends, you will earn *2* points per object dodged.";
    static String RHYTHM = " ";
    
    //The current displayed screen
    private int scene;
    //The bot
    private DrawableIntro theIntro;
    //
    //private DrawableGame theGame;
    //Student to be used
    private DrawablePlayer thePlayer;
    //The bot
    private DrawablePlayer theBot;
    //The location
    private int thePlace;
    //Font variable
    private final Font myFont;
    //Button to throw the heaviest button
    //private final JButton addOneToSpace;
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
    //
    private Settings theSettings;
    BoardPanel()
    {
        theX = 0;
        //Set the scene to intro screen
        //scene 0 = intro screen
        //scene 1 = board
        //scene 2 = etc
        scene = 0;
        //The intro screen
        theIntro = new DrawableIntro();
        //The board
        //theGame = new DrawableGame();
        //The game settings
        theSettings = new Settings();
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
        
        addMouseListener(this); 
        
    }
    
    @Override
    public void paintComponent(Graphics pen)
    {
        
        //Paint over because Windows
        super.paintComponent(pen);
        switch (scene) {
            case 0:
                theIntro.draw(pen);
                //theButtons();//Start Button
                startButton.draw(pen);
                //Load button
                loadButton.draw(pen);
                //Levels Buttons
                easyButton.draw(pen);
                mediumButton.draw(pen);
                hardButton.draw(pen);
                //Player buttons
                characterOneButton.draw(pen);
                characterTwoButton.draw(pen);
                characterThreeButton.draw(pen);
                characterFourButton.draw(pen);
                break;
            case 1:
                
                break;
            case 2:
                //theDrawableGame.draw(pen);
                //Draw the player
                thePlayer.draw(pen);
                //Game going
                gamePlay = true;
                theBot.draw(pen);
                
                //After game play update player location
                //theBot.moveTo(playerLocaton(theBot));
                break;
            default:
                break;
        }
        
        
    }
    
    public void playGame() throws InterruptedException
    {
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

    @Override
    public void mouseClicked(MouseEvent mouseClick) {
        /*
            loadButton.draw(pen);
            //Levels Buttons
            easyButton.draw(pen);
            mediumButton.draw(pen);
            hardButton.draw(pen);
            //Player buttons
            characterOneButton.draw(pen);
            characterTwoButton.draw(pen);
            characterThreeButton.draw(pen);
            characterFourButton.draw(pen);*/
        //Set the mouse location as the point
        Point mouseLocation = mouseClick.getPoint();
        //More buttons
        if(startButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            scene = 2;
        }
        else if(loadButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            //scene = 1;
        }
        //The difficulty
        else if(easyButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setDifficulty(0);
        }
        else if(mediumButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setDifficulty(1);
        }
        else if(hardButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setDifficulty(2);
        }
        //Character buttons
        else if(characterOneButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setPlayerChoice(1);
            scene = 1;
        }
        else if(characterTwoButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setPlayerChoice(2);
        }
        else if(characterThreeButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setPlayerChoice(3);
        }
        else if(characterFourButton.isInside(mouseLocation.x, mouseLocation.y))
        {
            theSettings.setPlayerChoice(4);
        }
        this.repaint(); 
    }

    @Override
    public void mousePressed(MouseEvent mouseClick) {
     //          
    }

    @Override
    public void mouseReleased(MouseEvent mouseClick) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent mouseClick) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent mouseClick) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
