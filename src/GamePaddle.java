import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GamePaddle extends GameObject {
	private Image paddle = new ImageIcon(getClass().getResource("pics/sprites/Paddle.png")).getImage(); //Paddle
	private GameBall b;
	
	
	public GamePaddle(int bx, int by, int bw, int bh, GameBall ball){
		x = bx;
		y = by;
		w = bw;
		h = bh;
		b = ball;	
		
		type = "Paddle";
		setDefaultValues();
	}
	
	public void draw(Graphics g, double scaleX, double scaleY){
		scaleValues(scaleX, scaleY);
		
/*
		System.out.println(" paddle  x " + x);
		System.out.println(" paddle  y " + y);
		System.out.println(" ----------------- " );
		*/
		g.drawImage(paddle, (int)x, (int)y, (int)w, (int)h, null);

		// If ball and paddle collide top
		if(BrickPhysics.checkCollision(b, this)){ 

	      if(BrickPhysics.ifSideCollision()){
	    	  b.reverseX();
	      }else{      	  							  	
	    	  b.reverseY();	      
	    	  
	      //BrickPhysicsT.resetSide();
	      }
	      //b.addRect(new Rectangle((int)b.getX(), (int)b.getY(), 20, 20));
		}
	    
	}
	
	
	
	public void setPaddleX(int nx){
		//x = nx - w/2;
		setX(nx - w/2);
		/*
		System.out.println(" nx -> " +nx);
		System.out.println(" paddle  x " + getX());
		System.out.println(" paddle  y " + getY());
		System.out.println(" ----------------- " );
		*/
	}
	/*
	 * 0 - speed
	 * 1 - slow 
	 * 2 - shrink
	 * 3 - grow 
	 * 
	 * */
	
	public void setPowerUp(int index){
		if(index == 0){
			//b.setSpeed();
			b.speedUp();
		}else if(index == 1){
			b.slowDown();	
		}else if(index == 2){
			double w = getWidth();
			setWidth(w - 60);
		}else if(index == 3){
			double w = getWidth();
			setWidth(w + 60);			
		}
	}
	
}
