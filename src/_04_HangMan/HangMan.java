package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame frame;
	JPanel panel;
	JLabel text;
	String Words;
	String Text = "";
	String answer = "";
	int words;
	Stack<String> stack = new Stack<String>();
	Utilities u = new Utilities();
	public HangMan() {
		 frame = new JFrame();
		 panel = new JPanel();
		 text = new JLabel();
		frame.setSize(500, 500);
		
	}
	public void Run() {
		panel.add(text);
		frame.add(panel);
		frame.addKeyListener(this);
		Words = JOptionPane.showInputDialog("How many words would you like to guess?");
		 words = Integer.parseInt(Words);
		if(words <= 0 || words > 257 || Words.equals("")) {
			JOptionPane.showMessageDialog(null, "Error. Enter  a number between 0 and 257");
			Reset();
		}
		
		
		else {
		frame.setVisible(true);
		for(int a = 0; a < words; a++) {
		
		//stack.pop();
		Text += " ";
		stack.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		String s = stack.pop();
		answer += s;
		for(int z = 0; z < s.length(); z++) {
			Text += "-";
			
		}
		text.setText(Text);
		System.out.println(answer);
		}
		}
		
		
		
		
		
		
	}
	void Reset() {
		Words = JOptionPane.showInputDialog("How many words would you like to guess?");
		 words = Integer.parseInt(Words);
	}
	/*public void reveal(char s) {
		//reveal a character
		char[] inspection = answer.toCharArray();
		char[] result = Text.toCharArray();
		for(int a = 0; a < inspection.length; a++) {
			if(inspection[a] == s) {
				result[a] = inspection[a];
			}
		}
		Text = result.toString();
		text.setText(Text);
	}
	*/
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//loop through all words and see if they contain the typed letter
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char input = e.getKeyChar();
		for(int a = 0; a < answer.length(); a++) {
			if(answer.toCharArray()[a] == input) {
				Text.toCharArray()[a] = answer.toCharArray()[a];
				System.out.println(Text.toCharArray()[a]);
			}
		}
		
		
	}
	
}
