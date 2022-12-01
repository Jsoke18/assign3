package ultilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class VLR<E extends Comparable<? super E>> extends BSTreeIterator<E>{
    public VLR(BSTreeNode<E> root) {
        tranverse(root);
    }

    private void tranverse(BSTreeNode<E> node) {
        super.queue.add(node);
        tranverse(node.getLeft());
        tranverse(node.getRight());
    }
}
