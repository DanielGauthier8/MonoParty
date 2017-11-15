import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 * 
 */

/**
 * @author Jesus
 *
 */
public class Board{
	private static int boardHeight;
	private static int boardWidth;
	private Color boardColor;
	private int x, y;
	private BoardSpaces [] bSpaces;
	
	public Board(){
		boardHeight = 1280;
		boardWidth = 720;
		boardColor = Color.blue;
		bSpaces = new BoardSpaces[36];
		bSpaces = generateSpaces();
	}
	
	public static int getBoardHeight(){
		return boardHeight;
	}
	
	public void setBoardHeight(int height){
		boardHeight = height;
	}
	
	public int getBoardWidth(){
		return boardWidth;
	}
	
	public void setBoardWidth(int width){
		boardWidth = width;
	}
	
	public Color getBoardColor (){
		return boardColor;
	}
	
	public void setBoardColor (Color color){
		boardColor = color;
	}
	
	public BoardSpaces[] generateSpaces(){
		x = -128;
		y = -72;
		int i = 0;
		
		while (x < boardWidth - 128){
			x = x + 128;
			bSpaces[i] = new BoardSpaces(x, 0, Color.orange, i);
			i++;
		}
		
		while (y < boardHeight -72){
			bSpaces[i] = new BoardSpaces(boardWidth - 128, y + 72, Color.orange, i);
			i++;
		}
		while (x > boardHeight -128){
			bSpaces[i] = new BoardSpaces(x - 128, y + 72, Color.orange, i);
			i++;
		}
		while (y > boardWidth -72){
			bSpaces[i] = new BoardSpaces(0, y - 72, Color.orange, i);
			i++;
		}
		
		return bSpaces;
		
	}
	
	public void paint(Graphics pane){
		
		for (int j = 0; j < bSpaces.length; j++){
			bSpaces[j].paint(pane);
		}
	}
	
}
