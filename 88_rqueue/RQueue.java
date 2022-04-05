/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW88 -- BPC Kiddies Do Not Wait in Line Either
2022-04-04
time spent: 2.0 hrs

DISCO:
- This was painful; we ran into a lot of errors due to both poor planning and
other issues that we don't know.

QCC:
- Why not use arrayLists to do this easier, more efficiently?


 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = null;
    _end = null;
    _size = 0;
  }


  public void enqueue( T enQVal )
  {
    //special case: when enqueuing to an empty list,
    //make _front && _end point to same node
    if ( isEmpty() ) {
      _front = _end = new LLNode<T>( enQVal, null );
    }
    else {
      _end.setNext( new LLNode<T>( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
    System.out.println("enqueued " + enQVal);
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    if (_size == 1) {
      T retVal = _front.getCargo();
      _front = null;
      _size--;
      return retVal;
    }
    else {
      sample(); //shuffle the queue.
      T retVal = _front.getCargo();
      _front = _front.getNext();
      _size--;
      return retVal;
    }
  }//O(n^2)


  public T peekFront()
  {
    return _front.getCargo();
  }//O(1)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   Pick a random node; remove it from the queue and put it at the end of the queue.
   *   Perform this n times so that all possible queue orders are equally likely.
   **/

  public void sample ()
  {
    for(int j = 0; j < _size; j++ ) {
      try {
        LLNode randomNode = _front;
        LLNode beforeNode = _front;
        int n = (int) (_size * Math.random());
        if ( n == 0 ) {
          // do nothing
        }
        else {
          for( int i = 0; i < n-1; i++ ) {
            beforeNode = beforeNode.getNext();
          }
          randomNode = beforeNode.getNext();
        }

        if( randomNode.equals(_front) ) {
          _front = _front.getNext();
          randomNode.setNext(null);
          // enqueue((T)(randomNode.getCargo()));
          _end.setNext(randomNode);
          _end = _end.getNext();
        }
        else if ( randomNode.equals(_end) ) {
          // do nothing
        }
        else {
          beforeNode.setNext(randomNode.getNext());
          //randomNode just got jumped in the sequence.
          randomNode.setNext(null);
          // enqueue((T)(randomNode.getCargo()));
          _end.setNext(randomNode);
          _end = _end.getNext();
          //pull out random node and put new node with same cargo in the back.
        }
      }
      catch(Exception NullPointerException) {
        //do nothing
        j--;
      }
    }
  }//O(n^2); we had an algorithm that worked in O(n) time, but required the use of
  // arrayLists, which were not queue-y enough to actually learn abt queues.


  public boolean isEmpty()
  {
    return _front == null;
  } //O(1)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode<T> tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {



    RQueue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");


    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow testing sample()...");
    PirateQueue.sample();
    System.out.println( PirateQueue );

    // System.out.println("\nnow testing sample()...");
    // PirateQueue.sample();
    // System.out.println( PirateQueue );



    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
