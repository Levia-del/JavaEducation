package Run;

public class AdjacencyMatrix {

	private int[][] matrix;
	  private int size;
	  private String print;
	  private GraphNode[] nodes;
	  private boolean[] checked;
	  private int[] costs;
	  private GraphNode firstNode;
	  
	  public AdjacencyMatrix()
	  {
	    matrix = new int[10][10];
	    matrix[0][1] = 7;
	    matrix[0][5] = 1;
	    matrix[0][8] = 6;
	    matrix[1][2] = 9;
	    matrix[1][3] = 7;
	    matrix[2][0] = 7;
	    matrix[2][4] = 8;
	    matrix[3][2] = 2;
	    matrix[3][6] = 9;
	    matrix[4][0] = 1;
	    matrix[4][0] = 1;
	    matrix[5][1] = 7;
	    matrix[5][7] = 4;
	    matrix[6][2] = 9;
	    matrix[7][4] = 9;
	    matrix[8][5] = 7;
	    matrix[8][9] = 2;
	    matrix[9][2] = 1;
	   nodes = new GraphNode[10];
	    size = 0;
	    print = "";
	  }

	  public void add(int value)
	  {
	    if(firstNode == null)
	    {
	      firstNode = new GraphNode(value);
	      nodes[0] = firstNode;
	    }
	    else
	    {
	      int curr = 0;
	      while(nodes[curr]!=null)
	      {
	        curr++;
	        if(curr>=10)
	        {
	          throw new IndexOutOfBoundsException();
	        }
	      }
	      int r1 = (int)(Math.random()*curr);
	      int r2 = (int)(Math.random()*curr);
	      nodes[curr] = new GraphNode(value);
	      /*if(matrix[curr][r1]==0)
	      {
	        matrix[r1][curr] = (int)(Math.random()*9)+1;
	      }
	      if(matrix[r2][curr]==0)
	      {
	        matrix[curr][r2] = (int)(Math.random()*9)+1;
	      }*/
	    }
	    size++;
	  }

	  public String toString()
	  {
	    updateOrClearChecked();
	    
	    DFSTraversal(0);
	    for(int r =0;r<matrix.length;r++)
	    {
	      for(int c = 0; c<matrix[0].length;c++)
	      {
	       System.out.print(matrix[r][c]+" ");
	      }
	      System.out.print("\n");
	    }
	    System.out.print("\n");
	    return print;
	  }

	  private void updateOrClearChecked()
	  {
	    checked = new boolean[size];
	  }

	  private void updateOrClearCosts()
	  {
	    costs = new int[size];
	    costs[0] = 0;
	    for(int i =1; i<costs.length;i++)
	    {
	    	costs[i] =Integer.MAX_VALUE;
	    }
	  }
	  private void DFSTraversal(int currentNode)
	  {
	    checked[currentNode] = true;
	   print += nodes[currentNode].getValue()+" ";
	   for(int i = 0; i<10;i++)
	   {
	     if(matrix[currentNode][i]>0&&!checked[i]) 
	     {
	       checked[i] = true;
	       DFSTraversal(i);
	     }
	   }
	  }

	  public boolean isCyclic()
	  {
	    updateOrClearChecked();
	    return DFSCheck(0);
	  }

	  private boolean DFSCheck(int currentNode)
	  {
	    checked[currentNode] = true;
	    int[] toCheck = new int[10];
	   for(int i = 0; i<10;i++)
	   {
	     if(matrix[currentNode][i]>0) 
	     {
	    	 //System.out.println("The node "+ i+" "+checked[i]+" checked");
	       if(!checked[i])
	       {
	       checked[i] = true;
	       toCheck[i] = 1;
	       }
	       else
	       {
	         return true;
	       }
	     }
	   }
	   boolean c = false;
	   for(int i = 0;i<10;i++)
	   {
		   if(toCheck[i]==1)
		   {
			   c = DFSCheck(i);
			   if(c) {
				  return c;
			   }
		   }
	   }
	   return false;
	  }

	
	  public int[] findShortestPaths()
	  {
		  updateOrClearChecked();
		  updateOrClearCosts();
		  calculatePaths(0,0);
		  return costs;
	  }
	  
	  private void calculatePaths(int current, int cost)
	  {
		  checked[current] = true;
		  int[] toCheck = new int[10];
		  for(int i = 0;i<10;i++)
		  {
			  if(matrix[current][i]>0&&!checked[i])
			  {
				  toCheck[i] = 1;
				  costs[i] = cost+matrix[current][i];
			  }
		  }
		  for(int i = 0;i<10;i++)
		   {
			   if(toCheck[i]==1)
			   {
				   calculatePaths(i, matrix[current][i]);
			   }
		   }
	  }
}
