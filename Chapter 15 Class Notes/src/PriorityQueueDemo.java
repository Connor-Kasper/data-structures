import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        //Create a priority queue of strings
        //A priority needs to be a comparable type
        Queue<String> students = new PriorityQueue<>();
        students.add("Neel");
        students.add("Jonathan");
        students.add("Cam");
        students.add("Kaitlyn");
        students.add("Dylan");

        while(students.size() > 0)
        {
            System.out.println("Next student: " + students.remove());
        }

        //Create a to-do list with priorities
        Queue<WorkOrder> toDo = new PriorityQueue<>();
        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(1, "Conquer the World")); //                                                          :)
        toDo.add(new WorkOrder(9, "Do Homework"));
        toDo.add(new WorkOrder(20, "Study fo tr r thjnedrt45y6u7i8o9p0"));//       /     /                         >>>

        System.out.println(toDo);                                                                                                                      //     ");

        while (toDo.size() > 0)
        {
            System.out.println("Next task: " + toDo.remove());
            
        }
    }
}
