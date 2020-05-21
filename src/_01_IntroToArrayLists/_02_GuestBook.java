package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton view = new JButton();
	String userInput;
	ArrayList<String> names = new ArrayList<String>();
	public _02_GuestBook () {
		
	}
	public void setup() {
		panel.add(add);
		panel.add(view);
		frame.add(panel);
		frame.setVisible(true);
		add.setText("Add Name");
		view.setText("View Names");
		add.addActionListener(this);
		view.addActionListener(this);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			userInput = JOptionPane.showInputDialog("Enter a name");
			names.add(userInput);
		}
		if(e.getSource() == view) {
			JOptionPane.showMessageDialog(frame, names);
		}
	}
	
	
}

