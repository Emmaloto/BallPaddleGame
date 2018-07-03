import java.awt.Rectangle;

import javax.swing.JFrame;

public class Junk {
	
	public static boolean checkBoundaryX(GameObject ball, JFrame fr){
		Rectangle b1 = new Rectangle(fr.getX()+fr.getWidth(), 0, 2, fr.getHeight());
		//g.drawRect((int)x, (int)y, (int)w, (int)h);
		
		//System.out.println(" finished well " + !gameGoing);
		
	  	//if(finished) System.out.println("Game finished!"); //ball.stop();
		//else finished = true;
	  	/*
		if(monitor){
		for(int i = 0; i < bricks.length && bricks[i] != null; i++){			
			System.out.println(i + " brick " + bricks[i].hasBeenHit());
		}
		System.out.println(" gameGoing " + gameGoing);
		System.out.println(" finished " + finished);
		System.out.println("  ");
		}

		monitor = false;
		*/
		
		/*

	    System.out.println(" Width -- " + fr.getWidth());	
	    System.out.println(" W -- " + w);
	    System.out.println(" Scaleee -- " + fr.getWidth()/1000);
		*/
		//System.out.printf(" Scale F-- %.3f \n", (double)(fr.getWidth()/1000.0) );
		
		
		//if(GameScreen.paused == false){
		
		//gameGoing = true;
		System.out.println(" gameGoing 1--" + true);
		//System.out.println(" finished 1--" + finished);
		System.out.println("  ");
		
		
	    /*
        // Delete brick if hit
	    for(int i = 0; i < bricks.length && !bricks[i].hasBeenHit(); i++)
		  if(bricks[i].hasBeenHit())
			 bricks[i] = null;
		
		 /* if(testBrick!= null&&testBrick.hit())
			  testBrick = null;	    */
		  
		//System.out.println(" brick "+ i +" value -> " + bricks[i].hasBeenHit());
		
		  /*
		  System.out.println(" finished in " + finished);
		  boolean don = bricks[i] != null;
		  System.out.println(" NULLORNOT ----------------- " + don);
		  */
		
		 /* if(bricks[i].isOnScreen())
	     bricks[i].draw(g2, scaleX, scaleY);
	  else;
		  //bricks[i].draw(g2, scaleX, scaleY);
	  //System.out.println(" finished b4 " + finished);
	   * */
		//if( bricks[i] != null)
		
		/*
		System.out.println(" gameGoing 2 " + gameGoing);
		System.out.println(" finished 2 " + finished);
		System.out.println("  ");
		*/
		//}

		//if(finished) gameGoing = false;  
		//}else if(finished) gameGoing = false;  
		
	     /*
		x = x*scaleX; 
		y = y*scaleY;
	    w = w*scaleX;
	    h = h*scaleY;
	    */
		
		//g.drawImage(brick, (int)(x*scaleX), (int)(y*scaleY), (int)(y*scaleY), (int)(h*scaleY), null);
		//g.drawRect((int)x, (int)y, (int)w, (int)h);
		
		  /*
		// If ball and paddle collide top
		if(BrickPhysics.checkCollisionTop(b, this))
			b.reverseY();
		
		// If ball and paddle collide sides
		else if(BrickPhysics.checkCollisionLeftSide(b, this) || BrickPhysics.checkCollisionRightSide(b, this))
	    	b.reverseX();
	    */
		
		
		/*
		// If ball and paddle collide top
		if(BrickPhysics.checkCollisionTop(b, this) || BrickPhysics.checkCollisionTop(b, this)){
			b.reverseY();
			b.addRect(new Rectangle((int)b.getX(), (int)b.getY(), 20, 20));
			//b.stop();
		
		// If ball and paddle collide sides
		}else if(BrickPhysics.checkCollisionLeftSide(b, this) || BrickPhysics.checkCollisionRightSide(b, this)){
	    	b.reverseX();
	    	b.addRect(new Rectangle((int)b.getX(), (int)b.getY(), 20, 20));
			//b.stop();
		}
		
		g.setColor(new Color(30 , 230, 56));
		//g.fillOval((int)b.x, (int)b.y, 20, 20);
*/
		
		// if ball hits paddle
		
		//if(yB + hBall >= yP && (xB + wBall > xP && xB < xP + wPadd) ){
		//System.out.printf("%d xball   %d yball   %d xPadd  %d yPadd  %d wpadd  %d hball\n\n", 
		//		              xB,        yB, 	  xP, 		yP, 	wPadd, 		hBall);
		//public void reset(){}
		
        Rectangle b2 = null;//new Rectangle(ball.getX(), ball.getY(), 	ball.getWidth(), ball.getHeight());
		/*boolean val = ball.getX() > fr.getWidth() - ball.getWidth() || ball.getX() < 0;	
		  
		*/
        
    	//b.reverseY(getCenterX());
/*		   	 System.out.println(BrickPhysicsT.checkCollisionSide());
	   	 System.out.printf("b.reverseY();\n\n");*/
        
   	    //b.reverseX(getCenterY());
   	 /*System.out.println(BrickPhysicsT.checkCollisionSide());
   	 System.out.printf("b.reverseX();\n\n");*/
		return b1.intersects(b2);
	}

