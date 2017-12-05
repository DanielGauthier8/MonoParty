
import java.awt.Point;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
public class Settings {
    //Bot Difficuity
    private int difficulty;
    //Users player index in player array
    private int playerChoice;
    //Current save code
    private String passcode;
    //Current save code
    private int intPasscode;
    //the users current space
    private int playerSpace;
    //The opponents current space
    private int botSpace;
    //The players points
    private int playerPoints;
    //The bot points
    private int botPoints;
    //The remaining rounds.  Starts with 10
    private int rounds;
    //Should not be hard coded
    final int[][] LOCATIONS = new int[][] { 
        {20,15},  // 0
        {140,15}, // 1
        {260,15}, // 2
        {400,15}, // 3
        {520,15}, // 4
        {645,15}, // 5
        {780,15}, // 6
        {900,15}, // 7
        {1040,15}, // 8
        {1160,15}, // 9
        {1160,90}, // 10
        {1160,165}, // 11
        {1160,235}, // 12
        {1160,305}, // 13
        {1160,375}, // 14
        {1160,445}, // 15
        {1160,525}, // 16
        {1160,595}, // 17
        {1160,670}, // 18
        {1040,670}, // 19
        {900,670}, // 20
        {780,670}, // 21
        {640,670}, // 22
        {520,670}, // 23
        {400,670}, // 24
        {260,670}, // 25
        {140,670}, // 26
        {20,670}, // 27
        {20,595}, // 28
        {20,525}, // 29
        {20,445}, // 30
        {20,375}, // 31
        {20,305}, // 32
        {20,235}, // 33
        {20,165}, // 34
        {20,90}, // 35
        {20,15}, // 36
    };
    
    private Point thePoint;
    private Point theBPoint;
    private final DecimalFormat TWODIGITS = new DecimalFormat("00");
    //Points are awarded in 10's so really up to FIVE digits kinda
    private final DecimalFormat FOURDIGITS = new DecimalFormat("0000");
    private final DecimalFormat FOURTEENDIGITS = new DecimalFormat("00000000000000");
    //All the game settings
    
    public Settings()
    {
        thePoint = new Point (200,100);
        theBPoint = new Point (200,100);
        playerSpace = 0;
        botSpace = 0;
        playerPoints = 0;
        botPoints = 0;
        difficulty = 1;
        playerChoice = 1;
        passcode = "0";
        rounds = 10;
    }

    //Getter methods
    public int getDifficulty()
    {
        return difficulty;   
    }
    
    public int getPlayerChoice()
    {
        return playerChoice;   
    }
  
    public String createSaveCode(){
        passcode = TWODIGITS.format(botSpace) + "" + TWODIGITS.format(playerSpace) + "" + FOURDIGITS.format(playerPoints) + "" + FOURDIGITS.format(botPoints) + "" + difficulty + "" + playerChoice + "" + rounds;
        //intPasscode = Integer.parseInt(passcode);
        //passcode =  Integer.toHexString(intPasscode);
        return passcode;
    }
    
    public String getSaveCode(){
        passcode = createSaveCode();

        return passcode;
                
    }
    
    public int getBotPoints(){
        return botPoints;
                
    }
    public int getPlayerPoints(){
        return playerPoints;
                
    }
  
    public int getBotSpace(){
        return botSpace;
                
    }
    public int getPlayerSpace(){
        return playerSpace;
                
    }
    //Setter methods
    public int setDifficulty(int dif)
    {
        difficulty = dif;
        difficulty = difficulty%4;
        return difficulty;
    }
    
    public int setPlayerChoice(int choice)
    {
        playerChoice = choice;
        playerSpace = playerSpace%4;
        return playerChoice;   
    }
    
    public int setPlayerSpace(int space)
    {
        playerSpace = space;
        playerSpace = playerSpace%36;
        return playerSpace;   
    }
    
    public int addPlayerSpace(int space)
    {
        playerSpace += space;
        playerSpace = playerSpace%36;
        return playerSpace;   
    }
    
    public int setPlayerPoints(int choice)
    {
        playerPoints = choice;
        return playerPoints;   
    }
    
    public int addPlayerPoints(int choice)
    {
        playerPoints += choice;
        return playerPoints;   
    }
    
    public int setBotSpace(int space)
    {
        botSpace = space;
        botSpace = botSpace % 36;
        return playerChoice;   
    }
    
    public int addBotSpace(int space)
    {
        botSpace += space;
        botSpace = botSpace % 36;
        return playerChoice;   
    }
    
    public int setBotPoints(int choice)
    {
        botPoints = choice;
        return botPoints;   
    }
    
    public int addBotPoints(int choice)
    {
        botPoints += choice;
        return botPoints;   
    }
    
    public Point getBotPointLocation()
    {
        theBPoint.x = (LOCATIONS[botSpace][0]) + 40;
        theBPoint.y = LOCATIONS[botSpace][1];
        return theBPoint;
    }
    //Would have liked to only include one in drawablePlayer, but because of saving method this is best option
    public Point getPlayerPointLocation()
    {
        thePoint.x = LOCATIONS[playerSpace][0] + 4;
        thePoint.y = LOCATIONS[playerSpace][1];
        return thePoint;
    }
    
    public void setRound(int code)
    {
        rounds = code;
    }
    
    public int getRound()
    {
        return rounds;
    }
    
    public void setSaveCode(String code)
    {
        //fourteen digits
        passcode = code;
        if (Integer.parseInt((passcode.substring(0, 2))) < 36 && Integer.parseInt((passcode.substring(0,2))) > 0)
        {
            botSpace = Integer.parseInt(passcode.substring(0, 2));
        }
        if (Integer.parseInt((passcode.substring(2, 4))) < 36 && Integer.parseInt((passcode.substring(2,4))) > 0)
        {
            playerSpace = Integer.parseInt(passcode.substring(2, 4));
        }
        if (Integer.parseInt((passcode.substring(4, 8))) < 9999 && Integer.parseInt((passcode.substring(4,8))) > 0)
        {
            playerPoints = (Integer.parseInt(passcode.substring(4, 8)) * 10);
        }
        if (Integer.parseInt((passcode.substring(8, 12))) < 9999 && Integer.parseInt((passcode.substring(8,12))) > 0)
        {
            botPoints = (Integer.parseInt(passcode.substring(8, 12)) * 10);
        }
        if (Integer.parseInt((passcode.substring(12, 13))) < 3 && Integer.parseInt((passcode.substring(12,13))) > 0)
        {
            difficulty = Integer.parseInt(passcode.substring(12, 13));
        }
        if (Integer.parseInt((passcode.substring(13))) < 4 && Integer.parseInt((passcode.substring(13))) > 0)
        {
            playerChoice = Integer.parseInt(passcode.substring(13));
        }
        if (Integer.parseInt((passcode.substring(14))) < 10 && Integer.parseInt((passcode.substring(14))) > 0)
        {
            rounds = Integer.parseInt(passcode.substring(14));
        }
    }
}
