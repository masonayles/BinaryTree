import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Iterator;

public class BinaryTreeTest {
    private BinaryTree<Integer> tree;
    private BinaryTree<Integer> childTree;

    @Before
    public void setUp() {
        tree = new BinaryTree<>(10); // Initialize the tree with a root element
        childTree = new BinaryTree<>(5); // Initialize a child tree
    }

    @Test
    public void testConstructorWithValidElement() {
        BinaryTree<Integer> validTree = new BinaryTree<>(5);
        assertNotNull("Tree should not be null", validTree);
        assertEquals("Tree element should be initialized to 5", (Integer) 5, validTree.getElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullElement() {
        new BinaryTree<>(null); // Replace with your constructor logic, assuming it throws IllegalArgumentException for null
    }

    @Test
    public void testGetElementOnNewNode() {
        assertEquals("Element of the newly created node should be 10", (Integer) 10, tree.getElement());
    }

    @Test
    public void testSetElementWithValidData() {
        tree.setElement(20);
        assertEquals("Element should be updated to 20", (Integer) 20, tree.getElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementWithNull() {
        tree.setElement(null); // This test assumes that setting a null element throws an IllegalArgumentException
    }

    @Test
    public void testHasLeftChildOnNewNode() {
        assertFalse("A new tree node should not have a left child", tree.hasLeftChild());
    }

    @Test
    public void testGetLeftChildOnNewNode() {
        assertNull("Getting left child on a new node should return null", tree.getLeftChild());
    }

    @Test
    public void testSetLeftChildWithValidNode() {
        tree.setLeftChild(childTree);
        assertTrue("Tree should have a left child after setting", tree.hasLeftChild());
        assertEquals("The left child should be the one that was set", childTree, tree.getLeftChild());
    }

    @Test
    public void testSetLeftChildWithNull() {
        tree.setLeftChild(childTree); // First set a valid child
        tree.setLeftChild(null); // Then set to null
        assertFalse("Tree should not have a left child after setting to null", tree.hasLeftChild());
    }

    @Test
    public void testHasRightuChildOnNewNode() {
        assertFalse("A new tree node should not have a right child", tree.hasRightChild());
    }

    @Test
    public void testGetRightuChildOnNewNode() {
        assertNull("Getting right child on a new node should return null", tree.getRightChild());
    }

    @Test
    public void testSetRuightChildWithValidNode() {
        tree.setRightChild(childTree);
        assertTrue("Tree should have a right child after setting", tree.hasRightChild());
        assertEquals("The right child should be the one that was set", childTree, tree.getRightChild());
    }

    @Test
    public void testSetuRightChildWithNull() {
        tree.setRightChild(childTree); // First set a valid child
        tree.setRightChild(null); // Then set to null
        assertFalse("Tree should not have a right child after setting to null", tree.hasRightChild());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLeftChildWithItself() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        tree.setLeftChild(tree); // This should throw an IllegalArgumentException as it's an invalid operation
    }

    @Test
    public void testHasRightChildOnNewNode() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        assertFalse("A new tree node should not have a right child", tree.hasRightChild());
    }

    @Test
    public void testGetRightChildOnNewNode() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        assertNull("Getting right child on a new node should return null", tree.getRightChild());
    }

    @Test
    public void testSetRightChildWithValidNode() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> childTree = new BinaryTree<>(5);
        tree.setRightChild(childTree);
        assertTrue("Tree should have a right child after setting", tree.hasRightChild());
        assertEquals("The right child should be the one that was set", childTree, tree.getRightChild());
    }

    @Test
    public void testSetRightChildWithNull() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> childTree = new BinaryTree<>(5);
        tree.setRightChild(childTree); // First set a valid child
        tree.setRightChild(null); // Then set to null
        assertFalse("Tree should not have a right child after setting to null", tree.hasRightChild());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetRightChildWithItself() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        tree.setRightChild(tree); // This should throw an IllegalArgumentException as it's an invalid operation
    }

    @Test
    public void testGetRootOnSingleNode() {
        BinaryTree<Integer> singleNodeTree = new BinaryTree<>(10);
        assertEquals("Root of a single node tree should be the node itself", singleNodeTree, singleNodeTree.getRoot());
    }

