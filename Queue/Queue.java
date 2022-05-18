package Queue;

import java.util.LinkedList;
import java.util.List;

public class Queue {
    private List<String> list = new LinkedList<String>();

    public void enqueue(String text){
        list.add(text);
    }

    public String dequeue(){
        return list.remove(0);
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
