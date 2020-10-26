import java.util.Scanner;

public class CircularLinkedList <E> {

    //Instance variables
    private Node<E> tail;
    private int size;
    /*
        init instance variables
     */
    public CircularLinkedList()
    {
        tail = null;
        size = 0;
    }

    /*
        return the size of the linked list
     */
    public int size()
    {
        return size;
    }

    /*
        checks if the linked list is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /*
        if linked list is empty return null
        if not empty return the first element
     */
    public E first()
    {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    /*
        if linked list is empty return null
        if not empty return last element
     */
    public E last()
    {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();

    }

    /*
        move tail to the next node
     */
    public void rotate()
    {
        tail = tail.getNext();
    }

    /*
        add element to the first of the linked list
        increase the size
     */
    public void addFirst(E e)
    {
        if (tail == null) {
            tail = new Node<>(e, null);
        }
        Node<E> oldtail = new Node<>(e, tail.getNext());
        tail = new Node<>(e, tail.getNext());
        tail.setNext(oldtail);
        size++;


    }

    /*
        add element to the end of the linked list
        increase size
     */
    public void addLast(E e)
    {
        Node<E> newitem = null;
        if (tail == null) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }
        else {
            //Node <E> oldtail = tail;
            newitem = new Node<>(e, tail.getNext());
            tail.setNext(newitem);
            tail = newitem;
            //Node<E> oldtail = new Node<>(e, tail.getNext());
          //  tail = new Node<>(e, tail.getNext());
            //tail.setNext(oldtail);

        }
        size++;
        }


    /*
        take out the first element
        decrease the size
        return first element or null


     */
    public E removeFirst()
    {
        if (isEmpty())
            return null;
        E answer = tail.getNext().getElement();
        tail = tail.getNext();
        size--;
        if (size == 0)
            tail= null;
        return answer;
    }

    public String toString()
    {
        String s;
        Node<E> n;
        if ( tail == null )
            return "null";
        s = "[";
        n = tail.getNext();
        if (n==null)
        {
            return s+ "empty list]";
        }
        int iter =0;
        while (n!=null && iter<2*size)
        {
            iter++;
            s = s+ n.getElement();
            if (n.getNext()!=null)
                s = s + ", ";
            n = n.getNext();
        }
        return s+"]";
    }
    public static void main(String args[])
    {
        String[] cars = { "prius", "rav4", "subaru", "crv", "pilot"};
        CircularLinkedList<String> carslist = new CircularLinkedList<String>();
        for (String i: cars)
        {
            carslist.addLast(i);
        }
        System.out.println("linkedlist:"+ carslist);
    }
}
