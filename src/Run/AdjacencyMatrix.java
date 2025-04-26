package Run;


public class AdjacencyMatrix {

	public int[][] matrix;
	 public int size;
	  public String print;
	  public GraphNode[] nodes;
	  public boolean[] checked;
	  public Path[] paths;
	  public GraphNode firstNode;
	  //
	  
	  public AdjacencyMatrix()
	  {
	    matrix = new int[10][10];
	   nodes = new GraphNode[10];
	    size = 0;
	    checked = new boolean[10];
	    firstNode = null;
	    print = "";
	    //
	  }

	  
	  public void printGraph(MSTNode[] my)
	  {
		  for(MSTNode i : my)
		  {
			  System.out.println(i);
		  }
		  System.out.println();
	  }
	  
	  public void printGraph(int[] my)
	  {
		  for(int i : my)
		  {
			  System.out.println(i);
		  }
		  System.out.println();
	  }

    public void printGraph(boolean[] my)
	  {
		  for(boolean i : my)
		  {
			  System.out.println(i);
		  }
		  System.out.println();
	  }


    public void printGraph(double[] my)
	  {
		  for(double i : my)
		  {
			  System.out.println(i);
		  }
		  System.out.println();
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
	    			//matrix[c][r] = v;
	    			
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

	  public void updateOrClearChecked()
	  {
	    checked = new boolean[size];
	  }

	  
	  
	  public int[] GetAFilledArray(int size, int numb)
	  {
		  int[] my = new int[size];
		  for(int i = 0; i<size;i++)
		  {
			  my[i] = numb;
		  }
		  return my;
	  }
	  
	  public MSTNode[] GetAFilledArray(int size, int node, int link)
	  {
		  MSTNode[] my = new MSTNode[size];
		  for(int i = 0; i<size;i++)
		  {
			  my[i] = new MSTNode(node, link);
		  }
		  return my;
	  }
	  
	  public void updateOrClearPaths()
	  {
	    paths = new Path[size];
	    for(int i =0; i<paths.length;i++)
	    {
       
         paths[i] = new Path();
       
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
		  updateOrClearPaths();
		  calculatePaths(node);
          paths[node]=null;
	  }
	  
	  public int shortestPath(int from, int to)
	  {
		  findShortestPathsFrom(from);
		  return calculateCost(to);
	  }
	  
	  public void printShortestPath(int from, int to)
	  {
		  int c = shortestPath(from, to);
		  System.out.println(paths[to]);
		  System.out.println("The cost of the shortest path is "+c);
	  }
	  private void calculatePaths(int current)
	  {
		  checked[current] = true;
		  for(int i = 0;i<checked.length;i++)
		  {
			  int cost = matrix[current][i];
			  if(cost>0)
			  {
				 cost += calculateCost(current);
				 if(cost<calculateCost(i)||calculateCost(i)==0)
				 {
					 paths[i] = copyList(paths[current]);
					 paths[i].add(new MSTNode(current, i));
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


    private Path copyList(Path ol)
    {
     Path my = new Path();
      for(MSTNode i : ol.getList())
      {
        my.add(i);
          
      }
      return my;
    }
  
   private int calculateCost(int index)
   {
    Path my = paths[index];
     int c = 0;
     for(MSTNode i : my.getList())
     {
       c += matrix[i.node][i.link];
      
     }
     return c;
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
				  maxI = i;//no
			  }
		  }
		  return new MSTNode(node,maxI);
	  }
}