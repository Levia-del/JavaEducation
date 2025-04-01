package Run;

public class main {

	public static void main(String[] args) {
		
	AdjacencyMatrix my = new AdjacencyMatrix();
    for(int i =0;i<=9;i++)
    {
      my.add(i);
    }
    
    System.out.println(my);
    int[] ow = my.findShortestPaths();
    for(int i : ow)
    {
    	System.out.println(i+" ");
    }
  }
}
