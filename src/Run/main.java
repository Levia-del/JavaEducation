package Run;

public class main {

	public static void main(String[] args) {
		
	/*FlowGraph my = new FlowGraph();
    
    for(int i =0;i<=9;i++)
    {
      my.add(i);
    }
	
    System.out.println(my);
    System.out.println(my.maximumFlow());*/
		
	
	//System.out.println(Algorithms.huffman("pneumonoultram"));
		
		
	AdjacencyMatrix my = new AdjacencyMatrix();
	for(int i =1;i<=5;i++)
    {
      my.add(0);
    }
	 System.out.println(my);
    int [] mi = Algorithms.GreedyTSP(my);
    
    
    
    for(int i = 0;i<mi.length;i++)
    {
    	
    	System.out.println(mi[i]);
    }
	}
}
