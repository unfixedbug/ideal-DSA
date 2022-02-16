public class burnBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Depth {
        int d;

        public Depth(int d) {
            this.d = d;
        }
    }

    static int ans;

    // returns minimum time to burn the binary tree, from target
    public static int minTime(Node root, int target) {
        Depth depth = new Depth(-1);
        burn(root, target, depth);
        return ans;
    }

    public static int burn(Node root, int target, Depth depth) {
        if (root == null)
            return 0;
        if (root.data == target) {
            depth.d = 0;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(root.left, target, ld); // left and right height
        int rh = burn(root.right, target, rd);

        if (ld.d != -1) {
            ans = Math.max(ans, ld.d + 1 + rh);
        } else if (rd.d != -1) {
            ans = Math.max(ans, rd.d + 1 + lh);
        }

        return Math.max(lh, rh) + 1;
    }
}
