package Run;

public class AVLTree {
	 public AVLTreeNode root;
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

	  public void RotateRight(AVLTreeNode node)
	  {
		  AVLTreeNode LChild = node.left;
		  if(LChild.right != null)
		  {
			  node.left = LChild.right;
			  
		  }
		  else
		  {
			  node.left = null;
		  }
		  
		  if(node == root)
		  {
		  LChild.right = node;
		  root = LChild;
		  }
		  else
		  {
			  AVLTreeNode temp = node;
			  LChild.right = node;
			  LChild = temp;
		  }
		  setBalancesAndHeights();
	  }
	  
	  public void RotateLeft(AVLTreeNode node)
	  {
		  AVLTreeNode RChild = node.right;
		  if(RChild.left != null)
		  {
			  node.right = RChild.left;
			  
		  }
		  else
		  {
			  node.right = null;
		  }
		  
		  if(node == root)
		  {
			  RChild.left = node;
			  root = RChild;
		  }
		  else {
		  AVLTreeNode temp = node;
		  RChild.left = node;
		  RChild = temp;
		  }
		  setBalancesAndHeights();
	  }
	  
	  public void postTrav(AVLTreeNode node)
	  {
	    if(node == null)
	    {
	      return;
	    }
	    node.leftH = 0;
	    node.rightH = 0;
	    node.balance = 0;
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
