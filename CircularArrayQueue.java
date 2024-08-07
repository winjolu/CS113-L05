import java.util.*;

/**
 * CircularArrayQueue: Stores data using the abstract data type of a queue, implements all the methods
 * of the java.util.Queue class
 *
 * @param <E> data type of elements to be stored in the arrayList
 */
public class CircularArrayQueue<E> implements Queue<E> {
    private E[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /**
     * Initializes an array using the abstract data type queue.
     *
     * @param maxSize the size of the array
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int maxSize) {
        capacity = maxSize;
        queue = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws NullPointerException if the specified element is null.
     */
    @Override
    public boolean offer(E e) {
        if (e == null) throw new NullPointerException();
        if (size == capacity) resize();
        rear = (rear + 1) % capacity;
        queue[rear] = e;
        size++;
        return true;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     */
    @Override
    public boolean add(E e) {
        if (offer(e)) return true;
        else throw new IllegalStateException("Queue full");
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        if (size == 0) return null;
        E item = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll() poll()} only in that it throws an exception if
     * this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        if (size == 0) throw new NoSuchElementException();
        return poll();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        if (size == 0) throw new NoSuchElementException();
        return queue[front];
    }

    /**
     * Returns the element at the head of the queue. Returns null if
     * the queue is empty.
     *
     * @return element at the head of the queue.
     */
    @Override
    public E peek() {
        if (size == 0) return null;
        return queue[front];
    }

    /**
     * Helper method that creates an array twice the size of the
     * original array.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newQueue = (E[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
        capacity *= 2;
    }

    /**
     * The following methods were inherited from java.util.Collections and
     * were not implemented in this homework assignment.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}