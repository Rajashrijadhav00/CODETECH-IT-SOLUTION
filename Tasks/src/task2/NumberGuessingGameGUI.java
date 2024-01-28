package task2;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class NumberGuessingGameGUI extends JFrame implements ActionListener {
	    private JTextField guessField;
	    private JButton guessButton, newGameButton;
	    private JLabel messageLabel;
	    private int secretNumber;
	    private int attemptsLeft;
	    private boolean gameWon;

	    public NumberGuessingGameGUI() {
	        setTitle("Number Guessing Game");
	        setSize(300, 150);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new GridLayout(4, 1));

	        guessField = new JTextField();
	        guessButton = new JButton("Guess");
	        newGameButton = new JButton("New Game");
	        messageLabel = new JLabel();

	        guessButton.addActionListener(this);
	        newGameButton.addActionListener(this);

	        add(guessField);
	        add(guessButton);
	        add(newGameButton);
	        add(messageLabel);

	        newGame();

	        setVisible(true);
	    }

	    private void newGame() {
	        secretNumber = (int) (Math.random() * 100) + 1;
	        attemptsLeft = 10;
	        gameWon = false;

	        messageLabel.setText("Guess a number between 1 and 100");
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == guessButton) {
	            handleGuess();
	        } else if (e.getSource() == newGameButton) {
	            newGame();
	        }
	    }

	    private void handleGuess() {
	        try {
	            int userGuess = Integer.parseInt(guessField.getText());

	            if (!gameWon) {
	                attemptsLeft--;

	                if (userGuess == secretNumber) {
	                    gameWon = true;
	                    displayMessage("Congratulations! You guessed the correct number.");
	                } else if (attemptsLeft > 0) {
	                    displayMessage(userGuess > secretNumber ? "Too high. Attempts left: " + attemptsLeft :
	                            "Too low. Attempts left: " + attemptsLeft);
	                } else {
	                    displayMessage("Sorry, you've run out of attempts. The correct number was " + secretNumber);
	                    gameWon = true;
	                }
	            } else {
	                displayMessage("Please start a new game.");
	            }
	        } catch (NumberFormatException ex) {
	            displayMessage("Invalid input. Please enter a valid number.");
	        }

	        guessField.setText("");
	    }

	    private void displayMessage(String message) {
	        messageLabel.setText(message);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new NumberGuessingGameGUI();
	        });
	    }
	}


