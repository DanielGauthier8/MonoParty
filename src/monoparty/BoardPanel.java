import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

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
    
    private int randomNum;
    private String botMessage;
    private boolean botTurn = false;
    
    //Change all drawable object X location with one variable
    int theX;
    //All buttons
    private final DrawableButton startButton = new DrawableButton(theX + 1000, 590,  "Start");
    private final DrawableButton easyButton = new DrawableButton(theX + 530, 110,-10, "Easy");
    private final DrawableButton mediumButton = new DrawableButton(theX + 530, 160,-10, "Medium");
    private final DrawableButton hardButton = new DrawableButton(theX + 530, 210, -10,"Hard");
    private final DrawableButton characterOneButton = new DrawableButton(theX + 120, 110, "Johnny G");
    private final DrawableButton characterTwoButton = new DrawableButton(theX + 120, 160, 30, "Patricia Maximum");
    private final DrawableButton characterThreeButton = new DrawableButton(theX + 120, 210, "Brad Beans");
    private final DrawableButton characterFourButton = new DrawableButton(theX + 120, 260, 20, "Manny Pianomouth");
    private final DrawableButton loadButton = new DrawableButton(theX + 975, 300, 35, "Load Previous Game");
    //Game Buttons
    
    //Fonts 
    private final Font headings = new Font("Times New Roman",Font.PLAIN,28);
    private final Font text = new Font("Times New Roman",Font.PLAIN,16);
    private final Font otherText = new Font("Monospaced", Font.BOLD, 20);
    private final Color primaryColor = new Color(85,140,137);
    private final Color textColor = new Color(64,64,64);
    private final Color secondaryColor = new Color(116,175,173);
    private final Color accentColor = new Color(217,133,59);
    private final Color whitePoint = new Color(236,236,234);

    
   // static GameObject[] squareArray = new GameObject[30];
     public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
     long invulTimeStamp;
                long currentTime;

    //Game dialoge
    private final String[] DIFFICULTY = new String[] { 
        "",
        "Easy",
        "Medium",
        "Hard"
    };
    //Game dialoge
    private final String[] GOODBOTACTIONS = new String[] { 
        "Wow, the bot did well! You've got a good opponent.",
        "The briliant Monoparty AI has succeded.",
        "The bot is clearly a boss.",
        "Your opponent has all the cheat codes.",
        "The AI is becoming sentiant with this games knowledge.",
        "The bot is having a lucky day",
        "Someone had a good breakfast, the bot did amazing.",import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

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
    
    private int randomNum;
    private String botMessage;
    private boolean botTurn = false;
    
    //Change all drawable object X location with one variable
    int theX;
    //All buttons
    private final DrawableButton startButton = new DrawableButton(theX + 1000, 590,  "Start");
    private final DrawableButton easyButton = new DrawableButton(theX + 530, 110,-10, "Easy");
    private final DrawableButton mediumButton = new DrawableButton(theX + 530, 160,-10, "Medium");
    private final DrawableButton hardButton = new DrawableButton(theX + 530, 210, -10,"Hard");
    private final DrawableButton characterOneButton = new DrawableButton(theX + 120, 110, "Johnny G");
    private final DrawableButton characterTwoButton = new DrawableButton(theX + 120, 160, 30, "Patricia Maximum");
    private final DrawableButton characterThreeButton = new DrawableButton(theX + 120, 210, "Brad Beans");
    private final DrawableButton characterFourButton = new DrawableButton(theX + 120, 260, 20, "Manny Pianomouth");
    private final DrawableButton loadButton = new DrawableButton(theX + 975, 300, 35, "Load Previous Game");
    //Game Buttons
    
    //Fonts 
    private final Font headings = new Font("Times New Roman",Font.PLAIN,28);
    private final Font text = new Font("Times New Roman",Font.PLAIN,16);
    private final Font otherText = new Font("Monospaced", Font.BOLD, 20);
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
    //Game dialoge
    private final String[] GOODBOTACTIONS = new String[] { 
        "Wow, the bot did well! You've got a good opponent.",
        "The briliant Monoparty AI has succeded.",
        "The bot is clearly a boss.",
        "Your opponent has all the cheat codes.",
        "The AI is becoming sentiant with this games knowledge.",
        "The bot is having a lucky day",
        "Someone had a good breakfast, the bot did amazing.",
        "It's the bots lucky day.",
        "I am sorry to inform you this...",
        "The bot has been studying this game like crazy."
    };
    private final String[] BADBOTACTIONS = new String[] { 
        "The Bot fell asleep at the keyboard.",
        "Your opponent tripped and fell.",
        "Even a bot can be a n00b sometimes.",
        "The Bot was listening to music and forgot it was their turn.",
        "Your opponent had cookies in the oven and had to leave the computer.",
        "The bots glasses fell off mid turn.",
        "The other player is having some bad luck today.",
        "The AI has failed on the space.",
        "Using their all knowning powers, the AI still managed to fail.",
        "Internet was down and the bot couldn't find the answers",
        "The bot was caught cheating.",
        "Your opponent is stuck on the phone with there parent.",
        "The bot was stuck behind the pod bay door.",
        "You distracted the bot with your great skills."
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
    
    
   
    static String MATCH = "                                 In this mini-game, you will be trying to find the matches in the flipped over cards on the screen."
      + "\n           If you click on two different cards and pictures under the cards are the exact same, you have found a match and earn a point."
      + "\n                   If the pictures do not match, the cards will flip back over. The mini-game will end when the timer stops."
      + "\n                                       The number of points earned will be added to the overall score.";
    static String PONG = "Who doesn't like a good pong game.";
    static String DODGER = "                     This is a single player game. In this mini-game, objects will fall from the top of the screen to the bottom."
      + "\n     You will have to avoid being hit by the fallen objects. The timer will give you *30* seconds to dodge as many objects as you can."
      + "\n                                  When the timer ends, you will earn *2* points per object dodged.";
    static String INTRO = "You and the computer will go around the board *10* times, and whoever has the most points at the end will win the game.\n" +
"                                        Start the game by rolling the dice.  After your turn don't forget to roll the die for the bot.\n"
            + "                                                                                           GOOD LUCK!";
    static String RHYTHM = "Moving to that inner rythm.!";
    
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
    
    
    
    BoardPanel() throws FileNotFoundException, IOException
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
        thePlayer.setInitals("JG");
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
                theDrawableGame.draw(pen);
                //Draw the player
                thePlayer.draw(pen);
                //Game going
                gamePlay = true;
                theBot.draw(pen);
                theDice.draw(pen);
                pen.setColor(whitePoint);
                pen.setFont(otherText);
                pen.drawString("Player Score: " + theSettings.getPlayerPoints(), 600, 180);
                pen.drawString("Bot Score: " + theSettings.getBotPoints(), 600, 200);
                pen.drawString("Remaining Rounds: " + theSettings.getRound(), 600, 220);
                pen.setColor(textColor);
                break;
            case 2:
                pen.setFont(headings);
                if(theSettings.getBotPoints() <= theSettings.getPlayerPoints())
                {
                    pen.drawString("You Won!", 600, 240);
                    try{
                    // open the sound file as a Java input stream
                    String win_sound = "/Users/michaeliula/NetBeansProjects/MonoParty3/src/monoParty_Win.wav";
        
                    
                    InputStream in = new FileInputStream(win_sound);

                    // create an audiostream from the inputstream
                    AudioStream audioStream;
                    audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                       } catch (FileNotFoundException ex) {
                Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                else
                {
                    pen.drawString("You Lose!", 600, 240);
                    
                     try{
                    // open the sound file as a Java input stream
                    String lose_sound = "/Users/michaeliula/NetBeansProjects/MonoParty3/src/monoParty_Lose.wav";
        
                    
                    InputStream in = new FileInputStream(lose_sound);

                    // create an audiostream from the inputstream
                    AudioStream audioStream;
                    audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                       } catch (FileNotFoundException ex) {
                Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                pen.drawString("Player Score: " + theSettings.getPlayerPoints(), 600, 180);
                pen.drawString("Bot Score: " + theSettings.getBotPoints(), 600, 200);
                break;
            case 3:
            
            break;
            default:
                break;
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
                scene = 1;
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
                thePlayer.setInitals("JG");
                thePlayer.setColor(Color.GREEN);
            }
            else if(characterTwoButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(2);
                thePlayer.setInitals("PM");
                thePlayer.setColor(Color.BLUE);
            }
            else if(characterThreeButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(3);
                thePlayer.setInitals("BB");
                thePlayer.setColor(Color.GRAY);
            }
            else if(characterFourButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(4);
                thePlayer.setInitals("MP");
                thePlayer.setColor(Color.ORANGE);
            }
        }
        else if (scene == 1)
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
                    this.repaint();
                    thePlayer.moveTo(theSettings.getPlayerPointLocation());
                    //this.repaint();
                    //If odd then chance card
                    if((theSettings.getPlayerSpace()) % 2 != 0)
                    {
                        randomNum = (int) ((Math.ceil(Math.random() * 600)) - 300 + ((theSettings.getDifficulty()-3)*5));
                        if (randomNum >= 0)
                        {
                            botMessage = "You have landed on a chance space. You gained " + randomNum + " points.";
                        }
                        else
                        {
                            botMessage = "You have landed on a chance space. You lost " + randomNum + " points.";
                        }
                        theSettings.addPlayerPoints(randomNum);
                        JOptionPane.showMessageDialog(null, botMessage);
                    }
                    //if even then mini game
                    else
                    {
                       randomNum = (int) Math.ceil(Math.random() * 3);
                        switch (randomNum) {
                        //minigame 1
                            case 1:
                                JOptionPane.showMessageDialog(null, MATCH);
                                break;
                        //minigame 2
                            case 2:
                                JOptionPane.showMessageDialog(null, DODGER);
                               
                                break;
                        //minigame 3
                            default:
                                JOptionPane.showMessageDialog(null, PONG);
                        //minigame 4
                            break;
                        }
                    }
                    botTurn = true;
                  //  JOptionPane.showMessageDialog(null, "Roll the die for the bot.");
                
                }
                
            }
            else if (botTurn)
            {
                //Check if the the is clicked
                if(theDice.isInside(mouseLocation.x, mouseLocation.y))
                {
                    theDice.shuffle();
                    theSettings.setRound(theSettings.getRound() - 1);
                    playersturn = false;
                    //theSettings.addPlayerSpace(1);
                    //theSettings.addBotSpace(1);
                    theSettings.addBotSpace(theDice.getNumber());

                    theBot.moveTo(theSettings.getBotPointLocation());
                    this.repaint();
                    if((theSettings.getBotSpace()) % 2 == 1)
                    {
                        {
                        randomNum = (int) ((Math.ceil(Math.random() * 600)) - 300 - ((theSettings.getDifficulty()-3)*4));
                        if (randomNum >= 0)
                        {
                            botMessage = "The bot has landed on a chance space. They gained " + randomNum + " points.";
                        }
                        else
                        {
                            botMessage = "The bot has landed on a chance space. They lost " + randomNum + " points.";
                        }
                        //theSettings.addPlayerPoints(randomNum);
                        //JOptionPane.showMessageDialog(null, botMessage);
                        }
                    }
                    //if even number then mini game
                    else
                    {
                        randomNum = (int) ((Math.ceil(Math.random() * 1000)) - 300 - ((theSettings.getDifficulty()-3)*4));
                        if (randomNum >= 0)
                        {
                            botMessage = "The bot has landed on a minigame space. " + GOODBOTACTIONS[(int) Math.floor(Math.random() * 10)] + " They gained " + randomNum + " points.";
                        }
                        else
                        {
                            botMessage = "The bot has landed on a minigame space. " + BADBOTACTIONS[(int) Math.floor(Math.random() * 14)] + " They lost " + randomNum + " points.";
                        }
                        //randomNum = rand.nextInt(5);  //random number from 1 to 4
                        //botMessage = "";
                    }
                    theSettings.addBotPoints(randomNum);
                    JOptionPane.showMessageDialog(null, botMessage);
                }
                if (theSettings.getRound() > 0)
                {
                botTurn = false;
                playersturn = true;
                }
                else
                {
                    playersturn = false;
                    scene = 2;
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

        "It's the bots lucky day.",
        "I am sorry to inform you this...",
        "The bot has been studying this game like crazy."
    };
    private final String[] BADBOTACTIONS = new String[] { 
        "The Bot fell asleep at the keyboard.",
        "Your opponent tripped and fell.",
        "Even a bot can be a n00b sometimes.",
        "The Bot was listening to music and forgot it was their turn.",
        "Your opponent had cookies in the oven and had to leave the computer.",
        "The bots glasses fell off mid turn.",
        "The other player is having some bad luck today.",
        "The AI has failed on the space.",
        "Using their all knowning powers, the AI still managed to fail.",
        "Internet was down and the bot couldn't find the answers",
        "The bot was caught cheating.",
        "Your opponent is stuck on the phone with there parent.",
        "The bot was stuck behind the pod bay door.",
        "You distracted the bot with your great skills."
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
    
    
   
    private static String MATCH = "                                 In this mini-game, you will be trying to find the matches in the flipped over cards on the screen."
      + "\n           If you click on two different cards and pictures under the cards are the exact same, you have found a match and earn a point."
      + "\n                   If the pictures do not match, the cards will flip back over. The mini-game will end when the timer stops."
      + "\n                                       The number of points earned will be added to the overall score.";
    private static String PONG = "Who doesn't like a good pong game.";
    private static String DODGER = "                     This is a single player game. In this mini-game, objects will fall from the top of the screen to the bottom."
      + "\n     You will have to avoid being hit by the fallen objects. The timer will give you *30* seconds to dodge as many objects as you can."
      + "\n                                  When the timer ends, you will earn *2* points per object dodged.";
    private static String INTRO = "You and the computer will go around the board *10* times, and whoever has the most points at the end will win the game.\n" +
"                                        Start the game by rolling the dice.  After your turn don't forget to roll the die for the bot.\n"
            + "                                                                                           GOOD LUCK!";
    private static String RHYTHM = "Moving to that inner rythm.!";
    
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
        thePlayer.setInitals("JG");
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
                theDrawableGame.draw(pen);
                //Draw the player
                thePlayer.draw(pen);
                //Game going
                gamePlay = true;
                theBot.draw(pen);
                theDice.draw(pen);
                pen.setColor(whitePoint);
                pen.setFont(otherText);
                pen.drawString("Player Score: " + theSettings.getPlayerPoints(), 600, 180);
                pen.drawString("Bot Score: " + theSettings.getBotPoints(), 600, 200);
                pen.drawString("Remaining Rounds: " + theSettings.getRound(), 600, 220);
                pen.setColor(textColor);
                break;
            case 2:
                pen.setFont(headings);
                if(theSettings.getBotPoints() <= theSettings.getPlayerPoints())
                {
                    pen.drawString("You Won!", 600, 240);
                }
                else
                {
                    pen.drawString("You Lose!", 600, 240);
                }
                pen.drawString("Player Score: " + theSettings.getPlayerPoints(), 600, 180);
                pen.drawString("Bot Score: " + theSettings.getBotPoints(), 600, 200);
                break;
            case 3:
            {
                DodgerGame game = new DodgerGame();
                
                JFrame frame = new JFrame();		//creates new jframe
                frame.add(game);
                frame.setVisible(true);
                frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Dodger Mini Game");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                
                Instant instant = Instant.now();
                invulTimeStamp = 0;
                currentTime = 0;
                //game.paint(pen);
                while (game.getPlayer().getLives() > 0 && currentTime < 10) {
                    while(currentTime - invulTimeStamp < 3) {
                        instant = Instant.now();
                        currentTime = instant.getEpochSecond();
                        game.fallingUpdate();
                        game.repaint();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    game.repaint();
                    game.getPlayer().setInvulnerable(false);
                    game.getPlayer().setColor(Color.red);

                    while(!game.getPlayer().getInvulnerable()) {
                        for (GameObject squareArray1 : game.getArray()) {
                            if (squareArray1.collisionDetection(game.getPlayer())) {
                                game.getPlayer().subtractLife();
                                game.getPlayer().setInvulnerable(true);
                                invulTimeStamp = instant.getEpochSecond();
                                instant = Instant.now();
                                game.getPlayer().setColor(Color.gray);
                                break;
                            }
                        }
                       // game.repaint();
                        DodgerGame.pointDetection();
                        game.fallingUpdate();
                        game.repaint();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       // game.repaint();
                    }
                }
               
                
            }
            
                scene = 1;
                this.repaint();
            break;
             case 4:
                Matching theMatch = new Matching();
                //theSettings.addPlayerPoints(theMatch.points(false)*2);
                theSettings.addPlayerPoints(400);
                try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                          //  Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                scene = 1;
                this.repaint();
                break;
            default:
                break;
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
                scene = 1;
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
                thePlayer.setInitals("JG");
                thePlayer.setColor(Color.GREEN);
            }
            else if(characterTwoButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(2);
                thePlayer.setInitals("PM");
                thePlayer.setColor(Color.BLUE);
            }
            else if(characterThreeButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(3);
                thePlayer.setInitals("BB");
                thePlayer.setColor(Color.GRAY);
            }
            else if(characterFourButton.isInside(mouseLocation.x, mouseLocation.y))
            {
                theSettings.setPlayerChoice(4);
                thePlayer.setInitals("MP");
                thePlayer.setColor(Color.ORANGE);
            }
        }
        else if (scene == 1)
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
                    this.repaint();
                    thePlayer.moveTo(theSettings.getPlayerPointLocation());
                    //this.repaint();
                    //If odd then chance card
                    if((theSettings.getPlayerSpace()) % 2 != 0)
                    {
                        randomNum = (int) ((Math.ceil(Math.random() * 600)) - 300 + ((theSettings.getDifficulty()-3)*5));
                        if (randomNum >= 0)
                        {
                            botMessage = "You have landed on a chance space. You gained " + randomNum + " points.";
                        }
                        else
                        {
                            botMessage = "You have landed on a chance space. You lost " + randomNum + " points.";
                        }
                        theSettings.addPlayerPoints(randomNum);
                        JOptionPane.showMessageDialog(null, botMessage);
                    }
                    //if even then mini game
                    else
                    {
                       randomNum = (int) Math.ceil(Math.random() * 2);
                       randomNum = 1;
                        switch (randomNum) {
                        //minigame 1
                            case 1:
                                JOptionPane.showMessageDialog(null, MATCH);
                                scene = 4;
                                break;
                        //minigame 2
                            case 2:
                                JOptionPane.showMessageDialog(null, DODGER);
                                scene = 3;
                                break;
                        //minigame 3
                            default:
                            break;
                        }
                    }
                    botTurn = true;
                  //  JOptionPane.showMessageDialog(null, "Roll the die for the bot.");
                
                }
                
            }
            else if (botTurn)
            {
                //Check if the the is clicked
                if(theDice.isInside(mouseLocation.x, mouseLocation.y))
                {
                    theDice.shuffle();
                    theSettings.setRound(theSettings.getRound() - 1);
                    playersturn = false;
                    //theSettings.addPlayerSpace(1);
                    //theSettings.addBotSpace(1);
                    theSettings.addBotSpace(theDice.getNumber());

                    theBot.moveTo(theSettings.getBotPointLocation());
                    this.repaint();
                    if((theSettings.getBotSpace()) % 2 == 1)
                    {
                        {
                        randomNum = (int) ((Math.ceil(Math.random() * 600)) - 300 - ((theSettings.getDifficulty()-3)*4));
                        if (randomNum >= 0)
                        {
                            botMessage = "The bot has landed on a chance space. They gained " + randomNum + " points.";
                        }
                        else
                        {
                            botMessage = "The bot has landed on a chance space. They lost " + randomNum + " points.";
                        }
                        //theSettings.addPlayerPoints(randomNum);
                        //JOptionPane.showMessageDialog(null, botMessage);
                        }
                    }
                    //if even number then mini game
                    else
                    {
                        randomNum = (int) ((Math.ceil(Math.random() * 1000)) - 300 - ((theSettings.getDifficulty()-3)*4));
                        if (randomNum >= 0)
                        {
                            botMessage = "The bot has landed on a minigame space. " + GOODBOTACTIONS[(int) Math.floor(Math.random() * 10)] + " They gained " + randomNum + " points.";
                        }
                        else
                        {
                            botMessage = "The bot has landed on a minigame space. " + BADBOTACTIONS[(int) Math.floor(Math.random() * 14)] + " They lost " + randomNum + " points.";
                        }
                        //randomNum = rand.nextInt(5);  //random number from 1 to 4
                        //botMessage = "";
                    }
                    theSettings.addBotPoints(randomNum);
                    JOptionPane.showMessageDialog(null, botMessage);
                }
                if (theSettings.getRound() > 0)
                {
                botTurn = false;
                playersturn = true;
                }
                else
                {
                    playersturn = false;
                    scene = 2;
                }
            }

        }
        this.repaint();
    }
    public int getScene()
    {
        return scene;
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