    @Test
    public void testGetParentOnRootNode() {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        assertNull("Root node should not have a parent", root.getParent());
    }

    @Test
    public void testSizeOnSingleNode() {
        BinaryTree<Integer> singleNodeTree = new BinaryTree<>(10);
        assertEquals("Size of a single node tree should be 1", 1, singleNodeTree.size());
    }

    @Test
    public void testSizeOnComplexTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);

        // Adding first level of children
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        tree.setLeftChild(leftChild);
        tree.setRightChild(rightChild);

        // Adding second level of children
        BinaryTree<Integer> leftChildLeft = new BinaryTree<>(3);
        BinaryTree<Integer> leftChildRight = new BinaryTree<>(7);
        leftChild.setLeftChild(leftChildLeft);
        leftChild.setRightChild(leftChildRight);

        BinaryTree<Integer> rightChildLeft = new BinaryTree<>(12);
        BinaryTree<Integer> rightChildRight = new BinaryTree<>(18);
        rightChild.setLeftChild(rightChildLeft);
        rightChild.setRightChild(rightChildRight);

        // Add additional nodes as needed to make the tree more complex
        // ...

        int expectedSize = 7; // Update this based on the actual size of your tree
        assertEquals("Size of the tree should match the number of nodes", expectedSize, tree.size());
    }

    @Test
    public void testHeightOnSingleNode() {
        BinaryTree<Integer> singleNodeTree = new BinaryTree<>(10);
        assertEquals("Height of a single node tree should be 0", 0, singleNodeTree.height());
    }

    @Test
    public void testHeightOnComplexTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        BinaryTree<Integer> leftChildLeft = new BinaryTree<>(2);
        tree.setLeftChild(leftChild);
        tree.setRightChild(rightChild);
        leftChild.setLeftChild(leftChildLeft);

        // Height is the number of edges on the longest path from the node to a leaf
        int expectedHeight = 2;
        assertEquals("Height of the tree should be 2", expectedHeight, tree.height());
    }

    @Test
    public void testLevelOnRootNode() {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        assertEquals("Level of the root node should be 0", 0, root.level());
    }

    @Test
    public void testLevelOnChildNode() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        tree.setLeftChild(child);

        assertEquals("Level of a direct child of the root should be 1", 1, child.level());
    }

    @Test
    public void testDegreeOnLeafNode() {
        BinaryTree<Integer> leafNode = new BinaryTree<>(5);
        assertEquals("Degree of a leaf node should be 0", 0, leafNode.degree());
    }

    @Test
    public void testDegreeOnParentNode() {
        BinaryTree<Integer> parentNode = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        parentNode.setLeftChild(leftChild);
        parentNode.setRightChild(rightChild);

        assertEquals("Degree of a parent node with two children should be 2", 2, parentNode.degree());
    }

    @Test
    public void testIsRootOnRootNode() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(10);
        assertTrue("The root node should return true for isRoot", rootNode.isRoot());
    }

    @Test
    public void testIsRootOnChildNode() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(10);
        BinaryTree<Integer> childNode = new BinaryTree<>(5);
        rootNode.setLeftChild(childNode); // Assuming setLeftChild sets the child node

        assertFalse("A child node should return false for isRoot", childNode.isRoot());
    }

    @Test
    public void testIsParentOnLeafNode() {
        BinaryTree<Integer> leafNode = new BinaryTree<>(10);
        assertFalse("A leaf node should not be a parent", leafNode.isParent());
    }

    @Test
    public void testIsParentOnParentNode() {
        BinaryTree<Integer> parentNode = new BinaryTree<>(10);
        BinaryTree<Integer> childNode = new BinaryTree<>(5);
        parentNode.setLeftChild(childNode); // Assuming setLeftChild sets the child node

        assertTrue("A node with children should be a parent", parentNode.isParent());
    }

    @Test
    public void testIsChildOnRootNode() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(10);
        assertFalse("Root node should not be a child", rootNode.isChild());
    }

    @Test
    public void testIsChildOnChildNode() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(10);
        BinaryTree<Integer> childNode = new BinaryTree<>(5);
        rootNode.setLeftChild(childNode);

        assertTrue("A child node should return true for isChild", childNode.isChild());
    }

    @Test
    public void testIsLeafOnLeafNode() {
        BinaryTree<Integer> leafNode = new BinaryTree<>(10);
        assertTrue("A node with no children should be a leaf", leafNode.isLeaf());
    }

    @Test
    public void testIsLeafOnParentNode() {
        BinaryTree<Integer> parentNode = new BinaryTree<>(10);
        BinaryTree<Integer> childNode = new BinaryTree<>(5);
        parentNode.setLeftChild(childNode);

        assertFalse("A parent node should not be a leaf", parentNode.isLeaf());
    }


    @Test
    public void testIsFullOnCompleteTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        tree.setLeftChild(leftChild);
        tree.setRightChild(rightChild);

        assertTrue("A complete tree with all nodes having two children should be full", tree.isFull());
    }

    @Test
    public void testIsFullOnIncompleteTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        tree.setLeftChild(leftChild); // Only one child

        assertFalse("A tree with nodes having less than two children should not be full", tree.isFull());
    }

    @Test
    public void testIsCompleteOnCompleteTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        tree.setLeftChild(leftChild);
        tree.setRightChild(rightChild);

        assertTrue("A complete binary tree should return true for isComplete", tree.isComplete());
    }

    @Test
    public void testIsCompleteOnIncompleteTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        tree.setLeftChild(leftChild); // Only left child is set, making it incomplete

        assertFalse("An incomplete binary tree should return false for isComplete", tree.isComplete());
    }

    @Test
    public void testIsDegenerateOnStraightLineTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        tree.setLeftChild(child);
        BinaryTree<Integer> grandChild = new BinaryTree<>(3);
        child.setLeftChild(grandChild); // Only left children, forming a straight line

        assertTrue("A straight-line tree should return true for isDegenerate", tree.isDegenerate());
    }

    @Test
    public void testIsDegenerateOnBalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        tree.setLeftChild(leftChild);
        tree.setRightChild(rightChild);

        assertFalse("A balanced tree should return false for isDegenerate", tree.isDegenerate());
    }

    @Test
    public void testIsAncestorOf() {
        BinaryTree<Integer> ancestor = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        BinaryTree<Integer> grandChild = new BinaryTree<>(3);
        ancestor.setLeftChild(child);
        child.setLeftChild(grandChild);

        assertTrue("Ancestor should return true for isAncestorOf its grandchild", ancestor.isAncestorOf(grandChild));
    }

    @Test
    public void testIsParentOf() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        parent.setLeftChild(child);

        assertTrue("Parent should return true for isParentOf its child", parent.isParentOf(child));
    }

    @Test
    public void testIsSiblingOf() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child1 = new BinaryTree<>(5);
        BinaryTree<Integer> child2 = new BinaryTree<>(15);
        parent.setLeftChild(child1);
        parent.setRightChild(child2);

        assertTrue("Child1 should return true for isSiblingOf Child2", child1.isSiblingOf(child2));
    }

    @Test
    public void testIsChildOf() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        parent.setLeftChild(child);

        assertTrue("Child should return true for isChildOf its parent", child.isChildOf(parent));
    }

    @Test
    public void testIsDescendantOf() {
        BinaryTree<Integer> ancestor = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        BinaryTree<Integer> grandChild = new BinaryTree<>(3);
        ancestor.setLeftChild(child);
        child.setLeftChild(grandChild);

        assertTrue("GrandChild should return true for isDescendantOf its ancestor", grandChild.isDescendantOf(ancestor));
    }

    @Test
    public void testIsAncestorOfWithValidDescendant() {
        BinaryTree<Integer> ancestor = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        BinaryTree<Integer> grandChild = new BinaryTree<>(2);
        ancestor.setLeftChild(child);
        child.setLeftChild(grandChild);

        assertTrue("Ancestor should return true for isAncestorOf with a valid descendant", ancestor.isAncestorOf(grandChild));
    }

    @Test
    public void testIsAncestorOfWithInvalidDescendant() {
        BinaryTree<Integer> ancestor = new BinaryTree<>(10);
        BinaryTree<Integer> nonDescendant = new BinaryTree<>(3);

        assertFalse("Ancestor should return false for isAncestorOf with an invalid descendant", ancestor.isAncestorOf(nonDescendant));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAncestorOfWithNullDescendant() {
        BinaryTree<Integer> ancestor = new BinaryTree<>(10);
        ancestor.isAncestorOf(null); // Assuming calling with null throws IllegalArgumentException
    }

    @Test
    public void testIsParentOfWithValidChild() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        parent.setLeftChild(child);

        assertTrue("Parent should return true for isParentOf with a valid child", parent.isParentOf(child));
    }

    @Test
    public void testIsParentOfWithInvalidChild() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> nonChild = new BinaryTree<>(3);

        assertFalse("Parent should return false for isParentOf with an invalid child", parent.isParentOf(nonChild));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsParentOfWithNullChild() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        parent.isParentOf(null); // Assuming calling with null throws IllegalArgumentException
    }

    @Test
    public void testIsSiblingOfWithValidSibling() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child1 = new BinaryTree<>(5);
        BinaryTree<Integer> child2 = new BinaryTree<>(15);
        parent.setLeftChild(child1);
        parent.setRightChild(child2);

        assertTrue("Child1 should return true for isSiblingOf with a valid sibling", child1.isSiblingOf(child2));
    }

    @Test
    public void testIsSiblingOfWithNoSibling() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child1 = new BinaryTree<>(5);
        parent.setLeftChild(child1);

        assertFalse("Child1 should return false for isSiblingOf when there is no sibling", child1.isSiblingOf(new BinaryTree<>(15)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSiblingOfWithNullSibling() {
        BinaryTree<Integer> child = new BinaryTree<>(5);
        child.isSiblingOf(null); // Assuming calling with null throws IllegalArgumentException
    }

    @Test
    public void testIsChildOfWithValidParent() {
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        parent.setLeftChild(child);

        assertTrue("Child should return true for isChildOf with a valid parent", child.isChildOf(parent));
    }

    @Test
    public void testIsChildOfWithInvalidParent() {
        BinaryTree<Integer> child = new BinaryTree<>(5);
        BinaryTree<Integer> nonParent = new BinaryTree<>(10);

        assertFalse("Child should return false for isChildOf with an invalid parent", child.isChildOf(nonParent));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsChildOfWithNullParent() {
        BinaryTree<Integer> child = new BinaryTree<>(5);
        child.isChildOf(null); // Assuming calling with null throws IllegalArgumentException
    }

    @Test
    public void testIsDescendantOfWithValidAncestor() {
        BinaryTree<Integer> ancestor = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);
        BinaryTree<Integer> grandChild = new BinaryTree<>(3);
        ancestor.setLeftChild(child);
        child.setLeftChild(grandChild);

        assertTrue("GrandChild should return true for isDescendantOf with a valid ancestor", grandChild.isDescendantOf(ancestor));
    }

    @Test
    public void testIsDescendantOfWithInvalidAncestor() {
        BinaryTree<Integer> grandChild = new BinaryTree<>(3);
        BinaryTree<Integer> nonAncestor = new BinaryTree<>(10);

        assertFalse("GrandChild should return false for isDescendantOf with an invalid ancestor", grandChild.isDescendantOf(nonAncestor));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsDescendantOfWithNullAncestor() {
        BinaryTree<Integer> grandChild = new BinaryTree<>(3);
        grandChild.isDescendantOf(null); // Assuming calling with null throws IllegalArgumentException
    }

    @Test
    public void testIteratorOnEmptyTree() {
        BinaryTree<Integer> emptyTree = new BinaryTree<>(null); // Assuming an empty tree is initialized with null
        Iterator<Integer> iterator = emptyTree.iterator();

        assertFalse("Iterator should not have next in an empty tree", iterator.hasNext());
    }

    @Test
    public void testIteratorOnSingleElementTree() {
        BinaryTree<Integer> singleElementTree = new BinaryTree<>(10);
        Iterator<Integer> iterator = singleElementTree.iterator();

        assertTrue("Iterator should have next in a single element tree", iterator.hasNext());
        assertEquals("Iterator next should return the single element", (Integer) 10, iterator.next());
        assertFalse("Iterator should have no more elements", iterator.hasNext());
    }

    private BinaryTree<Integer> createComplexTree() {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(15);
        BinaryTree<Integer> leftLeftChild = new BinaryTree<>(3);
        BinaryTree<Integer> leftRightChild = new BinaryTree<>(7);
        BinaryTree<Integer> rightLeftChild = new BinaryTree<>(12);
        BinaryTree<Integer> rightRightChild = new BinaryTree<>(17);

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftLeftChild);
        leftChild.setRightChild(leftRightChild);
        rightChild.setLeftChild(rightLeftChild);
        rightChild.setRightChild(rightRightChild);

        return root;
    }

    @Test
    public void testIteratorOnComplexTree() {
        BinaryTree<Integer> tree = createComplexTree();
        Iterator<Integer> iterator = tree.iterator();
        List<Integer> results = new ArrayList<>();

        while (iterator.hasNext()) {
            results.add(iterator.next());
        }

        List<Integer> expectedOrder = Arrays.asList(3, 5, 7, 10, 12, 15, 17);
        assertEquals("In-order traversal should return elements in the correct order", expectedOrder, results);
    }


    @Test
    public void testPreOrderIteratorOnComplexTree() {
        BinaryTree<Integer> tree = createComplexTree();
        Iterator<Integer> iterator = tree.preOrderIterator();
        List<Integer> results = new ArrayList<>();

        while (iterator.hasNext()) {
            results.add(iterator.next());
        }

        List<Integer> expectedOrder = Arrays.asList(10, 5, 3, 7, 15, 12, 17);
        assertEquals("Pre-order traversal should return elements in the correct order", expectedOrder, results);
    }


    @Test
    public void testInOrderIteratorOnComplexTree() {
        BinaryTree<Integer> tree = createComplexTree();
        Iterator<Integer> iterator = tree.inOrderIterator();
        List<Integer> results = new ArrayList<>();

        while (iterator.hasNext()) {
            results.add(iterator.next());
        }

        List<Integer> expectedOrder = Arrays.asList(3, 5, 7, 10, 12, 15, 17);
        assertEquals("In-order traversal should return elements in the correct order", expectedOrder, results);
    }

    @Test
    public void testPostOrderIteratorOnComplexTree() {
        BinaryTree<Integer> tree = createComplexTree();
        Iterator<Integer> iterator = tree.postOrderIterator();
        List<Integer> results = new ArrayList<>();

        while (iterator.hasNext()) {
            results.add(iterator.next());
        }

        List<Integer> expectedOrder = Arrays.asList(3, 7, 5, 12, 17, 15, 10);
        assertEquals("Post-order traversal should return elements in post-order", expectedOrder, results);
    }

    @Test
    public void testLevelOrderIteratorOnComplexTree() {
        BinaryTree<Integer> tree = createComplexTree();
        Iterator<Integer> iterator = tree.levelOrderIterator();
        List<String> results = new ArrayList<>();

        while (iterator.hasNext()) {
            results.add(String.valueOf(iterator.next()));
        }

        List<String> expectedOrder = Arrays.asList("10", "5", "15", "3", "7", "12", "17");
        assertEquals("Level-order traversal should return elements in level-order", expectedOrder, results);
    }

    @Test
    public void testToStringOnEmptyTree() {
        BinaryTree<Integer> emptyTree = new BinaryTree<>(null);
        String expectedResult = "[]"; // Empty tree should result in empty string with square brackets
        assertEquals("toString on an empty tree should match the expected result", expectedResult, emptyTree.toString());
    }

    @Test
    public void testToStringOnSingleElementTree() {
        BinaryTree<Integer> singleElementTree = new BinaryTree<>(5);
        String expectedResult = "[5]"; // Single element tree should have the element in square brackets
        assertEquals("toString on a single element tree should match the expected result", expectedResult, singleElementTree.toString());
    }

    @Test
    public void testToStringOnComplexTree() {
        BinaryTree<Integer> tree = createComplexTree();
        String expectedResult = "[3, 5, 7, 10, 12, 15, 17]"; // Adjust based on your toString implementation
        assertEquals("toString on a complex tree should match the expected result", expectedResult, tree.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetChildWithCircularReference() {
        // Create a tree structure with a circular reference
        BinaryTree<Integer> parent = new BinaryTree<>(10);
        BinaryTree<Integer> child = new BinaryTree<>(5);

        // Set child as the left child of the parent
        parent.setLeftChild(child);

        // Attempt to set the parent as the left child of the child, which should throw an exception
        child.setLeftChild(parent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperationThrowingIllegalArgumentException() {
        // Create a simple tree with a single node
        BinaryTree<Integer> tree = new BinaryTree<>(10);

        // Attempt an invalid operation, which should throw an exception (e.g., setting a non-root node as a root)
        tree.setRightChild(new BinaryTree<>(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodCallsWithNullArguments() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);

        // Attempt to call methods with null arguments, which should throw IllegalArgumentException
        tree.setLeftChild(null);
        tree.setRightChild(null);
        tree.isAncestorOf(null);
        tree.isParentOf(null);
        tree.isSiblingOf(null);
        tree.isChildOf(null);
        tree.isDescendantOf(null);
    }

    @Test
    public void testEntireTreeOperationsForConsistency() {
        // Create a complex tree
        BinaryTree<Integer> tree = createComplexTree();

        // Test operations for consistency
        assertEquals("getRoot should return the entire tree", tree, tree.getRoot());
        assertNull("getParent on root should return null", tree.getParent());
        assertEquals("size should be consistent with the expected count", 7, tree.size());
        assertEquals("height should be consistent with the expected value", 3, tree.height());
        assertEquals("degree should be consistent with the expected value", 2, tree.degree());
        assertTrue("isRoot should return true for the root node", tree.isRoot());
        assertFalse("isParent should return false for the root node", tree.isParent());
        assertTrue("isChild should return true for the root node", tree.isChild());
        assertFalse("isLeaf should return false for the root node", tree.isLeaf());
        assertFalse("isFull should return false for the tree", tree.isFull());
        assertFalse("isComplete should return false for the tree", tree.isComplete());
        assertFalse("isDegenerate should return false for the tree", tree.isDegenerate());
    }

    @Test
    public void testTreeManipulationAndIteratorConsistency() {
        // Create a complex tree
        BinaryTree<Integer> tree = createComplexTree();

        // Test tree manipulation and iterator consistency
        tree.setLeftChild(new BinaryTree<>(8));
        tree.setRightChild(new BinaryTree<>(20));

        // Verify iterator consistency after manipulation
        Iterator<Integer> iterator = tree.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next()).append(", ");
        }
        String expectedOrder = "8, 10, 20, ";
        assertEquals("Iterator should return elements in in-order traversal order after manipulation", expectedOrder, result.toString());

        // Add more complex tree manipulations and iterator consistency checks here...
    }

    @Test
    public void testComplexTreeManipulationsReflectingAllOperations() {
        // Add test cases to perform complex tree manipulations that reflect all operations
        // Ensure that these manipulations result in the expected tree structure and properties
        // Include cases for setting children, checking ancestors, siblings, etc.
    }

    @Test
    public void testTraversalMethodsOnEmptyTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(null);

        // Test in-order traversal on an empty tree
        Iterator<Integer> inOrderIterator = tree.inOrderIterator();
        assertFalse(inOrderIterator.hasNext());

        // Add more traversal method tests for pre-order, post-order, and level-order here
    }

    @Test
    public void testSetElementToNullOnExistingNode() {
        // Create a complex tree for testing
        BinaryTree<Integer> tree = createComplexTree();

        // Find an existing node with element 5
        BinaryTree<Integer> nodeToModify = findNode(tree, 5);
        assertNotNull(nodeToModify);

        // Set the element of the existing node to null
        nodeToModify.setElement(null);

        // Verify that the element is now null
        assertNull(nodeToModify.getElement());
    }


    // Helper method to find a node with a specific element
    private BinaryTree<Integer> findNode(BinaryTree<Integer> tree, int element) {
        if (tree == null) {
            return null;
        }

        if (tree.getElement() == element) {
            return tree;
        }

        BinaryTree<Integer> leftResult = findNode(tree.getLeftChild(), element);
        if (leftResult != null) {
            return leftResult;
        }

        return findNode(tree.getRightChild(), element);
    }

    @Test
    public void testGetParentOnSingleNode() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);

        // Test getParent on a tree with only one node
        assertNull(tree.getParent());
    }

    @Test
    public void testGetChildOnLeafNode() {
        BinaryTree<Integer> tree = new BinaryTree<>(10);

        // Test getting left and right child on a leaf node
        assertFalse(tree.hasLeftChild());
        assertFalse(tree.hasRightChild());
        assertNull(tree.getLeftChild());
        assertNull(tree.getRightChild());
    }
}







    // Test methods will be added here

