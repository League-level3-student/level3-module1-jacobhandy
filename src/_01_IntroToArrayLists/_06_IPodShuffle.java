package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	Boolean isPlaying = false;
	Song s;
		ArrayList<String> songs = new ArrayList<String>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
			//Song s = new Song("demo.mp3");
			//s.play();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		
		*/
		button.setText("SUPRISE ME!");
		panel.add(button);
		frame.add(panel);
		button.addActionListener(this);
		frame.setVisible(true);
		songs.add("Fly By Night.mp3");
		songs.add("Hitman.mp3");
		songs.add("Sneaky Snitch.mp3");
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int x = r.nextInt(songs.size());
		if (e.getSource() == button) {
			
			if(isPlaying == true) {
				s.stop();
			}
			s = new Song(songs.get(x));
			isPlaying = true;
			s.play();
			
		}
	}
}