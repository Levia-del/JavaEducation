package Run;


public class AdjacencyMatrix {

	 private int[][] matrix;
	  private int size;
	  private String print;
	  private GraphNode[] nodes;
	  private boolean[] checked;
	  public int[] costs;
	  private GraphNode firstNode;
	  
	  public AdjacencyMatrix()
	  {
	    matrix = new int[10][10];
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
	      int v = (int)(Math.random()*9)+1;
	      /*if(matrix[r1][curr]==0)
	      {
	        matrix[r1][curr] = v;
	        matrix[curr][r1] = v;
	      }
	      if(matrix[curr][r2]==0)
	      {
	        matrix[curr][r2] = v;
	        matrix[r2][curr] = v;
	        
	      }*/
	    }
	    size++;
	    for(int r =0;r<size;r++)
	    {
	    	for(int c = 0;c<size;c++)
	    	{
	    		if(matrix[r][c]==0&&r!=c)
	    		{
	    			int v =(int)(Math.random()*9)+1;
	    			matrix[r][c] = v;
	    			matrix[c][r] = v;
	    			
	    		}
	    	}
	    }
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

	  private void updateOrClearCosts(int startNode)
	  {
	    costs = new int[size];
	    for(int i =0; i<costs.length;i++)
	    {
       
         costs[i] =0;
       
	    }
	  }
	  private void DFSTraversal(int currentNode)
	  {
	    checked[currentNode] = true;
	   print += nodes[currentNode].getValue()+" ";
	   for(int i = 0; i<checked.length;i++)
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

	
	  private void findShortestPathsFrom(int node)
	  {
		  updateOrClearChecked();
		  updateOrClearCosts(node);
		  calculatePaths(node);
          costs[node]=0;
          for(int i =0;i<costs.length;i++)
          {
             if(i!=node&&costs[i]==0)
             {
               costs[i]=-1;
             }
          }
	  }
	  
	  public int shortestPath(int from, int to)
	  {
		  findShortestPathsFrom(from);
		  return costs[to];
	  }
	  private void calculatePaths(int current)
	  {
		  checked[current] = true;
		  for(int i = 0;i<checked.length;i++)
		  {
			  int cost = matrix[current][i];
			  if(cost>0)
			  {
				 cost += costs[current];
				 if(cost<costs[i]||costs[i]==0)
				 {
					 costs[i] = cost;
				 }
			  }
		  }
		  
		  for(int i = 0;i<checked.length;i++)
		  {
			  if(matrix[current][i]>0&&!checked[i])
			  {
				  calculatePaths(i);
			  }
		  }
	  }
	  
	  
	  
	  public MSTNode[] FindMST()
	  {
		  MSTNode[] my = new MSTNode[size];
		  for(int i =0; i<size;i++)
		  {
			  my[i] = calcVert(i);
		  }
		  return my;
	  }
	  
	  private MSTNode calcVert(int node)
	  {
		  
		  int maxI = 0;
		  for(int i = 0;i<size;i++)
		  {
			  if(i!=node&&matrix[node][i]<matrix[node][maxI])
			  {
				  maxI = i;
			  }
		  }
		  return new MSTNode(node,maxI);
	  }
}

