/***
 * class ALStack
 * v1
 * SKELETONTR
 * Implements a stack of Strings using an encapsulated arrayList
 **/

import java.util.LinkedList;

public class LLStack<T> implements Stack<T>
{
  private LinkedList<T> _stack;
  private int _stackSize;


  //constructor
  public LLStack( )
  {
    _stack = new LinkedList<T>();
    _stackSize = 0;

  }// O(1) always


  //means of insertion
  public void push( T s )
  {
    _stack.add(s);
    _stackSize ++;
  }// O(1)


  //means of removal
  public T pop( )
  {
    T retT;
    if(_stackSize > 0) {
      retT = _stack.get(_stackSize - 1);
      _stack.remove(_stackSize-1);
      _stackSize --;
    }
    else {
      retT = null;
    }
    return retT;
  }// O(n)

  public T peekTop( ){
    T retT;
    if(_stackSize > 0) {
      retT = _stack.get(_stackSize - 1);
    }
    else {
      retT = null;
    }
    return retT;
  }// O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    return (_stackSize == 0);
  }// O(1) always


  //chk for fullness
  public boolean isFull()
  {
    return (_stackSize == _stack.size());
  }// O(1) always


  //main method for testing
  public static void main( String[] args )
  {

    LLStack tastyStack = new LLStack();
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
