package nl.hva.ss;

import java.util.NoSuchElementException;

public class BST<K extends Comparable,V> {

    Node root;

    public void put(K k, V v) {
        root = put(root,k,v);
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if(x == null) return 0;

        return x.N;
    }

    private Node put(Node node, K k, V v) {

        if(node == null) {
            return new Node(k,v,1);
        }
        int comp = k.compareTo(node.key);

        // left
        if(comp < 0) {
            node.left = put(node.left,k,v);
        } else
            // right
            if (comp > 0) {
                node.right = put(node.right,k,v);
            } else { // equals
                node.value = v;
            }

        node.N = 1+ size(node.left) + size(node.right);

        return node;
    }

    public V get(K key) {
        return get(key,root);
    }

    private V get(K key, Node node) {

        if(node == null) {
            throw new NoSuchElementException("element not found with key " + key);
        }

        int comp = node.key.compareTo(key);

        if(comp < 0) {
            return get(key,node.left);
        } else if(comp > 0) {
            return get(key,node.right);
        } else {
            return node.value;
        }
    }

    public V min() {
        return min(root);
    }

    public V min(Node n) {
        if(n == null) {
            throw new
                    NoSuchElementException("empty tree");
        } else if(n.left == null) {
            return n.value;
        } else {
            return min(n.left);
        }
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);

    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }

    public K floor(K key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, K key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;

        if (cmp < 0)  return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        else           return x;

    }

    public int rank(K key)
    {  return rank(key, root);  }

    private int rank(K key, Node x)
    {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp  < 0) return rank(key, x.left);
        else if (cmp  > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    class Node {
        K key;
        V value;
        Node left;
        Node right;
        int N;

        Node(K k, V v, int size) {
            this.key = k;
            this.value = v;
            this.N = size;
        }
    }


    public static void main(String[] args) {

        BST<Double,Integer> bst = new BST();

        bst.put(10.0,1);
        bst.put(7.0,1);
        bst.put(12.0,1);
        bst.put(3.0,1);
        bst.put(9.5,1);
        bst.put(4.0,1);
        bst.put(11.0,1);
        bst.put(18.0,1);

        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();

        System.out.println("Floor of 5: " + bst.floor(5.0));

        System.out.println("Rank of 7: " + bst.rank(7.0));

        System.out.println("Min: " + bst.min());

    }
    
}

