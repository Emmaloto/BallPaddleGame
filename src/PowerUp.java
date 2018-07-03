import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PowerUp extends GameObject {

	private int powerID;
	private GamePaddle paddle;
	public boolean drawPower = false;
	private Image powerups[] = new Image[5];
	private Image power;
	
	private int velY = 1;
	
	public PowerUp(){
		drawPower = false;
	}
	
	public PowerUp(int px, int py, int index, GamePaddle p){
		x = px;
		y = py;
		w = 50;
		h = 50;
		paddle = p;
		
		powerID = index;
		loadImages();
		setDefaultValues();
		
		if(powerID >= powerups.length) powerID = powerID % powerups.length;
		
		for(int i = 0; i < powerups.length; i++)
			if(i == powerID)
				power = powerups[i];
		
		//System.out.println("Power:  " + powerID);
		//drawPower = true;
	}
	
	public void draw(Graphics g, double scaleX, double scaleY){
		
		if(drawPower){
			//System.out.println("draw b4 "+ drawPower);
			scaleValues(scaleX, scaleY);
			
			// If paddle collects powerUp
			if(BrickPhysics.checkCollision(this, paddle)){ 
				drawPower = false;
				paddle.setPowerUp(powerID);
				//System.out.println("draw "+ drawPower);
			}else if(y >  paddle.getY() + paddle.getHeight()){
				drawPower = false;
			}
			
			if(power != null){ g.drawImage(power, (int)x, (int)y, (int)w, (int)h, null); }
			drop();
			
			//drawPower = true;
			//System.out.println("draw afta "+ drawPower);
			// System.out.println("Power displaying:  " + powerID);
		}
		
		//System.out.println("draw => "+ drawPower);
		
	}
	
	private void drop(){
		// setX(x + 1); should work too
		ory = ory + velY;
	}
	
	public void loadPowerUp(){
		drawPower = true;
		//System.out.println("Are we good to draw? "+ drawPower);
	}
	
	public boolean displayed(){
		return drawPower;
	}
	
	private void loadImages(){
		Image speed = null, 
			  shrink = null, 
			  grow = null, 
			  slow = null;
	
		try {

			speed  = ImageIO.read(this.getClass().getResource("pics/power-ups/speed.png"));
			shrink = ImageIO.read(this.getClass().getResource("pics/power-ups/shrink-2.png"));
			grow   = ImageIO.read(this.getClass().getResource("pics/power-ups/grow.png"));
			slow   = ImageIO.read(this.getClass().getResource("pics/power-ups/slow.png"));

			
		} catch (IOException e) {

			e.printStackTrace();
		}		
		
		powerups = GameUtilities.placeImages(speed, slow, shrink, grow);
	}
}
