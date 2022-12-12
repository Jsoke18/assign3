package referenceBasedTreeImplementation;

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
    public BSTreeNode(E element) {
    	this.element = element;
    }
	
    /** 
     * @return E
     */
    public E getElement() {
        return element;
    }
    
    /** 
     * @param element
     */
    public void setElement(E element) {
        this.element = element;
    }
    
    /** 
     * @return BSTreeNode<E>
     */
    public BSTreeNode<E> getLeft() {
        return left;
    }
    
    /** 
     * @param left
     */
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }
    
    /** 
     * @return BSTreeNode<E>
     */
    public BSTreeNode<E> getRight() {
        return right;
    }
    
    /** 
     * @param right
     */
    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    
    /** 
     * @return boolean
     */
    public boolean hasLeftChild(){
		return this.left != null;
	}
	
	
    /** 
     * @return boolean
     */
    public boolean hasRightChild() {
		return this.right != null;
	}
	
	
    /** 
     * @return boolean
     */
    public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
}
