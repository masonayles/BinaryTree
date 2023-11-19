import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;


/**
 *Class BinaryTree<E> is recursive data structure, where each
 * tree node has an optional left and right child
 * node. Each node allows setting the left or right child,
 * which has the side effect of detaching any pre-existing
 * child subtree rooted at that node from itself and returning it.
 * @param <E> param E is the type parameter
 */
public class BinaryTree<E> implements Iterable<E> {
    private E element;
    private BinaryTree<E> _leftChild;
    private BinaryTree<E> _rightChild;
    private BinaryTree<E> _parent;

    /**
     * Constructs a new BinaryTree node with a specified element.
     * both left and right children are set to null.
     *
     * @param element The element to be added in the new tree.
     */
    public BinaryTree(E element) {
        this.element = element;
        this._leftChild = null;
        this._rightChild = null;
        this._parent = null;
    }

    /**
     * Retrviews the element contained in this node.
     *
     * @return returns the element contained in this node.
     */
    public E getElement() {
        return this.element;
    }

    /**
     * Updates the element of this node.
     *
     * @param element element the new element to be stored in this node.
     * @return returning the previously stored element.
     */
    public E setElement(E element) {
        return this.element = element;
    }

    /**
     * Checks if this node has a left child.
     *
     * @return returns true if this node has a left child.
     */
    public boolean hasLeftChild() {
        return this._leftChild != null;
    }

    /**
     * Retrieves the left child of this node.
     *
     * @return returns the left child of this node, or null if there isn't one.
     */
    public BinaryTree<E> getLeftChild() {
        return this._leftChild;
    }

    /**
     * Sets the left child of this node. Detaches the current left child.
     *
     * @param child child is the new left child to be set.
     * @return returning the previous left child.
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child) {
        return setChild(true, child);
    }

    /**
     * Cehcks if this node has a right child.
     *
     * @return returning true if this node has a right child, false otherwise.
     */
    public boolean hasRightChild() {
        return this._rightChild != null;
    }

    /**
     * Retrieves the right child.
     *
     * @return returning the right child of this node.
     */
    public BinaryTree<E> getRightChild() {
        return this._rightChild;
    }

    /**
     * Sets the right child of this node. Detaches the current right child.
     *
     * @param child child is the new right child to be set.
     * @return returning the previous right child.
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child) {
        return setChild(false, child);
    }

    /**
     * Returns the root of the tree.
     *
     * @return returning the root node of the tree.
     */
    public BinaryTree<E> getRoot() {
        BinaryTree<E> current = this;
        while (current._parent != null) {
            current = current._parent;
        }
        return current;
    }

    /**
     * getParent is a method that returns the parent of this node.
     *
     * @return returning the parent of this node.
     */
    public BinaryTree<E> getParent() {
        return this._parent;
    }

    /**
     * Calculates the size of the subtree rooted at this node.
     *
     * @return returning the total number of nodes in the subtree.
     */
    public int size() {
        int _leftSize = 0;
        int _rightSize = 0;

        if (this._leftChild != null) {
            _leftSize = this._leftChild.size();
        }
        if (this._rightChild != null) {
            _rightSize = this._rightChild.size();
        }
        return 1 + _leftSize + _rightSize;
    }

    /**
     * Calculates the height of the subtree rooted at this node.
     *
     * @return
     */
    public int height() {
        int _leftHeight = 0;
        int _rightHeight = 0;

        if (this._leftChild != null) {
            _leftHeight = this._leftChild.height();
        }
        if (this._rightChild != null) {
            _rightHeight = this._rightChild.height();
        }

        if (_leftHeight > _rightHeight) {
            return 1 + _leftHeight;
        } else {
            return 1 + _rightHeight;
        }
    }

    /**
     * Determines the level of this node within the binary tree.
     *
     * @return returns the level of this node.
     */
    public int level() {
        if (this._parent == null) {
            return 0;
        } else {
            return 1 + this._parent.level();
        }
    }

    /**
     * Calculates the degree of this node.
     *
     * @return returning the degree of this node.
     */
    public int degree() {
        int _degree = 0;
        if (this._leftChild != null) {
            _degree++;
        }
        if (this._rightChild != null) {
            _degree++;
        }
        return _degree;
    }

    /**
     * Checks whether this node is the root of the binary tree.
     *
     * @return returning true if this node is the root.
     */
    public boolean isRoot() {
        return this._parent == null;
    }

    /**
     * Checks whether this node is a parent.
     *
     * @return returning true if this node has at least one child.
     */
    public boolean isParent() {
        return this._leftChild != null || this._rightChild != null;
    }

    /**
     * Checks whether this node is a child.
     *
     * @return returning true if this node has a parent.
     */
    public boolean isChild() {
        return this._parent != null;
    }

    /**
     * Checks whether this node is a leaf.
     *
     * @return returning true if this node has no children.
     */
    public boolean isLeaf() {
        return this._leftChild == null && this._rightChild == null;
    }

    /**
     * Checks whether this node is a full node.
     *
     * @return returns true if this node has two children.
     */
    public boolean isFull() {
        return this._leftChild != null && this._rightChild != null;

    }

    /**
     * Checks whether this binary tree is complete, all levels are fully filled.
     *
     * @return returning true if the tree is complete.
     */
    public boolean isComplete() {

    }

    /**
     * Checks whether this binary tree is degenerate.
     *
     * @return returning true if the tree is degenerate false otherwise.
     */
    public boolean isDegenerate() {
        return (this._leftChild == null && this._rightChild != null) ||
                (this._leftChild != null && this._rightChild == null);
    }

