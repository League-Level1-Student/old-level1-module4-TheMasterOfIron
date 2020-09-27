package extra;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.prism.paint.Stop;

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
	int randomnumber = randy.nextInt(3);
	int randomnumber2 = randy.nextInt(3);
	int randomnumber3 = randy.nextInt(3);
	try {
		if (randomnumber == 0) {
			image1 = createLabelImage("cherry.png");
		}
		else if (randomnumber == 1) {
	image1 = createLabelImage("seven.png");
		}
		else if (randomnumber == 2) {
	image1 = createLabelImage("bar.png");
}		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		if (randomnumber2 == 0) {
			image2 = createLabelImage("cherry.png");
		}
		else if (randomnumber2 == 1) {
	image2 = createLabelImage("seven.png");
		}
		else if (randomnumber2 == 2) {
	image2 = createLabelImage("bar.png");
}		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		if (randomnumber3 == 0) {
			image3 = createLabelImage("cherry.png");
		}
		else if (randomnumber3 == 1) {
	image3 = createLabelImage("seven.png");
		}
		else if (randomnumber3 == 2) {
	image3 = createLabelImage("bar.png");
}		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	frame.add(panel);	
	panel.add(image1);
	panel.add(image2);
	panel.add(image3);
	frame.setVisible(true);
	frame.pack();
	if (randomnumber == 0 && randomnumber2 == 0 && randomnumber3 == 0) {
		JOptionPane.showMessageDialog(null, "Congratulations you won with all cherries./eEnjoy the feast.");
	}
	else if (randomnumber == 1 && randomnumber2 == 1 && randomnumber3 == 1) {
		JOptionPane.showMessageDialog(null, "Congratulations you won with all sevens./eGood thing they're not all 6.");
	}
	else if (randomnumber == 3 && randomnumber2 == 3 && randomnumber3 == 3) {
		JOptionPane.showMessageDialog(null, "Congratulations you won with all bars./eMake sure not to walk into one.");
}	
	else {
		JOptionPane.showMessageDialog(null, "Better luck next time.");w
	}
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
