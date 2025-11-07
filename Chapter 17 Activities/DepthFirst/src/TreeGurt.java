import java.util.List;
import java.util.ArrayList;

/**
    Add a method void depthFirst(Visitor v) to the Tree class of
    Section 17.4 (below).
    Keep visiting until the visit method returns false.
*/
public class TreeGurt
{
    private Node root;

    class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 0;
            for (Node child : children) { sum = sum + child.size(); }
            return 1 + sum;
        }
    }

    /**
        Constructs an empty tree.
    */
    public TreeGurt()
    {
        root = null;
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public TreeGurt(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(TreeGurt subtree)
    {
        root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size()
    {
        if (root == null) { return 0; }
        else { return root.size(); }
    }

    public ArrayList<Object> postorder(){
        ArrayList<Object> postorderList = new ArrayList<>();
        for(Node child : root.children) {
            postorderHelper(child, postorderList);
        }
        postorderList.add(root.data);
        return postorderList;
    }

    public void postorderHelper(Node node, ArrayList<Object> postorderList){
        for(Node child : node.children) {
            postorderHelper(child, postorderList);
        }
        postorderList.add(node.data);
    }

    public ArrayList<Object> depthFirst()
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

    // Additional methods will be added in later sections.
}
