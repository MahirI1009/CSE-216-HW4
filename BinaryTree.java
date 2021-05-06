import java.util.*;

public class BinaryTree<T> implements Iterable<T>{

    public Node<T> root;

    //#1 node-and-pointer implementation of binary tree
    static class Node<T> {
        T data;
        BinaryTree<T> right = null, left = null;

        Node(T data) {this.data = data;}
    }

    //#2 no-arg constructor for empty tree, and constructor for tree with single node containing a specific value
    public BinaryTree() {};

    public BinaryTree(T data) {setRoot(data);}

    public BinaryTree(BinaryTree<T> left, T data, BinaryTree<T> right) {
        setRoot(data);
        addLeftChild(left);
        addRightChild(right);
    }

    public void setRoot(T data) {root = new Node<>(data);}

    //#3 addLeftChild and addRightChild
    public void addLeftChild(BinaryTree<T> tree) {root.left = tree;}

    public void addRightChild(BinaryTree<T> tree) {root.right = tree;}

    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator<>(this);
    }

    //#4 iterator implementation
    private static class BinaryTreeIterator<T> implements Iterator<T> {
       Queue<BinaryTree<T>> q = new LinkedList<>();

        BinaryTreeIterator(BinaryTree<T> tree) {
            if (tree.root.data != null)
                q.add(tree);
        }

        @Override
        public boolean hasNext() {return !q.isEmpty();}

        @Override
        public T next() {
            BinaryTree<T> tree = q.remove();
            //Node<T> node = tree.root;
            if (tree.root.left != null)
                q.add(tree.root.left);
            if (tree.root.right != null)
                q.add(tree.root.right);
            return tree.root.data;
        }
    }
}
