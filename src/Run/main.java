package Run;

public class main {

	public static void main(String[] args) {
		
	AdjacencyMatrix my = new AdjacencyMatrix();
    for(int i =0;i<=4;i++)
    {
      my.add(i);
    }
    
    System.out.println(my);
    MSTNode[] m = my.FindMST();
    for(MSTNode i : m)
    {
    	System.out.println(i);
    }
    
  }
}
