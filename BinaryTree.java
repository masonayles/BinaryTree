import jdk.incubator.vector.VectorOperators;

/**
 *Class BinaryTree<E> is recursive data structure, where each
 * tree node has an optional left and right child
 * node. Each node allows setting the left or right child,
 * which has the side effect of detaching any pre-existing
 * child subtree rooted at that node from itself and returning it.
 * @param <E> param E is the type parameter
 */
public class BinaryTree<E> implements Iterable<E>
{
    private E element;
    private BinaryTree<E> _leftChild;
    private BinaryTree<E> _rightChild;
    private BinaryTree<E> _parent;

    /**
     * Constructs a new BinarayTree node with a specificed element.
     * both left and right children are set to null.
     * @param element The element to be added in the new tree.
     */
    public BinaryTree(E element)
    {
        this.element = element;
        this._leftChild = null;
        this._rightChild = null;
        this._parent = null;
    }

    /**
     * Retrviews the element contained in this node.
     * @return returns the element contained in this node.
     */
    public E getElement()
    {
        return this.element;
    }

    /**
     * Updates the element of this node.
     * @param element element the new element to be stored in this node.
     * @return returning the previously stored element.
     */
    public E setElement(E element)
    {
        return this.element = element;
    }

    /**
     * Checks if this node has a left child.
     * @return returns true if this node has a left child.
     */
    public boolean hasLeftChild()
    {
        return this._leftChild != null;
    }

    /**
     * Retrieves the left child of this node.
     * @return returns the left child of this node, or null if there isn't one.
     */
    public BinaryTree<E> getLeftChild()
    {
        return this._leftChild;
    }

    /**
     * Sets the left child of this node. Detaches the current left child.
     * @param child child is the new left child to be set.
     * @return returning the previous left child.
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child)
    {
        return setChild(true, child);
    }

    /**
     * Cehcks if this node has a right child.
     * @return returning true if this node has a right child, false otherwise.
     */
    public boolean hasRightChild()
    {
        return this._rightChild != null;
    }

    /**
     * Retrieves the right child.
     * @return returning the right child of this node.
     */
    public BinaryTree<E> getRightChild()
    {
        return this._rightChild;
    }

    /**
     * Sets the right child of this node. Detaches the current right child.
     * @param child child is the new right child to be set.
     * @return returning the previous right child.
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child)
    {
        return setChild(false, child);
    }

    /**
     * Returns the root of the tree.
     * @return returning the root node of the tree.
     */
    public BinaryTree<E> getRoot()
    {
        BinaryTree<E>  current = this;
        while (current._parent != null)
        {
            current = current._parent;
        }
        return current;
    }

    /**
     * getParent is a method that returns the parent of this node.
     * @return returning the parent of this node.
     */
    public BinaryTree<E> getParent()
    {
        return this._parent;
    }

    /**
     * Calculates the size of the subtree rooted at this node.
     * @return returning the total number of nodes in the subtree.
     */
    public int size()
    {
        int _leftSize = 0;
        int _rightSize = 0;

        if (this._leftChild != null)
        {
            _leftSize = this._leftChild.size();
        }
        if (this._rightChild != null)
        {
            _rightSize = this._rightChild.size();
        }
        return 1 + _leftSize + _rightSize;
    }

    /**
     * Calculates the height of the subtree rooted at this node.
     * @return
     */
    public int height()
    {
        int _leftHeight = 0;
        int _rightHeight = 0;

        if (this._leftChild != null)
        {
            _leftHeight = this._leftChild.height();
        }
        if (this._rightChild != null)
        {
            _rightHeight = this._rightChild.height();
        }

        if (_leftHeight > _rightHeight)
        {
            return 1 + _leftHeight;
        }
        else
        {
            return 1 + _rightHeight;
        }
    }

    /**
     *
     * @return
     */
    public int level()
    {
        if (this._parent == null)
        {
            return 0;
        }
        else
        {
            return 1 + this._parent.level();
        }
    }

    /**
     *
     * @return
     */
    public int degree()
    {
        int _degree = 0;
        if (this._leftChild != null)
        {
            _degree++;
        }
        if (this._rightChild != null)
        {
            _degree++;
        }
        return _degree;
    }

    /**
     *
     * @return
     */
    public boolean isRoot()
    {
        return this._parent == null;
    }

    /**
     *
     * @return
     */
    public boolean isParent()
    {
        return this._leftChild != null || this._rightChild != null;
    }

    /**
     *
     * @return
     */
    public boolean isChild()
    {
        return this._parent != null;
    }

    /**
     *
     * @return
     */
    public boolean isLeaf()
    {
        return this._leftChild == null && this._rightChild == null;
    }

    /**
     *
     * @return
     */
    public boolean isFull()
    {
        return this._leftChild != null && this._rightChild != null;

    }

    /**
     *
     * @return
     */
    public boolean isComplete()
    {

    }

    /**
     *
     * @return
     */
    public boolean isDegenerate()
    {
        return (this._leftChild == null && this._rightChild != null) ||
                (this._leftChild != null && this._rightChild == null);
    }

    /**
     *
     * @param descendant
     * @return
     */
    public boolean isAncestorOf(BinaryTree<E> descendant) throws IllegalArgumentException {
        if (descendant == null) throw new IllegalArgumentException("Illegal Access Exception");
        BinaryTree<E> parent = descendant.getParent();
        while (parent != null)
        {
            if (parent == this)
            {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    /**
     *
     * @param child
     * @return
     */
    public boolean isParentOf(BinaryTree<E> child)
    {
        return this._leftChild == child || this._rightChild == child;
    }

    /**
     *
     * @param sibling
     * @return
     */
    public boolean isSiblingOf(BinaryTree<E> sibling)
    {
        return this._parent != null && (this._parent._leftChild == sibling
                || this._parent._rightChild == sibling);
    }

    /**
     *
     * @param parent
     * @return
     */
    public boolean isChildOf(BinaryTree<E> parent)
    {
        return this._parent == parent;
    }

    /**
     *
     * @param ancestor
     * @return
     */
    public boolean isDescendantOf(BinaryTree<E> ancestor)
    {

    }

    /**
     *
     * @return
     */
    public Iterator<E> iterator()
    {

    }

    /**
     *
     * @return
     */
    public Iterator<E> preOrderIterator()
    {

    }

    /**
     *
     * @return
     */
    public Iterator<E> inOrderIterator()
    {

    }

    /**
     *
     * @return
     */
    public Iterator<E> postOrderIterator()
    {

    }

    /**
     *
     * @return
     */
    public Iterator<E>levelOrderIterator()
    {

    }

    /**
     *
     * @return
     */
    public String toString()
    {

    }
//size, height, level, must be recurrsive methods. does my code do that?
    /**
     * private helper method setChild is used to assist in the public set left
     * and right child methods
     * @param _isLeft _isLeft is used for
     * @param child
     * @return
     */
    private BinaryTree<E> setChild(boolean _isLeft, BinaryTree<E> child) {
        BinaryTree<E> oldChild;
        if (_isLeft) {
            oldChild = this._leftChild;
        } else {
            oldChild = this._rightChild;
        }

        // Detach current child.
        if (oldChild != null) {
            oldChild._parent = null;
        }

        // Setting new child.
        if (_isLeft) {
            this._leftChild = child;
        } else {
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
}

