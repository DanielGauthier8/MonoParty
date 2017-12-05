import java.awt.Color;
import java.awt.Graphics;

public class BoardSpaces{
    private int spaceXSize, spaceYSize;
    private Color spaceColor;
    private int x,y;
    private int spaceIdentity;
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

    public BoardSpaces(){
        this(0,0,0);
    }

    public BoardSpaces(int xpos, int ypos, int id){
        primaryColor = new Color(85,140,137);
        textColor = new Color(64,64,64);
        secondaryColor = new Color(116,175,173);
        accentColor = new Color(217,133,59);
        whitePoint = new Color(236,236,234);
        spaceXSize = 127;
        spaceYSize = 72;
        spaceColor = accentColor;
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

        pane.setColor(textColor);
        pane.drawRect(x, y, spaceXSize, spaceYSize);
        
        if ((spaceIdentity % 2) == 0)
        {
           pane.setColor(secondaryColor);
           pane.fillOval(x + 40, y + 10, 50, 50);
        }
 
        else if (((spaceIdentity + 1) % 2) == 0)
        {
             pane.setColor(textColor);
            pane.fillRect(x + 40, y + 10, 50, 50);
        }
    }

}
