package lessons25;


    import java.util.Arrays;
    import java.util.Scanner;

    public class Task01 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            String[] strNumbers = input.split(" ");
            int[] numbers = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                numbers[i] = Integer.parseInt(strNumbers[i]);
            }

            sort(numbers);

            int searchNumber = scanner.nextInt();
            int index = binarySearch(numbers, searchNumber, 0, numbers.length - 1);
            if (index != -1) {
                System.out.println("Index of the number " + index);
            } else {
                System.out.println("Number " + searchNumber + " not found");
            }
        }

        public static void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j] > arr[j+1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }

        public static int binarySearch(int[] arr, int x, int left, int right) {
            if (right >= left) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == x)
                    return mid;
                if (arr[mid] > x)
                    return binarySearch(arr, x, left, mid - 1);
                return binarySearch(arr, x, mid + 1, right);
            }
            return -1;
        }
    }

