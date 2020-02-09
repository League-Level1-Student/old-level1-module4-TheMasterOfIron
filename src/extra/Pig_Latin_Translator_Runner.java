package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Pig_Latin_Translator_Runner implements Runnable, ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JTextField texter = new JTextField(15);
JTextField dexter = new JTextField(15);
JButton translateButton = new JButton();
PigLatinTranslator pigLatinTranslator = new PigLatinTranslator();

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Pig_Latin_Translator_Runner());

}
public void run() {
	
	frame.add(panel);
	panel.add(texter);
	panel.add(translateButton);
	panel.add(dexter);
	translateButton.addActionListener(this);
	translateButton.setText("Translate");
	frame.show();
	frame.pack();
	

}

public void actionPerformed(ActionEvent e) {
	JButton buttonPressed = (JButton) e.getSource();
	String textToTranslate = texter.getText();
	if (buttonPressed == (translateButton)) {
		System.out.println("translating " + textToTranslate + "...");
		String translatedText = pigLatinTranslator.translate(textToTranslate);
		dexter.setText(translatedText);
				}
}
}
