
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Gauthier
 */
public class DrawableButton implements DrawableInterface{

//Data Fields............................
    //The location of the drawable object
    private Point location;
    //The text
    private String theText;
    //White point
    private final Color whitePoint;
    //The font for the text
    private final Font text;
    //The main game color
    private final Color theColor;
    //The width of the button
    private final int width;
    //The width of the button
    private final int height;
    //Check and see if the button is clicked 
    private boolean beenClick;
    
    //Constuctors............................
    //Default constuctor
    public DrawableButton()
    {
        //Calling the parameterized constuctor
        this(150, 150, "Button");
    }
    public DrawableButton(int theX, int theY, int theW, String thText)
    {
        whitePoint = new Color(236,236,234);
        theColor = new Color(217,133,59);
        text = new Font("Monospaced", Font.BOLD, 20);
        beenClick = false;
        
        //Set the location for the button
        location = new Point(theX, theY);
        theText = thText;
        width = thText.length() * 10 + 2 - theW;
        height = 40;
    }
    public DrawableButton(int theX, int theY, String thText)
    {
        whitePoint = new Color(236,236,234);
        theColor = new Color(217,133,59);
        text = new Font("Monospaced", Font.BOLD, 20);
        
        //Set the location for the button
        location = new Point(theX, theY);
        theText = thText;
        width = thText.length() * 10 + 2;
        height = 40;
    }
    //Methods.................................
    //methods implemented from DrawableInterface, javadoc comments are made for those methods below
    //ALL CODE BELOW HAS COMMENTS FOUND IN THE INTERFACE...........................
    //Gets the location based using the Point object
    public Point getLocation()
    {
        return location; 
    }
 
    @Override
    //Gets the X location
    public int getX() {
        return location.x;
    }

    @Override
    //Gets the Y location
    public int getY() {
        return location.y;
    }

    @Override
    //Moves object to an exact point using the x and y values
    public void moveTo(int absX, int absY) {
        location.x = absX;
        location.y = absY;
    }

    //Moves object to an exact point using the Point object
    public void moveTo(Point whereToGo) {
    location = whereToGo;    
    }

    @Override
    //moves the object by a specified amount
    public void moveBy(int dX, int dY) {
       location.x += dX;
       location.y += dY; 
    }

    @Override
    //moves the object based on the velocity
    public void move() {
        
    }

    @Override
    //Returns the velocity for the x velocity
    public double getVelocityX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //Returns the velocity for the y velocity
    public double getVelocityY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //Sets the velocity of the student for both the x and y directions
    public void setVelocity(double dvX, double dvY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //Gets the color of the shirt
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //Sets the color of the shirt
    public void setColor(Color theColor) {
        
    }
    
    //Gets the number of wins
    public int getWins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Increments the wins value by one
    public void upWins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void flipClick ()
    {
        beenClick = !beenClick;
    }
    
    @Override
    public void draw(Graphics pen)
    {             
        //Sets the shirts color
        pen.setColor(theColor);
        // Body
        pen.fillRect(location.x, location.y, width, height);
        pen.setColor(whitePoint);
        pen.drawString(theText, location.x + 10, location.y + 21);
        
    }
    
    public boolean isInside(int mouseX, int mouseY) {
    return (mouseX >= location.x &&
            mouseX <= (location.x+width) &&
            mouseY >= location.y && 
            mouseY <= (location.y + height));
};
    
} 
