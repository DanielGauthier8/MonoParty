import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int points;
	private int xPos;
	private int yPos;
	private int size;
	private Color pColor;
	private String pName;
	
	public Player (){
		points = 0;
		xPos = 25;
		yPos = 25;
		pColor = Color.red;
		size = 50;
		pName = "New Player";
	}
	
	public Player (int point, int x, int y, Color color, String name){
		points = point;
		xPos = x;
		yPos = y;
		pColor = color;
		size = 50;
		pName = name;
	}
	
	public String getName(){
		return pName;
	}
	
	public void setName(String neoName){
		pName = neoName;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void setPoints(int p){
		points = p;
	}
	
	public int getXPos (){
		return xPos;
	}
	
	public void setXPos (int xPosition){
		xPos = xPosition;
	}
	
	public int getYPos (){
		return yPos;
	}
	
	public void setYPos (int yPosition){
		yPos = yPosition;
	}
	
	public Color getColor (){
		return pColor;
	}
	
	public void setColor (Color neoColor){
		pColor = neoColor;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int neoSize){
		size = neoSize;
	}
	
	public void move (){
		
		
		
	}
	
	public void paint(Graphics pane){
		pane.setColor(pColor);
		pane.fillOval(xPos, yPos, size, size);
	}
}
