import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListStack: Stores data using the abstract data type of a stack, utilizing the two main methods for
 * data manipulation push() and pop().
 *
 * @param <E> data type of elements to be stored in the arrayList
 */
public class ArrayListStack<E> implements StackInterface<E> {
    private ArrayList<E> stack;

    /**
     * Default Constructor, initializes an empty arrayList.
     */
    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    @Override
    public E push(E obj) {
        stack.add(obj);
        return obj;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        return stack.size();
    }
}