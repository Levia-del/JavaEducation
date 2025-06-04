package Run;

import java.util.ArrayList;

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
		
		
	/*(AdjacencyMatrix my = new AdjacencyMatrix();
	for(int i =1;i<=10;i++)
    {
      my.add(0);
    }
	
	System.out.println(my);
	 
	
	Path mi = Algorithms.BruteTSP(my);
	
	
	 Path m = Algorithms.TravelingSalesman(my);
	 for (int i = 0; i < mi.size(); i++) {

			
			System.out.println(mi.get(i));
	}
	 //System.out.println(mi);
	 //System.out.println(m);
	 
	 System.out.println(m.compareTo(mi));*/
    
	/*ArrayList<KnapsackItem> my = new ArrayList<KnapsackItem>();
	my.add(new KnapsackItem("LOL", 4, 401));
	my.add(new KnapsackItem("Cup", 5, 400));
	my.add(new KnapsackItem("Crown", 3, 500));
	
	my.add(new KnapsackItem("Globe", 1, 200));
	my.add(new KnapsackItem("Microscope",2, 300));
	
	KnapsackBag k = new KnapsackBag(8);
	KnapsackBag sol = Algorithms.knapsack(my, k);
	 System.out.println(sol);
	 System.out.println("Value: "+sol.getTotalValue());*/
		
		
		 System.out.println(Algorithms.fibonacciTabulation(99));
	}
}