	public static boolean checkBoundaryY(GameObject ball, JFrame fr){
		Rectangle b1 = new Rectangle(0, fr.getY()+fr.getHeight(), fr.getWidth(), 2);
        Rectangle b2 =  null;//new Rectangle(ball.getX(), ball.getY(), 	ball.getWidth(), ball.getHeight());
        return b1.intersects(b2) ;
	//	boolean val = ball.getY() > fr.getHeight() - ball.getHeight() || ball.getY() < 0;	
      //  return val;	
		
    	/*private Image ball = new ImageIcon(getClass().getResource("blueball.png")).getImage(); //Ball	
    	private Image paddle = new ImageIcon(getClass().getResource("Paddle.png")).getImage(); //Paddle
    	private Image bricks[] = new Image[36];

    	
    	private boolean repaintBall = true
    			      , repaintPaddle = true
    				  , paintBricks = true;*/
        
        
	}
	/*
	 * xP = 100  //x of paddle
			   ,yP = 800  //y of paddle
			   ,xB = 0    //x of ball
			   ,yB = 50   //y of ball
			   ,dxB = 1   //change in x of ball
			   ,dyB = dxB //change in y of ball
			   //,pOffset = 0//paddle error
			   ,wBall = 50   // width of ball
			   ,hBall = 50   // height of ball
			   ,wPadd = 300   //width of paddle
			   ,hPadd = hBall   //height of paddle
			   
			   
	 * 		System.out.printf("b.getX() %d\n", b.getX());
	System.out.printf(" sq.getX() + sq.getWidth()  %d\n\n", getX() + getWidth());
	System.out.printf("ball.getX() >= sq.getX() + sq.getWidth() +1 %s\n\n",
			b.getX()+1 >= getX() + getWidth() );*/
	public void simplegame(){
		/*	System.out.println("Brick 4: "+bricks[4].getX()+","+bricks[4].getY()+
		","+bricks[4].getWidth()+","+bricks[4].getHeight() );

bricks[4].draw(g);
System.out.println("Brick 5: "+bricks[5].getX()+","+bricks[5].getY()+
		","+bricks[5].getWidth()+","+bricks[5].getHeight() );
bricks[5].draw(g);

/*	System.out.println("Brick 4: "+bricks[4].getX()+","+bricks[4].getY()+
		","+bricks[4].getWidth()+","+bricks[4].getHeight() );
bricks[6].draw(g);

System.out.println("Brick 4: "+bricks[4].getX()+","+bricks[4].getY()+
		","+bricks[4].getWidth()+","+bricks[4].getHeight() );
bricks[10].draw(g);
	
	System.out.println("Ball: "+ball.getX()+","+ball.getY()+
	","+ball.getWidth()+","+ball.getHeight() );  
System.out.printf("\n\n");			
*/
//	System.out.printf("\n\n\n\n");		
	}
	
