
import javax.swing.JComponent;

// GameObject class for brickbreaker game
public abstract class GameObject {
	// orx, ory, orw, orh are the original 1000 by 1000 coordinates and dimensions
	// x, y, w, h are the scaled quantities for a resized screen, also used for calculating
	
	// If you need to change something, changing the original is recommended, since that is used to calculate
	protected double x, y, w, h;
	protected double orx, ory, orw, orh;
	protected double sX = 1, sY = 1;
	
	protected String type;
	public boolean applyScaling = true;
	
	public void setDefaultValues(){
		orx = x;
		ory = y;
		orw = w;
		orh = h;
	}
/*
	// Not yet in use
	public void draw(Graphics g, double sx, double sy){
		scaleValues(sx, sy);
	}
	*/
	public void scaleValues(double scaleX, double scaleY){
		//if(applyScaling){
			x = orx*scaleX; 
			y = ory*scaleY;
		    w = orw*scaleX;
		    h = orh*scaleY;
		    applyScaling = true;
		    
		    sX = scaleX; 
		    sY = scaleY;
		    		
		//}//else{applyScaling = true;}
	}	
	
	public void setX(double nx){
		//x = nx;
		orx = nx/sX;
		
		//applyScaling = false;
	}
	
	public void setY(double ny){
		//y = ny;
		ory = ny/sY;
		//applyScaling = false;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setWidth(double nw){
		orw = nw/sX;
	}
	
	public void setHeight(double nh){
		orh = nh/sY;
	}	
	public double getWidth(){
		return w;
	}
	
	public double getHeight(){
		return h;
	}
	
	public double getCenterX(){
		return x + w/2;
	}
	
	public double getCenterY(){
		return y + h/2;
	}
	
	public void update(JComponent e){
		e.repaint();
	}
}
