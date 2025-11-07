import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;
    
    static class Node
    {
        public List<Node> children;
        public Object data;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int retSize = 0;
            for(Node child : children) {
                retSize += child.size();
            }
            return retSize + 1;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(TreeGurt subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return root.size();
    }

    public int countLeaves(Node node) 
    {
        int retSize = 0;
        for(Node child : node.children) {
            retSize += countLeaves(child);
        }
        if(node.children.isEmpty()) {
            return 1;
        }
        return retSize;
    }
    
    public int countLeaves() 
    {
        return countLeaves(this.root);
    }

    // Additional methods will be added in later sections.
    // A visitor method is called for each visited node during a tree traversal.

    public interface Visitor
    {
        /*
         * The visit method is called for each visited node.
         * @param data: The data of the node being visited.
         */
        void visit(Object data);
    }

    /*
     * Traverse this tree in pre-order.
     * @param v: visitor to be invoked on each node.
     */
    private void preorder(Visitor v) 
    {
          TreeGurt.preorder(this.root, v);
    }

    public ArrayList<Object> depthFirstList()
    {
        ArrayList<Object> depthFirstObjectList = new ArrayList<>();
        ArrayList<Node> rootNodeList = new ArrayList<>();
        rootNodeList.add(this.root);
        depthFirstObjectList.add(this.root.data);
        depthFirstList(rootNodeList, depthFirstObjectList);
        return depthFirstObjectList;
        
    }

    private void depthFirstList(ArrayList<Node> nodes, ArrayList<Object> dfList)
    {
        ArrayList<Node> childNodeList = new ArrayList<>();

        if(nodes.isEmpty()) 
        {
            return;
        }

        for(Node n : nodes) 
        {
            for(Node child : n.children) 
            {
                dfList.add(child.data);
                childNodeList.add(child);
            }
        }
        depthFirstList(childNodeList, dfList);
        return;
    }


     /*
      * Traverse the tree with a given root in preorder.
      * @param n: the root of the tree to traverse.
      * @param v: the visitor to be invoked on each node.
      */
    public static void preorder(Node n, Visitor v) 
    {
        if( n == null ) 
        {
           return;
        }
        v.visit(n.data);

        for(Node child : n.children) 
        {
            TreeGurt.preorder(child, v);
        }
    }
}
