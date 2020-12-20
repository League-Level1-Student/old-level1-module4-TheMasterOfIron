package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Practice_Test_1 implements Runnable, ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton hint = new JButton();
	JButton submit = new JButton();
	JTextField answer = new JTextField();
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Practice_Test_1());
}
public void run() {
	frame.add(panel);
	panel.add(label);
	panel.add(hint);
	panel.add(submit);
	panel.add(answer);
	frame.show();
	frame.pack();
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

}
}
