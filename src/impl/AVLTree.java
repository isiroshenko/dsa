package impl;

public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;
    private long size;

    public long size() {
        return size;
    }

    private void leftRotation(Node<T> node) {
        if (node.right == null) throw new NullPointerException("Right value is null");
        Node<T> rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
    }

    private void rightRotation(Node<T> node) {
        if (node.left == null) throw new NullPointerException("Left value is null");
        Node<T> leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
    }

    private void leftAndRightRotation(Node<T> node) {
        leftRotation(node);
        rightRotation(node);
    }

    private void rightAndLeftRotation(Node<T> node) {
        rightRotation(node);
        leftRotation(node);
    }

    private void checkBalance(Node<T> current) {
        if ((current.left != null) && (current.right == null))
            current.height = -1;
        else current.height = Math.max(current.left.height, current.right.height) + 1;
        if (current.left.height - current.right.height > 1) {
            if (current.left.left.height - current.left.right.height > 0) {
                rightRotation(current);
            } else leftAndRightRotation(current);
        } else if (current.left.height - current.right.height < -1) {
            if (current.right.left.height - current.right.right.height < 0) {
                leftRotation(current);
            } else rightAndLeftRotation(current);
        }
    }

    public void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else insertNode(root, value);
        size++;
    }

    private void insertNode(Node<T> current, T value) {
        if (value.compareTo(current.value) < 0) {
            if (current.left == null) {
                current.left = new Node<>(value);
            } else {
                insertNode(current.left, value);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<>(value);
            } else {
                insertNode(current.right, value);
            }
        }
        checkBalance(current);
    }

    private static class Node<T extends Comparable<T>> {
        Node<T> left;
        Node<T> right;
        T value;
        int height;

        Node(T value) {
            this.value = value;
        }
    }
}
