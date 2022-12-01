package ultilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class LVR<E extends Comparable<? super E>> extends BSTreeIterator<E>{
    public LVR(BSTreeNode<E> root) {
        tranverse(root);
    }

    private void tranverse(BSTreeNode<E> node) {
        tranverse(node.getLeft());
        super.queue.add(node);
        tranverse(node.getRight());
    }
}
