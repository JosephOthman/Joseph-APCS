/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW86 -- What a Racket
2022-03-30
time spent: 0.8 hrs

DISCO:
- The use of two stacks was very clever, and very hard to come up with in my opinion.
- On the last point, coming up with the algo was hard.

QCC:
- What to do when stuck on an algo and don't know what to do?
  - QAF seems like a good idea, but any tips for solo/trio-adventuring?

 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the expression by the white space.
     2. Create 2 new stacks: one that will hold everything except close parens,
      and one that will only hold the numbers between parens, as well as the operation
      on them.
 *   3. Traverse through the array of elements that remained after splitting the input
     along the white space. If an element is not a closed parens, then add it to the
     first stack. If an element is a closed parens, then we use the upload helper method
     to evaluate everything between this closed parens and the last open parens.
     4. This works since we are able to push and pop all of the numbers that are between
     the two parens into the numbersOnly stack, and then push the operation as well. Then
     we can peek and pop to find the operation.
 *   5. Perform this until no more closed parens (i.e. the array has been traversed completely).
     The only element that remains is the final answer.
     6. Profit!
 *
 * STACK OF CHOICE: ALStack by PJOLLN
 * b/c the main advantage for LinkedLists instead of ArrayLists is being able to
 insert or delete at a position in the middle easier. But since we're only ever
 pushing or popping at the top of the stack, we felt that LinkedLists did not offer
 any advantages.
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] expressionParts = expr.split("\\s+");
    Stack<String> all = new ALStack<String>();
    Stack<String> numbersOnly = new ALStack<String>();

    for(int i = 0; i < expressionParts.length; i++) {
      if( !expressionParts[i].equals(")") ) {
        all.push(expressionParts[i]);
      }
      else {
        int op = 0;
        while( !all.peekTop().equals("(") ) {
          numbersOnly.push(all.peekTop());
          all.pop();
        }
        if(numbersOnly.peekTop().equals("+")) {
          op = 1;
          numbersOnly.pop();
        }
        else if(numbersOnly.peekTop().equals("-")) {
          op = 2;
          numbersOnly.pop();
        }
        else if(numbersOnly.peekTop().equals("*")) {
          op = 3;
          numbersOnly.pop();
        }
        all.pop();
        all.push(unload(op,numbersOnly));
      }
    }
    return all.peekTop();
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    int ans;
    if(op == 1) {
      ans = 0;
      while( !numbers.isEmpty() ) {
        ans += Integer.parseInt(numbers.peekTop());
        numbers.pop();
      }
    }
    else if(op == 2) {
      ans = 2*Integer.parseInt(numbers.peekTop());
      while ( !numbers.isEmpty() ) {
        ans -= Integer.parseInt(numbers.peekTop());
        numbers.pop();
      }
    }
    else {
      ans = 1;
      while( !numbers.isEmpty() ) {
        ans *= Integer.parseInt(numbers.peekTop());
        numbers.pop();
      }
    }
    return Integer.toString(ans);
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
