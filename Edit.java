package notepad;

import java.awt.Font;

public class Edit {
	GUI gui;
	Font arial, timesNewRoman;
	String currentFont;
	
	public Edit(GUI gui) {
		this.gui = gui; 
	}
	
	public void wordWrap() {
		if(gui.wordWap == false) {
			gui.wordWap = true;
			gui.text.setLineWrap(true);
			gui.text.setWrapStyleWord(true);
			gui.wrap.setText("Word Wrap: Enabled");
		}
		else {
			gui.wordWap = false;
			gui.text.setLineWrap(false);
			gui.text.setWrapStyleWord(false);
			gui.wrap.setText("Word Wrap: Disabeld");
		}
		
	}
	
	public void makeFont(int size) {
		arial = new Font("Arial", Font.PLAIN, size);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, size);
		
		setFont(currentFont);
	}
	
	public void setFont(String font) {
		currentFont = font; 
		if(currentFont.equals("Times New Roman")) {
			gui.text.setFont(timesNewRoman);
		}
		
		else if(currentFont.contentEquals("Ariel")) {
			gui.text.setFont(arial);
		}
		
		
	}
}
