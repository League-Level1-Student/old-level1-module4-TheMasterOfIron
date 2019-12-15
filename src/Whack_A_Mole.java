import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;

public class Whack_A_Mole implements ActionListener, Runnable {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random randy = new Random();
	JButton mole;
	int molesWhacked = 0;
	int timesMissed = 0;
	Date timeAtStart = new Date();

	private void drawButtons(int randy) {
		for (int i = 0; i <= 100; i++) {
			JButton button = new JButton();
			button.addActionListener(this);
			panel.add(button);
			if (i == randy) {
				mole = button;
				button.setText("MOLE!");
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Whack_A_Mole());
	}

	public void run() {
		frame.setTitle("Whack-A-Mole");
		frame.add(panel);
		frame.setVisible(true);
		int randomNumber = randy.nextInt(100);
		drawButtons(randomNumber);
		frame.setSize(550, 600);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed.getText().equals("MOLE!")) {
			speak("Owie!");
			System.out.println("Owie!");
			molesWhacked++;
			System.out.println(molesWhacked);
			panel.removeAll();
				int randomNumber = randy.nextInt(100);
			drawButtons(randomNumber);
		} else {
			speak("Better luck next time.");
			System.out.println("Better luck next time.");
			timesMissed++;
			System.out.println(timesMissed);
			panel.removeAll();
			int randomNumber = randy.nextInt(100);
			drawButtons(randomNumber);
		}
		if (molesWhacked == 10) {
			endGame(timeAtStart,molesWhacked);
			frame.hide();
		} else if(timesMissed == 5) {
		speak("You missed 5 times nice try. Game Over.");
		System.exit(0);
		}
	}


	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}
}
