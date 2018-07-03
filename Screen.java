import java.awt.*;
import java.awt.geom.AffineTransform;
/*https://stackoverflow.com/questions/258486/calculate-the-display-width-of-a-string-in-java*/
public class Screen {
	
	private Image s;
	
	private String message;
	private String [] text;
	
	private int textX , textY, titleX, titleY, space, photoWidth, photoHeight;
	private Color textcolor;
	private Font font;
	//private int textsize;
	private boolean showText;
			
	public Screen(Image bg, int photoW, int photoH){
		
		s = bg;
		message = "Your text goes here...";
		String t[] = {"TEXT", "TEXT"};
		text = t;
		
		textX = 30;
		textY = 30;
		textcolor = Color.WHITE;
		
		photoWidth = photoW;
		photoHeight = photoH;
		
		boolean a = bg == null;
		boolean b = s == null;
		System.out.println(" bg --" + a);
		System.out.println("  s  " +  b);
		System.out.println("++++++++++++++");
	}

	public Screen(Image bg){
		int pw = 800;
		int ph = 800;
		if(bg != null){
			pw = bg.getWidth(null);
			ph = bg.getHeight(null);
		}
		new Screen(bg, pw, ph);
	}
	
	public void setTitle(String st){
		message = st;
	}
	
	public void changeTitlePosition(int nx, int ny){
		titleX = nx;
		titleY = ny;
	}
	
	// https://stackoverflow.com/questions/16100175/store-text-file-content-line-by-line-into-array
	public void setPhrase(String [] info, int spacing){
		text = info;
		space = spacing;
		
		showText = true;
	}

	public void changeTextPosition(int nx, int ny){
		textX = nx;
		textY = ny;
	}
	
	public void setTextFont(Font f){
		font = f;
	}
	
	public void setTextColor(Color c){
		textcolor = c;
	}
	
	public void changeScreenBackground(Image newbg){
		s = newbg;
	}
	
	
	public void drawScreen(AffineTransform trans, Graphics2D g){
		//trans.scale(photoWidth, photoHeight);
		//g.drawImage(s, trans, null);		
		g.setColor(textcolor);
				
		// Top text
		int fs = font.getSize();
		g.setFont(font.deriveFont(fs*1.5f));
		g.drawString(message, titleX, titleY);
		
		// Info
		g.setFont(font);
		if(showText){
		  for(int i = 0, x = textX, y = textY; i < text.length; i++){
			if(text[i] != null) g.drawString(text[i], x, y);
			y += space;
		}
	  }
		
		
		boolean z = s == null;
		System.out.println(" is it magically null? => " + z);
	}
	
	public void drawScreen(int x, int y, Graphics2D g){
		//drawScreen(x, y, s.getWidth(null), s.getHeight(null), g);
		//System.out.println(" | " +  s.getWidth(null) + " | " + s.getHeight(null));
		boolean z = s == null;
		System.out.println(" is it Null? => " + z);
	}

	public void drawScreen(Graphics2D g){
		drawScreen(0, 0, s.getWidth(null), s.getHeight(null), g);
	}
	
	public void drawScreen(int x, int y, int w, int h, Graphics2D g){
		AffineTransform t = GameUtilities.getTransform(x, y, 0, (double)w/s.getWidth(null), (double)h/s.getHeight(null));
		drawScreen(t, g);
		
		//System.out.println((double)w/s.getWidth(null));
	}	

}
