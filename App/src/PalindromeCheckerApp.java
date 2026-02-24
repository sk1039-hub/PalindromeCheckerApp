
import java.util.Stack;

    public class PalindromeCheckerApp {

        public static void main(String[] args) {

            // Original string
            String word = "civic";

            // Create Stack
            Stack<Character> stack = new Stack<>();

            // Push characters into stack
            for (int i = 0; i < word.length(); i++) {
                stack.push(word.charAt(i));   // Push operation
            }

            // Pop characters and build reversed string
            String reversed = "";
            while (!stack.isEmpty()) {
                reversed = reversed + stack.pop();   // Pop operation
            }

            // Compare original and reversed
            if (word.equals(reversed)) {
                System.out.println(word + " is a Palindrome.");
            } else {
                System.out.println(word + " is NOT a Palindrome.");
            }
        }
    }

