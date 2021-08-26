import java.util.*;

public class trie_insert_search_delete {
    // implemenation of trie
    public static void main(String[] args) {

        // creating a trie from class Trie
        Trie trie = new Trie();
        // tree.root = new TrieNode();

        // helper input
        String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

        // constructing a trie from class Trie
        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }

        System.out.println(trie.search("the"));
        System.out.println(trie.search("googlebc"));

    }
}

// 1) Trie(generic class)
// 2) trie_insert_search_delete(public assesible class)
// 3) Trieee(using arrays)

class Trie {
    private static final int CHAR_SIZE = 26;

    private boolean isLeaf; // boolean value to denote the end of the word
    private List<Trie> children = null;

    // constructer
    Trie() {
        isLeaf = false;
        children = new ArrayList<Trie>(Collections.nCopies(CHAR_SIZE, null));
    }

    // insert a strig to a Trie
    public void insert(String key) {
        Trie curr = this;

        for (char c : key.toCharArray()) {
            if (curr.children.get(c - 'a') == null) {
                curr.children.set(c - 'a', new Trie());
            }
            // set current to next node(children node)
            curr = curr.children.get(c - 'a');
        }
        curr.isLeaf = true; // end of the word
    }

    public boolean search(String key) {
        Trie curr = this;
        for (char c : key.toCharArray()) {
            curr = curr.children.get(c - 'a');
            if (curr.children.get(c - 'a') == null) {
                return false;
            }
        }

        return curr.isLeaf;
    }

}

class Trieeeee { // using array
    private static final int CHAR_SIZE = 26;

    // trie Node(another constructer)
    static class TrieNode {
        TrieNode children[] = new TrieNode[CHAR_SIZE];

        // to denote that is the word ended?
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < CHAR_SIZE; i++) {
                // initially mark all childrens as null
                children[i] = null;
            }
        }
    };// created a TrieNode

    static TrieNode root = new TrieNode(); // instance of a trie (starts from root)

    // function to insert a word in the trie(full word)
    static void insert(String key) {

        // current level, lenght -> (levels we want to traverse upto)
        int level, length = key.length(), index;

        // index used to crawl over the tree
        TrieNode parent = root;
        for (level = 0; level < length; level++) {

            // traverse the childrens of parent(full trie)
            index = key.charAt(level) - 'a'; // a->0, b->1, c->2, ...(conversion)
            if (parent.children[index] == null) { // this means that the child is not there
                // create a new child
                parent.children[index] = new TrieNode();
            }
            // mark last node as leaf
            parent = parent.children[index];
        }

        // after every level is travered, mark the last node as leaf and set end of word
        // to be true
        parent.isEndOfWord = true;
    }

    static boolean search(String key) {// returns true if the word is present in the trie, else false
        int level, lenght = key.length(), index;
        TrieNode parent = root;
        for (level = 0; level < lenght; level++) {
            index = key.charAt(level) - 'a';
            if (parent.children[index] == null) {
                return false;
            }
            parent = parent.children[index];
        }
        return parent.isEndOfWord;
    }

}