package Set;

public class SetTest {
    public static void main(String[] args) {
        Set set = new Set();

        set.add("Joao");
        System.out.println(set);

        set.add("Joao");
        System.out.println(set);

        set.add("Juca");
        set.add("Pedro");
        System.out.println(set);

        set.remove("Juca");
        System.out.println(set);
    }
}
