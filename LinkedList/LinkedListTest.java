package LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add("Joao");
        list.add("Pedro");
        list.add("Moises");
        list.addAtStart("Hamilton");

        System.out.println(list);
        list.addAt(2, "Java");
        System.out.println(list);

        Object obj = list.get(2);
        System.out.println(obj);

        System.out.println(list.length());

        list.removeFromStart();
        System.out.println(list);

        list.removeFrom(1);
        list.removeFrom(2);
        System.out.println(list);

        list.add("Python");
        list.add("Clojure");
        System.out.println(list);
        list.removeFrom(1);
        System.out.println(list);
    }
}
