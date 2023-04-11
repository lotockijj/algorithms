package three.five;

import java.util.ArrayList;
import java.util.List;

public class ST {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key; // key
        double val; // associated data
        Node left, right; // subtrees
        int N; // # nodes in this subtree
        boolean color; // color of link from
        // parent to this node
        Node(int key, double val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }

        @Override
        public String toString() {
            return "[" + key + "; " + val + "] ";
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public void put(int key, double val) { // Search for key. Update value if found; grow table if new.
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, int key, double val) {
        if (h == null) // Do standard insert, with red link to parent.
            return new Node(key, val, 1, RED);
        if (key < h.key) h.left = put(h.left, key, val);
        else if (key > h.key) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public List<String> getKeys(){
        List<String> nodes = new ArrayList<>();
        Node tempNode = root;
        nodes.add(tempNode.toString());
        add(nodes, tempNode.left, tempNode.right);
        return nodes;
    }

    private void add(List<String> nodes, Node left, Node right) {
        if(left != null){
            nodes.add(left.toString());
            add(nodes, left.left, left.right);
        }
        if(right != null){
            nodes.add(right.toString());
            add(nodes, right.left, right.right);
        }
    }
}