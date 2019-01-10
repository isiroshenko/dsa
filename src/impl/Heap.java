package impl;

import java.lang.reflect.Array;
import java.util.Optional;

public class Heap<T extends Comparable<T>>  {

    private T[] heap;
    private int count;


    public Heap(Class<T> tClass, int capacity) {
        @SuppressWarnings("unchecked")
        final T[] heap =  (T[]) Array.newInstance(tClass, capacity);
        this.heap = heap;
    }

    public void add(T value) {
        heap[count++] = value;
        minHeapify();
    }

    private void minHeapify() {
        int i = count - 1;
        while ((i > 0) && (heap[i].compareTo(heap[(i - 1) / 2]) < 0)) {
            T temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    private int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < heap.length; i++) {
                if (heap[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < heap.length; i++) {
                if (heap[i].equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean remove(T value) {
        int index = indexOf(value);
        if (index < 0) return false;
        int count = this.count - 1;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        heap[index] = heap[count];
        while ((left < count) && ((heap[index].compareTo(heap[left]) > 0) || (heap[index].compareTo(heap[right]) > 0))) {
            if (heap[left].compareTo(heap[right]) < 0) {
                T temp = heap[left];
                heap[left] = heap[index];
                heap[index] = temp;
                index = left;
            } else {
                T temp = heap[right];
                heap[right] = heap[index];
                heap[index] = temp;
                index = right;
            }
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
        this.count--;
        return true;
    }

    public boolean contains(T value){
        int i = 0;
        while ((i < count) && (!heap[i].equals(value))){
            i++;
        }
        return i < count;
    }
}
