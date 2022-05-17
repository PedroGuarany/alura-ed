package class1;

public class ArrayTest {
    public static void main(String[] args) {
        Student s1 = new Student("Joao");
        Student s2 = new Student("Pedro");
        Student s3 = new Student("Mario");

        MyArray array = new MyArray();

        for (int i = 0; i < 300; i++) {
            array.add(new Student("" + i));
        }

        System.out.println(array);
    }
}
