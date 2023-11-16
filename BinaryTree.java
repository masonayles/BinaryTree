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
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;
    private BinaryTree<E> parent;
    private int modCount;

    /**
     *
     * @param element
     */
    public BinaryTree(E element)
    {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        this.modCount = 0;
    }

    /**
     *
     * @return
     */
    public E getElement()
    {

    }

    /**
     *
     * @param element
     * @return
     */
    public E setElement(E element)
    {

    }

    /**
     *
     * @return
     */
    public boolean hasLeftChild()
    {

    }

    /**
     *
     * @return
     */
    public BinaryTree<E> getLeftChild()
    {

    }

    /**
     *
     * @param child
     * @return
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child)
    {

    }

    /**
     *
     * @return
     */
    public boolean hasRightChild()
    {

    }

    /**
     *
     * @return
     */
    public BinaryTree<E> getRightChild()
    {

    }

    /**
     *
     * @param child
     * @return
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child)
    {

    }

    /**
     *
     * @return
     */
    public BinaryTree<E> getRoot()
    {

    }

    /**
     *
     * @return
     */
    public BinaryTree<E> getParent()
    {

    }

    /**
     *
     * @return
     */
    public int size()
    {

    }

    /**
     *
     * @return
     */
    public int height()
    {

    }

    /**
     *
     * @return
     */
    public int level()
    {

    }

    /**
     *
     * @return
     */
    public int degree()
    {

    }

    /**
     *
     * @return
     */
    public boolean isRoot()
    {

    }

    /**
     *
     * @return
     */
    public boolean isParent()
    {

    }

    /**
     *
     * @return
     */
    public boolean isChild()
    {

    }

    /**
     *
     * @return
     */
    public boolean isLeaf()
    {

    }

    /**
     *
     * @return
     */
    public boolean isFull()
    {

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

    }

    /**
     *
     * @param descendant
     * @return
     */
    public boolean isAncestorOf(BinaryTree<E> descendant)
    {

    }

    /**
     *
     * @param child
     * @return
     */
    public boolean isParentOf(BinaryTree<E> child)
    {

    }

    /**
     *
     * @param sibling
     * @return
     */
    public boolean isSiblingOf(BinaryTree<E> sibling)
    {

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

