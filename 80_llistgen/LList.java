/**
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW78 -- Double Up
2022-03-15
time spent: 0.7 h
KTS Used: 4

DISCO:
- Methods are basically the same, except now we have to account for the fact
that there are also points to previous nodes that must be updated during the
addition and removal methods.
QCC:
- How does being able to go backwards in a DLL help us more?
- Why make a DLL instead of another LL that just reverses the original LL (is this
  easier?)?
ALGO ADD:
- Create a new node with parameters (newVal, null).
- if adding at index 0 or _size - 1, setNext of newNode to be head (tail), then
  setPrev of head (tail) to be new node, then set head (tail) = newNode.
- Otherwise, traverse through existing LL until reach the node at index (i-1).
- setNext of the new Node to be the node currently at index i.
- setNext of the node currently at index (i-1) to be the new node.
- increase the size accordingly.
-
ALGO REM:
- If removing at index 0, set tmp = _head.getNext(). Then set head = tmp, then
  setPrev(head) = null, and return cargo of temp.
- If removing at index _size - 1, set tmp = _tail.getPrev(). Then set tail = tmp,
  setNext(tail) = null, and return cargo of temp.
- Traverse through the LL until we reach the node at index (i-1).
- Create a temp storge node of the node currently at index i.
- setNext of the node at index (i-1) to be the node currently at index (i+1).
- decrease the size accordingly.
- return the cargo of the temp storage node.
*/

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( T newVal )
  {
    DLLNode tmp = new DLLNode( newVal, _tail, _head );
    if (_head == null) {
      _tail = tmp;
      _head = tmp;
    }
    else {
      _head.setPrev(tmp);
      tmp.setNext(_head);
      _head = tmp;
    }
    _size++;
    return true;
  }


  public T get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = (T) tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = (T) tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, T newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode newNode = new DLLNode ( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
	    add( newVal );

    else if ( index == _size - 1 ) {
      newNode.setPrev(_tail);
      _tail.setNext(newNode);
      _tail = newNode;
    }
    else {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();

        DLLNode tmp2 = tmp.getNext();
	    //insert new node
	    newNode.setNext( tmp2 );
      newNode.setPrev( tmp );
	    tmp.setNext( newNode );
      tmp2.setPrev( newNode );

	    //increment size attribute
	    _size++;
    }
  }


  //remove node at pos index, return its cargo
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //if index==0, remove head node
    if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = (T) _head.getCargo();

	    //remove target node
	    _head = _head.getNext();
    }
    else if ( index == _size - 1 ) {
      retVal = (T) _tail.getCargo();
      _tail = _tail.getPrev();
      _tail.setNext(null);
    }
    else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = (T) tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
      tmp.getNext().setPrev( tmp );
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += (T) tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
  }

}//end class LList
