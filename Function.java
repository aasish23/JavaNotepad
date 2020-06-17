package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function {
	GUI gui; 
	String fileName; 
	String fileAddress;
	
	public Function(GUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		gui.text.setText("");
		gui.window.setTitle("New");
		
		fileName = null; 
		fileAddress = null;
	}
	
	public void open() {
		FileDialog fileDialog = new FileDialog(gui.window, "DialogBox", FileDialog.LOAD);
		fileDialog.setVisible(true);
		
		if(fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
			gui.text.setText("");
			
			String line = ""; 
			
			while((line = br.readLine()) != null) {
				gui.text.append(line + "\n");
			}
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveAs() {
		FileDialog f = new FileDialog(gui.window, "DialogBox", FileDialog.SAVE);
		f.setVisible(true);
		
		if(f.getFile() != null) {
			fileName = f.getFile();
			fileAddress = f.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(gui.text.getText());
			fw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		//overwrite the current file with the edits made
		if(fileName != null) {
			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.text.getText());
				gui.window.setTitle(fileName);
				fw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		//if current file is a new file, save as
		else {
			saveAs();
		}
		
	}
}
