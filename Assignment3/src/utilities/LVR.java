package utilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class LVR<E extends Comparable<? super E>> extends BSTreeIterator<E>{
    public LVR(BSTreeNode<E> root) {
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
        super.queue.add(node);
        tranverse(node.getRight());
    }
}
