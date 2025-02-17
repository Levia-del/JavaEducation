package Run;

public class AVLTree {
	 private AVLTreeNode root;
	  private int size;
	  private String print;
	  
	  public AVLTree()
	  {
	    root = null;
	    size = 0;
	  }

	  public void add(int value)
	  {
	    if(root==null)
	    {
	      root = new AVLTreeNode(value);
	    }
	    else
	    {
	      AVLTreeNode curr = root;
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
	            curr.right = new AVLTreeNode(value);
	            curr.rightH = 1;
	            setBalancesAndHeights();
	            size++;
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
	            curr.left = new AVLTreeNode(value);
	            curr.leftH = 1;
	            setBalancesAndHeights();
	            size++;
	            return;
	          }
	        }
	      }
	    }
	  }

	  public void search(int value)
	  {
	    int op = 0;
	    AVLTreeNode curr = root;
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
	  
	  public void preOrderTraversal(AVLTreeNode node)
	  {
	    if(node == null)
	    {
	       print += "<\n";
	      return;
	    }
	    print += node.value+" and its balance is "+ node.balance+"\n";
	    preOrderTraversal(node.left);
	    preOrderTraversal(node.right);
	  }

	  public void setBalancesAndHeights()
	  {
	    postTrav(root);
	  }

	  public void postTrav(AVLTreeNode node)
	  {
	     if(node == null)
	    {
	      return;
	    }
	    postTrav(node.left);
	    postTrav(node.right);
	    node.setHeights();
	    node.setBalance();
	  }
	  
	  public int getSize()
	  {
		  return size;
	  }
}
