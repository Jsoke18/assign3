package referenceBasedTreeImplementation;

import exceptions.TreeException;
import utilities.*;
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    public BSTreeNode<E> root;
    public int size;

    public BSTree() {
        this.root = null;
    }

    
    /** 
     * @param newEntry
     * @return boolean
     * @throws NullPointerException
     */
    @Override
    public boolean add(Comparable newEntry) throws NullPointerException {
        if (this.root == null) {
            root = new BSTreeNode<E>((E) newEntry);
            size++;
            return true;
        }
        BSTreeNode current = this.root;
        while (current != null) {
            if (newEntry.compareTo(current.getElement()) < 0) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new BSTreeNode<E>((E) newEntry));
                    size++;
                    return true;
                }
            } else if (newEntry.compareTo(current.getElement()) > 0) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new BSTreeNode<E>((E) newEntry));
                    size++;
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    
    /** 
     * @return BSTreeNode<E>
     * @throws TreeException
     */
    @Override
    public BSTreeNode<E> getRoot() throws TreeException {
        return root;
    }

    
    /** 
     * @param entry
     * @return BSTreeNode<E>
     * @throws TreeException
     */
    @Override
    public BSTreeNode<E> search(Comparable entry) throws TreeException {
        if (root == null) {
            return null;
        }
        BSTreeNode<E> current = root;
        while (current != null) {
            if (entry.compareTo(current.getElement()) < 0) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    return null;
                }
            } else if (entry.compareTo(current.getElement()) > 0) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    return null;
                }
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        this.root = null;
    }

    
    /** 
     * @param entry
     * @return boolean
     * @throws TreeException
     */
    @Override
    public boolean contains(Comparable entry) throws TreeException {
        return search(entry) != null;
    }

    
    /** 
     * @return int
     */
    @Override
    public int getHeight() {
        return getHeight(this.root);
    }

    
    /** 
     * @param node
     * @return int
     */
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

    
    /** 
     * @return Iterator<E>
     */
    @Override
    public Iterator<E> inorderIterator() {
        return new LVR<E>(root);
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    
    /** 
     * @return Iterator<E>
     */
    @Override
    public Iterator<E> postorderIterator() {
        return new LRV<E>(root);
    }

    
    /** 
     * @return Iterator<E>
     */
    @Override
    public Iterator<E> preorderIterator() {
        return new VLR<E>(root);
    }

    
    /** 
     * @return int
     */
    @Override
    public int size() {
        return this.size;
    }

}
