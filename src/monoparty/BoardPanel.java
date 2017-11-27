import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NoEntiendo Members: Michael Iula, Jeremy Peacock, Daniel Gauthier, Michael Tyler, Cassie Archetto, Jesus Lopez
 */

public class BoardPanel extends JPanel implements MouseListener
{
    //The Game
    private boolean playersturn;
    private int lastX, lastY; // To keep the mouse location
    private final DrawableGame theDrawableGame;
    private BoardSpaces spaceLocations;
    
    
    //Change all drawable object X location with one variable
    int theX;
    //All buttons
    private final DrawableButton startButton = new DrawableButton(theX + 1000, 590,  "Start");
    private final DrawableButton easyButton = new DrawableButton(theX + 530, 110,-10, "Easy");
    private final DrawableButton mediumButton = new DrawableButton(theX + 530, 160,-10, "Medium");
    private final DrawableButton hardButton = new DrawableButton(theX + 530, 210, -10,"Hard");
    private final DrawableButton characterOneButton = new DrawableButton(theX + 120, 110, "Johnny G");
    private final DrawableButton characterTwoButton = new DrawableButton(theX + 120, 160, 30, "Patricia Maximum");
    private final DrawableButton characterThreeButton = new DrawableButton(theX + 120, 210, "Brad Brown");
    private final DrawableButton characterFourButton = new DrawableButton(theX + 120, 260, 20, "Manny Pianomouth");
    private final DrawableButton loadButton = new DrawableButton(theX + 975, 300, 35, "Load Previous Game");
    
    //Game Buttons
    
    //Fonts 
    private final Font headings = new Font("Times New Roman",Font.PLAIN,28);
    private final Font text = new Font("Times New Roman",Font.PLAIN,16);
    private final Color primaryColor = new Color(85,140,137);
    private final Color textColor = new Color(64,64,64);
    private final Color secondaryColor = new Color(116,175,173);
    private final Color accentColor = new Color(217,133,59);
    private final Color whitePoint = new Color(236,236,234);

    //Game dialoge
    private final String[] DIFFICULTY = new String[] { 
        "",
        "Easy",
        "Medium",
        "Hard"
    };
    private final String[] DESCRIPTIONS = new String[] {"",
        "Johnny lives a life on the computer.  If it’s \n"
        + "not posted on social media did it even \n"
        + "happen?  While all of his profile pictures \n"
        + "look staged, he would never admit it.",
        
        "Patricia lives a busy life.  Whether she \n"
        + "is leading the office meeting or picking up \n"
        + "her kids from their soccer practice, her \n"
        + "kindness is infectious.  Her only negative \n"
        + "is her “may I speak to the manager” haircut.",
        
        "Brad is a full time baseball coach.  If he \n"
        + "could describe himself in five words they \n"
        + "would be: Sarcastic, Political, Narcissistic, \n"
        + "Poignant, and Extroverted.",

        "Everybody loves Manny.  His daily job is a \n"
        + "boat captain, but he still has dreams of \n"
        + "becoming a pilot. Not the most athletic \n"
        + "person in the world."};;
    
    
   
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
    static String INTRO = "You and the computer will go around the board *10* times, and whoever has the most points at the end will win the game.\n" +
"                                                            Start the game by rolling the dice.  GOOD LUCK!";
    static String RHYTHM = " ";
    
    //The current displayed screen
    private int scene;
    //The bot
    private DrawableIntro theIntro;
    //private DrawableGame theGame;
    //Student to be used
    private DrawablePlayer thePlayer;
    //The bot
    private DrawablePlayer theBot;
    //The die object
    private DrawableDie theDice; 
    //The location
    private int thePlace;
    //Font variable
    private final Font myFont;
    //If the game is playing
    private boolean gamePlay = true;
    //create a settings object
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
        theDrawableGame = new DrawableGame();
        //The Die
        theDice = new DrawableDie(900,110);
        //The game settings
        theSettings = new Settings();
        //The player
        thePlayer = new DrawablePlayer(30,15, Color.GREEN);
        //Player Velocity
        thePlayer.setVelocity(1, 0);
        //
        playersturn = true;
        //The computer player
        theBot = new DrawablePlayer(70,15,Color.RED);
        myFont = new Font("Times New Roman",Font.PLAIN,28);
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
                pen.setColor(textColor);
                drawString(pen,DESCRIPTIONS[theSettings.getPlayerChoice()], 116, 320);
                pen.setFont(headings);
                drawString(pen,DIFFICULTY[theSettings.getDifficulty()], 600, 320);
                break;
            case 1:
                break;
            case 2:
                theDrawableGame.draw(pen);
                //Draw the player
                thePlayer.draw(pen);
                //Game going
                gamePlay = true;
                theBot.draw(pen);
                theDice.draw(pen);
                pen.setColor(whitePoint);
                pen.drawString("Player Score: " + theSettings.getPlayerPoints(), 600, 180);
                pen.drawString("Bot Score: " + theSettings.getBotPoints(), 600, 200);
                pen.drawString("Remaining Rounds: " + theSettings.getRound(), 600, 220);
                pen.setColor(textColor);
                //Pause
                if (!playersturn)
                {
                    theDice.shuffle();
                    theSettings.addBotSpace(theDice.getNumber());
                    thePlayer.moveTo(theSettings.getPlayerPointLocation());
                    theBot.moveTo(theSettings.getBotPointLocation());
                    playersturn = true;
                    this.repaint();
                }
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
            //thePlayer.move();
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

    //https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring
    void drawString(Graphics g, String text, int x, int y) {
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
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
        if (scene == 0)
        {
            if(startButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                scene = 2;
                thePlayer.moveTo(theSettings.getPlayerPointLocation());
                theBot.moveTo(theSettings.getBotPointLocation());
                JOptionPane.showMessageDialog(null, INTRO);
            }
            else if(loadButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setSaveCode(JOptionPane.showInputDialog(null, "Progress Code:"));
            }
            //The difficulty
            else if(easyButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setDifficulty(1);
            }
            else if(mediumButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setDifficulty(2);
            }
            else if(hardButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setDifficulty(3);
            }
            //Character buttons
            else if(characterOneButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(1);
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
        }
        else if (scene == 2)
    {
        if (playersturn)
        {
            //Check if the the is clicked
            if(theDice.isInside(mouseLocation.x, mouseLocation.y))
            {
                theDice.shuffle();
                theSettings.setRound(theSettings.getRound() - 1);
                playersturn = false;
                //theSettings.addPlayerSpace(1);
                //theSettings.addBotSpace(1);
                theSettings.addPlayerSpace(theDice.getNumber());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                thePlayer.moveTo(theSettings.getPlayerPointLocation());
                theBot.moveTo(theSettings.getBotPointLocation());
            }
        }
        
        
    }
        this.repaint(); 
        
    }

    @Override
    public void mousePressed(MouseEvent mouseClick) {
     //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
