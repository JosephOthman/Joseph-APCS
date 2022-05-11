/***
Jerk Kafe :: Joseph, Ruby, Kosta
APCS pd7
HW96 -- BSTs is the Perfect Place for Shade
2022-05-06f
time spent:  hrs


DISCO
------------------------------------------------
* Recursing down the left and/or right branches of a tree/subtree allowed us to
easily complete these methods.
* Better to get number of leaves the way we did, or to just look at traversal?
Traversal length is equal to number of leaves in the tree, so this might be more
optimal.
================================================


QCC
------------------------------------------------
* How do we quantify the run times of each method, with respect to:
a) number of nodes
b) height
* We believe it is possible to write these iteratively using while loops as well.
(We did this for the search method).
================================================
***/

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
	    return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~FEATURES NOT BUGS~~v~~~~~~~~~~~~~~~~~~~~~

  /*****************************************************
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   *****************************************************/
  TreeNode search( int target )
  {
  	/*** YOUR IMPLEMENTATION HERE ***/
    TreeNode currNode = _root;
    while(true) {
      if(currNode == null) {
        return null;
      }
      else if(target < currNode.getValue()) {
        currNode = currNode.getLeft();
      } else if(target > currNode.getValue()) {
        currNode = currNode.getRight();
      } else {
        return currNode;
      }
    }
  }


  /*****************************************************
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 1
   *****************************************************/
  public int height()
  {
  	/*** YOUR IMPLEMENTATION HERE ***/
    return height(_root);
  }

  public int height(TreeNode currNode) {
    if (currNode == null) {
      return 0;
    }
    else {
      if (height(currNode.getLeft()) >= height(currNode.getRight())) {
        return 1 + height(currNode.getLeft());
      }
      else {
        return 1 + height(currNode.getRight());
      }
    }
  }


  /*****************************************************
   * int numLeaves()
   * returns number of leaves in tree
   *****************************************************/
  public int numLeaves()
  {
  	/*** YOUR IMPLEMENTATION HERE ***/
    return numLeaves(_root);
  }

  public int numLeaves(TreeNode currNode) {
    if (currNode == null) {
      return 0;
    }
    else {
      return (1 + numLeaves(currNode.getLeft()) + numLeaves(currNode.getRight()));
    }
  }




  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "height:" );
    System.out.print( arbol.height()); // Expect 3

    System.out.println( "\n-----------------------------");
    System.out.println( "number of leaves:" );
    System.out.print( arbol.numLeaves()); // Expect 6

    System.out.println( "\n-----------------------------");
    System.out.println( "searching for 2" );
    System.out.print( arbol.search(2)); // Expect some location

    System.out.println( "\n-----------------------------");
    System.out.println( "searching for 7" );
    System.out.print( arbol.search(7)); // Expect null
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



    /**
       EXPECTED OUTPUT:
       -----------------------------
       pre-order traversal:
       4 2 1 3 5 6
       -----------------------------
       in-order traversal:
       1 2 3 4 5 6
       -----------------------------
       post-order traversal:
       1 3 2 6 5 4
       -----------------------------
    */
  }

}//end class
