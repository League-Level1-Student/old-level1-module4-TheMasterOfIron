package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Simple_Calculator implements Runnable, ActionListener {
	String firstNumberString = "";
	String secondNumberString = "";
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField firstNumber = new JTextField(20);
	JTextField secondNumber = new JTextField(20);
	JButton add = new JButton();
	JButton subtract = new JButton();
	JButton multiply = new JButton();
	JButton divide = new JButton();
	JButton exponent = new JButton();
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Simple_Calculator());
}
	public void run() {
		add.setText("Add");
		subtract.setText("Subtract");
		multiply.setText("Multiply");
		divide.setText("Divide");
		exponent.setText("Exponent");
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		exponent.addActionListener(this);
		panel.add(firstNumber);
		panel.add(secondNumber);
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		panel.add(exponent);
		frame.add(panel);
		frame.setSize(500, 110);
		frame.show();
			frame.setTitle("Simple Calculator");
	}

public void actionPerformed(ActionEvent e) {
	JButton buttonPressed = (JButton) e.getSource();
	firstNumberString = firstNumber.getText();
	secondNumberString = secondNumber.getText();
	int numberOne = Integer.parseInt(firstNumberString);
	int numberTwo = Integer.parseInt(secondNumberString);
	if (buttonPressed == (add)) {
		int answer = numberOne + numberTwo;
		JOptionPane.showMessageDialog(null, numberOne + "+" + numberTwo + "=" + answer);
	}
	if (buttonPressed == (subtract)) {
		int answer = numberOne - numberTwo;
		JOptionPane.showMessageDialog(null, numberOne + "-" + numberTwo + "=" + answer);
	}
	if (buttonPressed == (multiply)) {
		int answer = numberOne * numberTwo;
		JOptionPane.showMessageDialog(null, numberOne + "*" + numberTwo + "=" + answer);
	}
	if (buttonPressed == (divide)) {
		int answer = numberOne / numberTwo;
		JOptionPane.showMessageDialog(null, numberOne + "/" + numberTwo + "=" + answer);
	}
	if (buttonPressed == (exponent)) {
		int answer = numberOne ^ numberTwo;
		JOptionPane.showMessageDialog(null, numberOne + "^" + numberTwo + "=" + answer);
	}
}
}
