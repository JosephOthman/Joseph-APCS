/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW87 -- The English Do Not Wait In Line for Soup
2022-04-03
time spent: 0.5 hrs

DISCO:
- Queues follow the FIFO formula, meaning that the first thing entered is the first
thing leaving.
- Queues are basically just backwards linked lists. We add behind instead of at the
front, and we pop off the front instead of the back.

QCC:
- When to use queue vs llist vs stack?

**/

public class NodeQueue<T> implements Queue<T> {

  private class Node
  {
    //instance vars
    private T _cargo;
    private Node _nextNode;

    // constructor
    public Node( T value, Node next )
    {
      _cargo = value;
      _nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo()
    {
      return _cargo;
    }

    public Node getNext()
    {
      return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo )
    {
      T foo = getCargo();
      _cargo = newCargo;
      return foo;
    }

    public Node setNext( Node newNext )
    {
      Node foo = getNext();
      _nextNode = newNext;
      return foo;
    }
    //--------------^  MUTATORS  ^--------------
  }

  Node _first;
  int _queueSize;

  public T dequeue() {
    if( _queueSize == 0 ) {
      return null;
    }
    else {
      T retVal = _first.getCargo();
      _first = _first.getNext();
      _queueSize--;
      return retVal;
    }
  }

  public void enqueue( T x ) {
    Node newNode = new Node( x, null);
    if(_queueSize == 0) {
      _first = newNode;
    }
    else {
      Node temp = _first;
      while( temp.getNext() != (null) ) {
        temp = temp.getNext();
      }
      temp.setNext( newNode );
    }
    _queueSize++;
  }

  public boolean isEmpty() {
    return ( _queueSize == 0 );
  }

  public T peekFront() {
    return _first.getCargo();
  }

  public String toString() {
    Node temp = _first;
    String retVal = "";
    while( temp.getNext() != (null) ) {
      retVal += temp.getCargo() + " ";
      temp = temp.getNext();
    }
    retVal += temp.getCargo();
    return retVal;
  }



  public static void main(String[] args) {

    NodeQueue<Integer> Adi = new NodeQueue<Integer>();
    Adi.enqueue(1);
    Adi.enqueue(2);
    Adi.enqueue(3);
    Adi.enqueue(4);
    Adi.enqueue(5);
    Adi.enqueue(6);
    Adi.enqueue(7);
    //System.out.println(Adi);
    while(!Adi.isEmpty()) {
      System.out.println(Adi.peekFront());
      Adi.dequeue();
    }


    NodeQueue<String> wu = new NodeQueue<String>();
    wu.enqueue("RZA");
    wu.enqueue("GZA");
    wu.enqueue("ODB");
    wu.enqueue("Inspectah Deck");
    wu.enqueue("Raekwon the Chef");
    wu.enqueue("U-God");
    wu.enqueue("Ghostface");
    wu.enqueue("Method Man");
    System.out.println(wu);
    while(!wu.isEmpty()) {
      System.out.println(wu.peekFront() + " raps for the Wu");
      wu.dequeue();
    }
  }

}
