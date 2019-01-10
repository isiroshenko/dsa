package impl;

import java.util.ArrayList;
import java.util.List;

public class HeapWithList<T extends Comparable<T>> {

    private List<T> list;

    private int size;

    private int count;

    public HeapWithList(int size) {
        this.size = size;
        list = new ArrayList<>(size);
    }


    public void add(T value) {
        if (list.size() == size) throw new ArrayIndexOutOfBoundsException("Capacity is " + size + " elements");
        list.add(value);
        count++;
        minHeapify();
    }


    private void minHeapify() {
        int i = list.size() - 1;
        while ((i > 0) && (list.get(i).compareTo(list.get((i - 1) / 2)) < 0)) {
            T temp = list.get(i);
            list.set(i, list.get((i - 1) / 2));
            list.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }


    public boolean remove(T value) {
        int index = list.indexOf(value);
        if (index < 0) return false;
        int count = list.size() - 1;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        list.set(index, list.get(count));
        while ((left < count) && ((list.get(index).compareTo(list.get(left)) > 0) || (list.get(index).compareTo(list.get(right)) > 0))) {
            if (list.get(left).compareTo(list.get(right)) < 0) {
                T temp = list.get(left);
                list.set(left, list.get(index));
                list.set(index, temp);
                index = left;
            } else {
                T temp = list.get(right);
                list.set(right, list.get(index));
                list.set(index, temp);
                index = right;
            }
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
        this.count--;
        return true;
    }

    public boolean contains(T value) {
        return list.contains(value);
    }

    public void traversal() {
        for (int i = 0; i < count; i++) {
            System.out.print(list.get(i).toString() + " ");
        }
    }
}
