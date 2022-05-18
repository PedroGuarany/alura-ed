package Stack;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    private List<String> names = new LinkedList<String>();

    public void push(String name){
        names.add(name);
    }

    public String pop(){
        return names.remove(names.size() - 1);
    }

    public boolean empty(){
        return names.isEmpty();
    }

    @Override
    public String toString() {
        return names.toString();
    }
}
