import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowStateListener;

public class Executable extends Frame{
	private int lastX, lastY; // To keep the mouse location
	private Board board;
	private BoardSpaces spaces;
	private Player player;
	private Opponent opponent;
	private UneFenetre window; //unefentre window
	private WindowAdapter state;
	
	
	public Executable(){
		board = new Board();
		
		setSize(board.getBoardHeight(), board.getBoardWidth());
		setLocation(25, 50);
		setBackground(board.getBoardColor());
	
		window = new UneFenetre();// to allow for window closing
		addWindowListener(window);
		addWindowStateListener(state);
		
		setVisible(true);
	}
	
	public void paint(Graphics pane){
		board.paint(pane);
		
		
	}
	
	public void check(){
		
		
		
	}
	
	public void mouseClicked(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
		lastX = event.getX(); // Update the mouse location
		lastY = event.getY();
		check();

	}

	public void mouseReleased(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	
}
