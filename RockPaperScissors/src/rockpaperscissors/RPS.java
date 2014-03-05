package rockpaperscissors;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class RPS extends JFrame implements ActionListener {
	// Set width and height for window
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	public int playerSelection;

	private JLabel fillerL, fillerL2, fillerL3, fillerL4;
	private JLabel winnerL, computerL;
	private JButton rockB, paperB, scissorsB, lizardB, spockB;
	private JButton exitB;
	private WinnerHandler whoWins;
	
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	ImageIcon rockImage = new ImageIcon("Images/rock.png");
	ImageIcon paperImage = new ImageIcon("Images/paper.png");
	ImageIcon scissorsImage = new ImageIcon("Images/scissors.png");
	ImageIcon lizardImage = new ImageIcon("Images/lizard.png");
	ImageIcon spockImage = new ImageIcon("Images/spock.png");

	public RPS() {
		// Instantiate the filler labels
		fillerL = new JLabel("", SwingConstants.CENTER);
		fillerL2 = new JLabel("", SwingConstants.CENTER);
		fillerL3 = new JLabel("", SwingConstants.CENTER);
		fillerL4 = new JLabel("", SwingConstants.CENTER);
		winnerL = new JLabel("", SwingConstants.CENTER);
		winnerL.setFont(new Font("Ariel", Font.PLAIN, 26));
		winnerL.setForeground(new Color(255, 255, 255));
		computerL = new JLabel("", SwingConstants.CENTER);
		computerL.setForeground(new Color(255, 255, 255));

		// Set Buttons and their Action Listeners
		rockB = new JButton("Rock", rockImage);
		buttonSetup(rockB);
		//rockB.addActionListener(this);
		
		paperB = new JButton("Paper", paperImage);
		buttonSetup(paperB);

		scissorsB = new JButton("Scissors", scissorsImage);
		buttonSetup(scissorsB);

		lizardB = new JButton("Lizard", lizardImage);
		buttonSetup(lizardB);
		
	    spockB = new JButton("Spock", spockImage);
		buttonSetup(spockB);

		exitB = new JButton("Exit");
		exitB.addActionListener(this);
		
		// Set Window
		setTitle("Rock, Paper, Scissors, Lizard, Spock");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(6, 2));

		// Add items to the board
		pane.add(rockB);
		pane.add(fillerL);
		pane.add(paperB);
		pane.add(fillerL2);
		pane.add(scissorsB);
		pane.add(computerL);
		pane.add(lizardB);
		pane.add(fillerL3);
		pane.add(spockB);
		pane.add(fillerL4);
		pane.add(winnerL);
		pane.add(exitB);

		// Other panel options
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		pane.setBackground(new Color(0, 46, 79));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == rockB){
			playerSelection = 0;
		} else if (e.getSource() == paperB){
			playerSelection = 1;
		} else if (e.getSource() == scissorsB){
			playerSelection = 2;
		} else if (e.getSource() == lizardB){
			playerSelection = 3;
		} else if (e.getSource() == spockB){
			playerSelection = 4;
		} else if (e.getSource() == exitB){
			System.exit(0);
		}
		int cpuChoice = cpuSelection();
		whoWins = new WinnerHandler(cpuChoice, playerSelection);
		int winner = whoWins.getWinner();
		switch (winner){
		case 0:
			winnerL.setText("Draw!");
			break;
		case 1:
			winnerL.setText("CPU Wins!");
			break;
		case 2:
			winnerL.setText("You win!");
			break;
		}
	}

	public int cpuSelection() {
		Random rand = new Random();

		int selection = rand.nextInt((5 - 1) + 1);
		
		switch (selection){
		case 0:
			computerL.setIcon(rockImage);
			computerL.setText("Rock");
			break;
		case 1:
			computerL.setIcon(paperImage);
			computerL.setText("Paper");
			break;
		case 2:
			computerL.setIcon(scissorsImage);
			computerL.setText("Scissors");
			break;
		case 3:
			computerL.setIcon(lizardImage);
			computerL.setText("Lizard");
			break;
		case 4:
			computerL.setIcon(spockImage);
			computerL.setText("Spock");
			break;
		}

		return selection;
	}
	
	// Sets colors for buttons
	public void buttonSetup(JButton s){
		s.setBackground(new Color(0, 46, 79));
		s.setForeground(new Color(255, 255, 255));
		s.setFocusPainted(false);
		s.setBorderPainted(false);
		s.addActionListener(this);
	}

	public static void main(String[] args) {
		RPS rps = new RPS();
	}
}