package interfaces;

import java.util.List;

public interface MyLinkedList<T> {

    boolean delete(T value);

    boolean contains(T value);

    void add(T value);

    List traversalWithAddToList();

    List reverseTraversalWithAddToList();
}
