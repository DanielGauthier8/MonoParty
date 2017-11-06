/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Player {
    //Data fields...............
    //name (String)
    // Player name
    // Default: "Player One"    
    private String name;
    //score (int)
    // Default: 0
    // min: 0; max: No Limit
    private int score = 0;
    //score (int)
    // Default: 0
    // min: 0; max: Number of spaces
    private int place = 0;
    
    //Constuctors...............
    /** 
     * Default player initialization
     */
    public Player()
    {
        this("Player One");
        score = 0;
    }
    
    /** 
     * Specific student initialization and 
     * assigns name and a pre-defined textbooks to the student
     * @param myName name of student
     */
    
    public Player(String myName)
    {
        name = myName;
        score = 0;
    }
    
    //Methods.......................
    // Accessor methods
     /**
     * Accessor method for player name
     * @return name of player
     */
    public String getName()
    {
        return name;
    }
    
    
    /**
     * Accessor method for player's current health status
     * @return player's health data field
     */    
    public double getScore()
    {
        return score;
    }
    
    /**
     * Accessor method for player's current health status
     * @return player's health data field
     */    
    public int getPlace()
    {
        return place;
    }
    
    // Mutator Methods  
    /**
     * Setter for player name, no validation on name
     * @param myName the new name of player
     */    
    public void setName(String myName)
    {
        name = myName;
    }
    
    //The player's score
    public double changeScoreBy(int thePoints)
    {
        //Damage has to be negative.  Prevent cheating by the creature using abs
        score += thePoints;
        //Don't let health go negative
        return score;
    }
    //The player's score
    
    //Add to the postion of the student
    public double playerPostion(int placesEarned)
    {
        //Damage has to be negative.  Prevent cheating by the creature using abs
        place += placesEarned;
        //Place will be max of 36
        place = place % 36;
        return place;
    }
}
