import java.util.Currency;

class Node {
    int data;
    Node left, right;

    public Node(int key) {
        data = key;
        left = right = null;
    }
}

public class binarysearchTree {

    public Node search(Node root, int key) {
        if (root == null || root.data == key)
            return root;
        if (root.data < key) {
            return search(root.right, key);
        } else
            return search(root.left, key);
    }

    public static Node insertRecursive(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static Node insertIterative(Node root, int key) {
        Node curr = root;
        Node parent = null;
        if (root == null) {
            return new Node(key);
        }
        while (curr != null) {
            parent = curr;
            if (key < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (key < parent.data) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);

        }
        return root;
    }
}
