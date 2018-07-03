import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GameBall extends GameObject{

	private Image ball = new ImageIcon(getClass().getResource("pics/sprites/blueball.png")).getImage(); //Ball
    //private BufferedImage iball;
    
    private ArrayList<Rectangle> rects = new ArrayList<Rectangle>();

	public double velX, velY, startX, startY, originaldx, originaldy;
	
	public GameBall(int bx, int by, int bw, int bh){
		x = bx;
		y = by;
		w = bw;
		h = bh;
		
		startX = x;
		startY = y;
		velX = 5;
		velY = -velX;
		
		originaldx = velX;
		originaldy = velY;
		
		/*
	    try {	
		iball = ImageIO.read(this.getClass().getResource("pics/sprites/blueball.png"));
	    } catch (IOException ex) {
	    	System.out.println("Baaad!!");
	        //Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    */
	    setDefaultValues();
	}
	
	public void draw(Graphics2D g, boolean doIt){

	    /*
		AffineTransform originalTransform = g.getTransform();
        g.translate(x, y);
        g.scale((float)w/iball.getWidth(),(float)h/iball.getHeight());

        g.drawImage(iball, 0, 0, null);


	    g.setTransform(originalTransform);

		*/
		
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, (int)w, (int)h);
		
		for(Rectangle r:rects){
			g.setColor(new Color(GameUtilities.getRandomInteger(0, 255), GameUtilities.getRandomInteger(0, 255), GameUtilities.getRandomInteger(0, 255)));
			g.draw(r);
		}
	}
	
	public void draw(Graphics2D g, double scaleX, double scaleY){
		g.drawImage(ball, (int)x, (int)y, (int)w, (int)h, null);	
		
		//g.drawRect((int)x, (int)y, (int)w, (int)h);
	}
	
	public void moveBallTo(int nx, int ny){
		x = nx;
		y = ny;
	}
	
	public void moveBall(){
		x = x + velX;
		y = y + velY;
	}

	public void slowDown(){
		if(Math.abs(velX) > 2){ 
			velX = velX * .8;
			velY = velY * .8;
		}
	}
	
	public void speedUp(){
		
		if(Math.abs(velX) < 12){ 
			//System.out.println("Vel x b4: " +velX+"| Vel y b4: "+velY);
			velX = velX * 1.25;
			velY = velY * 1.25;
			/*
			System.out.println("Vel x afta: " +velX+"| Vel y afta: "+velY);
			System.out.println("   ");	
			*/		
		}

		
	}
	
	public void setSpeed(){
		x = x + velX;
		y = y + velY;
	}
	
	
	public void stop(){
		velX = 0;
		velY = 0;		
	
	}
	
	public void restart(){
		velX = originaldx ;
		velY = originaldy;		
	}
	
	public void reset(){
		x = startX;
		y = startY;
	}
	
	public void reverseX(){
		velX = -velX;
	}
	
	public void reverseX(float center){
		velX = -velX;
	velX += (getCenterY() - center) *0.5;
		
		if(velX > 3)
			velX  = 3;
		else if(velX < -3)
			velX = -3;
	}
	
	public void reverseY(float center){
		velY = -velY;
	velY += (getCenterX() - center) *0.5;
		
		if(velY > 3)
			velY  = 3;
		else if(velY < -3)
			velY = -3;
	}
	
	public void reverseY(){
		velY = -velY;
	}
	
	public void addRect(Rectangle newRect){
		rects.add(newRect);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
}
