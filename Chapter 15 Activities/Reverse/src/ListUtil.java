import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        LinkedList<String> newStrings = new LinkedList<>();
        for(String s : strings)
            newStrings.addFirst(s);
        strings.clear(); strings.addAll(newStrings); //replaces strings with newStrings
    }
}