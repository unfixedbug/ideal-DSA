
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int key) {
        data = key;
        left = right = null;
    }
}

class inroder {
    public static void IterativeInorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr == null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.println(curr.data + " ");
                curr = curr.right;
            }
        }
    }

    public static void recursiveinorder(Node root) {
        if (root == null) {
            return;
        }

        recursiveinorder(root.left);

        System.out.print(root.data + " ");

        recursiveinorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        recursiveinorder(root);
    }
}

class preorder {
    public static void recursivepreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        recursivepreorder(root.left);
        recursivepreorder(root.right);
    }

    public static void iterativePreorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Integer> out = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            out.push(curr.data);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        while (!out.isEmpty()) {
            System.out.println(out.pop());
        }

    }
}

class postOrder {
    public static void recursivepostorder(Node root) {
        if (root == null) {
            return;
        }

        recursivepostorder(root.left);
        recursivepostorder(root.right);
        System.out.println(root.data);
    }

    public static void iterativePostorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Integer> out = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            out.push(curr.data);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            } // right child must be pusshed first in order to get left one early
        }
        while (!out.isEmpty()) {
            System.out.println(out.pop());
        }

    }

}

class levelorder {

    void levelorder(Node root) {/// bfs traversal ie 1-2-3-4-5
        int h = height(root);
        
        for (int j = 0; j <=h; j++) {
            printCurrentLevel(root, j);
        }
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return rheight + 1;
            }
        }
    }

    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.println(root.data + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
}