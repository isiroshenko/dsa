package impl;


import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    private long size;

    public long size() {
        return size;
    }

    public void insert(T value) {
        if (value == null) throw new IllegalArgumentException("You can insert only numbers");
        if (root == null) {
            root = new Node<>(value);
            size++;
        } else insertNode(root, value);
    }

    private void insertNode(Node<T> node, T value) {
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node<>(value);
                size++;
            } else {
                insertNode(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(value);
                size++;
            } else {
                insertNode(node.right, value);
            }
        }
    }

    public boolean contains(T value) {
        if (value == null) throw new IllegalArgumentException("You can write only numbers");
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) return false;
        if (node.value.equals(value)) return true;
        if (value.compareTo(node.value) < 0) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    private Optional<Node<T>> findParent(Node<T> root, T value) {
        if (value.compareTo(root.value) == 0) return Optional.empty();
        if (value.compareTo(root.value) < 0) {
            if (root.left == null) {
                return Optional.empty();
            } else if (root.left.value.compareTo(value) == 0) {
                return Optional.of(root);
            } else {
                return findParent(root.left, value);
            }
        } else {
            if (root.right == null) {
                return Optional.empty();
            } else if (root.right.value.compareTo(value) == 0) {
                return Optional.of(root);
            } else {
                return findParent(root.right, value);
            }
        }
    }

    private Optional<Node<T>> findNode(Node<T> root, T value) {
        if (root == null) return Optional.empty();
        if (root.value.compareTo(value) == 0) return Optional.of(root);
        else if (value.compareTo(root.value) < 0) {
            return findNode(root.left, value);
        } else {
            return findNode(root.right, value);
        }
    }

    public boolean remove(T value) {
        if (value == null) throw new IllegalArgumentException("You can write only numbers");
        Optional<Node<T>> optionalNodeToRemove = findNode(root, value);
        if (!optionalNodeToRemove.isPresent()) {
            return false;
        }
        Node<T> nodeToRemove = optionalNodeToRemove.get();
        Optional<Node<T>> optionalParent = findParent(root, value);
        if (!optionalParent.isPresent()) {
            return false;
        }
        Node<T> parent = optionalParent.get();
        if (size == 1) {
            root = null;
        } else if ((nodeToRemove.left == null) && (nodeToRemove.right == null)) {
            if (nodeToRemove.value.compareTo(parent.value) < 0) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (nodeToRemove.left == null) {
            if (nodeToRemove.value.compareTo(parent.value) < 0) {
                parent.left = nodeToRemove.right;
            } else {
                parent.right = nodeToRemove.right;
            }
        } else if (nodeToRemove.right == null) {
            if (nodeToRemove.value.compareTo(parent.value) < 0) {
                parent.left = nodeToRemove.left;
            } else {
                parent.right = nodeToRemove.left;
            }
        } else {
            Node<T> largestValue = nodeToRemove.left;
            while (largestValue.right != null) {
                largestValue = largestValue.right;
            }
            Node<T> rightPointer = findParent(root, largestValue.value).isPresent() ? findParent(root, largestValue.value).get() : null;
            if (rightPointer != null) {
                rightPointer.right = null;
            }
            nodeToRemove.value = largestValue.value;
        }
        size--;
        return true;
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(Node<T> node) {
        if (node == null) throw new IllegalArgumentException("You can't write nulls here");
        if (node.left == null) return node.value;
        else return findMin(node.left);
    }

    public T findMax() {
        return findMax(root);
    }

    private T findMax(Node<T> node) {
        if (node == null) throw new IllegalArgumentException("You can't write nulls here");
        if (node.right == null) return node.value;
        else return findMax(node.right);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    public List<T> breadthFirst() {
        return breadthFirst(root);
    }

    private List<T> breadthFirst(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<>();
        List<T> list = new ArrayList<>();
        while (node != null) {
            list.add(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!queue.isEmpty()) {
                node = queue.poll();
            } else {
                node = null;
            }
        }
        return list;
    }

    private static class Node<T extends Comparable<T>> {
        Node<T> left;
        Node<T> right;
        T value;

        Node(T value) {
            this.value = value;
        }
    }
}
