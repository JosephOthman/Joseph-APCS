/***
 * interface Stack
 * Specifies actions a stack must be able to perform.
 * Allows for generic typing.
 **/

public interface Stack<T>
{
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty();

    //Return top element of stack without popping it.
    public T peekTop();

    //Pop and return top element of stack.
    public T pop();

    //Push an element onto top of this stack.
    public void push( T x );

}//end interface
