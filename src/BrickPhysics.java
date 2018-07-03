
	import java.awt.Rectangle;
	import javax.swing.JFrame;

// https://codeincomplete.com/posts/collision-detection-in-breakout/
	public class BrickPhysics {
		
		static boolean hitSide = false;
		static boolean ballFell = false;
		
		public static boolean checkCollision(GameObject ball, GameObject sq){
			Rectangle r1 = new Rectangle((int)ball.getX(), (int)ball.getY(), 
					                     (int)ball.getWidth(), (int)ball.getHeight());
            Rectangle r2 = new Rectangle((int)sq.getX(), (int)sq.getY(), 
            		                      (int)sq.getWidth(), (int)sq.getHeight());
          
            /*
			hitSide =  ball.getX() + ball.getWidth() + 3 <= sq.getX() + 0|| 
					   ball.getX() + 3 >= sq.getX() + sq.getWidth() + 0 ;    // Problem ?
					   
					               if(r1.contains(r2))
            	System.out.println("I got it!!!!");
*/
            Rectangle intersection = r1.getBounds().intersection(r2.getBounds());
            hitSide = intersection.height >= intersection.width;
            		
            return r1.intersects(r2);
             
             
            	 
		}

		// Returns true if left/right, false if top/bottom
		public static boolean ifSideCollision(){
			  return hitSide;
		}
		
		public static void resetSide(){
			hitSide = false;
		}
	
		
		public static boolean checkBoundaryX(GameObject ball, JFrame fr){

			boolean val = ball.getX() > fr.getWidth() - ball.getWidth() || ball.getX() < 0;	
			return val;	

		}

		public static boolean checkBoundaryY(GameObject ball, JFrame fr){

			ballFell = ball.getY() + ball.getHeight() > fr.getHeight();
			
			boolean val = ball.getY() > fr.getHeight() - ball.getHeight() || ball.getY() < 0;	
            return val;	
			
			
		}

		public static boolean ballDown(){
            return ballFell;	
						
		}		

	}
