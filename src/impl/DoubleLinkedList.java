package impl;

import interfaces.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<T> implements MyLinkedList<T> {

    private Node<T> head;
    private Node<T> last;

    private static class Node<T> {
        Node<T> previous;
        T value;
        Node<T> next;

        Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void add(T value) {
        if (value == null) throw new IllegalArgumentException("You can't add null");
        Node<T> element = new Node<>(null, value, null);
        if (head == null) {
            head = element;
            last = element;
        } else {
            element.previous = last;
            last.next = element;
            last = element;
        }
    }

    @Override
    public boolean contains(T value) {
        if (value == null) throw new IllegalArgumentException("You can't write null");
        Node<T> head = this.head;
        while (head != null) {
            if ((head.value).equals(value)) return true;
            else head = head.next;
        }
        return false;
    }

    @Override
    public boolean delete(T value) {
        if (value == null) throw new IllegalArgumentException("You can't delete null");
        Node<T> currentHead = head;
        if (currentHead == null) return false;
        if (currentHead.value.equals(value)) {
            if (currentHead.equals(last)) {
                head = null;
                last = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            return true;
        }
        currentHead = head.next;
        while ((currentHead != null) && (!currentHead.value.equals(value))) {
            currentHead = currentHead.next;
        }
        if (currentHead == last) {
            last = last.previous;
            last.next = null;
            return true;
        } else if (currentHead != null) {
            currentHead.previous.next = currentHead.next;
            currentHead.next.previous = currentHead.previous;
            return true;
        }
        return false;
    }


    @Override
    public List<T> traversalWithAddToList() {
        List<T> list = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }
        return list;
    }

    @Override
    public List<T> reverseTraversalWithAddToList() {
        List<T> list = new ArrayList<>();
        Node<T> current = last;
        while (current != null) {
            list.add(current.value);
            current = current.previous;
        }
        return list;
    }
}