    /**
     * Determnines if this node is an ancestor of a given descendant node.
     *
     * @param descendant descendant the node to check against this node for ancestry.
     * @return returns true if this node is an ancestor of the given descendant node.
     */
    public boolean isAncestorOf(BinaryTree<E> descendant) throws IllegalArgumentException {
        if (descendant == null) throw new IllegalArgumentException("Illegal Access Exception");
        BinaryTree<E> parent = descendant.getParent();
        while (parent != null) {
            if (parent == this) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    /**
     * Determines if this node is the parent of a given child node.
     *
     * @param child child is the node to check against this node for parentage
     * @return returning true if this node is the parent of the given child node.
     */
    public boolean isParentOf(BinaryTree<E> child) {
        return this._leftChild == child || this._rightChild == child;
    }

    /**
     * Determines if this node is a sibling of a given node.
     *
     * @param sibling sibling is the node to check against this node for sibling.
     * @return returning true if this node is a sibling of the given node.
     */
    public boolean isSiblingOf(BinaryTree<E> sibling) {
        return this._parent != null && (this._parent._leftChild == sibling
                || this._parent._rightChild == sibling);
    }

    /**
     * Determines if this node is a child of a given parent node.
     *
     * @param parent parent is the node to check against this node for child.
     * @return returning true if this node is a child of the given parent node.
     */
    public boolean isChildOf(BinaryTree<E> parent) {
        return this._parent == parent;
    }

    /**
     * Determines if this node is a descendant of a given ancestor node.
     *
     * @param ancestor ancestor is the node to check against this node for descendant.
     * @return returning true if this node is a descendant of the given ancestor node.
     */
    public boolean isDescendantOf(BinaryTree<E> ancestor)
    {
        if (ancestor == null)
        {
            // Null cannot be an ancestor
            return false;
        }
        // Start from the current node
        BinaryTree<E> current = this;
        while (current != null)
        {
            if (current == ancestor)
            {
                return true; // Found the ancestor in the current node's lineage
            }
            current = current._parent; // Move up the tree
        }
        return false; // Ancestor not found in the lineage
    }

    /**
     * @return
     */
    public Iterator<E> iterator()
    {
        return inOrderIterator();
    }

    /**
     * @return
     */
    public Iterator<E> preOrderIterator()
    {
        LinkedList<E> elements = new LinkedList<>();
        preOrderTraversal(this, elements);
        return elements.iterator();
    }

    /**
     * @return
     */
    public Iterator<E> inOrderIterator()
    {
        LinkedList<E> elements = new LinkedList<>();
        inOrderTraversal(this, elements);
        return elements.iterator();
    }

    /**
     * @return
     */
    public Iterator<E> postOrderIterator()
    {
        LinkedList<E> elements = new LinkedList<>();
        postOrderTraversal(this, elements);
        return elements.iterator();
    }

    /**
     * @return
     */
    public Iterator<E> levelOrderIterator()
    {
        LinkedList<E> elements = new LinkedList<>();
        levelOrderTraversal(this, elements);
        return elements.iterator();
    }

    /**
     * @return
     */
    public String toString()
    {

    }

    /**
     * private helper method setChild is used to assist in the public set left
     * and right child methods
     *
     * @param _isLeft _isLeft is used for
     * @param child   the child node to be set.
     * @return returning the previous child node that was replaced.
     */
    private BinaryTree<E> setChild(boolean _isLeft, BinaryTree<E> child)
    {
        BinaryTree<E> oldChild;
        if (_isLeft)
        {
            oldChild = this._leftChild;
        } else
        {
            oldChild = this._rightChild;
        }

        // Detach current child.
        if (oldChild != null)
        {
            oldChild._parent = null;
        }

        // Setting new child.
        if (_isLeft)
        {
            this._leftChild = child;
        } else
        {
            this._rightChild = child;
        }

        // Update parent reference of the new child.
        if (child != null)
        {
            if (child._parent != null)
            {
                child._parent.detachChild(child);
            }
            child._parent = this;
        }
        return oldChild;
    }

    /**
     * private helper method detachChild is used to help keep track of
     * the internal state of the program ensuring the node has its
     * correct edges after updating a nodes reference, like adding a new node or removing a node.
     *
     * @param child
     */
    private void detachChild(BinaryTree<E> child)
    {
        if (this._leftChild == child)
        {
            this._leftChild = null;
        } else if (this._rightChild == child)
        {
            this._rightChild = null;
        }
    }

    private void preOrderTraversal(BinaryTree<E> node, LinkedList<E> elements)
    {
        if (node != null)
        {
            elements.add(node.element);
            preOrderTraversal(node._leftChild, elements);
            preOrderTraversal(node._rightChild, elements);
        }
    }

    private void inOrderTraversal(BinaryTree<E> node, LinkedList<E> elements)
    {
        if (node != null)
        {
            inOrderTraversal(node._leftChild, elements);
            elements.add(node.element);
            inOrderTraversal(node._rightChild, elements);
        }
    }

    private void postOrderTraversal(BinaryTree<E> node, LinkedList<E> elements)
    {
        if (node != null)
        {
            postOrderTraversal(node._leftChild, elements);
            postOrderTraversal(node._rightChild, elements);
            elements.add(node.element);
        }
    }

    private void levelOrderTraversal(BinaryTree<E> node, LinkedList<E> elements)
    {
        if (node != null)
        {
            Deque<BinaryTree<E>> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty())
            {
                BinaryTree<E> current = queue.poll();
                elements.add(current.element);

                if (current._leftChild != null)
                {
                    queue.add(current._leftChild);
                }
                if (current._rightChild != null)
                {
                    queue.add(current._rightChild);
                }
            }
        }
    }
}

