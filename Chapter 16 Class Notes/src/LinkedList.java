import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    //stati c claw sse  ruasg e sto res the info
    static class Node {
        public Node next;
        public Object data;
    }
    Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        this.first = null;
    }
    public LinkedList(Node nod)
    {
        this.first = nod;
    }


    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        if (first == null) {
            throw new NoSuchElementException();

        }
        return first.data;
    }




    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        if (first == null) {
            throw new NoSuchElementException();

        }
        Node temp = first;
        first = first.next;
        return temp.data;
    }





    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }





    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator getIterator()
    {
        return new LinkedListIterator();
    }




    //Class Node
    public String toString()
    {
        String result = "[";
        Node current = first;
        while (current != null)
        {
            if (current != first)
            {
                result += ", ";
            }
            result += current.data;
            current = current.next;
        }
        return result + "]";
    }

    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous;
        private boolean isAfterNext;
      //private data


        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        public Object next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            previous = position; // Remember for remove
            isAfterNext = true;

            if (position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }
            return position.data;
        }

        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            isAfterNext = false;
        }

        public boolean hasNext()
        {
            if(position == null)
            {
                return first != null;
            }
            else
            {
                return position.next != null;
            }
        }

        public void set(Object element)
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }
            position.data = element;
        }

        public void remove()
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }
            if(position == first)
            {
                removeFirst();
                position = null;
            }
            else
            {
                isAfterNext = false;
                position = previous;
                position.next = position.next.next;
            }
            
            
        }

        public int size()
        {
            if(first == null)
            {
                return 0;
            }
            int curSize = 1;
            Node curThing = first;
            while(curThing.next != null)
            {
                curSize++;
                curThing = curThing.next;
            }
            return curSize;
        }
        public int size2()
        {
            return sizeHelper(first);
        }
        public int sizeHelper(Node n)
        {
            if(n == null)
            {
                return 0;
            }
            return 1 + sizeHelper(n.next);
        }

        public boolean contains(Object element)
        {
            Node cur = first;
            while(cur != null)
            {
                if(cur.data.equals(element))
                {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }

        public boolean contains2(Object element)
        {
            return containsHelper(first, element);
        }
        public boolean containsHelper(Node n, Object element)
        {
            if(n == null)
            {
                return false;
            }
            if(n.data.equals(element))
            {
                return true;
            }
            return containsHelper(n.next, element);
        }

    }//LinkedListIterator
}//LinkedList
