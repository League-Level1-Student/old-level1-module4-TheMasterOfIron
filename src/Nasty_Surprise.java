import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Nasty_Surprise implements Runnable, ActionListener {
	JButton trick = new JButton();
	JButton treat = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Nasty_Surprise());
	}

	public void run() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(trick);
		panel.add(treat);
		trick.setText("Trick");
		treat.setText("Treat");
		trick.addActionListener(this);
		treat.addActionListener(this);
		frame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == (trick)) {
			showPictureFromTheInternet("https://cdn.mos.cms.futurecdn.net/BwL2586BtvBPywasXXtzwA-320-80.jpeg");
		}
		if (buttonPressed == (treat)) {
			showPictureFromTheInternet("https://pbs.twimg.com/profile_images/778230226761375744/X3_-Whev_400x400.jpg");
		}
	}
}
