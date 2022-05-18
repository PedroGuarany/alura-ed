package Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Set {

    private ArrayList<LinkedList<String>> table = new ArrayList<LinkedList<String>>();

    public Set(){
        for (int i = 0; i < 26; i++) {
            table.add(new LinkedList<String>());
        }
    }

    public void add(String text){
        if(!contains(text)){
            int index = getTableIndex(text);
            List<String> list = table.get(index);
            list.add(text);
        }
    }

    public void remove(String text){
        if(contains(text)){
            int index = getTableIndex(text);
            List<String> list = table.get(index);
            list.remove(text);
        }
    }
 
    private boolean contains(String text){
        int index = getTableIndex(text);
        return table.get(index).contains(text);
    }

    private int getTableIndex(String text){
        return text.toLowerCase().charAt(0) % 26;
    }

    @Override
    public String toString() {
        return table.toString();
    }
}
