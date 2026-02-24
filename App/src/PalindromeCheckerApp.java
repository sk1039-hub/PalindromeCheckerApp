// Palindrome service class
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class to use strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.isPalindrome(input);
    }
}

// Main application class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "radar";

        // Create context
        PalindromeCheckerContext context = new PalindromeCheckerContext();

        // Use StackStrategy
        context.setStrategy(new StackStrategy());
        System.out.println("Using StackStrategy:");
        System.out.println(word + " is palindrome? " + context.check(word));

        // Use DequeStrategy
        context.setStrategy(new DequeStrategy());
        System.out.println("\nUsing DequeStrategy:");
        System.out.println(word + " is palindrome? " + context.check(word));
    }
}