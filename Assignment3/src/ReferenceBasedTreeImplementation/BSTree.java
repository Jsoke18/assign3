package ReferenceBasedTreeImplementation;

import Exceptions.TreeException;
import Ultilities.BSTreeADT;
import Ultilities.Iterator;

public class BSTree<E extends Comparable> implements BSTreeADT<E> {
    public BSTreeNode<E> root;
    public int size;

    public BSTree() {
        this.root = null;
    }

    @Override
    public boolean add(Comparable newEntry) throws NullPointerException {
        if (this.root == null) {
            root = new BSTreeNode<E>(newEntry);
            size++;
            return true;
        }
        BSTreeNode current = this.root;
        while (current != null) {
            if (newEntry.compareTo(current.getElement()) < 0) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new BSTreeNode<E>(newEntry));
                    size++;
                    return true;
                }
            } else if (newEntry.compareTo(current.getElement()) > 0) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new BSTreeNode<E>(newEntry));
                    size++;
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    @Override
    public BSTreeNode<E> getRoot() throws TreeException {
        return root;
    }

    @Override
    public BSTreeNode<E> search(Comparable entry) throws TreeException {
        if (root == null) {
            return null;
        }
        BSTreeNode<E> current = root;
        while (current != null) {
            if (newEntry.compareTo(current.getElement()) < 0) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    return null;
                }
            } else if (newEntry.compareTo(current.getElement()) > 0) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    return null;
                }
            } else {
                return current;
            }
        }
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean contains(Comparable entry) {
        return search(entry) != null;
    }

    @Override
    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(BSTreeNode<E> node) {
        if(node == null) {
			return 0;
		}
		
		int leftHeight = getHeight(node.getLeft());
		int rightHeight = getHeight(node.getRight());
		
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		else {
			return rightHeight + 1;
		}
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
