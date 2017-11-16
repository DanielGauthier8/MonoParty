
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
	//Font variable
        private final Font headings;
        //Font variable
        private final Font text;
        //The main game color
        private final Color primaryColor;
        //Secondary color
        private final Color secondaryColor;
        //Accent or tertiary color
        private final Color accentColor;
        //The text color
        private final Color textColor;
        //White point
        private final Color whitePoint;
        //Start x
        private int theX;
        //Start y
        private int theY;
    
	public DrawableGame(){
            primaryColor = new Color(85,140,137);
            textColor = new Color(64,64,64);
            secondaryColor = new Color(116,175,173);
            accentColor = new Color(217,133,59);
            whitePoint = new Color(236,236,234);

            theX = 0;
            theY = 0;
            headings = new Font("Times New Roman",Font.PLAIN,28);
            text = new Font("Times New Roman",Font.PLAIN,16);
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
			x = x + 127;
			bSpaces[j] = new BoardSpaces(x + 0, 0, j);
			i++;
			j ++;
		}
		
		i = 0;
		
		while (i < bSpaces.length/4){
			y = y + 72;
			bSpaces[j] = new BoardSpaces(1140, y, j);
			i++;
			j ++;
		}
		
		i = 0;
		x = 1280;
		
		while (i < bSpaces.length/4){
			x = x - 127;
			bSpaces[j] = new BoardSpaces(x - 13 , 648, j);
			i++;
			j ++;
		}
		
		i = 0;
		y = 720;

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
                
        //Background
        pen.setColor(primaryColor);
            pen.fillRect(theX + 0, 0, 1280, 720);
      
        for (int j = 0; j < bSpaces.length; j++){
			bSpaces[j].paint(pen);
		}
    }
	
}
