
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Gauthier
 */
public class DrawableIntro extends Settings implements DrawableInterface{
    //Start x
    private int theX;
    //Start y
    private int theY;
    //The max x
    private int maxX;
    //The max y
    private int maxY;
    //Font variable
    private final Font headings;
    //Font variable
    private final Font text;
    //The main game color
    private final Color primaryColor;
    //Secondary color
    private final Color secondaryColor;
    //Accent or tertiary color
    private final Color accentColor;
    //The text color
    private final Color textColor;
    //White point
    private final Color whitePoint;
     //The decriptions
    private final String[] descriptions = new String[] {"","Johnny lives a life on the computer.  If it’s not posted on social media did it even happen?  While all of his profile pictures look staged, he would never admit it.","Patricia lives a busy life.  Whether she is leading the office meeting or picking up her kids from their soccer practice, her kindness is infectious.  Her only negative is her “may I speak to the manager” haircut.","Brad is a full time baseball coach.  If he could describe himself in five words they would be: Sarcastic, Political, Narcissistic, Poignant, and Extroverted.","Everybody loves Manny.  His daily job is a boat captain, but he still has dreams of becoming a pilot. Not the most athletic person in the world."};;
   
    
    public DrawableIntro()
    {
        this(1280, 720);
    }
    
    public DrawableIntro(int theMaxX, int theMaxY)
    {
        //descriptions = new String[] {"Johnny lives a life on the computer.  If it’s not posted on social media did it even happen?  While all of his profile pictures look staged, he would never admit it.","Patricia lives a busy life.  Whether she is leading the office meeting or picking up her kids from their soccer practice, her kindness is infectious.  Her only negative is her “may I speak to the manager” haircut.","Brad is a full time baseball coach.  If he could describe himself in five words they would be: Sarcastic, Political, Narcissistic, Poignant, and Extroverted.","Everybody loves Manny.  His daily job is a boat captain, but he still has dreams of becoming a pilot. Not the most athletic person in the world."};
        primaryColor = new Color(85,140,137);
        textColor = new Color(64,64,64);
        secondaryColor = new Color(116,175,173);
        accentColor = new Color(217,133,59);
        whitePoint = new Color(236,236,234);
        
        theX = 0;
        theY = 0;
        headings = new Font("Times New Roman",Font.PLAIN,28);
        text = new Font("Times New Roman",Font.PLAIN,16);
        maxX = theMaxX;
        maxY = theMaxY;
    }
    
    @Override
    public int getX() {
        return theX;
    }

    @Override
    public int getY() {
        return theY;
    }

    @Override
    public void moveTo(int absX, int absY) {
        theX = absX;
        theY = absY;
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
        
        
        //Background
        pen.setColor(primaryColor);
            pen.fillRect(theX + 0, 0, maxX, maxY);
      
        //Areas
        pen.setColor(secondaryColor);
        //Top rectangles
            pen.fillRect(theX + 90, 50, 300, 380);
            pen.fillRect(theX + 500, 50, 300, 380);
            pen.fillRect(theX + 900, 50, 300, 380);
            //Low
            pen.fillRect(theX + 115, 450, 1060, 210);
        pen.setColor(whitePoint);
            //The entering box
            pen.fillRect(theX + 950, 120, 200, 110);
            
        pen.setColor(textColor);
            pen.setFont(headings);
            //welcome
            pen.drawString("Welcome to MonoParty!", theX + 520, 30);
            //Instruction heading
            pen.drawString("Instructions:", theX + 132, 485);
            //Character choice heading
            pen.drawString("Choose Player:", theX + 125, 80);
            //Bot difficulty heading
            pen.drawString("Difficulty:", theX + 535, 80);
            //Load previous game? heading
            pen.drawString("Load Previous Game:", theX + 935, 80);
            pen.setFont(text);
            pen.drawString("The object of the game is to earn more points than the computer. You can earn points by landing on a *POINTS* space and by playing mini-games. You can lose points", theX + 142, 515);
            pen.drawString("by landing on a *DEDUCTION* space. When it is your turn to move around the board, click on the die. After your turn is completed, the computer will automatically", theX + 142, 530);
            pen.drawString("take it’s turn.\n You and the computer will go around the board *10* times, and whoever has the most points at the end will win the game.\n", theX + 142, 544);
            pen.drawString("GOOD LUCK!", theX + 142, 562);
            pen.drawString(descriptions[super.getPlayerChoice()], theX + 152, 582);
            
            //Button Time
            
    }
}
