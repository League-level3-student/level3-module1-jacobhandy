package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	public HashMap<Integer,String> search;
	public JFrame frame;
	public JPanel panel;
	public JButton entry;
	public JButton IDsearch;
	public JButton view;
	public JButton remove;
	
	public _02_LogSearch() {
		search = new HashMap<Integer,String>();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		entry = new JButton();
		IDsearch = new JButton();
		view = new JButton();
		remove = new JButton();
		frame.add(panel);
		panel.add(entry);
		panel.add(IDsearch);
		panel.add(view);
		panel.add(remove);
		entry.setText("Add Entry");
		IDsearch.setText("Search by ID");
		view.setText("View List");
		remove.setText("Remove Entry");
		entry.addActionListener(this);
		IDsearch.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(entry)) {
			String numberInput = JOptionPane.showInputDialog("Enter an ID Number");
			int idNum = Integer.parseInt(numberInput);
			String name = JOptionPane.showInputDialog("Enter a name");
			search.put(idNum, name);
		}
		if(e.getSource().equals(IDsearch)) {
			String numInput = JOptionPane.showInputDialog("Enter an ID Number");
			int number = Integer.parseInt(numInput);
			if(search.containsKey(number)) {
				JOptionPane.showMessageDialog(null, search.get(number));
			}
			else {
				JOptionPane.showMessageDialog(null, "That ID number doesn't exist, you lackwit fool! lolololololololololololololololololololololololololol");
			}
		}
		if(e.getSource().equals(view)) {
			//for(Integer i: search.keySet()) {
			///	for(String s : search.values()){
			//		JOptionPane.showMessageDialog(null, "ID Number: " + i + " Name: " + s);
			//	}
			//}
			String text = "";
			for(Integer i : search.keySet()) {
				text += "ID Number: ";
				text += i.toString();
				text += " Name: ";
				text += search.get(i);
				text += " ";
			}
			JOptionPane.showMessageDialog(null, text);
		}
		if(e.getSource().equals(remove)) {
			String intInput = JOptionPane.showInputDialog("Enter the ID Number you want to remove");
			int number = Integer.parseInt(intInput);
			if(search.containsKey(number)) {
				search.remove(number);
				JOptionPane.showMessageDialog(null, "ID successfully removed");
			}
			else {
				JOptionPane.showMessageDialog(null, "That number doesn't exist. I've dealt with mudcrabs more intelligent than you!");
			}
		}
	}
}
