import java.util.Queue;

public class Main {
  public static void main(String[] args) {
      // Demonstrate Stack functionality
      System.out.println("Demonstrating Stack functionality:");
      StackInterface<Integer> stack = new ArrayListStack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      System.out.println("Peek: " + stack.peek()); // Should print 3
      System.out.println("Pop: " + stack.pop());   // Should print 3
      System.out.println("Pop: " + stack.pop());   // Should print 2
      System.out.println("Empty: " + stack.empty()); // Should print false
      System.out.println("Pop: " + stack.pop());   // Should print 1
      System.out.println("Empty: " + stack.empty()); // Should print true

      // Demonstrate Queue functionality
      System.out.println("\nDemonstrating Queue functionality:");
      Queue<String> queue = new CircularArrayQueue<>(5);
      queue.offer("A");
      queue.offer("B");
      queue.offer("C");
      System.out.println("Peek: " + queue.peek()); // Should print A
      System.out.println("Poll: " + queue.poll()); // Should print A
      System.out.println("Poll: " + queue.poll()); // Should print B
      System.out.println("Empty: " + queue.isEmpty()); // Should print false
      System.out.println("Poll: " + queue.poll()); // Should print C
      System.out.println("Empty: " + queue.isEmpty()); // Should print true

      // Demonstrate Palindrome functionality
      System.out.println("\nDemonstrating Palindrome functionality:");
      Palindrome palindromeChecker = new Palindrome();
      String[] testStrings = {"madam", "racecar", "hello", "A man a plan a canal Panama", "12321"};
      for (String testString : testStrings) {
          System.out.println("Is \"" + testString + "\" a palindrome? " + palindromeChecker.isPalindrome(testString));
      }
  }
}