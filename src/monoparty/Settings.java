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
    //Passcode
    private int pXPos, oXPos, pYpos, oYPos, pPoints, oPoints;
    //All the game settings
    
    public Settings()
    {
        difficulty = 0;
        playerChoice = 0;
        passcode = "00000000000";
    }
    //Methods
    public void updateSaveCode()
    {
        
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
    private String createPasscode()
    {
        /*
        pXPos = super.getXPos();
        pYpos = super.getYPos();
        oXPos = super.getXPos();
        oYPos = super.getYPos();
        pPoints = super.getPoints();
        oPoints = super.getPoints();

        passcode = "pXpos" + "pYpos" + "oXPos" + "oYPos" + "pPoints" + "oPoints";
*/
        return passcode;
    }
    public String getPasscode(){
        passcode = createPasscode();

        return passcode;
                
    }
    //Setter methods
    public int setDifficulty(int dif)
    {
        difficulty = dif;
        return difficulty;
    }
    
    public int setPlayerChoice(int choice)
    {
        playerChoice = choice;
        return playerChoice;   
    }
    public String setSaveCode(String code)
    {
        passcode = code;
        return passcode;
    }
}
