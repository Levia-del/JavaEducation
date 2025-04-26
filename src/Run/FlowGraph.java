package Run;
public class FlowGraph extends AdjacencyMatrix{

	private FlowCost[][] Fmatrix;
	public FlowGraph() {
		super();
		Fmatrix = new FlowCost[10][10];
	}

	public void add(int value)
	{

		if(firstNode == null)
		{
			firstNode = new GraphNode(value);
			size++;
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
			// int r1 = (int)(Math.random()*curr);
			// int r2 = (int)(Math.random()*curr);
			nodes[curr] = new GraphNode(value);
			int v = (int)(Math.random()*9)+1;
			/* if(matrix[curr][r1]==0)
	      {
	        matrix[r1][curr] = v;
	        Fmatrix[r1][curr] = new FlowCost(v);
	      }
	      if(matrix[r2][curr]==0)
	      {
	        matrix[curr][r2] = v;
	        Fmatrix[curr][r2] = new FlowCost(v);
	      } */
			size++;
			for(int i = 0;i<size-1;i++)
			{
				for(int j = i+1;j<size;j++)
				{
					matrix[i][j] = v;
					Fmatrix[i][j] = new FlowCost(v);
					v = (int)(Math.random()*9)+1;

				}

			}

		}

	}


	private void clearFlow()
	{
		for(int r =0;r<Fmatrix.length;r++)
		{
			for(int c = 0; c<Fmatrix[0].length;c++)
			{
				if(Fmatrix[r][c]!=null)
				{
					Fmatrix[r][c].setCF(0);
				}
			}
		}
	}

	public int maximumFlow()
	{
		clearFlow();
		int c = 0;
		int f = Integer.MAX_VALUE; 
		findShortestPathsFrom(0);
		while(paths[size-1].getList().size()>0)
		{
			 
			 
			Path aPath = paths[size-1];
			
			for(MSTNode i : aPath.getList())
			{
				if(i!=null)
				{
					
					if(Fmatrix[i.node][i.link].maxFill()<f)
					{
					 f = Fmatrix[i.node][i.link].maxFill();
					}
					
					
				}
			}
			
			for(MSTNode i : aPath.getList())
			{
				if(i!=null)
				{
					Fmatrix[i.node][i.link].setCF(Fmatrix[i.node][i.link].cf+f);
				}
			}
			c += f;
			System.out.println("f = "+f);
			f = Integer.MAX_VALUE; 
			printShortestPath(0,size-1);
			System.out.println();
			
			
		}

		return c;
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
		  if(paths[to].getList().size()>0)
		  {
			  System.out.println(paths[to]);
			  System.out.println("The cost of the shortest path is "+c); 
		  }
		  
	  }
	  private void calculatePaths(int current)
	  {
		  checked[current] = true;
		  for(int i = 0;i<checked.length;i++)
		  {
			  System.out.println("Checked from: "+current+" to "+ i);
			  int cost = matrix[current][i];
			  if(cost>0&&!Fmatrix[current][i].isFilled())
			  {
				 cost += calculateCost(current);
				 if(cost<calculateCost(i)||calculateCost(i)==0)
				 {
					 paths[i] = copyList(paths[current]);
					 paths[i].add(new MSTNode(current, i));
					 if(paths[size-1].getList().size()>0) {
					 System.out.println();
				     for(int m = 0; m<5;m++)
				     {
				    	 System.out.println("To: "+m);
				    	 for(MSTNode k : paths[m].getList())
						 {
					    	 System.out.println(k);
					    	 
						 }
				    	 
				     }
				     
					 System.out.println();
					 }
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

	


	public void ToString()
	{
		String re = "";
		for(int i =0;i<size;i++)
		{
			for(int j =0;j<size;j++)
			{
				FlowCost l = Fmatrix[i][j];
				if(l!=null) {
					re += "From "+i+" to "+j+" with "+l+"\n";

				}
			}
		}
		System.out.println(re);;
	}
}
