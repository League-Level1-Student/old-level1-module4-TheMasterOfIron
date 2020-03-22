package extra;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Typing_Tutor_Runner implements Runnable, KeyListener {
	JFrame frame = new JFrame();
	JLabel letter = new JLabel();
	char currentLetter;
	char keyYouTyped;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Typing_Tutor_Runner());

	}

	@Override
	public void run() {
		frame.add(letter);
		frame.setTitle("TYPE OR DIE!");
		frame.show();

		currentLetter = Typing_Tutor.generateRandomLetter();
		letter.setText(currentLetter + "");
		letter.setFont(letter.getFont().deriveFont(35.0f));
		letter.setHorizontalAlignment(JLabel.CENTER);
		frame.pack();
		frame.addKeyListener(this);

	}

	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		keyYouTyped = e.getKeyChar();
	}

	public void keyReleased(KeyEvent e) {
		if (currentLetter == e.getKeyChar()) {
			System.out.println("CORRECT!");
			frame.setBackground(Color.green);
		}
		else {
			System.out.println("WRONG!");	
			frame.setBackground(Color.red);
		}
		System.out.println("released");
		currentLetter = Typing_Tutor.generateRandomLetter();
		letter.setText(currentLetter + "");
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}
}
