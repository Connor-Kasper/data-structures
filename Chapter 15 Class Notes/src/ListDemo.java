import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The add lLast Method can be used to populate a list */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Steven");
        System.out.println(staff);

        //The list is TNPS

        //The listIterator method creates a new list iterator
        // | is used for iterator position

        ListIterator<String> gurtTerator = staff.listIterator(); // |TNPS

        gurtTerator.next(); // T|NPS
        //Next method returns the thing that it jumped over
        String staffMember = gurtTerator.next(); //TN|PS
        System.out.println(staffMember);

        /*the add method inserts an element at the iterator position
         * after added itterator put after that position
        */
        gurtTerator.add("Adrian"); //TNA|PS
        gurtTerator.add("Bruce"); // TNAB|PS
        System.out.println(staff);

        //The remove method can only be called after calling next or previous
        //gurtTerator.remove(); TS gives an error

        gurtTerator.next();
        gurtTerator.remove(); // TNABP|S
        System.out.println(staff); //TNAB|S

        gurtTerator.previous(); //TNA|BS
        gurtTerator.set("GooberGuy");
        System.out.println(staff); //TNAG
        
        gurtTerator = staff.listIterator();
        while(gurtTerator.hasNext())
        {
            String nextDude = gurtTerator.next();
            System.out.println("IM NEXTING IT");
            System.out.println(nextDude);
            if(nextDude.equals("Natasha"))
            {
                System.out.println("Found natasha here guys");
            }
        }
        /* 
        gurtTerator = staff.listIterator();
        while(gurtTerator.hasNext())
        {
            String n = gurtTerator.next();
            if(n.equals("Tony"))
            {
                gurtTerator.remove(); // If you used staff instead to remove you would run into a concurrent modification exception
            }
        } */

        for(String n: staff)
        {
            if(n.equals("Tony"))
            {
                staff.add("T'Challa");
            }
        }
        System.out.println(staff);
        

    }
}
