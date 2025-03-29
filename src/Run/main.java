package Run;

public class main {

	public static void main(String[] args) {
		
	AdjacencyMatrix my = new AdjacencyMatrix();
    for(int i =0;i<5;i++)
    {
      my.add(i);
    }
    
    System.out.println(my);
    System.out.println(my.isCyclic());
  }
}
