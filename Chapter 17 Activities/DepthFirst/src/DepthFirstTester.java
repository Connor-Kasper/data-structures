import java.util.Iterator;

/**
    This program demonstrates tree traversal.
*/
public class DepthFirstTester
{
    public static void main(String[] args)
    {
        TreeGurt t1 = new TreeGurt("Anne");
        TreeGurt t2 = new TreeGurt("Peter");
        t1.addSubtree(t2);
        TreeGurt t3 = new TreeGurt("Zara");
        t1.addSubtree(t3);
        TreeGurt t4 = new TreeGurt("Sonia");
        t2.addSubtree(t4);
        TreeGurt t5 = new TreeGurt("Mike");
        t2.addSubtree(t5);
        TreeGurt t6 = new TreeGurt("Sam");
        t2.addSubtree(t6);
        TreeGurt t7 = new TreeGurt("Jane");
        t5.addSubtree(t7);

        // Use a lambda (Section 10.4) for the visitor
        Visitor visitor = (data) -> {
            if (data == null) return false;
            System.out.print(data + " ");
            return true;
        };

        
        System.out.println(t1.postorder());
        System.out.println("Expected: Anne Peter Sonia Mike Jane Sam Zara");

    }
}
