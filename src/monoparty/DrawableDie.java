

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DrawableDie implements DrawableInterface{
    //Data Fields............................
    //The location of the drawable object
    private Point location;
    private int sides;
    //White point
    private final Color whitePoint;
    //The text color
    private final Color textColor;
    //The width and height of the die
    private final int width;
    //the number shown on the die
    private int theNumber;
    
    //Constuctors............................
    //Default constuctor
    public DrawableDie(int theX, int theY)
    {
        theNumber =  getNumber();
        //Set the starting location for the student
        location = new Point(theX, theY);
        //Calling the parameterized constuctor
        textColor = new Color(64,64,64);
        whitePoint = new Color(236,236,234);
        location.x = theX;
        location.y = theY;
        width = 200;
        
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
        location.x += 0;
        location.y += 0;
    }

    @Override
    //Returns the velocity for the x velocity
    public double getVelocityX() {
        return 0;
    }

    @Override
    //Returns the velocity for the y velocity
    public double getVelocityY() {
        return 0;
    }

    @Override
    //Sets the velocity of the student for both the x and y directions
    public void setVelocity(double dvX, double dvY) {
        //
    }

    @Override
    //Gets the color of the shirt
    public Color getColor() {
        return textColor;
    }

    @Override
    //Sets the color of the shirt
    public void setColor(Color theColor) {
       //
    }
    
    public int getNumber()
    {
        return theNumber;
    }
    
    public void shuffle ()
    {
        theNumber = (int) (Math.floor(Math.random() * (6 - 1 + 1)) + 1); //The maximum is inclusive and the minimum is inclusive 
    }
   


    /**   Draws one dot, centered at given location. 
     */ 
    private void drawDot (Graphics pane, int x, int y){
            int radius=30;
            int dotX=x-(radius/2);
            int dotY=y-(radius/2);
            pane.setColor(textColor);
            pane.fillOval(dotX, dotY, radius, radius);

    }
    	/**   The following methods draws the number 
	 *       of dots on the face of the die. 
	 */ 
	private void drawOne (Graphics pane){

		drawDot(pane,getX()+100,getY()+100);
	}

	private void drawTwo (Graphics pane){
		drawDot(pane,getX()+30,getY()+30);
		drawDot(pane,getX()+170,getY()+170);
	}

	private void drawThree(Graphics pane){

		drawOne(pane);
		drawTwo(pane);
	}

	private void drawFour (Graphics pane){
		drawTwo(pane);
		drawDot(pane,getX()+170,getY()+30);
		drawDot(pane,getX()+30,getY()+170);
	}

	private void drawFive (Graphics pane){
		drawOne(pane);
		drawFour(pane);
	}

	private void drawSix (Graphics pane){
		drawFour(pane);
		drawDot(pane,getX()+30,getY()+100);
		drawDot(pane,getX()+170,getY()+100);
	}
        
    @Override
    public void draw(Graphics pen)
    {             
        /**
        * draws the mainface of the die
        */
        pen.setColor(textColor);
        pen.drawRect(location.x,  location.y,  width, width);
        pen.setColor(whitePoint);
        pen.fillRect(location.x, location.y, width,width);

        /**
        * draws the rest of the die
        

        pen.setColor(whitePoint);
        pen.drawLine(location.x, location.y, location.x-100, location.y-50);
        pen.drawLine(location.x-100, location.y-50, location.x-100, location.y+150);
        pen.drawLine(location.x-100, location.y+150, location.x, location.y+200);
        pen.drawLine(location.x-100, location.y-50, location.x+100, location.y-50);
        pen.drawLine(location.x+100, location.y-50, location.x+200, location.y);
        * */
        switch(theNumber)
		{
		case 1:
			drawOne(pen);
			break;
		case 2:
			drawTwo(pen);
			break;
		case 3:
			drawThree(pen);
			break;
		case 4:
			drawFour(pen);
			break;
		case 5:
			drawFive(pen);
			break;
		case 6:
			drawSix(pen);
			break;

		}
    }
public boolean isInside(int mouseX, int mouseY) {
    return (mouseX >= location.x &&
            mouseX <= (location.x+width) &&
            mouseY >= location.y && 
            mouseY <= (location.y + width));
};
}
