package nl.hva.ss.test;

public class TestBST {

    public static void main(String[] args) {

        BST<Integer,String> bst = new BST<>();

        bst.put(10,"A");
        bst.put(7,"A");
        bst.put(3,"A");
        bst.put(4,"A");
        bst.put(9,"A");
        bst.put(12,"A");
        bst.put(11,"A");
        bst.put(18,"A");

        System.out.println("getting value of 10: " + bst.get(10));
        System.out.println("min: " + bst.min());
        System.out.println("max: " + bst.max());
        bst.inOrder();



    }
}
