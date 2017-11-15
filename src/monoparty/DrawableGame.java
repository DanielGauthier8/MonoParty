
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;


public class DrawableGame extends Settings implements DrawableInterface{
	private static int boardHeight;
	private static int boardWidth;
	private Color boardColor;
	private int x, y;
	private BoardSpaces [] bSpaces;
	
	public DrawableGame(){
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
		
		while (y > boardHeight -72){
			bSpaces[i] = new BoardSpaces(boardWidth - 128, y + 72, Color.orange, i);
			i++;
		}
		while (x > boardHeight -128){
			bSpaces[i] = new BoardSpaces(x - 128, y + 72, Color.orange, i);
			i++;
		}
		while (y < boardWidth -72){
			bSpaces[i] = new BoardSpaces(0, y - 72, Color.orange, i);
			i++;
		}
		
		return bSpaces;
		
	}
	
	public void paint(Graphics pane){
		
		
	}

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveTo(int absX, int absY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
