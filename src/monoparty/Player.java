package dodger;

import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Player extends JPanel {
	//Timer t = new Timer(5,this);
    private boolean invulnerable = false;
    private int lives = 3;
    private final int size=25;
    private int x=640, y=600;
    double velx =0, vely=0;
    int xL = 0,xR = 1280,yU =0 ,yD = 690;
    private int vkUp, vkDown, vkLeft, vkRight;
    Color color = new Color(255, 0, 0);


    public Player(int vkUp, int vkDown, int vkLeft, int vkRight) {
            // TODO Auto-generated constructor stub
             this.vkUp = vkUp;
         this.vkDown = vkDown;
         this.vkLeft = vkLeft;
         this.vkRight = vkRight;
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);

    }

    //public void player(int up, int down,int left,int right){
            //t.start();
            //addKeyListener(this);

    //}

    public boolean getInvulnerable() {
        return invulnerable;
    }
    
    public void setInvulnerable(boolean bool) {
        invulnerable = bool;
    }
    
    @Override
    public int getWidth() {
        return this.size;
    }

    @Override
    public int getHeight() {
        return this.size;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void subtractLife() {
        this.lives--;
    }
    
    public int getLives() {
        return this.lives;
    }

    public void update(){
        if(x>xL){
            if(velx<0) {
            x += velx;
            }

        }
        if(x<xR-30) {
            if(velx>0) { 
                x += velx;
            }
        }
        if(y>yU) {
            if(vely<0) {
                y += vely;
            }
        }
        if(y<yD-30) {
            if(vely>0) {
                y += vely;
            }
        }
            /*if(x>xL && x<xR-30 && y>yU && y<yD-30){
            //repaint();
            x += velx;
            y += vely;
            }*/


    }
    public void pressed(int keyCode) {
        if (keyCode == vkUp){
        	vely = -2.5;
        	velx = 0;
        }
        else if (keyCode == vkDown){
        	vely = 2.5;
        	velx = 0;
        }
        else if (keyCode == vkLeft){
           	velx = -2.5;
           	vely = 0;
        }
        else if (keyCode == vkRight){
            velx = 2.5;
            vely = 0;
        }
    }

    public void released(int keyCode) {
        if (keyCode == vkUp || keyCode == vkDown)
            vely = 0;
        else if (keyCode == vkLeft || keyCode == vkRight)
        	velx = 0;
    }


	public void paint(Graphics g){
            g.setColor(color);
	    //update();
	    g.fillRect(x,y,size,size);
	    // t.start();
		}
}
