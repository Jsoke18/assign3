package utilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class LRV<E extends Comparable<? super E>> extends BSTreeIterator<E>{
    public LRV(BSTreeNode<E> root) {
        tranverse(root);
    }

    
    /** 
     * @param node
     */
    private void tranverse(BSTreeNode<E> node) {
        if (node == null){
            return;
        }
        tranverse(node.getLeft());
        tranverse(node.getRight());
        super.queue.add(node);
    }
}
