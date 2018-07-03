import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

@SuppressWarnings("serial")
public class SimpleGame extends JComponent implements ActionListener, 
													  MouseMotionListener{
	
	private Timer tm = new Timer(10, this);
	
			   
	//private int count;
	private JFrame fr;
	private final int DEFAULT_W = 1000, DEFAULT_H = 1000;
	private double scaleX, scaleY;
	
	private GameBall ball = new GameBall(0,0,0,0);
	private GamePaddle paddle = new GamePaddle(0,0,0,0,ball);
	private GameBricks bricks[] = {new GameBricks(0, 0, 0, 0, ball, paddle, 0, true)};
	private GameBricks testBrick =  new GameBricks(0,0,0,0,ball, null, 999, true);
	private Graphics2D g2;
	//private boolean finished = false;
	private boolean gameGoing = true, loadHelp = false;
	
	private Image endBG, helpBG;
	private GameScreen pauseScr  = new GameScreen();;
	private Screen infoScreen, helpScreen;	
	private Font f;
	private String [] endText, endFailText, helpText;
	
	public SimpleGame(JFrame window){
		fr = window;
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Close window on exit
		fr.setSize(DEFAULT_W, DEFAULT_H);
		fr.setVisible(true);
		fr.getContentPane().setBackground(new Color(217,217,217));
	    fr.add(this);
	    fr.addMouseMotionListener(this);
	    
	    scaleX = fr.getWidth()/(double)DEFAULT_W;
	    scaleY = fr.getHeight()/(double)DEFAULT_H;
	    
	    //bricks[0] = new GameBricks(0, 0, 0, 0, ball, paddle, 0, true);
	    
	    loadImages();
	    setup();	    
	}
	
	
	private void setup() {

		int xBricks = 150  // x of bricks
				   ,yBricks = 20  // y of bricks
				   ,wBricks = new ImageIcon(getClass().getResource("pics/sprites/Brick.png")).getIconWidth()
				   ,hBricks = new ImageIcon(getClass().getResource("pics/sprites/Brick.png")).getIconHeight(); 
		bricks = new GameBricks[25];
		
	    ball = new GameBall(400, 600, 50, 50);
		//ball = new GameBall(0, 0, 50, 50);
	    paddle = new GamePaddle(100, 700, 300, 50,ball);  // y -> 300
	    testBrick = new GameBricks(400, 50, 40, 15, ball, paddle, 999, true);
	    //testBrick = new GameBricks(0, 0, 40, 15, ball, 999);

        // Assign val to bricks
	    for(int i = 0; i < bricks.length; i++){		    	      
	    	if(i % 5 == 0){
		          xBricks = 150;
		          yBricks = yBricks + hBricks + 20;
			  }
		        int rand = GameUtilities.getRandomInteger(1, 30);
		        boolean power;
		        if(rand % 3 == 0)
		        	power = true;
		        else 
		        	power = false;
		        
		  	  bricks[i] = new GameBricks(xBricks, yBricks, wBricks, hBricks, ball, paddle, i, power);
		      xBricks = xBricks + wBricks + 20;		    		      	    
	    }		
	    
	  //endText
	    //infoScreen = new Screen(endBG, fr.getWidth(), fr.getHeight());
	    //infoScreen.changeScreenBackground(endBG);
	    infoScreen = new Screen(endBG);
	    infoScreen.changeTextPosition(70, 140);
	    infoScreen.setTitle("BETA TEST v 1.0");
	    infoScreen.changeTitlePosition(250, 100); 
	    infoScreen.setPhrase(endText, 30);
	    
	    helpScreen = new Screen(helpBG);
	    helpScreen.changeTextPosition(70, 90);
	    helpScreen.setTitle("Block Breaker - HELP");
	    helpScreen.changeTitlePosition(200, 80); 
	    helpScreen.setPhrase(helpText, 20);
	    
	    // Fonts
	    Font toUse = fr.getFont();
	    if(f != null) toUse = f;
	    infoScreen.setTextFont(new Font(toUse.getFontName(), toUse.getStyle(), 25));
	    helpScreen.setTextFont(toUse);
		
	    tm.start();
	    
	    gameGoing = true;
	    loadHelp = false;
	}
	
    // Actual drawing on frame
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		g2 = (Graphics2D)g;
		
		// For scaling
		double w = fr.getWidth();
		double h = fr.getHeight();
	    scaleX = w/1000.0;
	    scaleY = h/800.0;

		g2.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g2.drawString("Press h for game help.", 0, 20 );
	    //AffineTransform tr = GameUtilities.getTransform(10, 10, 0, 1.5, 1.5);
	    
		if(gameGoing){
			paddle.draw(g2, scaleX, scaleY);		
			//testBrick.draw(g2, scaleX, scaleY);				
			ball.draw(g2, scaleX, scaleY);	
			
			boolean finished = true;
			
			//Draw bricks
			for(int i = 0; i < bricks.length; i++){			
			  //if(bricks[i].isOnScreen()){
				bricks[i].draw(g2, scaleX, scaleY);			  
				finished = finished && bricks[i].hasBeenHit();
			  //}
			}

			if(finished){ 
				infoScreen.setPhrase(endText, 20);
				stopGame(System.currentTimeMillis()); //gameGoing = false;  				
			}

			// Draws the pause and help screens
			pauseScr.draw(g, scaleX, scaleY);
			if(loadHelp) helpScreen.drawScreen(0, 0, g2);
			
		}else if(!gameGoing && infoScreen != null) infoScreen.drawScreen(0, 0, fr.getWidth(), fr.getHeight(), g2);
	}
		
	
	public void actionPerformed(ActionEvent e) {

	  if(e.getSource() == tm){
	    ball.moveBall();
	    
	    // If ball passes side of screen, switch direction
	    if(BrickPhysics.checkBoundaryX(ball, fr))
	    	ball.reverseX();	    
	    
	    // If ball passes top of screen, switch direction
	    // If ball passes bottom of screen, fail game
	    if(BrickPhysics.checkBoundaryY(ball, fr))
	    	if(BrickPhysics.ballDown()){ 
	    		//gameGoing = false; 
	    		infoScreen.setPhrase(endFailText, 20);
	    		stopGame(System.currentTimeMillis());
	    	}else
	    		ball.reverseY();
	    
	    repaint();
	  }
	  
	}
	


	// For debugging
	public void moveBrickTo(int x, int y) {
      testBrick.setX(x - testBrick.getWidth()/2);
      testBrick.setY(y - testBrick.getHeight());
      repaint();
	}

	/*
	public void displayHelp() {
		loadHelp = true;
		tm.stop();
	}

	public void closeHelp() {
		loadHelp = false;
		tm.start();
		
	}
	The bottom method does both
	*/
	
	public void toggleHelp() {
		loadHelp = !loadHelp;
		
		if(tm.isRunning()) tm.stop();
		else 			   tm.start();
		
		repaint();
	}
	
	public void pause() {
		pauseScr.pauseScreen();
		tm.stop();
		
	    repaint();
	}
	
	public void proceed(){
      pauseScr.continueGame();
      tm.start();  
      
      repaint();
	}

	public boolean isRunning(){
	      return tm.isRunning();       
	}
	
	public void stopGame(long startTime) {

		long duration = System.currentTimeMillis() - startTime;
		//System.out.println( "Starting...");
		while(duration < 3000){
			duration = System.currentTimeMillis() - startTime;
			//System.out.println( "Duration " + duration);
			if(duration % 100 == 0){
				repaint(); 
				//System.out.println( "REPAINTING... ");
				
			}
		}
		
		//System.out.println( "Done! Stopping...");
		tm.stop();
		gameGoing = false;
		
	    repaint();
	}

	public void restart(){
		setup();
		repaint();
	}
	
	private void loadImages(){

		try {

			endBG = ImageIO.read(this.getClass().getResource("pics/end-bg.png"));
			helpBG = ImageIO.read(this.getClass().getResource("pics/help-bg.jpg"));

			/*
			boolean z = endBG != null;
			System.out.println( " Is endBG LOADED?| " + z);
			System.out.println( "  endBG w| " + endBG.getWidth(null));
			*/
			f = GameUtilities.getFont("res/ComickBook_Simple.ttf", 27f, this);
			
			
			endText = GameUtilities.getInputFromFile("res/end-txt.txt", this);
			endFailText = GameUtilities.getInputFromFile("res/fail.txt", this);
			helpText = GameUtilities.getInputFromFile("res/game-help.txt", this);
		} catch (IOException | NullPointerException e ) {

			e.printStackTrace();
		}
		
		Font resize = f;
		f = new Font(resize.getFontName(), resize.getStyle(), 13);
	}	

	// Mouse actions
	public void mouseDragged(MouseEvent e) {
		moveBrickTo(e.getX() , e.getY());
	}


	public void mouseMoved(MouseEvent e) {
			paddle.setPaddleX(e.getX());	
	}



	
}
