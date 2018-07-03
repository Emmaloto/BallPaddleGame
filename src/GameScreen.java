import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GameScreen {
	private Image box = new ImageIcon(getClass().getResource("pics/pause.png")).getImage(),
	              resume = new ImageIcon(getClass().getResource("pics/sprites/textresume.png")).getImage();
	              //pausetext = new ImageIcon(getClass().getResource("pics/sprites/textpause.png")).getImage();
	
	private boolean paused = false;
	private int w, h;
  
	public GameScreen(){
		
	    //g.drawImage(pausetext, 580, -100, 350, 250, null);
		w = box.getWidth(null);
		h = box.getHeight(null);
	} 
	
	public void draw(Graphics ga, double scaleX, double scaleY){
		/*
		int scaleX = (int)sx;
		int scaleY = (int)sy;
		*/
		if(paused){
	       ga.drawImage(box, (int)(90 * scaleX), (int)(150*scaleY), (int)(820 *scaleX), (int)(450*scaleY), null);
	       ga.drawImage(resume, (int)(200 *scaleX), (int)(150*scaleY), (int)(w*scaleX), (int)(h*scaleY), null);
	       /*
	       System.out.println("scaleX  => "+ (int)(200 *scaleX));
	       System.out.println("scaleX factor => "+ scaleX);
	       System.out.println("scaleX factor => "+ scaleX);
	       */
		}
	}
	
	public void pauseScreen(){
		//if(paused){

	       /*g.drawString("Press R to Resume", 200, 340);
	       g.drawString("Press P to Pause" , 200, 380);*/
		//}
		
		paused = true;
	}
	
	public void continueGame(){		
		paused = false;
	}
	
	public void startScreen(){
		
	}
}
