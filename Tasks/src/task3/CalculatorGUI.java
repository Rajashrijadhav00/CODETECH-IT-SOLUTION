package task3;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class CalculatorGUI extends JFrame implements ActionListener {
	    private JTextField display;
	    private String currentInput;
	    private char currentOperation;
	    private double result;

	    public CalculatorGUI() {
	        setTitle("Simple GUI Calculator");
	        setSize(300, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        display = new JTextField();
	        display.setEditable(false);
	        display.setHorizontalAlignment(JTextField.RIGHT);
	        add(display, BorderLayout.NORTH);

	        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
	        String[] buttonLabels = {
	                "7", "8", "9", "/",
	                "4", "5", "6", "*",
	                "1", "2", "3", "-",
	                "0", ".", "=", "+"
	        };

	        for (String label : buttonLabels) {
	            JButton button = new JButton(label);
	            button.addActionListener(this);
	            buttonPanel.add(button);
	        }

	        add(buttonPanel);

	        currentInput = "";
	        currentOperation = ' ';
	        result = 0.0;

	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();

	        switch (command) {
	            case "=":
	                calculateResult();
	                break;
	            case "+":
	            case "-":
	            case "*":
	            case "/":
	                handleOperation(command.charAt(0));
	                break;
	            default:
	                handleDigit(command);
	        }
	    }

	    private void handleDigit(String digit) {
	        currentInput += digit;
	        display.setText(currentInput);
	    }

	    private void handleOperation(char operation) {
	        if (!currentInput.isEmpty()) {
	            if (currentOperation != ' ') {
	                calculateResult();
	            } else {
	                result = Double.parseDouble(currentInput);
	            }

	            currentInput = "";
	            currentOperation = operation;
	        }
	    }

	    private void calculateResult() {
	        if (!currentInput.isEmpty()) {
	            double operand = Double.parseDouble(currentInput);

	            switch (currentOperation) {
	                case '+':
	                    result += operand;
	                    break;
	                case '-':
	                    result -= operand;
	                    break;
	                case '*':
	                    result *= operand;
	                    break;
	                case '/':
	                    if (operand != 0) {
	                        result /= operand;
	                    } else {
	                        display.setText("Error: Cannot divide by zero.");
	                        currentInput = "";
	                        currentOperation = ' ';
	                        result = 0.0;
	                        return;
	                    }
	                    break;
	            }

	            display.setText(String.valueOf(result));
	            currentInput = "";
	            currentOperation = ' ';
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new CalculatorGUI();
	        });
	    }
	}
