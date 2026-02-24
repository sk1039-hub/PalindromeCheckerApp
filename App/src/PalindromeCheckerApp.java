import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) stack.push(ch);
        for (char ch : input.toCharArray())
            if (stack.pop() != ch) return false;
        return true;
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    // Two-pointer string check
    public static boolean twoPointerPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end)
            if (input.charAt(start++) != input.charAt(end--)) return false;
        return true;
    }

    // Recursive palindrome check
    public static boolean recursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursivePalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String testString = "abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba"; // Long string for measurable timing

        // Stack-based
        long startTime = System.nanoTime();
        stackPalindrome(testString);
        long endTime = System.nanoTime();
        System.out.println("Stack-based: " + (endTime - startTime) + " ns");

        // Deque-based
        startTime = System.nanoTime();
        dequePalindrome(testString);
        endTime = System.nanoTime();
        System.out.println("Deque-based: " + (endTime - startTime) + " ns");

        // Two-pointer
        startTime = System.nanoTime();
        twoPointerPalindrome(testString);
        endTime = System.nanoTime();
        System.out.println("Two-pointer: " + (endTime - startTime) + " ns");

        // Recursive
        startTime = System.nanoTime();
        recursivePalindrome(testString, 0, testString.length() - 1);
        endTime = System.nanoTime();
        System.out.println("Recursive: " + (endTime - startTime) + " ns");
    }
}