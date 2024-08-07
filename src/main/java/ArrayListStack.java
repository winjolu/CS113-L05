import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
    private ArrayList<E> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E push(E obj) {
        stack.add(obj);
        return obj;
    }
}