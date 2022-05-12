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
     return search( target, _root );
   }
   TreeNode search( int target, TreeNode currNode )
   {
     if ( currNode==null || currNode.getValue()==target )
       return currNode;
     else if ( target < currNode.getValue() )
       return search( target, currNode.getLeft() );
     else if ( target > currNode.getValue() )
       return search( target, currNode.getRight() );
     else
       return null; //to get past compiler
   }

   public String inOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += inOrderTravStr( currNode.getLeft() );
    retStr += " " + currNode.getValue();
    retStr += inOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String preOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += " " + currNode.getValue();
    retStr += preOrderTravStr( currNode.getLeft() );
    retStr += preOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String postOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += postOrderTravStr( currNode.getLeft() );
    retStr += postOrderTravStr( currNode.getRight() );
    retStr += " " + currNode.getValue();
    return retStr;
  }

   //overridden toString
   public String toString()
   {
     return
       " pre-order trav:" + preOrderTravStr( _root ) + '\n' +
       "  in-order trav:" + inOrderTravStr( _root ) + '\n' +
       "post-order trav:" + postOrderTravStr( _root ) + '\n' +
       "         height: " + height() + '\n' +
       "     num leaves: " + numLeaves()
       ;
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

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~^~~FEATURES NOT BUGS~~^~~~~~~~~~~~~~~~~~~~~~


  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~v~~THE DROIDS YOU'RE LOOKING FOR~~v~~~~~~~~


  /*****************************************************
   * void remove()
   * removes the input node from the BST
   * POST CONDITION: BST left right order is maintained
   *****************************************************/
  public void remove(int target) {
    if(search(target) != null) _root = remove(target, _root);
  }

  // Helper method; assumes target is the cargo of a node
  // in the BST.
  public TreeNode remove(int target, TreeNode subRoot) {
    if (subRoot == null) {
      return null;
    }

    if(target < subRoot.getValue()) {
      subRoot.setLeft(remove(target, subRoot.getLeft()));
    }
    else if(target > subRoot.getValue()) {
      subRoot.setRight(remove(target, subRoot.getRight()));
    }

    else {
      if(subRoot.getLeft() == null) {
        return subRoot.getRight();
      }
      else if(subRoot.getRight() == null) {
        return subRoot.getLeft();
      }

      subRoot.setValue(getMax(subRoot.getLeft()));
      subRoot.setLeft(remove(subRoot.getValue(), subRoot.getLeft()));
    }
    return subRoot;

  }

  // Helper method; assumes subRoot is not null, not a leaf
  // gets the max cargo of any node on the left branch of TreeNode subroot
  int getMax(TreeNode subRoot) {
    TreeNode max = subRoot;
    while(max.getRight() != null) {
      max = max.getRight();
    }
    return max.getValue();
  }

  //main method for testing
  public static void main( String[] args ) {

  	BST arbol = new BST();

  	System.out.println( "tree init'd: " + arbol );

  	//inserting in this order will build a perfect tree
  	arbol.insert( 3 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	arbol.insert( 2 );
  	arbol.insert( 5 );
  	arbol.insert( 4 );
  	arbol.insert( 6 );
  	/*
  	*/

  	//insering in this order will build a linked list to left
  	/*
  	arbol.insert( 6 );
  	arbol.insert( 5 );
  	arbol.insert( 3 );
  	arbol.insert( 4 );
  	arbol.insert( 2 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	*/

  	System.out.println( "tree after insertions:\n" + arbol );
  	System.out.println();

  	System.out.println();
  	for( int i=-1; i<8; i++ ) {
  	    System.out.println(" searching for "+i+": " + arbol.search(i) );
  	}

  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(6);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(5);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(4);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(3);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(2);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(1);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(0);
  	System.out.println();
  	System.out.println( arbol );

  }

}//end class
