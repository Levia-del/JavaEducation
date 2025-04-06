package Run;

public class main {

	public static void main(String[] args) {
		
	FlowGraph my = new FlowGraph();
    for(int i =0;i<=4;i++)
    {
      my.add(i);
    }
    
    System.out.println(my);
  }
}
