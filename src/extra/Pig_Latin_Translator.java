package extra;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Pig_Latin_Translator implements Runnable {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JTextField texter = new JTextField();
JTextField dexter = new JTextField();
JButton translateButton = new JButton();

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Pig_Latin_Translator());

}
private void run() {

}
}
