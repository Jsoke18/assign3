package ReferenceBasedTreeImplementation;

import Exceptions.TreeException;
import Ultilities.BSTreeADT;
import Ultilities.Iterator;

public class BSTree<E extends Comparable> implements BSTreeADT {
    public BSTreeNode<E> root;
    public int size;

    public BSTree() {
        this.root = null;
    }
    public BSTree(BSTreeNode<E> node) {
        this.root = node;
    }

    @Override
    public boolean add(Comparable newEntry) throws NullPointerException {
        if (this.root == null) {
            root = new BSTreeNode<E>(newEntry);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public BSTreeNode getRoot() throws TreeException {
        return root;
    }

    @Override
    public BSTreeNode search(Comparable entry) throws TreeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(Comparable entry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator inorderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Iterator postorderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator preorderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

}
