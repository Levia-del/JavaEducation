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
	            balanceTree();
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
	            balanceTree();
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

	  public void RotateRight(AVLTreeNode node, AVLTreeNode parent, boolean isRoot, boolean isLeft)
	  {
		  if(isRoot)
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
		      LChild.right = node;
		      root = LChild;
		  }
		  else
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
			  
			  LChild.right = node;
			  if(isLeft)
			  {
				  parent.left = LChild;
			  }
			  else
			  {
				  parent.right = LChild;
			  }
		  }
		  System.out.println("RotateRight done");
		  setBalancesAndHeights();
		  
	  }
	  
	  public void RotateLeft(AVLTreeNode node,AVLTreeNode parent, boolean isRoot, boolean isLeft)
	  {
		  if(isRoot)
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
			  
			  RChild.left = node;
			  root = RChild;
		  }
		  else {
		   AVLTreeNode RChild = node.right;
		   if(RChild.left != null)
		   {
			   node.right = RChild.left;
				  
		   }
		   else
		   {
			   node.right = null;
		   } 
		  
		 
		  RChild.left = node;
		  if(isLeft)
		  {
			  parent.left = RChild;
		  }
		  else
		  {
			  parent.right = RChild;
		  }
		  }
		  System.out.println("RotateLeft done");
		  setBalancesAndHeights();
	  }
	  
	  
	  public void balanceTree()
	  {
		  PreOrderCheck(root,null, false);
	  }
	  
	  public void PreOrderCheck(AVLTreeNode node, AVLTreeNode parent, boolean isLeft)
	  {
		  if(node == null)
		  {
			  return;
		  }
		  if(node==root)
		  { 
			  
			  if(node.balance >1)
			  {
				  if(node.right.balance>0)
				  {
					  RotateLeft(node,null, true, false);
				  }
				  else
				  {
					  RotateRight(node.right, node, false, false);
					  RotateLeft(node,null, true, false);
				  }
			  }
			  else if(node.balance<-1)
			  {
				  if(node.left.balance<0)
				  {
					  RotateRight(node,null, true, false);
				  }
				  else
				  {
					  RotateLeft(node.left, node, false, true);
					  RotateRight(node,null, true, false);
				  }
			  }
		  }
		  else
		  {
			  if(node.balance >1)
			  {
				  if(node.right.balance>0)
				  {
					  RotateLeft(node,parent, false, isLeft);
				  }
				  else
				  {
					  RotateRight(node.right, node, false, false);
					  RotateLeft(node,parent, false, isLeft);
				  }
			  }
			  else if(node.balance<-1)
			  {
				  
				  if(node.left.balance<0)	
				  {
					  RotateRight(node,parent, false, isLeft);
				  }
				  else
				  {
					  RotateLeft(node.left, node, false, true);
					  RotateRight(node,parent, false, isLeft);
				  }
			  }
		  }
		  
		  PreOrderCheck(node.left, node, true);
		  PreOrderCheck(node.right, node, false);
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
