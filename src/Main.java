import impl.DoubleLinkedList;
import interfaces.MyLinkedList;
import impl.SingleLinkedList;

public class Main {

    public static void main(String[] args) {
        /*single linked list*/
        MyLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(5);
        singleLinkedList.add(7);
        singleLinkedList.add(9);
        singleLinkedList.add(11);
        System.out.println(singleLinkedList.contains(0));
        System.out.println(singleLinkedList.delete(11));
        System.out.println(singleLinkedList.traversalWithAddToList());
        System.out.println(singleLinkedList.reverseTraversalWithAddToList());

        /*double linked list*/
        MyLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(5);
        doubleLinkedList.add(7);
        doubleLinkedList.add(9);
        doubleLinkedList.add(11);
        System.out.println(doubleLinkedList.contains(0));
        System.out.println(doubleLinkedList.delete(9));
        System.out.println(doubleLinkedList.traversalWithAddToList());
        System.out.println(doubleLinkedList.reverseTraversalWithAddToList());
    }
}
