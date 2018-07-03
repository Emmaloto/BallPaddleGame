import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BallMain extends JFrame implements MouseListener, 
                                                KeyListener{
  //private JPanel mouseP;
  private JLabel statusBar;
  //private boolean inLine;
  private SimpleGame game = new SimpleGame(this);
  

  
  public static void main(String args[]){
	  
	  new BallMain();
	  
  }

  public BallMain(){
      super("Brick Breaker");
	  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Close window on exit
 	  setSize(1100, 750);
	  setVisible(true);

	  add(game);
      statusBar = new JLabel("default");
      add(statusBar,  BorderLayout.SOUTH);
      
      addMouseListener(this);
      addKeyListener(this);
   }
	
  public void mouseClicked(MouseEvent e) {
		
	statusBar.setText(String.format("Click at %d, %d", e.getX(), e.getY()));
	
	//game.proceed();
  }


  public void mousePressed(MouseEvent e) {
	
  }


  public void mouseReleased(MouseEvent e) {
	
  }


  public void mouseEntered(MouseEvent e) {
	statusBar.setText("You entered the area");
	//getContentPane().setBackground(Color.RED);	

  }


  public void mouseExited(MouseEvent e) {

	statusBar.setText("You left the area");
	//getContentPane().setBackground(Color.WHITE);	
	//inLine = false; 	
  }

  public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_P){
    	System.out.printf("\n P is pressed!\n\n"); 
    	if(game.isRunning()) game.pause();
	    
    }else if(e.getKeyCode() == KeyEvent.VK_Q){
    	System.out.printf("\n Q is pressed!\n\n"); 
    	if(!game.isRunning()) game.proceed();
    	
    }else if(e.getKeyCode() == KeyEvent.VK_R){
    	System.out.printf("\n R is pressed!\n\n"); 
    	//restartGame();
    	game.restart();
    }else if(e.getKeyCode() == KeyEvent.VK_H){
      	System.out.printf("\n H is pressed!\n\n"); 
      	game.toggleHelp();
  	}    
  }


  public void keyReleased(KeyEvent e) {

	
  }


  public void keyTyped(KeyEvent e) {

	
  }
}