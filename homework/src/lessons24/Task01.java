package lessons24;


    import java.util.Scanner;

    public class Task01 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the string: ");
            String inputString = scanner.nextLine();

            String[] words = inputString.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                result.append(word.charAt(0));
            }

            System.out.println("Result: " + result);
            System.out.println(
                    "Size of the resulting term: " + result.length());

            for (String word : words) {
                System.out.println(
                        "The first letter of the word: "+ word.charAt(0) + ", The last letter of the word: " + word.charAt(word.length() - 1));
            }
        }
    }
