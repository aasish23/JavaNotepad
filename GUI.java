package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener {
	// main window
	JFrame window;

	// text area
	JTextArea text;
	JScrollPane scrollBar;

	// bar
	JMenuBar menuBar;
	JMenu file, edit, color;

	// file
	JMenuItem Open, Save, SaveAs, New;
	Function newFile = new Function(this);

	// edit
	Edit newEdit = new Edit(this);
	boolean wordWap = false; // check if currently word wrap is on or not
	JMenu font, fontSize;
	JMenuItem wrap, fontTimesNewRoman, fontAriel, fontSize8, fontSize12, fontSize16, fontSize24;
	
	// colors
	JMenuItem dark, light;
	BackGroundColor newColor = new BackGroundColor(this);
	// main driver
	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {
		makeWindow();
		makeTextArea();
		makeMenu();
		fileMenu();
		editMenu();
		colorMenu();
		
		newEdit.currentFont = "Arial";
		newEdit.makeFont(16);
		newColor.background("White");

		window.setVisible(true);

	}

	// Main window maker
	public void makeWindow() {
		window = new JFrame("Java Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text = new JTextArea();
	}

	// make text area
	public void makeTextArea() {
		text = new JTextArea();

		scrollBar = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollBar);
	}

	// Menu Bar maker, contains file, color, edit
	public void makeMenu() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

		file = new JMenu("File");
		menuBar.add(file);

		edit = new JMenu("Edit");
		menuBar.add(edit);

		color = new JMenu("Color");
		menuBar.add(color);
	}

	// Contains new, open, saveAs, save
	public void fileMenu() {
		New = new JMenuItem("New");
		New.addActionListener(this);
		New.setActionCommand("New");
		file.add(New);

		Open = new JMenuItem("Open");
		Open.addActionListener(this);
		Open.setActionCommand("Open");
		file.add(Open);

		SaveAs = new JMenuItem("SaveAs");
		SaveAs.addActionListener(this);
		SaveAs.setActionCommand("SaveAs");
		file.add(SaveAs);

		Save = new JMenuItem("Save");
		Save.addActionListener(this);
		Save.setActionCommand("Save");
		file.add(Save);

	}

	public void editMenu() {
		wrap = new JMenuItem("Word Wrap: Disabled");
		wrap.addActionListener(this);
		wrap.setActionCommand("Word Wrap");
		edit.add(wrap);

		font = new JMenu("Font");
		edit.add(font);
		// Arial font
		fontAriel = new JMenuItem("Ariel");
		fontAriel.addActionListener(this);
		fontAriel.setActionCommand("Ariel");
		font.add(fontAriel);
		// Times new Roman font
		fontTimesNewRoman = new JMenuItem("Times New Roman");
		fontTimesNewRoman.addActionListener(this);
		fontTimesNewRoman.setActionCommand("Times New Roman");
		font.add(fontTimesNewRoman);

		fontSize = new JMenu("Font Size");
		edit.add(fontSize);

		fontSize8 = new JMenuItem("8");
		fontSize8.addActionListener(this);
		fontSize8.setActionCommand("8");
		fontSize.add(fontSize8);

		fontSize12 = new JMenuItem("12");
		fontSize12.addActionListener(this);
		fontSize12.setActionCommand("12");
		fontSize.add(fontSize12);

		fontSize16 = new JMenuItem("16");
		fontSize16.addActionListener(this);
		fontSize16.setActionCommand("16");
		fontSize.add(fontSize16);

		fontSize24 = new JMenuItem("24");
		fontSize24.addActionListener(this);
		fontSize24.setActionCommand("24");
		fontSize.add(fontSize24);

	}

	public void colorMenu() {
		dark = new JMenuItem("Dark");
		dark.addActionListener(this);
		dark.setActionCommand("Dark");
		color.add(dark);
		
		light = new JMenuItem("Light");
		light.addActionListener(this);
		light.setActionCommand("Light");
		color.add(light);
		
	}
	// override for action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		String click = e.getActionCommand();

		switch (click) {
		case "New":
			newFile.newFile();
			break;

		case "Open":
			newFile.open();
			break;

		case "SaveAs":
			newFile.saveAs();
			break;

		case "Save":
			newFile.save();
			break;

		case "Word Wrap":
			newEdit.wordWrap();
			break;

		case "8":
			newEdit.makeFont(8);
			break;

		case "12":
			newEdit.makeFont(12);
			break;

		case "16":
			newEdit.makeFont(16);
			break;

		case "24":
			newEdit.makeFont(24);
			break;

		case "Ariel":
			newEdit.setFont(click);
			break;

		case "Times New Roman":
			newEdit.setFont(click);
			break;
			
		case "Dark":
			newColor.background("Dark");
			break;
			
		case "Light":
			newColor.background("Light");
			break;
		}

	}
}
