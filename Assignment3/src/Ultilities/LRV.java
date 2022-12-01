package ultilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class LRV<E extends Comparable<? super E>> extends BSTreeIterator<E>{
    public LRV(BSTreeNode<E> root) {
        tranverse(root);
    }

    private void tranverse(BSTreeNode<E> node) {
        tranverse(node.getLeft());
        tranverse(node.getRight());
        super.queue.add(node);
    }
}
