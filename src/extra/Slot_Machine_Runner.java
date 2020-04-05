package extra;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Slot_Machine_Runner implements Runnable {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel image1 = new JLabel();
	JLabel image2 = new JLabel();
	JLabel image3 = new JLabel();
	Random randy = new Random();
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Slot_Machine_Runner());
}

@Override
public void run() {
	try {
		image1 = createLabelImage("cherry.png");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		image2 = createLabelImage("seven.png");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		image3 = createLabelImage("bar.png");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	frame.add(panel);	
	panel.add(image1);
	panel.add(image2);
	panel.add(image3);
	frame.setVisible(true);
	frame.setSize(2000, 500);

}
private JLabel createLabelImage(String fileName) throws MalformedURLException {
	URL imageURL = getClass().getResource(fileName);
	if (imageURL == null) {
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
}
