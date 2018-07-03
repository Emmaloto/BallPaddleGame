//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class GameBricks extends GameObject{

	private Image brick = new ImageIcon(getClass().getResource("pics/sprites/Brick.png")).getImage();
	private GameBall b;
	private PowerUp powerUp;
	double xt = 0, yt = 0;
	
	int index = 0;
	int count;
	private boolean isHit = false;

	public GameBricks(int bx, int by, int bw, int bh, GameBall ball, GamePaddle p, int i, boolean special){
	     x = bx;
	     y = by;
	     w = brick.getWidth(null);
	     h = brick.getHeight(null);
	     

	     index = i;
	     b = ball;
	     
	     type = "Brick";
	     if(special)
	    	 powerUp = new PowerUp((int)x + 20, (int)y + 20, GameUtilities.getRandomInteger(0, 4), p); // 
	     else
	    	 powerUp = null;
	     
	     setDefaultValues();
	}
	
	public void draw(Graphics g, double scaleX, double scaleY){
		if(!isHit){
			scaleValues(scaleX, scaleY);
			g.drawImage(brick, (int)x, (int)y, (int)w, (int)h, null);
			count++;
			
			
			// If ball and brick collide
			if(BrickPhysics.checkCollision(b, this)){ 
		        isHit = true;
			    //System.out.println("Collision for brick "+ index +"!!");

		      if(BrickPhysics.ifSideCollision()){
		    	  b.reverseX();	  
		      }else{      	  							  	
		    	  b.reverseY();	      
		      }

		      if(powerUp != null) powerUp.loadPowerUp();
			}  			
		}
		
		//if(powerUp.displayed())
		if(powerUp != null) powerUp.draw(g, scaleX, scaleY);

	}

	
	// For debugging
	public int noOfTimesCalled() {
		return count;
	}
	
	
	public boolean hasBeenHit(){
		return isHit;
	}

	public boolean isOnScreen(){
		return !isHit;
	}	
	
	public int returnIndex(){
		return index;
	}	

}
