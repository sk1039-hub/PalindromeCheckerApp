public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string with spaces and mixed case
        String input = "Nurses Run";

        // Step 1: Normalize string
        // Convert to lowercase and remove spaces using regular expression
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Apply two-pointer palindrome logic
        int start = 0;
        int end = normalized.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Step 3: Display result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}