/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    //Stack<Integer> cakes = new ALStack<Integer>(10);
    Stack<Integer> cakes = new LLStack<Integer>();
    cakes.push(1);
    cakes.push(2);
    cakes.push(3);
    cakes.push(4);
    cakes.push(5);
    cakes.push(6);
    cakes.push(7);
    cakes.push(8);
    cakes.push(9);
    cakes.push(10);
    //10
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //9
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //8
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //7
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //6
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //5
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //4
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //3
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //2
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //1
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //Blastoff! (Print null)
    System.out.println( "Peeking top... ");
    System.out.println( cakes.peekTop() );
    System.out.println( "Popping... ");
    System.out.println( cakes.pop() );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //...

  }//end main

}//end class
