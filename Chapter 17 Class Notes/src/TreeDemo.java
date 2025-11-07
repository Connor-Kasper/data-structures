/**
   This class demonstrates the tree class.
*/
public class TreeDemo
{
   public static void main(String[] args)
   {
      TreeGurt t1 = new TreeGurt("Anne");
      TreeGurt t2 = new TreeGurt("Peter");
      t1.addSubtree(t2);
      TreeGurt t3 = new TreeGurt("Zara");
      t1.addSubtree(t3);
      TreeGurt t4 = new TreeGurt("Savannah");
      t2.addSubtree(t4);
      TreeGurt t5 = new TreeGurt("Wobble");
      t1.addSubtree(t5);
      System.out.println("Size: " + t1.size());

      System.out.println("DepthFirstOrder" + t1.depthFirstList());
   }
}
