/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode<T>
{
    //instance vars
    private T _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _prevNode; // pointer to previous DLLNode

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode next, DLLNode prev) {
	     _cargo = value;
	     _nextNode = next;
       _prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return (T)_cargo; }
    public DLLNode getPrev() { return _prevNode; }
    public DLLNode getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
      T foo = getCargo();
  	  _cargo = newCargo;
  	  return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
    	DLLNode foo = getNext();
    	_nextNode = newNext;
    	return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
    	DLLNode foo = getPrev();
    	_prevNode = newPrev;
    	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args )
    {

	//Below is an exercise in creating a linked list...

	//Create a node
	// DLLNode first = new DLLNode( "cat", null );

	// //Create a new node after the first
	// first.setNext( new DLLNode( "dog", null ) );

	// //Create a third node after the second
	// first.getNext().setNext( new DLLNode( "cow", null ) );

	/* A naive list traversal, has side effects.... ??
	   while( first != null ) {
	   System.out.println( first );
	   first = first.getNext();
	   }
	*/

	//Q: when head ptr moves to next node in list, what happens to the node it just left?

	//...so better: ?
	//
	//
	//

    }//end main

}//end class DLLNode
