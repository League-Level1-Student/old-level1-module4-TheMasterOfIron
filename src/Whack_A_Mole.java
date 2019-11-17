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
	Random randy = new Random(1000000);

	private void drawButtons(int randy) {
		for (int i = 0; i <= 10000; i++) {
			JButton button = new JButton();
			button.addActionListener(this);
			button.setSize(1,1);
			panel.add(button);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Whack_A_Mole());
	}

	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		drawButtons(1000);
		frame.setSize(150, 200);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
