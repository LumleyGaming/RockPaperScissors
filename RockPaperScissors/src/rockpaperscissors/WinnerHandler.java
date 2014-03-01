package rockpaperscissors;

public class WinnerHandler {

	private int winner;

	public WinnerHandler(int cpuSelection, int playerSelection) {

		// winner = 0 for draw
		if (cpuSelection == playerSelection) {
			winner = 0;
		}
		// winner = 1 for CPU
		if (cpuSelection == 0) { // Rock
			switch (playerSelection) {
			case 2: // Scissors
			case 3: // Lizard
				winner = 2;
				break;
			case 1: // Paper
			case 4: // Spock
				winner = 1;
				break;
			// Scissors
			
			}
		} else if (cpuSelection == 1) { // Paper
			switch (playerSelection) {
			case 2: // Scissors
			case 3: // Lizard
				winner = 2;
				break;
			case 0: // Rock
			case 4: // Spock
				winner = 1;
				break;
			}
		} else if (cpuSelection == 2) { // Scissors
			switch (playerSelection) {
			case 0: // Rock
			case 4: // Spock
				winner = 2;
				break;
			case 1: // Paper
			case 3: // Lizard
				winner = 1;
				break;
			}
		} else if (cpuSelection == 3) { // Lizard
			switch (playerSelection) {
			case 0: // Rock
			case 2: // Scissors
				winner = 2;
				break;
			case 1: // Paper
			case 4: // Spock
				winner = 1;
				break;
			}
		} else if (cpuSelection == 4) { // Spock
			switch (playerSelection) {
			case 1: // Paper
			case 3: // Lizard
				winner = 2;
				break;
			case 0: // Rock
			case 2: // Scissors
				winner = 1;
				break;
			}
		}
	}

	public int getWinner() {
		return winner;
	}

}
