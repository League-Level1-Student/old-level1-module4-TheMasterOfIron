package extra;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Typing_Tutor {
static JPanel panel = new JPanel();
static JFrame frame = new JFrame();
public static void main(String[] args) {
	frame.add(panel);
	panel.setName("TYPE OR DIE!");
	frame.show();
}
}
