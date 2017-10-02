import java.awt.Color;
import java.awt.Graphics;

public class Opponent {
	private int points;
	private int xPos;
	private int yPos;
	private int size;
	private Color qColor;
	private String qName;
	
	public Opponent (){
		points = 0;
		xPos = 25;
		yPos = 25;
		qColor = Color.MAGENTA;
		size = 50;
		qName = "xXCosmicDestroyerXx";
	}
	
	public Opponent (int point, int x, int y, Color color, String name){
		points = point;
		xPos = x;
		yPos = y;
		qColor = color;
		size = 50;
		qName = name;
	}
	
	public String getName(){
		return qName;
	}
	
	public void setName(String neoName){
		qName = neoName;
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
		return qColor;
	}
	
	public void setColor (Color neoColor){
		qColor = neoColor;
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
		pane.setColor(qColor);
		pane.fillOval(xPos, yPos, size, size);
	}
}
