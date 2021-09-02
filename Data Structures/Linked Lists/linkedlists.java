class sinlgyLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    Node IterativeReverse(Node node) {
        Node prev = null;
        Node current = node;
        Node temp = null; // temp is used to store the next node
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        node = prev;
        return node;
    }

    Node recursiveReverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = recursiveReverse(head.next);
        Node headNNEXT = head.next;

        headNNEXT.next = head;
        head.next = null;
        return newHead;

    }
}