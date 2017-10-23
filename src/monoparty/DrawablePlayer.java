package monoparty;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class DrawablePlayer extends Player implements DrawableInterface{
    //Data Fields............................
    //The location of the drawable object
    private Point location;
    //Objects velocity in the x direction
    private double xVelocity;
    //Objects velocity in the y direction
    private double yVelocity;
    //The color of the players shirt
    private Color shirtColor;
    //The body width of the student.  Never changes
    private final int BODY_WIDTH;
    //The height of the student.  Never changes
    private final int BODY_HEIGHT;
    //The number of wins by the student
    private int wins = 0;
    
    //Constuctors............................
    //Default constuctor
    public DrawablePlayer()
    {
        //Calling the parameterized constuctor
        this(150, 150, Color.CYAN);
    }
    public DrawablePlayer(int theX, int theY, Color theColor)
    {
        //Set the starting location for the student
        location = new Point(theX, theY);
        //The student is not moving
        xVelocity = 0;
        yVelocity = 0;
        //Color of the shirt
        shirtColor = theColor;
        BODY_WIDTH = 150;
        BODY_HEIGHT = 150;
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
        location.x += xVelocity;
        location.y += yVelocity;
    }

    @Override
    //Returns the velocity for the x velocity
    public double getVelocityX() {
        return xVelocity;
    }

    @Override
    //Returns the velocity for the y velocity
    public double getVelocityY() {
        return yVelocity;
    }

    @Override
    //Sets the velocity of the student for both the x and y directions
    public void setVelocity(double dvX, double dvY) {
        if (xVelocity >= -5 && xVelocity <= 5 && yVelocity >= -5 && yVelocity <= 5)
        {
            xVelocity = dvX;
            yVelocity = dvY;
        }
    }

    @Override
    //Gets the color of the shirt
    public Color getColor() {
        return shirtColor;
    }

    @Override
    //Sets the color of the shirt
    public void setColor(Color theColor) {
        shirtColor = theColor;
    }
    
    //Gets the number of wins
    public int getWins() {
        return wins;
    }

    //Increments the wins value by one
    public void upWins() {
        wins++;
    }
    @Override
    public void draw(Graphics pen)
    {             
        //Sets the shirts color
        pen.setColor(shirtColor);
        // Body
        pen.fillRect(location.x, location.y, BODY_WIDTH, BODY_HEIGHT);
        //Draws the book using the pen object
        //Changed to Backpack
        pen.setColor(shirtColor);
        // Left Arm
        pen.fillRect(location.x-40, location.y, 40, BODY_HEIGHT + 50);
        // Right Arm
        pen.fillRect(location.x+BODY_WIDTH, location.y, 40, BODY_HEIGHT + 50);

        // Outline arms for visibility
        pen.setColor(Color.BLACK);
        pen.drawRect(location.x-40, location.y, 40, BODY_HEIGHT+ 50);
        pen.drawRect(location.x+BODY_WIDTH, location.y, 40, BODY_HEIGHT +50 );
        
        // Pants Top
        pen.setColor(Color.DARK_GRAY);
        pen.fillRect(location.x, location.y+BODY_HEIGHT, 150, 100);
        // Left Leg      
        pen.fillRect(location.x, location.y+BODY_HEIGHT+100, 50, 200);
        // Right Leg
        pen.fillRect(location.x+100, location.y+BODY_HEIGHT+100, 50, 200);
        
        // Draw Head
        pen.setColor(new Color(0xf1c27d));
        pen.fillOval(location.x+20, location.y-125, 110, 150);
        pen.setColor(Color.BLACK);
        //The left eye
        pen.fillOval(location.x+51, location.y-100, 15, 15);
        //The right eye
        pen.fillOval(location.x+81, location.y-100, 15, 15);
        //Draw the mouth
        pen.drawArc(location.x+45, location.y-60, 60, 60, 0, -180);
        pen.setColor(Color.DARK_GRAY);
        //Creates font
        pen.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

}
