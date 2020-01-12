package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Chuckle_Clicker implements ActionListener, Runnable {
	static JPanel panel = new JPanel();
	static JFrame frame = new JFrame();
	static JButton joke = new JButton();
	static JButton punchline = new JButton();
	String punchlineText = "[insert punchline here]";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Chuckle_Clicker());
	}

	public void run() {
		makeButtons();
		joke.addActionListener(this);
		punchline.addActionListener(this);
	}

	private static void makeButtons() {
		// TODO Auto-generated method stub

		frame.add(panel);
		frame.show();
		frame.setSize(190, 85);
		panel.add(joke);
		joke.setText("Joke");
		panel.add(punchline);
		punchline.setText("Punchline");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == (joke)) {
			JOptionPane.showMessageDialog(null, "What is a skeleton's favorite instrument?");
		}
		if (buttonPressed == (punchline) && punchlineText == "[insert punchline here]") {
			int punchlineTest = JOptionPane.showOptionDialog(null, punchlineText, "Punchline", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"Why?"}, null);
			if (punchlineTest == 0) {
				punchlineText = JOptionPane.showInputDialog("Because i'm too lazy.");
			}
			System.out.println(punchlineTest);
		}
		else if (buttonPressed == (punchline) && punchlineText != "[insert punchline here]") {
			JOptionPane.showMessageDialog(null, punchlineText);
		}
	}

}
