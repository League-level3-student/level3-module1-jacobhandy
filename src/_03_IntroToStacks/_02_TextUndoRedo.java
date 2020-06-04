package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
	String text;
	JLabel label;
	
	Stack<Character> input;
	public _02_TextUndoRedo() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		input = new Stack<>();
		//text = label.getText(keyPressed(this));
	}
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	   
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			//input.add(e.getKeyCode());
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("hello");
			String text = label.getText();
			if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_SHIFT) {
				text += e.getKeyChar();
				label.setText(text);
				//label.setText(text)
				//System.out.println(input.size());
				}
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				System.out.println("hello");
			}
			else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
				input.push(text.charAt(text.length()-1));
				String newText;
				newText = text.substring(0, text.length()-1);
				label.setText(newText);
				
			}
			if(e.getKeyCode() == KeyEvent.VK_SHIFT && input.empty() == false) {
				for(int a = 0; a < input.size() + 1; a++) {
					input.pop();
					text += input.pop();
				}
				
				label.setText(text);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		 }  

