package Run;

public class FlowGraph extends AdjacencyMatrix{

	private FlowCost[][] Fmatrix;
	private MSTNode[] paths = {new MSTNode(0,1)};
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
		int f = 0; 
		while(paths[0].link!=-1)
		{
		 super.printGraph(paths);
		 for(MSTNode i : paths)
		 {
			 if(i!=null)
			 {
				 Fmatrix[i.node][i.link].setCF(Fmatrix[i.node][i.link].cf+f);
			 }
		 }
		   c += f;
		   ToString();
		   f =trav();
		   //System.out.println(paths[0]);
		}
		//thidfndsf
		return c;
	}
	
	private int trav()
	{
	 
	  paths = super.GetAFilledArray(size, -1, 0);
	  int c =Fmatrix[0][1].maxFill();
	  int index = 0;
	  int lastI = 0;
	  
	  for(int i =0;i<size;i++)
	  {
		  
		  if(Fmatrix[lastI][i]!=null)
		  {
			  
			  if(!Fmatrix[lastI][i].isFilled())
			  {
				  //System.out.println(i);
				  paths[index] = new MSTNode(lastI,i);
				  if(Fmatrix[lastI][i].maxFill()<c)
				  {
					  c =Fmatrix[lastI][i].maxFill();
				  }
				  lastI = i;
				  index++;
				  i =0;
			  }
		  }
		  if(i==size-1&&index!=size-1)
		  {
			  paths[index] = new MSTNode(-1, -1);
			  index--;
			  if(index<0)
			  {
				  paths[0].link = -1;
				  return 0;
				  
			  }
			  i =lastI+1;
			  lastI --;
		  }
		 
	  }
	  for(int i =0;i<size;i++)
	  {
		if(paths[i].node==-1)
		{
			paths[i] = null;
		}
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
