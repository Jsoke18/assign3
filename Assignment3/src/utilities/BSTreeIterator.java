package utilities;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import referenceBasedTreeImplementation.BSTreeNode;

public class BSTreeIterator<E extends Comparable<? super E>> implements Iterator<E> {
    protected Queue<BSTreeNode<E>> queue = new LinkedList<>();

    
    /** 
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return queue.peek() != null;
    }

	
    /** 
     * @return E
     * @throws NoSuchElementException
     */
    @Override
	public E next() throws NoSuchElementException {
		return queue.poll().getElement();
	}

}
