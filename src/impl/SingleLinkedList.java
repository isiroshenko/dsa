package impl;

import interfaces.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList<T> implements MyLinkedList<T> {

    private Node<T> head;
    private Node<T> last;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void add(T value) {
        if (value == null) throw new IllegalArgumentException("You can't write null");
        Node<T> element = new Node<>(value, null);
        if (head == null) {
            head = element;
            last = element;
        } else {
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
        if (value == null) throw new IllegalArgumentException("You can't write null");
        Node<T> currentHead = this.head;
        if (this.head == null) return false;
        if (this.head.value.equals(value)) {
            if (this.head.equals(this.last)) {
                this.head = null;
                last = null;
            } else {
                this.head = head.next;
            }
            return true;
        }
        while ((currentHead.next != null) && (!currentHead.next.value.equals(value))) {
            currentHead = currentHead.next;
        }
        if (currentHead.next != null) {
            if (currentHead.next == last) {
                last = currentHead;
            }
            currentHead.next = currentHead.next.next;
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
        Node<T> previous;
        while (current != head) {
            previous = head;
            while (previous.next != current) {
                previous = previous.next;
            }
            list.add(current.value);
            current = previous;
        }
        list.add(current.value);
        return list;
    }
}
