package Run;

public class BSTree{

	 private BinaryTreeNode root;
	  private int size;
	  private String print;
	  
	  public BSTree()
	  {
	    root = null;
	    size = 0;
	  }

	  public void add(int value)
	  {
	    if(root==null)
	    {
	      root = new BinaryTreeNode(value);
	    }
	    else
	    {
	      BinaryTreeNode curr = root;
	      while(true)
	      {
	        if(value>curr.value)
	        {
	          if(curr.right!=null)
	          {
	            curr = curr.right;
	          }
	          else
	          {
	            curr.right = new BinaryTreeNode(value);
	            return;
	          }
	        }
	        else
	        {
	          if(curr.left!=null)
	          {
	            curr = curr.left;
	          }
	          else
	          {
	            curr.left = new BinaryTreeNode(value);
	            return;
	          }
	        }
	      }
	    }
	    size++;
	  }

	  public void search(int value)
	  {
	    int op = 0;
	    BinaryTreeNode curr = root;
	    while(curr!=null)
	    {
	      if(curr.value==value)
	      {
	        System.out.println("Value "+value+" found, took "+op+" operations!");
	        return;
	      }
	      else if(value>curr.value)
	      {
	        curr = curr.right;
	        op++;
	      }
	      else
	      {
	       curr = curr.left;
	       op++;
	      }
	   }
	  System.out.println("Value "+value+" not found");
	  }
	  public String toString()
	  {
	    print = "";
	    preOrderTraversal(root);
	    return print;
	  }
	  
	  public void preOrderTraversal(BinaryTreeNode node)
	  {
	    if(node == null)
	    {
	       print += "<";
	      return;
	    }
	    print += node.value+" ";
	    preOrderTraversal(node.left);
	    preOrderTraversal(node.right);
	  }
	  public int getSize()
	  {
		  return size;
	  }

}
