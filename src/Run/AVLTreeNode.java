package Run;

public class AVLTreeNode {
	public int value;
	   public AVLTreeNode left;
	   public AVLTreeNode right;
	   public int balance;
	   public int leftH;
	   public int rightH;

	   public AVLTreeNode(int value)
	   {
	     this.value = value;
	     balance = 0;
	     leftH = 0;
	     rightH = 0;
	     left = null;
	     right = null;
	   }

	   public void setBalance()
	   {
	     balance = rightH-leftH;
	   }
	  
	   public void setHeights()
	   {
	    if(left==right)
	    {
	      
	    }
	    else if(left == null)
	    {
	      rightH = Math.max(right.leftH,right.rightH)+1;
	    }
	    else if(right == null)
	    {
	      leftH = Math.max(left.leftH,left.rightH)+1;
	    }
	    else
	    {
	      leftH = Math.max(left.leftH,left.rightH)+1;
	      rightH = Math.max(right.leftH,right.rightH)+1;
	    }
	   }
}
