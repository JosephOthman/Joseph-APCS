/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS
HW84 -- Stack: What Is It Good For? (Not Absolutely Nothing) (Using stack to do cool things)
2022-03-29
time spent: 0.8 hrs

 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.

DISCO:
- Stacks can be used to perform operations that would otherwise be much more complicated.
- Using stacks to represent something wisely allows us to control the information that we
want from the top of the stack.
QCC:
- These examples seem pretty contrived. When to use stacks in a more "natural" setting?
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    String retStr = "";
    Latkes Coco = new Latkes( s.length() );
    for(int i = 0; i < s.length(); i++) {
      Coco.push(s.substring(i,i+1));
    }
    for(int j = 0; j < s.length(); j++) {
      retStr += (Coco.pop());
    }
    return retStr;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    Latkes Kat = new Latkes ( s.length() );
    for(int i = 0; i < s.length(); i++) {
      String nextChar = s.substring(i,i+1);
      if( (nextChar.equals("{")) || (nextChar.equals("(")) || (nextChar.equals("[")) ) {
        Kat.push( nextChar );
      }
      else {
        if( Kat.isEmpty() ) {
          return false;
        }
        else {
          String justPopped = Kat.pop();
          // Case 1: nextChar == "}"
          if(nextChar.equals("}")) {
            if( justPopped.equals("[") || justPopped.equals("(")) {
              return false;
            }
          }
          // Case 2: nextChar == ")"
          else if(nextChar.equals(")")) {
            if( justPopped.equals("[") || justPopped.equals("{")) {
              return false;
            }
          }
          // Case 3: nextChar == "]"
          else if(nextChar.equals("]")) {
            if( justPopped.equals("{") || justPopped.equals("(")) {
              return false;
            }
          }
        }
      }
    }
    return (Kat.isEmpty());
  }


  //main method to test
  public static void main( String[] args )
  {

    System.out.println(flip("stressed"));
    System.out.println(flip("pupils"));

    System.out.println(allMatched("")); //true
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
