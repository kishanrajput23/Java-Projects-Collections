// Java program to demonstrate
// why collection framework was needed
import java.io.*;
import java.util.*;
 
class CollectionDemo {
 
    public static void main(String[] args)
    {
        // Creating instances of the array,
        // vector and hashtable
        int arr[] = new int[] { 1, 2, 3, 4 };
        Vector<Integer> v = new Vector();
        Hashtable<Integer, String> h = new Hashtable();
 
        // Adding the elements into the
        // vector
        v.addElement(1);
        v.addElement(2);
 
        // Adding the element into the
        // hashtable
        h.put(1, "geeks");
        h.put(2, "4geeks");
 
        // Array instance creation requires [],
        // while Vector and hastable require ()
        // Vector element insertion requires addElement(),
        // but hashtable element insertion requires put()
 
        // Accessing the first element of the
        // array, vector and hashtable
        System.out.println(arr[0]);
        System.out.println(v.elementAt(0));
        System.out.println(h.get(1));
 
        // Array elements are accessed using [],
        // vector elements using elementAt()
        // and hashtable elements using get()
    }
          }
