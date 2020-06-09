package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame;
	JPanel panel;
	JLabel text;
	String Words;
	int words;
	Stack<String> stack = new Stack<String>();
	Utilities u = new Utilities();
	public HangMan() {
		 frame = new JFrame();
		 panel = new JPanel();
		 text = new JLabel();
		frame.setSize(100, 100);
		
	}
	public void Run() {
		panel.add(text);
		frame.add(panel);
		Words = JOptionPane.showInputDialog("How many words would you like to guess?");
		 words = Integer.parseInt(Words);
		if(words <= 0 || words > 257 || Words.equals("")) {
			JOptionPane.showMessageDialog(null, "Error. Enter  a number between 0 and 257");
			Reset();
		}
		
		
		else {
		frame.setVisible(true);
		for(int a = 0; a < words; a++) {
		stack.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		//stack.pop();
		text.setText(stack.pop());
		}
		}
	}
	void Reset() {
		Words = JOptionPane.showInputDialog("How many words would you like to guess?");
		 words = Integer.parseInt(Words);
	}
	
}
