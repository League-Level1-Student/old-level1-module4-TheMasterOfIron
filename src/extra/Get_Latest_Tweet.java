package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Get_Latest_Tweet implements Runnable, ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField tweetText = new JTextField(20);
	JButton searchButton = new JButton();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Get_Latest_Tweet());

	}

	public void run() {

		frame.add(panel);
		panel.add(tweetText);
		panel.add(searchButton);
		searchButton.addActionListener(this);
		searchButton.setText("Search for a Legendary Tweet");
		frame.pack();
		frame.show();

	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		String tweet = tweetText.getText();
		if (buttonPressed == (searchButton)) {
System.out.println("Searching for " + tweet + "...");
		}
	}
}
