import impl.*;
import interfaces.MyLinkedList;


public class Main {

    public static void main(String[] args) {
        verifySingleLinkedList();
        verifyDoubleLinkedList();
        verifyBinarySearchTree();
        verifyHeap();
        verifyHeapWithList();
    }

    /*single linked list*/
    private static void verifySingleLinkedList() {
        MyLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(5);
        singleLinkedList.add(7);
        singleLinkedList.add(9);
        singleLinkedList.add(11);
        System.out.println();
        System.out.println("Single linked list:");
        System.out.println("Contains 0: " + singleLinkedList.contains(0));
        System.out.println("Is 11 deleted: " + singleLinkedList.delete(11));
        System.out.println("Show elements: " + singleLinkedList.traversalWithAddToList());
        System.out.println("Show elements in reverse order: " + singleLinkedList.reverseTraversalWithAddToList());
    }

    /*double linked list*/
    private static void verifyDoubleLinkedList() {
        MyLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(5);
        doubleLinkedList.add(7);
        doubleLinkedList.add(9);
        doubleLinkedList.add(11);
        System.out.println();
        System.out.println("Double linked list:");
        System.out.println("Contains 0: " + doubleLinkedList.contains(0));
        System.out.println("Is 9 deleted: " + doubleLinkedList.delete(9));
        System.out.println("Show elements: " + doubleLinkedList.traversalWithAddToList());
        System.out.println("Show elements in reverse order: " + doubleLinkedList.reverseTraversalWithAddToList());
    }

    /*binary search tree*/
    private static void verifyBinarySearchTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(8);
        binarySearchTree.insert(2);
        System.out.println();
        System.out.println("Binary search tree:");
        System.out.println("Size: " + binarySearchTree.size());
        System.out.println("Contains 3: " + binarySearchTree.contains(3));
        System.out.println("Is 4 removed: " + binarySearchTree.remove(4));
        System.out.println("Biggest element: " + binarySearchTree.findMax());
        System.out.println("Smallest element: " + binarySearchTree.findMin());
        System.out.print("Preorder traversal: ");
        binarySearchTree.preorder();
        System.out.println();
        System.out.print("Postorder traversal: ");
        binarySearchTree.postorder();
        System.out.println();
        System.out.print("Inorder traversal: ");
        binarySearchTree.inorder();
        System.out.println();
        System.out.print("Breadth First traversal: ");
        System.out.println(binarySearchTree.breadthFirst());
    }

    private static void verifyHeapWithList() {
        HeapWithList<Integer> heap = new HeapWithList<>(10);
        heap.add(1);
        heap.add(3);
        heap.add(9);
        heap.add(12);
        heap.add(13);
        System.out.println();
        System.out.println("Heap with list inside:");
        System.out.println("Was element 1 deleted: " + heap.remove(1));
        System.out.println("Contains 9: " + heap.contains(9));
    }

    private static void verifyHeap(){
        Heap<Integer> heap = new Heap<>(Integer.class,10);
        heap.add(1);
        heap.add(3);
        heap.add(9);
        heap.add(12);
        heap.add(13);
        System.out.println();
        System.out.println("Heap:");
        System.out.println("Was element 1 deleted: " + heap.remove(1));
        System.out.println("Contains 9: " + heap.contains(9));
    }
}
