package impl;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Number> {

    private List<T> list;

    public Heap(int size){
        list = new ArrayList<>(size);
    }


    public void add(T value){
        list.add(value);
        minHeapify();
    }

    private void minHeapify(){
        int i = list.size() - 1;
        while((i > 0) && (list.get(i).doubleValue() < list.get((i - 1)/2).doubleValue())){
            T temp = list.get(i);
            list.set(i, list.get((i -1)/2));
            list.set((i -1)/2, temp);
            i = (i-1)/2;
        }
    }
}
