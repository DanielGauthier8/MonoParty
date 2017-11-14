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
    private String saveCode;
    //All the game settings
    public Settings()
    {
        difficulty = 0;
        playerChoice = 0;
        saveCode = "00000000000";
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
    public String getSaveCode()
    {
        return saveCode;
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
        saveCode = code;
        return saveCode;
    }
}
