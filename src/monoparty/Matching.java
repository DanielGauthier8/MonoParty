import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import static java.util.Collections.*;
 
public class Matching extends JFrame implements ActionListener {
 
    /**
     * parts of code taken from:
     * https://www.java-forums.org/awt-swing/19997-help-make-memory-game.html
     */
    private static final long serialVersionUID = 1L;
    private JButton[] gameBtn = new JButton[16];
    private ArrayList<Integer> gameList = new ArrayList<Integer>();
    private int counter = 0;
    private int[] btnID = new int[2];
    private int[] btnValue = new int[2];
    
    int points = 0;
 
    public Matching() {
        init();
        drawMatch();
        setArrayListText();
       // setTitle("Matching");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 720);
        setVisible(true);
    }
 
    public void init() {
        for (int i = 0; i < gameBtn.length; i++) {
            gameBtn[i] = new JButton();
            gameBtn[i].setFont(new Font("Times New Roman", Font.BOLD, 30));
            gameBtn[i].addActionListener(this);
        }
    }
 
    public void drawMatch() {
        Panel gamePnl = new Panel();
        gamePnl.setLayout(new GridLayout(4,4));
        for (int i = 0; i < gameBtn.length; i++) {
            gamePnl.add(gameBtn[i]);
        }
 
        Panel buttonPnl = new Panel();
        buttonPnl.setLayout(new GridLayout(1, 0));
 
        add(gamePnl, BorderLayout.CENTER);
        add(buttonPnl, BorderLayout.SOUTH);
 
    }
 
    public void setArrayListText() {
        for (int i = 0; i < 2; i++) {
            for (int ii = 1; ii < (gameBtn.length / 2) + 1; ii++) {
                gameList.add(ii);
            }
        }
        shuffle(gameList);
    }
 
    public boolean isMatch() {
        if (btnValue[0] == btnValue[1]) {
            return true;
        }
        return false;
    }
    public int points(boolean match) {
    	if(isMatch() == true){
    		points += 15;
        	System.out.print(points);
    	}
    	return points;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        for (int i = 0; i < gameBtn.length; i++) {
            if (gameBtn[i] == e.getSource()) {
                gameBtn[i].setText("" + gameList.get(i));
                gameBtn[i].setEnabled(false);
                counter++;
                if (counter == 3) {
                    if (isMatch()) {
                        gameBtn[btnID[0]].setEnabled(false);
                        gameBtn[btnID[1]].setEnabled(false);
                    } else {
                        gameBtn[btnID[0]].setEnabled(true);
                        gameBtn[btnID[0]].setText("");
                        gameBtn[btnID[1]].setEnabled(true);
                        gameBtn[btnID[1]].setText("");
                    }
                    counter = 1;
                }
                if (counter == 1) {
                    btnID[0] = i;
                    btnValue[0] = gameList.get(i);
                }
                if (counter == 2) {
                    btnID[1] = i;
                    btnValue[1] = gameList.get(i);
                }
            }
        }
    }

}
