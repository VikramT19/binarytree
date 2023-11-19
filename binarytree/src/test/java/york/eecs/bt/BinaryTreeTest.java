package york.eecs.bt;
import static org.junit.Assert.*;
import org.junit.Assert;
import york.eecs.bt.BinaryTree;
import york.eecs.bt.Node;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBinaryTree() throws Exception {
    	BinaryTree tree;
    	Node root = new Node(1);
        tree = new BinaryTree(root);
    }

    /**
     * TODO: Add your own test cases as many as possible.
     * The statement-level coverage of your test cases should be larger than 80%.
     */
    
    @Test
    public void testInsert() {
    	// Test inserting nodes in tree
        BinaryTree tree = new BinaryTree(); // Create a binary tree

        // Create and insert the root node
        Node rootNode = new Node(1);
        tree.insert(rootNode);

        // Create and insert child nodes
        Node leftChild = new Node(2);
        Node rightChild = new Node(3);
        tree.insert(leftChild);
        tree.insert(rightChild);

        // Validate that the child nodes are inserted correctly
        assertEquals(leftChild, tree.getRoot().getLeft());
        assertEquals(rightChild, tree.getRoot().getRight());
    }

    @Test
    public void testInsertingTwoNodes() {
    	// Test inserting two nodes in the binary tree
    	
        // Create a binary tree with a root node
        Node rootNode = new Node(1);
        BinaryTree tree = new BinaryTree(rootNode);

        // Create two sibling nodes without children
        Node leftNode = new Node(2);
        Node rightNode = new Node(3);

        // Insert the sibling nodes
        tree.insert(leftNode);
        tree.insert(rightNode);

        // Validate that the sibling nodes are inserted correctly as the left and right children of the root node
        assertEquals(leftNode, rootNode.getLeft());
        assertEquals(rightNode, rootNode.getRight());
    }

    @Test
    public void testInsertingMultipleLevels() {
        // Create a binary tree with a root node
        Node rootNode = new Node(1);
        BinaryTree tree = new BinaryTree(rootNode);

        // Create multiple levels of sibling nodes
        Node level1LeftNode = new Node(2);
        Node level1RightNode = new Node(3);
        Node level2LeftNode = new Node(4);
        Node level2RightNode = new Node(5);

        // Insert the sibling nodes
        tree.insert(level1LeftNode);
        tree.insert(level1RightNode);
        tree.insert(level2LeftNode);
        tree.insert(level2RightNode);

        // Validate that the sibling nodes are inserted correctly at their respective levels
        assertEquals(level1LeftNode, rootNode.getLeft());
        assertEquals(level1RightNode, rootNode.getRight());
        assertEquals(level2LeftNode, level1LeftNode.getLeft());
        assertEquals(level2RightNode, level1LeftNode.getRight());
    }
    
    @Test
    public void testInserting() {
    	// Test inserting nodes in tree
        BinaryTree tree = new BinaryTree(); // Create an empty binary tree
        Node rootNode = new Node(1); // Insert the root node
        tree.insert(rootNode);

        // Validate that the root node is set correctly
        assertEquals(rootNode, tree.getRoot());

        // Insert two child nodes
        Node leftChild = new Node(2);
        Node rightChild = new Node(3);
        tree.insert(leftChild);
        tree.insert(rightChild);

        // Validate that the child nodes are inserted correctly as the left and right children of the root node
        assertEquals(leftChild, tree.getRoot().getLeft());
        assertEquals(rightChild, tree.getRoot().getRight());
    }
    
    @Test
    public void testBinaryTreeConstructor() {
        // Test the constructor of BinaryTree class with a root node
        Node root = new Node(1); // Adding a node to the tree which becomes the root
        BinaryTree tree = new BinaryTree(root); // Creating a binary tree with the root node
        assertEquals(root, tree.getRoot()); // Checking if the function to get the tree's root works
    }
    
    @Test
    public void testBinaryTreeEmptyConstructor() {
        // Test the empty constructor of BinaryTree class
        BinaryTree tree = new BinaryTree(); // Creating a new binary tree (null) since there is no nodes
        assertNull(tree.getRoot()); // Since there is no node (or root), it should return null
    }
    
    @Test
    public void testInsertSingleNode() {
        // Test inserting a single node into the tree
        Node root = new Node(1); // This node will serve as the root for the tree
        BinaryTree tree = new BinaryTree(root); // Creating the binary tree with the root node
        Node newNode = new Node(2); // Another node is created
        tree.insert(newNode); // The second node is added to the tree
        assertEquals(newNode, tree.getRoot().getLeft()); // This checks if the new node is indeed the left child of the root node to make sure the binary treee functions
    }
    
    @Test
    public void testSetValue() {
    	// Test setting value to a node
        Node node = new Node(); // Create a new Node instance
        Object value = "Test Value"; // Define a test value
        node.setValue(value); // Set the value of the Node using the setValue() method
        Assert.assertEquals(value, node.getValue()); // Assert that the value retrieved from the Node is equal to the test value
    }

    @Test
    public void testNodeConstructorWithValue() {
    	// Test the node constructor with the value
        Object value = "Test Value"; // Define a test value
        Node node = new Node(value); // Create a new Node instance using the constructor with a value parameter
        Assert.assertEquals(value, node.getValue()); // Assert that the value stored in the Node is equal to the test value
        Assert.assertNull(node.getLeft()); // Assert that the left child node is null
        Assert.assertNull(node.getRight()); // Assert that the right child node is null
    }
    
    @Test
    public void testGetValue() {
        // Test getting value from node
        Object value = "Test Value";// Define a test value
        Node node = new Node(value);  // Create a new Node instance with the test value  
        Object retrievedValue = node.getValue(); // Retrieve the value from the Node using the getValue() method
        Assert.assertEquals(value, retrievedValue); // Assert that the retrieved value is equal to the test value
    }
    
    @Test
    public void testInsertMultipleNodes() {
        // Test inserting multiple nodes into the tree to see if the tree functions properly (According to binary)
        Node root = new Node(1); // Root node of the tree
        BinaryTree tree = new BinaryTree(root); // Creating the binary tree from the root node
        // Two more nodes are created
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        // Both nodes are added to the tree
        tree.insert(node2);
        tree.insert(node3);
        // We have to check that the binary tree is functioning properly accordingly
        assertEquals(node2, tree.getRoot().getLeft()); // The second node is added then after the third is added as well. The second node should be on the left child of the root
        assertEquals(node3, tree.getRoot().getRight()); // The third node should be the right child of the root
    }
    
    @Test
    public void testPreOrderTraversal() {
        // Test the pre-order traversal of the tree
        Node root = new Node(1); // Create the root node 
        BinaryTree tree = new BinaryTree(root); // Create a binary tree with the root node

        Node node2 = new Node(2); // Create node 2 
        Node node3 = new Node(3); // Create node 3
        
        root.setLeft(node2); // Set node2 as the left child of the root node
        root.setRight(node3); // Set node3 as the right child of the root node
        
        // Verify that the pre-order traversal of the tree is correct
        assertEquals(root, tree.preOrder().get(0)); // Check if the first element in the pre-order traversal is the root node (1)
        assertEquals(node2, tree.preOrder().get(1)); // Check if the second element in the pre-order traversal is node2 (2)
        assertEquals(node3, tree.preOrder().get(2)); // Check if the third element in the pre-order traversal is node3 (3)
    }

    @Test
    public void testInOrderTraversal() {
        // Test the in-order traversal of the tree
        Node root = new Node(1); // Create a root node with a value of 1
        BinaryTree tree = new BinaryTree(root); // Create a binary tree with the root node
        
        Node node2 = new Node(2); // Create a node with a value of 2
        Node node3 = new Node(3); // Create a node with a value of 3
        root.setLeft(node2); // Set node2 as the left child of the root node
        root.setRight(node3); // Set node3 as the right child of the root node
        
        // Check the in-order traversal order of the tree
        // The expected order is: node2, root, node3
        assertEquals(node2, tree.inOrder().get(0)); // Check if the first element in the in-order traversal is node2
        assertEquals(root, tree.inOrder().get(1)); // Check if the second element in the in-order traversal is the root node
        assertEquals(node3, tree.inOrder().get(2)); // Check if the third element in the in-order traversal is node3
    }
    
    @Test
    public void testPostOrderTraversal() {
        // Test the post-order traversal of the tree
        Node root = new Node(1); // Create a root node with a value of 1
        BinaryTree tree = new BinaryTree(root); // Create a binary tree with the root node
        
        Node node2 = new Node(2); // Create a node with a value of 2
        Node node3 = new Node(3); // Create a node with a value of 3
        root.setLeft(node2); // Set node2 as the left child of the root node
        root.setRight(node3); // Set node3 as the right child of the root node
        
        // Check the post-order traversal order of the tree
        // The expected order is: node2, node3, root
        assertEquals(node2, tree.postOrder().get(0)); // Check if the first element in the post-order traversal is node2
        assertEquals(node3, tree.postOrder().get(1)); // Check if the second element in the post-order traversal is node3
        assertEquals(root, tree.postOrder().get(2)); // Check if the third element in the post-order traversal is the root node
    }

    @Test
    public void testBfsTraversal() {
        // Test the breadth-first search (BFS) traversal of the tree
        Node root = new Node(1); // Create a root node with a value of 1
        BinaryTree tree = new BinaryTree(root); // Create a binary tree with the root node
        
        Node node2 = new Node(2); // Create a node with a value of 2
        Node node3 = new Node(3); // Create a node with a value of 3
        root.setLeft(node2); // Set node2 as the left child of the root node
        root.setRight(node3); // Set node3 as the right child of the root node
        
        // Check the breadth-first search (BFS) traversal order of the tree
        // The expected order is: root, node2, node3
        assertEquals(root, tree.bfs().get(0)); // Check if the first element in the BFS traversal is the root node
        assertEquals(node2, tree.bfs().get(1)); // Check if the second element in the BFS traversal is node2
        assertEquals(node3, tree.bfs().get(2)); // Check if the third element in the BFS traversal is node3
    }
    
    @Test
    public void testBfsTraversalWithSingleNodeTree() {
        // Test the BFS traversal of a tree with a single node
        Node root = new Node(1); // Create a node with a value of 1
        BinaryTree tree = new BinaryTree(root); // Create binary tree with the root node
        assertEquals(root, tree.bfs().get(0)); // Check if the first and only element in the BFS traversale is the root node
    }
    
    @Test
    public void testBfsTraversalWithLargeTree() {
        // Test the BFS traversal of a large tree
    	// This adds more complexity to the tree which will really put it to the test to see if it functions properly
        Node root = new Node(1); // Root node
        BinaryTree tree = new BinaryTree(root); // Create binary tree with root node
        // Creating multiple nodes
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        // Setting the left and right child nodes for each node
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        // Performing the BFS traversal and checking the expected order of visited nodes
        assertEquals(root, tree.bfs().get(0));
        assertEquals(node2, tree.bfs().get(1));
        assertEquals(node3, tree.bfs().get(2));
        assertEquals(node4, tree.bfs().get(3));
        assertEquals(node5, tree.bfs().get(4));
        assertEquals(node6, tree.bfs().get(5));
        assertEquals(node7, tree.bfs().get(6));
    }
    
    @Test
    public void testBfsTraversalWithUnbalancedTree() {
        // Test the BFS traversal of an unbalanced tree
        Node root = new Node(1); // Root node
        BinaryTree tree = new BinaryTree(root); // Create binary node
        // Create nodes
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        // Setting left and right child nodes of nodes
        root.setLeft(node2);
        node2.setRight(node3);
        node3.setLeft(node4);
        // Checking the order of visited nodes 
        assertEquals(root, tree.bfs().get(0));
        assertEquals(node2, tree.bfs().get(1));
        assertEquals(node3, tree.bfs().get(2));
        assertEquals(node4, tree.bfs().get(3));
    }


}