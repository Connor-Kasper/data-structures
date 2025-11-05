import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
    private Node first;

    /**
     * Constructs an empty stack.
    */
    public LinkedListStack()
    {
        first = null;
    }

    public boolean empty()
    {
        return first == null;
    }

    public Object push(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
        return element;
    }

    public Object pop()
    {
        if(this.empty())
        {
            throw new NoSuchElementException();
        }
        Object temp = first.data;
        first = first.next;
        return temp;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */






    /**
        Removes the element from the top of the stack.
        @return the removed element
    */








    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */


    static class Node
    {
        public Object data;
        public Node next;
    }
}
