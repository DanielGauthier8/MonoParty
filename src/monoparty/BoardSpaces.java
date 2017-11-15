import java.awt.Color;
import java.awt.Graphics;

public class BoardSpaces{
	private int spaceXSize, spaceYSize;
	private Color spaceColor;
	private int x,y;
	private int spaceIdentity;
	
	public BoardSpaces(){
		
		spaceXSize = 128;
		spaceYSize = 72;
		spaceColor = Color.green;
		x = 0;
		y = 0;
		spaceIdentity = 0;
	}
	
	public BoardSpaces(int xpos, int ypos, Color sColor, int id){
		spaceXSize = 128;
		spaceYSize = 72;
		spaceColor = sColor;
		x = xpos;
		y = ypos;
		spaceIdentity = id;
	}
	
	public int getSXsize(){
		return spaceXSize;
	}
	
	public int getSYsize(){
		return spaceYSize;
	}
	
	public Color getScolor(){
		return spaceColor;
	}
	
	public void setScolor(Color color){
		spaceColor = color;
	}
	
	public void setSID(int ID){
		spaceIdentity = ID;
	}
	
	public int getSID(){
		return spaceIdentity;	
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int newY){
		y = newY;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int newX){
		x = newX;
	}
	
	public void paint(Graphics pane){
		
		pane.setColor(spaceColor);
		pane.fillRect(x, y, spaceXSize, spaceYSize);
		
		pane.setColor(Color.black);
		pane.drawRect(x, y, spaceXSize, spaceYSize);
	}
	
}
