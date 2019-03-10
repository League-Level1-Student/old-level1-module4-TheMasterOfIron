
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	JButton seagullbutton = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Song s1 = new Song("Seagull sounds (1).mp3");
	JButton rickrollbutton = new JButton();
	Song s2 = new Song("Rick Astley - Never Gonna Give You Up (Official Music Video).mp3");
	JButton crabbutton = new JButton();
	Song s3 = new Song("Noisestorm - Crab Rave [Monstercat Release].mp3");
	JButton defaultbutton = new JButton();
	Song s4 = new Song("Fortnite Default Dance Bass Boosted.mp3");
	JButton anthembutton = new JButton();
	Song s5 = new Song("National Anthem of USSR.mp3");
	JButton ussrbutton = new JButton();
	Song s6 = new Song("USSR (YMCA PARODY).mp3");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());

	}

	public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song

		// 5. Play the Song

		/*
		 * 6. Create a user interface for your Jukebox so that the user can to choose
		 * which song to play. You can use can use a different button for each song, or
		 * a picture of the album cover. When the button or album cover is clicked, stop
		 * the currently playing song, and play the one that was selected.
		 */

		seagullbutton.setText("Seagull Noises");
		crabbutton.setText("Barc");
		defaultbutton.setText("Default");
		anthembutton.setText("USSR");
		ussrbutton.setText("YMCA");
		frame.add(panel);
		panel.add(seagullbutton);
		panel.add(crabbutton);
		frame.setVisible(true);
		seagullbutton.addActionListener(this);
		crabbutton.addActionListener(this);
		defaultbutton.addActionListener(this);
		anthembutton.addActionListener(this);
		ussrbutton.addActionListener(this);
		rickrollbutton.setText("Calming Waves");
		rickrollbutton.addActionListener(this);
		panel.add(rickrollbutton);
		panel.add(defaultbutton);
		panel.add(anthembutton);
		panel.add(ussrbutton);
		frame.pack();

	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == (seagullbutton)) {
			s1.play();
		}
		if (buttonPressed == (rickrollbutton)) {
			s2.play();
		}
		if (buttonPressed == (crabbutton)) {
			s3.play();
		}
		if (buttonPressed == (defaultbutton)) {
			s4.play();
		}
		if (buttonPressed == (anthembutton)) {
			s5.play();
		}
		if (buttonPressed == (ussrbutton)) {
			s6.play();
		}

	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}
