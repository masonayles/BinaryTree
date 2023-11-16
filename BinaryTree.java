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
     *
     * @param element
     */
    public BinaryTree(E element)
    {
        this.element = element;
        this._leftChild = null;
        this._rightChild = null;
        this._parent = null;
    }

    /**
     *
     * @return
     */
    public E getElement()
    {
        return this.element;
    }

    /**
     *
     * @param element
     * @return
     */
    public E setElement(E element)
    {
        return this.element = element;
    }

    /**
     *
     * @return
     */
    public boolean hasLeftChild()
    {
        return this._leftChild != null;
    }

    /**
     *
     * @return
     */
    public BinaryTree<E> getLeftChild()
    {
        return this._leftChild;
    }

    /**
     *
     * @param child
     * @return
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child)
    {
        return setChild(true, child);

    }

    /**
     *
     * @return
     */
    public boolean hasRightChild()
    {
        return this._rightChild != null;
    }

    /**
     *
     * @return
     */
    public BinaryTree<E> getRightChild()
    {
        return this._rightChild;
    }

    /**
     *
     * @param child
     * @return
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child)
    {
        return setChild(false, child);
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public BinaryTree<E> getParent()
    {
        return this._parent;
    }

    /**
     *
     * @return
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
     *
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
    public boolean isAncestorOf(BinaryTree<E> descendant) throws IllegalAccessException {
        if (descendant == null) throw new IllegalAccessException("Illegal Access Exception");
        BinaryTree<E> parent = descendant.getParent();
        while (parent != null)
        {
            if (parent == this)
            {
                parent = parent.getParent();
                return true;
            }
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
        return this._parent != null && (this._parent._leftChild == sibling || this._parent._rightChild == sibling);
    }

    /**
     *
     * @param parent
     * @return
     */
    public boolean isChildOf(BinaryTree<E> parent)
    {

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



}

