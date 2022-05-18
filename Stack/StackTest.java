package Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("Joao");
        System.out.println(stack);
        stack.push("Pedro");
        System.out.println(stack);

        String name1 = stack.pop();
        System.out.println(stack);

        stack.push("Hamilton");
        System.out.println(stack);
        String name2 = stack.pop();
        System.out.println(stack);

        System.out.println(name1);
        System.out.println(name2);
        stack.pop();

        System.out.println(stack);
        System.out.println(stack.empty());
    }
}
