
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Gauthier
 */
public class DrawableIntro extends Intro implements DrawableInterface{

     //The max x
    private int maxX;
    //The max y
    private int maxY;
    //Font variable
    private final Font myFont;
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
    
    
    public DrawableIntro()
    {
        this(1280, 720);
    }
    
    public DrawableIntro(int theMaxX, int theMaxY)
    {
        primaryColor = new Color(85,140,137);
        textColor = new Color(64,64,64);
        secondaryColor = new Color(116,175,173);
        accentColor = new Color(217,133,59);
        whitePoint = new Color(236,236,234);
        
        
        myFont = new Font("Times New Roman",Font.PLAIN,28);
        maxX = theMaxX;
        maxY = theMaxY;
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
        pen.setColor(primaryColor);
            pen.fillRect(0, 0, maxX, maxY);
            
        //Areas
        pen.setColor(secondaryColor);
            pen.fillRect(100, 50, 300, 200);
            pen.fillRect(400, 50, 300, 200);
            pen.fillRect(100, 450, 1000, 200);
        
           // pen.fillRect(100, 400, 700, 200);
        pen.setColor(textColor);
            pen.setFont(myFont);
            pen.drawString("Welcome to MonoParty!", (720/2)+50, 30);
            pen.drawString("Instructions:", 128, 428);
    }
    
}
