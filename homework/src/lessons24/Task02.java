package lessons24;



import java.util.Scanner;

    public class Task02 {
        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a numeric expression (for example, 4 + 4): ");
            String expression = scanner.nextLine();
            String[] parts = expression.split(" ");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            String operator = parts[1];

            int result = 0;
            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                result = num1 / num2;
            }

            System.out.println("Result of numeric expression: " + result);
        }
    }