import java.util.*;
class BinaryTreeNode<T> {
    int data;
    BinaryTreeNode<T> left, right;

    BinaryTreeNode(Integer data) {
        this.data = data;
        left = right = null;
    }
}

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

// parent tree method

class timeToBurnBinaryTreeStriver {
    private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root,
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node.data == start)
                res = node;
            if (node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp,
            BinaryTreeNode<Integer> target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);
        HashMap<BinaryTreeNode<Integer>, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;

            for (int i = 0; i < sz; i++) {
                BinaryTreeNode<Integer> node = q.poll();
                if (node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if (node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if (mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if (fl == 1)
                maxi++;
        }
        return maxi;
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }
}