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
    public void addSubtree(Tree subtree)
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
}
