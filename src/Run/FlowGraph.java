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
	      if(matrix[r1][curr]==0)
	      {
	        matrix[r1][curr] = v;
	        Fmatrix[r1][curr] = new FlowCost(v);
	      }
	      if(matrix[curr][r2]==0)
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
	    	  Fmatrix[r][c].setCF(0);
	      }
	    }
	}
	
	public int maximumFlow()
	{
		clearFlow();
		int c = 0;
		int[] my = trav(0,size-1);
		while(my!=null)
		{
			
		}
		return c;
	}
	
	private int[] trav(int from, int to)
	{
		return null;
	}
}
