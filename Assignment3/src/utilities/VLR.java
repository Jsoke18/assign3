package utilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class VLR<E extends Comparable<? super E>> extends BSTreeIterator<E>{
    public VLR(BSTreeNode<E> root) {
        tranverse(root);
    }

    
    /** 
     * @param node
     */
    private void tranverse(BSTreeNode<E> node) {
        if (node == null){
            return;
        }
        super.queue.add(node);
        tranverse(node.getLeft());
        tranverse(node.getRight());
    }
}
