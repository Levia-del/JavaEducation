package Run;
public class FlowGraph extends AdjacencyMatrix{

	private FlowCost[][] Fmatrix;
	private Path aPath;
	public FlowGraph() {
		super();
		Fmatrix = new FlowCost[10][10];
		
		aPath = new Path();
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
		updateOrClearChecked();
		int c = 0;
		int f = Integer.MAX_VALUE; 
		aPath.clear();
		DFSTraversal(0);
		while(aPath.size()>0)
		{
			
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
			//System.out.println("f = "+f);
			System.out.println(aPath);
			//System.out.println();
		    /*System.out.println();*/
			f = Integer.MAX_VALUE; 
			
			
			aPath.clear();
			updateOrClearChecked();
			
			DFSTraversal(0);
			if(aPath.size()>0)
			{
		    MSTNode first = aPath.get(0);
			MSTNode last = aPath.get(aPath.size()-1);
			while(last.link!=size-1)
			{
				Fmatrix[first.node][first.link].fill();
				aPath.clear();
				updateOrClearChecked();
				
				DFSTraversal(0);
				if(aPath.size()>0)
				{
				first = aPath.get(0);
				last = aPath.get(aPath.size()-1);
				}
				else
				{
					break;
				}
				
				
			}
			
			}
			
			
		}

		return c;
	}
	  
	 
	private void DFSTraversal(int currentNode) {
		checked[currentNode] = true;
		//System.out.println(currentNode);
		
		if(currentNode == size-1)
		{
			checkEverything();
			return;
		}
		for (int i = 0; i < checked.length; i++) {
			if (matrix[currentNode][i] > 0 && !checked[i]&&!Fmatrix[currentNode][i].isFilled()) {
				
				checked[i] = true;
				
				aPath.add(new MSTNode(currentNode,i));
				DFSTraversal(i);
			}
		}
	}


	
	
	
	private void checkEverything()
	{
		for(int i = 0;i<checked.length;i++)
		{
			
			checked[i] = true;
		}
		
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
