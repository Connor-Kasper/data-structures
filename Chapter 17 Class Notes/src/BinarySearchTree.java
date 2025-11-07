/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if(this.root == null) 
        {
            this.root = newNode;
            return;
        }
        this.root.addNode(newNode);
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        while(current != null) 
        {
            if(current.data.compareTo(obj) == 0) 
            {
                return true;
            } 
            else if(current.data.compareTo(obj) < 0) 
            {
                current = current.left;
            } 
            else 
            {
                current = current.right;
            }
        }
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node toBeRemoved = this.root;
        boolean found = false;
        Node parent = null;

        while(toBeRemoved != null && !found) 
        {
            if(toBeRemoved.data.compareTo(obj) == 0) 
            {
                found = true;
            } 
            else if(toBeRemoved.data.compareTo(obj) < 0) 
            {
                parent = toBeRemoved;
                toBeRemoved = toBeRemoved.left;
            } 
            else 
            {
                parent = toBeRemoved;
                toBeRemoved = toBeRemoved.right;
            }

            if(!found) 
            {
                return;
            }
            //Case 1 and Case 2 (Atleast one child is null)
            if(toBeRemoved.left == null || toBeRemoved.right == null) 
            {
                Node newChild;
                if(toBeRemoved.left == null) 
                {
                    newChild = toBeRemoved.right;
                } 
                else 
                {
                    newChild = toBeRemoved.left;
                }
                if(parent == null) 
                {
                    this.root = newChild;
                } 
                else
                {
                    parent.right = newChild;
                } 
                return;
            } 
            //Case 3 (Both children are non-null)

            Node leastParent = toBeRemoved;
            Node least = toBeRemoved.right;
            while(least.left != null) 
            {
                leastParent = least;
                least = least.left;
            }
            toBeRemoved.data = least.data;
            if(leastParent == toBeRemoved) 
            {
                leastParent.right = least.right;
            } 
            else 
            {
                leastParent.left = least.right;
            }
        } 
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print (this.root);
        System.out.println();
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        
        if(parent != null) 
        {
            print(parent.left);
            System.out.print(parent.data + " ");
            print(parent.right);
        }
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Node left;
        public Node right;
        public Comparable<Object> data;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            if(this.data.compareTo(newNode.data) < 0) 
            {
                if(this.left == null) 
                {
                    this.left = newNode;
                } else 
                {
                    this.left.addNode(newNode);
                }
            } else if(this.data.compareTo(newNode.data) > 0)
            {
                if(this.right == null) 
                {
                    this.right = newNode;
                } else 
                {
                    this.right.addNode(newNode);
                }
            }
        }
    }
}



