


    import java.util.Scanner;

        public class PalindromeCheckerApp {

            public static void main(String[] args) {

                // Create Scanner object to take user input
                Scanner scanner = new Scanner(System.in);

                // Prompt user
                System.out.print("Enter a string to check palindrome: ");
                String input = scanner.nextLine();

                // Convert string to char array
                char[] charArray = input.toCharArray();

                int start = 0;
                int end = charArray.length - 1;
                boolean isPalindrome = true;

                // Two-pointer comparison
                while (start < end) {
                    if (charArray[start] != charArray[end]) {
                        isPalindrome = false;
                        break;
                    }
                    start++;
                    end--;
                }

                // Print result
                if (isPalindrome) {
                    System.out.println(input + " is a Palindrome.");
                } else {
                    System.out.println(input + " is NOT a Palindrome.");
                }

                // Close scanner
                scanner.close();
            }
        }




