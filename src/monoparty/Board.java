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
		int j = 0;
		
		while (i < bSpaces.length/4){
			x = x + 128;
			bSpaces[j] = new BoardSpaces(x, 0, j);
			i++;
			j ++;
		}
		
		i = 0;
		
		while (i < bSpaces.length/4){
			y = y + 72;
			bSpaces[j] = new BoardSpaces(1152, y, j);
			i++;
			j ++;
		}
		
		i = 0;
		x = 1408;
		
		while (i < bSpaces.length/4){
			x = x - 128;
			bSpaces[j] = new BoardSpaces(x, 648, j);
			i++;
			j ++;
		}
		
		i = 0;
		y = 792;

		while (i < bSpaces.length/4){
			y = y - 72;
			bSpaces[j] = new BoardSpaces(0, y, j);
			i++;
			j ++;
		}
		
		
		return bSpaces;
		
	}
	
	public void paint(Graphics pane){
		
		for (int j = 0; j < bSpaces.length; j++){
			bSpaces[j].paint(pane);
		}
	}
	
}
