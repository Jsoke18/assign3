package ReferenceBasedTreeImplementation;

import java.io.*;

public class BSTreeNode<E extends Comparable<? super E>> implements Serializable {
    private E element;
    private BSTreeNode<E> left;
    private BSTreeNode<E> right;
    public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
    public BSTreeNode() {
    }
    public E getElement() {
        return element;
    }
    public void setElement(E element) {
        this.element = element;
    }
    public BSTreeNode<E> getLeft() {
        return left;
    }
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }
    public BSTreeNode<E> getRight() {
        return right;
    }
    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    public boolean hasLeftChild(){
		return this.left != null;
	}
	
	public boolean hasRightChild() {
		return this.right != null;
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
}
