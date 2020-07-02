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
	JLabel lifeDisplay;
	String Words;
	String Text = "";
	String answer = "";
	int words;
	int lives = 10;
	int correctCharacters = 0;
	String length;
	Stack<String> stack = new Stack<String>();
	Utilities u = new Utilities();
	public HangMan() {
		
		
	}
	public void Run() {
		correctCharacters = 0;
		Text = "";
		length = "";
		answer = "";
		 frame = new JFrame();
		 panel = new JPanel();
		 text = new JLabel();
		 lifeDisplay = new JLabel();
		frame.setSize(500, 500);
		panel.add(text);
		panel.add(lifeDisplay);
		lives = 10;
		lifeDisplay.setText("Lives: " + lives);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
		length = stack.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		//String s = stack.pop();
		answer += stack.pop();
		answer += " ";
		for(int z = 0; z < answer.length(); z++) {
			if(answer.charAt(a) != ' ') {
			Text += "-";
			}
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
		//System.out.println("Text: " + Text);
		//System.out.println("answer: " + answer);
		char input = e.getKeyChar();
		String newAnswer = "";
		boolean correct = false;
		//Text = answer;
		if(lives > 0) {
		for(int a = 0; a < answer.length(); a++) {
			if(answer.charAt(a) == input) {
				//System.out.println(answer.toCharArray()[a]);
				//Text.toCharArray()[a] = answer.charAt(a);
				newAnswer += input;
				correct = true;
			
			
			}
			else {
				newAnswer += Text.charAt(a);
				
			}
			 if(Text.charAt(a) != '-') {
				 correctCharacters++;
				 System.out.println(correctCharacters + " correct characters");
				 System.out.println(length.length());
				 	if(correctCharacters > length.length() + 2) {
				 	frame.dispose();
					stack.clear();
					int reset = JOptionPane.showConfirmDialog(null, "Congratulations! You guessed all your words! Play again?");
					if(reset == 0) {
						Run();
						text.setText(Text);
					}
				}
				 	else if (lives <= 0) {
				 		frame.dispose();
						stack.clear();
						int reset = JOptionPane.showConfirmDialog(null, "Game Over! Play again?");
						if(reset == 0) {
							Run();
							text.setText(Text);
						}
				 	}
			 }
		}
		if(correct == false) {
			lives--;
		}
		Text = newAnswer;
		text.setText(Text);
		lifeDisplay.setText("Lives: " + lives);
		correct = false;
		
	}
		
		else {
			frame.dispose();
			stack.clear();
			int reset = JOptionPane.showConfirmDialog(null, "Game Over! Play again?");
			if(reset == 0) {
				Run();
			}
		}
	}
	
}
