import java.awt.*;						//	AWT = "Abstract Window Toolkit"
import java.util.Scanner;

/**
 * This project was to ask the user to input a value that would be on a basic die (1-6).
 * The user would also have to input the coordinates of the die and show the die in a graphics window at that coordinate.
 * This is the only class for the project and can operate according to the specifications for this project.
 * @author Michael Tyler
 *
 */
public class Die extends Frame{


	int number=0;
	int X=0;
	int Y=0;

	/**
	 * Takes the number entered of a die and x,y coordinates to produce a die with the value entered from the user.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean badInput=false;
		int dieNumber;
		int xA;
		int yA;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Hi! Let's play dice!");
		System.out.println("Enter the number on the face of the die");

		do{
			dieNumber=keyboard.nextInt();		//takes number input by user and sets it to number shown on dice

			if ((1<=dieNumber)&&(dieNumber<=6)){
				badInput=false;
				System.out.println("Enter the location of the die:");		
				xA=keyboard.nextInt();				//	takes first number input by user and sets it to x coordinate
				yA=keyboard.nextInt();				//	takes second number input by user and sets it to y coordinate
				Die myPicture = new Die();
				myPicture.setNumber(dieNumber);
				myPicture.setX(xA);
				myPicture.setY(yA);
			}
			else {
				System.out.println("Error:Please enter a number from 1 to 6.");
				badInput=true;
			}
		}while(badInput);
		System.out.println("I hope you had fun!");
		System.out.println("BYE!");
	}
	/**
	 * The following methods sets the variables from the inputs from the main method. 
	 * These are used when plotting the dots
	 */
	private final int width=200;
	private final int height=200;

	public void setNumber(int input){
		number=input;
	}

	public int getNumber(){
		return number;
	}

	public void setX(int xB){
		X=xB;
	}

	public int getX(){
		return X;
	}

	public void setY(int yB){
		Y=yB;
	}

	public int getY(){
		return Y;
	}

	/**
	 * The method sets up the window that the die is drawn in
	 */
	public Die(){
		setTitle("Roll the Dice");									//		We set the characteristics of our
		setLocation(50, 50);										//		drawing window: the location,
		setSize(1000, 1000);										//		the size, and
		setBackground(Color.lightGray);								//		the color of the background

		setVisible(true);											//	And we make it appear
	}

	/**
	 * This method is a switch statement to draw the number on the the die.
	 * @param pane
	 */


	public void selectDie(Graphics pane){	

		switch(getNumber())
		{
		case 1:
			drawOne(pane);
			break;
		case 2:
			drawTwo(pane);
			break;
		case 3:
			drawThree(pane);
			break;
		case 4:
			drawFour(pane);
			break;
		case 5:
			drawFive(pane);
			break;
		case 6:
			drawSix(pane);
			break;

		}
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

	/**   Draws the "blank" die in a given frame. 
	 * @param height 
	 * @param width 
	 * @param yA 
	 * @param xA 
	 */ 
	private void drawBlank (int xA, int yA, int width, int height, Graphics pane) {
		/**
		 * draws the mainface of the die
		 */
		pane.setColor(Color.black);
		pane.drawRect(xA,  yA,  width, height);
		pane.setColor(Color.white);
		pane.fillRect(xA, yA, width,height);

		/**
		 * draws the rest of the die
		 */

		pane.setColor(Color.black);
		pane.drawLine(xA, yA, xA-100, yA-50);
		pane.drawLine(xA-100, yA-50, xA-100, yA+150);
		pane.drawLine(xA-100, yA+150, xA, yA+200);
		pane.drawLine(xA-100, yA-50, xA+100, yA-50);
		pane.drawLine(xA+100, yA-50, xA+200, yA);
	}

	/**   Draws one dot, centered at given location. 
	 */ 
	private void drawDot (Graphics pane, int x, int y){
		int radius=20;
		int dotX=x-(radius/2);
		int dotY=y-(radius/2);
		pane.setColor(Color.red);
		pane.fillOval(dotX, dotY, radius, radius);

	}

	/**
	 * Places the drawing inside of the window.
	 */
	public void paint(Graphics pane){

		drawBlank(getX(),getY(),200,200,pane);
		selectDie(pane);		

	}

}
