package Run;

public class BinaryTree {
	 private BinaryTreeNode root;
	   private int size;
	   private String print;
	   public BinaryTree()
	   {
	    root = null;
	    size = 0;
	   }

	   public void add(int value)
	   {
	     if(root==null)
	     {
	       root = new BinaryTreeNode(value);
	       size++;
	     }
	     else
	     {
	      size++;
	      int n = log(size,2);
	      //System.out.println(n+" : n init");
	      int sizeCopy = size;
	      //System.out.println(sizeCopy+" : sizeCopy init");
	      int index;
	      BinaryTreeNode curr = root;
	      while(n>1)
	      {
	        sizeCopy %= Math.pow(2,n);
	        //System.out.println(sizeCopy+" : sizeCopy loop on n = "+n);
	        n--;
	        //System.out.println(n+" : new n");
	        index = (int)(sizeCopy/Math.pow(2,n));
	        //System.out.println(index+" : index");
	        curr = (index ==0) ? curr.left : curr.right;
	      }
	       sizeCopy %= Math.pow(2,n);
	        if(sizeCopy ==0)
	        {
	          curr.left = new BinaryTreeNode(value);
	        
	        }
	        else
	        {
	          curr.right= new BinaryTreeNode(value);
	          
	        }
	     }
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

	  public int log(int value, int base)
	  {
	    return(int)(Math.log(value)/Math.log(base));
	  }
}
