/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW83 -- Stacks on Stacks (on Stacks. Creating a stack (which is an ADT, or Abstract Data Type))
2022-03-28
time spent: 0.5 hrs

    DISCO
    - Class Latkes operates very similarly to the ArrayList that we created earlier (Superarray).
    Is this the intention of the assignment?

    QCC
    - Add to left side of array or right side? When creating this, we followed the maxim of
    Make life easy (paraphrased from class on linked lists), which was adding to the right side.
    - Why does the main method print an initial "null"?
 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;

  }// O(1) always


  //means of insertion
  public void push( String s )
  {
    if (_stackSize < _stack.length) {
    _stack[_stackSize] = s;
    _stackSize ++;
    }
    else {
      String[] newStack = new String[_stackSize*2];
      for(int i = 0; i < _stackSize; i++) {
        newStack[i] = _stack[i];
      }
      _stack = newStack;
      _stack[_stackSize] = s;
      _stackSize ++;
    }
  }// O(n) worst case, O(1) amoritized.


  //means of removal
  public String pop( )
  {
    if( !isEmpty() ) {
      String _temp = _stack[_stackSize];
      _stack[_stackSize] = null;
      _stackSize --;
      return _temp;
    }
    else {
      return null;
    }
  }// O(1) always


  //chk for emptiness
  public boolean isEmpty()
  {
    return (_stackSize == 0);
  }// O(1) always


  //chk for fullness
  public boolean isFull()
  {
    return (_stackSize == _stack.length);
  }// O(1) always


  //main method for testing
  public static void main( String[] args )
  {

    Latkes tastyStack = new Latkes(10);
    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");
    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );
    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
