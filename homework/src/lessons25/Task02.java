package lessons25;


    import java.util.Scanner;

    public class Task02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a starting number: ");
            int start = scanner.nextInt();

            System.out.print("Enter the final number: ");
            int end = scanner.nextInt();

            printNumbers(start, end);
        }

        public static void printNumbers(int start, int end) {
            if (start <= end) {
                System.out.print(start + " ");
                printNumbers(start + 1, end);
            }
        }
    }

