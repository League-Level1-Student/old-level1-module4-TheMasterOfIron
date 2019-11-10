import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Nasty_Surprise {
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL("https://www.google.com/search?q=puppy&sxsrf=ACYBGNT6qMpD_RCYnnDe4w0_TQQgo35Stg:1573414087512&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjI-JSesODlAhUZIjQIHS3ZDugQ_AUIEigB&biw=934&bih=720&dpr=1.25#imgrc=NuHW-1lFpv8eoM:");
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
		JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton trick = new JButton();
	JButton treat = new JButton();
	frame.setVisible(true);
	frame.add(panel);
	panel.add(trick);
	panel.add(treat);
	trick.setText("Trick");
	treat.setText("Treat");
	frame.pack();
	}
}
