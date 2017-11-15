


import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Represents the shape that contains 
 * color and the position of the object */
public interface DrawableInterface {
    //Data fields
    /**@return the xPostion */
    int getX();
    
    /**@return the yPostion */
    int getY();
    
    /**Moves the shape to the absolute value of x and y */
    void moveTo(int absX, int absY);
    
    /**Moves the shape by x and y values */
    void moveBy(int dX, int dY);
    
    /**@return the yPostion */
    void move();
    
    /**@return the velocity of x*/
    double getVelocityX();
    
    /**@return the velocity of y */
    double getVelocityY();
    
     /**sets the velocity of a shape*/
    void setVelocity(double dvX,double dvY);
    
     /**@return the color of the shape*/
    Color getColor();
    
     /**sets the color*/
    void setColor(Color theColor);
    
     /**Calls the Graphics pen*/
    void draw(Graphics pen);
}
