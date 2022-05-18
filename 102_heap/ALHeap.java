/**
Jerk Kafe :: Joseph, Ruby, Kosta
APCS pd7
HW102 -- Heap On Heapin' On
2022-05-18w
time spent: 1.0 hrs
*/

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    String ret = "";
    int pow = 1;
    for (int i=0; i<_heap.size(); i++) {
      if (i + 1 == (int)Math.pow(2, pow)) {
        ret += "\n";
        pow++;
      }
      ret += _heap.get(i) + " ";
    }
    ret += "\n";
    return ret;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * insert node as leaf by adding to the end, and comparing its value with its
   parent. If parent > new val, swap them. Continue until parent is no longer
   greater than node.
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal);
    int index = _heap.size() - 1; // points to current index of the node we're adding.
    int parentInd = (index - 1) / 2; // parent location
    while(_heap.get(index) < _heap.get(parentInd)) { // while my parent is larger than I am
      swap(index, parentInd); // swap me with my parent in the ArrayList
      index = parentInd; // update my location.
      parentInd = (index - 1) / 2; // update my parent's location. Repeat until done.
    }
  }//O(logn)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * first, store the min element (first element of array).
   Then, set the root to temporarily be the final leaf.
   Swap the leaf with its minimum child until it is at most both of its children.
   */
  public Integer removeMin()
  {
    if(_heap.size() == 1) {
      return _heap.remove(0);
    }
    int retVal = _heap.get(0);
    int x = _heap.remove(_heap.size() - 1);
    _heap.set(0, x);
    int index = 0; //where the last leaf is now.
    while(2*index + 1 < _heap.size()
    && _heap.get(index) > _heap.get(minChildPos(index))) { //if node leaf is greater than >= 1 of its children
      int tmp = minChildPos(index);
      swap(index, minChildPos(index)); //swap me with the SMALLER child
      index = tmp; //update my location. Continue until done.
    }
    return retVal;
  }//O(logn)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    if(_heap.size() <= (2*pos + 1)) { // If not in the list, or don't have children
      return -1;
    }

    if(_heap.size() == (2*pos + 2)) {
      return 2*pos + 1; //only have left child; return its index.
    }

    if(minOf(_heap.get(2*pos+1), _heap.get(2*pos+2)) == _heap.get(2*pos+1)) {
      return 2*pos + 1;
    }
    else {
      return 2*pos + 2;
    }
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {

      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);


      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
