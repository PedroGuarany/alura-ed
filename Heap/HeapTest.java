import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{40, 87, 2, 90, 1, 100, 30, 20});

        System.out.println(heap);
        int[] sorted = heapSort(heap);
        System.out.println(Arrays.toString(sorted));

    }

    public static int[] heapSort(Heap heap){
        int[] aux = new int[heap.length()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = heap.remove();
        }
        return aux;
    }
}
