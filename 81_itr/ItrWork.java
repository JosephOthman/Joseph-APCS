/***
  Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
  APCS pd7
  HW81 -- Thank You, Next
  2022-03-24
  time spent: 0.6 h

 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    - Since the list interface only outlines what other classes can do, it can not
    be initialized as a variable; it is regarded as abstract.
    QCC
    - How similar are iterators to nodes in linked lists and doubly linked lists?
    What properties are shared and what properties aren't?
    SUMMARY THE FIRST:
    - Iterators point to an element of an iterable collection, and traverse the
    collection from the outside (as opposed to a node of a linked list, which
    traverses from the inside). Then, we can use the hasNext and remove methods to
    make it do what we want.
    SUMMARY THE SECOND:
    - Iterators point to an element of an interable collection, and use the next method
    in order to traverse along the collection. They have pointers to the  elements
    (shown by the next() method), and they have the ability to remove the element
    that they point to.

**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for (int n : L) {
      if (n == key) {
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    while( it.hasNext()) {
      int check = (int) it.next();
      if( check == key ) {
        return true;
      }
    } return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> returnList = new ArrayList<Integer>();
    for(int n : L) {
      if ( (n % 2) == 1 ) {
        returnList.add(n);
      }
    }
    return returnList;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> returnList = new ArrayList<Integer>();
    Iterator it = L.iterator();
    while(it.hasNext()) {
      int check = (int) it.next();
      if( (check % 2) == 1 ) {
        returnList.add(check);
      }
    }
    return returnList;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    while(it.hasNext()) {
      int check = (int) it.next();
      if ( (check % 2) == 0 ) {
        it.remove();
      }
    }
  }


  public static void main( String [] args )
  {


    //var type: List   obj type: ArrayList
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ ) {
      L.add(i);
    }

    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    for (Integer n : L) {
      System.out.print(n + " ");
    }

    // b) explicitly using an iterator


    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );


    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);


    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);



    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
