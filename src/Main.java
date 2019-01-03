import impl.DoubleLinkedList;
import impl.SingleLinkedList;

public class Main {

    public static void main(String[] args) {
        /*single linked list*/
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(5);
        singleLinkedList.add(7);
        singleLinkedList.add(9);
        singleLinkedList.add(11);
        System.out.println(singleLinkedList.contains(0));
        System.out.println(singleLinkedList.delete(11));
        System.out.println(singleLinkedList.traversalWithAddToList());
        System.out.println(singleLinkedList.reverseTraversalWithAddToList());

        /*double linked list*/
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
    }
}
