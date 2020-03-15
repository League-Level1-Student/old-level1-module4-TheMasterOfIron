package extra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Typing_Tutor_Runner implements Runnable, KeyListener {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JLabel letter = new JLabel();
	Typing_Tutor typingTutor = new Typing_Tutor();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Typing_Tutor_Runner());

	}

	@Override
	public void run() {
		frame.add(panel);
		frame.setTitle("TYPE OR DIE!");
		frame.show();
		char currentLetter;
		currentLetter = typingTutor.generateRandomLetter();
		letter.setText(currentLetter + "");
		panel.add(letter);
		letter.setFont(letter.getFont().deriveFont(35.0f));
		letter.setHorizontalAlignment(JLabel.CENTER);
		frame.pack();
		frame.addKeyListener(this);
		
	}
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}
}
