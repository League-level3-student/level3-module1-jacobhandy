package _04_HangMan;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame;
	JPanel panel;
	JLabel text;
	public HangMan() {
		 frame = new JFrame();
		 panel = new JPanel();
		 text = new JLabel();
		frame.setSize(100, 100);
		
	}
	public void Run() {
		panel.add(text);
		frame.add(panel);
		String Words = JOptionPane.showInputDialog("How many words would you like to guess?");
		int words = Integer.parseInt(Words);
		if(words <= 0 || words > 257) {
			JOptionPane.showMessageDialog(null, "Error. Enter  a number between 0 and 257");
			Words = JOptionPane.showInputDialog("How many words would you like to guess?");
			words = Integer.parseInt(Words);
		}
		frame.setVisible(true);
	}
	
	
}
