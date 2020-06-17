package notepad;
import java.awt.Color;

public class BackGroundColor {
	GUI gui; 
	
	public BackGroundColor(GUI gui) {
		this.gui = gui;
	}
	
	public void background(String color) {
		if(color.equals("Light")) {
			gui.window.getContentPane().setBackground(Color.white);
			gui.text.setBackground(Color.white);
			gui.text.setForeground(Color.black);
		}
		else {
			gui.window.getContentPane().setBackground(Color.DARK_GRAY);
			gui.text.setBackground(Color.DARK_GRAY);
			gui.text.setForeground(Color.white);
		}
	}
}
