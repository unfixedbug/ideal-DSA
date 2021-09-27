import java.util.*;

public class SortStack {

    static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    static void printstack(Stack<Integer> s) {
        ListIterator<Integer> itr = s.listIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    static void sortstack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sortstack(s);
            sortedInsert(s, x);

        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        sortstack(stack);
        System.out.println(stack);
    }

}
