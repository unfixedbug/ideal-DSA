//level order traversal of a binary tree
//zigzag traversal of a binary tree
//vertical order traversal of a binary tree

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}


class LevelOrderT {
    Node root;

    // constructer
    // public BinaryTreeLevelOrder() {
    // root = null;
    // }

    void printlevelorder() {
        int h = height(root);

        for (int i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight)
                return lheight + 1;
            else
                return rheight + 1;
        }
    }

    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

}

class ZigZagT {

    Node root;

    void PrintZigZagTreeTraversal() {
        if (root == null)
            return;
        Stack<Node> currentlevel = new Stack<>();
        Stack<Node> nextlevel = new Stack<>();

        currentlevel.push(root);
        boolean lefttoright = true;
        while (!currentlevel.isEmpty()) {
            Node node = currentlevel.pop();
            System.out.print(node.data + " ");

            if (lefttoright) {
                if (node.left != null)
                    nextlevel.push(node.left);
                if (node.right != null)
                    nextlevel.push(node.right);
            } else {
                if (node.right != null)
                    nextlevel.push(node.right);
                if (node.left != null)
                    nextlevel.push(node.left);
            }
            if (currentlevel.isEmpty()) {
                lefttoright = !lefttoright;
                Stack<Node> temp = currentlevel;
                currentlevel = nextlevel;
                nextlevel = temp;
            }
        }
    }
}

public class TreeTraversals {
    public static void main(String[] args) {

        LevelOrderT tree = new LevelOrderT();
        // ZigZagT tree = new ZigZagT();

        //org main
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);



        // System.out.println("zigzag traversal of binary tree is ");
        // tree.PrintZigZagTreeTraversal();

        System.out.println("level order traversal of binary tree is ");
        tree.printlevelorder();

    }
}
