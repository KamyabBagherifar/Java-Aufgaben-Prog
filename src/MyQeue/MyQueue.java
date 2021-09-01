package MyQeue;

import java.util.LinkedList;
import java.util.List;

public class MyQueue<T> {
    private List<T> queue = new LinkedList<>();


    public MyQueue() {

    }

    public String toString() {
        return queue.toString();
    }

    public boolean enter(T e) {
        queue.add(0, e);
        return true;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T leave() {
        try {
            T lastelement = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            return lastelement;

        } catch (Exception e) {
            throw new java.util.NoSuchElementException();

        }

    }

    public T front() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.get(queue.size() - 1);
        }
    }


}