	// These 2 checks are conflicting!!!!
	// If ball and paddle collide sides
	/*else if(BrickPhysicsT.checkCollisionLeftSide(b, this)){
		c ++;
    	
    System.out.printf("\n\n\n");
    System.out.printf("Line %d\n", c);
	System.out.printf("b.getX()  %d\n", b.getX());
	System.out.printf("b.getY()  %d\n", b.getY());
	System.out.printf("b.getX() + b.getWidth()  %d\n", b.getX()+b.getWidth());
	System.out.printf("b.getY()) + b.getHeight() %d\n", b.getY()+b.getHeight());
	System.out.printf("\n-------------------------\n");
	System.out.printf("brick.getX()  %d\n",x);
	System.out.printf("brick.getY()  %d\n", y);
	System.out.printf("brick.getX() + brick.getWidth()  %d\n", x + w);
	System.out.printf("brick.getY()) + brick.getHeight() %d\n", y+h);
	System.out.println(b.getX() + b.getWidth() >= x);
	System.out.println(b.getY() + b.getHeight() >= y);
	System.out.println(b.getY()  <= y +  h );
	b.reverseX();
	}else if(BrickPhysicsT.checkCollisionRightSide(b, this))
    	b.reverseX();	    
	else if(BrickPhysicsT.checkCollisionBottom(b, this))
		b.reverseY();*/
	
	
	
	
	
	// Your problem is your conditions set, maybe they shouldn't be independent
	
/*	public static boolean checkCollisionTop(GameObject ball, GameObject sq){
		
		
		boolean val  = ball.getX() + ball.getWidth() >= sq.getX() &&  // Ball is touching top of paddle
				
				(ball.getY() + ball.getHeight() >= sq.getY() &&         // Ball is about to enter paddle
						ball.getX() < sq.getX() + sq.getWidth());     // Ball is not past right corner of paddle
		;
		return val;
		
		
		return checkCollision(ball, sq);
		
	}*/
	
	//Simplegame
	/*g.setColor(Color.GREEN);
	g.fillRect(x, 550, w, h);
	
	
	Graphics2D g2 = (Graphics2D)g; 
	g2.draw(ball);*/
	
	/*		if(BrickPhysicsT.checkCollision(b, this)){
	if(b.getX() + b.getWidth() >= getX() && b.getX() <= getWidth() + getX()){
		b.reverseX();
		System.out.println(xt + " x is reversed.");
		xt++;
	}
	 if(b.getY() + b.getHeight() >= getY()&&b.getY() <= getHeight() + getY()){
		b.reverseY();
		System.out.println(yt + " y is reversed.");
		yt++;
		}
	}*/

	
    
    //for(int i = 0; i < bricks.length; i++)
     // bricks[i] = new ImageIcon(getClass().getResource("Brick.png")).getImage();
    
	
	
	
	
	
	
	
    //g.drawImage(paddle, xP, yP, wPadd, hPadd, null);

	
    //g.drawImage(ball, xB, yB, wBall, hBall, null);

	/*	if(xB > fr.getWidth() - wBall || xB < 0)  
	  dxB = -dxB;
	 
	//if y of ball is not within box, switch direction
	if(yB > fr.getHeight() - hBall*2|| yB < 0)
	  dyB = -dyB;
	}*/

    // construct bricks

	
	
	//Mouseevt
	  //getContentPane().setBackground(new Color(217,217,217));
    
    
    //mouseP = new JPanel();
    //mouseP.setBackground(Color.WHITE);
    //add(mouseP, BorderLayout.CENTER);
}
