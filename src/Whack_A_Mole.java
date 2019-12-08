import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;

public class Whack_A_Mole implements ActionListener, Runnable {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random randy = new Random();
	JButton mole;

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
			speak("Owww!");
			System.out.println("Owww!");
			int randomNumber = randy.nextInt(100);
			drawButtons(randomNumber);
		} else {
			speak("Better luck next time.");
			System.out.println("Better luck next time.");
			int randomNumber = randy.nextInt(100);
			drawButtons(randomNumber);
		}
	}
}
