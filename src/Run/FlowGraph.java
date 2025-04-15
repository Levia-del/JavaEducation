package Run;

public class FlowGraph extends AdjacencyMatrix{

	private FlowCost[][] Fmatrix;
	private int[] paths = {0};
	public FlowGraph() {
		super();
		Fmatrix = new FlowCost[10][10];
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
	      if(matrix[curr][r1]==0)
	      {
	        matrix[r1][curr] = v;
	        Fmatrix[r1][curr] = new FlowCost(v);
	      }
	      if(matrix[r2][curr]==0)
	      {
	        matrix[curr][r2] = v;
	        Fmatrix[curr][r2] = new FlowCost(v);
	      } 
	    }
		size++;
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
		while(paths[0]!=-1)
		{
			int f = trav(); 
			System.out.println(f);
			for(int i =0;i<size;i++)
			{
				for(int j =0;j<size;j++)
				{
					if(Fmatrix[i][j]!=null)
					{
						Fmatrix[i][j].setCF(Fmatrix[i][j].cf+f);
					}
				}
			}
		  c += f;
		}
		
		return c;
	}
	
	private int trav()
	{
	 
	  int[] my = super.GetAFilledArray(size, -1);
	  int c =Fmatrix[0][1].maxFill();
	  int index = 0;
	  int lastI = 0;
	  for(int i =0;i<size;i++)
	  {
		  if(Fmatrix[index][i]!=null)
		  {
			  if(!Fmatrix[index][i].isFilled())
			  {
				  my[index] = i;
				  if(Fmatrix[index][i].maxFill()<c)
				  {
					  c =Fmatrix[index][i].maxFill();
				  }
				  lastI = i;
				  index++;
				  i =0;
			  }
		  }
		  else if(i==size-1&&index!=size-1)
		  {
			  index--;
			  if(index<0)
			  {
				  paths[0] = -1;
				  return 0;
				  
			  }
			  i =lastI+1;
		  }
		  
	  }
	  
	  paths = my;
	  return c;
	}
	
	public String toString()
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
		return re;
	}
}
