import java.util.Stack;

public class Palindrome {

    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param s a string comprised of any character
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Remove whitespace and convert to lowercase
        s = s.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push first half of the string onto the stack
        int length = s.length();
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            stack.push(s.charAt(i));
        }

        // If the length is odd, skip the middle character
        int startIndex = (length % 2 == 0) ? halfLength : halfLength + 1;

        // Compare the second half of the string with the characters popped from the stack
        for (int i = startIndex; i < length; i++) {
            if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}