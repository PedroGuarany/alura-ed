import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int totalElements;

    public Heap(){
        this.heap  = new int[15];
        this.totalElements = -1;
    }
    public Heap(int[] array){
        this.heap = array;
        this.totalElements = this.heap.length - 1;
        for (int i = parent(totalElements); i >= 0; i--) {
            reorganizeDown(i);
        }
    }
    public boolean isEmpty(){
        return totalElements == 0;
    }

    public int length() { return totalElements; };
    public void add(int value){
        if(heap.length == totalElements)
            resize();
        totalElements++;

        heap[totalElements] = value;

        reorganizeUp(totalElements, parent(totalElements));
    }

    public int remove(){
        int aux = heap[0];
        heap[0] = heap[totalElements];
        totalElements--;


        reorganizeDown(0);
        return aux;
    }

    private void reorganizeUp(int index, int parentIndex){
        if(parentIndex == -1)
            return;
        if (heap[index] > heap[parentIndex]){
            swap(index, parentIndex);
            reorganizeUp(parent(index), parent(parentIndex));
        }
    }

    private void reorganizeDown(int index){
        if (isLeaf(index) || !isValidIndex(index))
            return;

        int indexFromBigger = getGreater(index, left(index), right(index));
        if (indexFromBigger != index){
            swap(index, indexFromBigger);
            reorganizeDown(indexFromBigger);
        }
    }

    private int getGreater(int index, int leftIndex, int rightIndex){
        if (this.heap[index] > this.heap[leftIndex]) {
            if (isValidIndex(rightIndex)) {
                if (this.heap[index] < this.heap[rightIndex])
                    return rightIndex;
            }
            return index;

        } else {
            if (isValidIndex(rightIndex)) {
                if (this.heap[leftIndex] < this.heap[rightIndex])
                    return rightIndex;
            }

            return leftIndex;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= totalElements;
    }

    private boolean isLeaf(int index) {
        return index > parent(totalElements) && index <= totalElements;
    }

    private void swap(int index, int otherIndex){
        int aux = heap[index];
        heap[index] = heap[otherIndex];
        heap[otherIndex] = aux;
    }

    private void resize(){
        int[] aux = new int[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            aux[i] = heap[i];
        }
        heap = aux;
    }

    private int left(int index){
        return 2 * index + 1;
    }

    private int right(int index){
        return 2 * (index + 1);
    }

    private int parent(int index){
        return (index - 1)/2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i <= totalElements; i++) {
            builder.append(heap[i] + ", ");
        }
        builder.delete(builder.length() -2, builder.length());
        builder.append("]");
        return builder.toString();
    }
}
