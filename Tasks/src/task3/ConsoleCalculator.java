package task3;

	import java.util.Scanner;

	public class ConsoleCalculator {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Simple Console Calculator");
	        System.out.print("Enter the first number: ");
	        double num1 = scanner.nextDouble();

	        System.out.print("Enter the second number: ");
	        double num2 = scanner.nextDouble();

	        System.out.print("Choose an operation (+, -, *, /): ");
	        char operator = scanner.next().charAt(0);

	        double result = 0;

	        switch (operator) {
	            case '+':
	                result = num1 + num2;
	                break;
	            case '-':
	                result = num1 - num2;
	                break;
	            case '*':
	                result = num1 * num2;
	                break;
	            case '/':
	                if (num2 != 0) {
	                    result = num1 / num2;
	                } else {
	                    System.out.println("Cannot divide by zero.");
	                    return;
	                }
	                break;
	            default:
	                System.out.println("Invalid operator. Please choose +, -, *, or /.");
	                return;
	        }

	        System.out.println("Result: " + result);

	        scanner.close();
	    }
	}

