package Run;

public class KnapsackItem {
   private int weight;
   private int value;
   private String name;
   
   public KnapsackItem(String n, int w, int v)
   {
	   name = n;
	   weight = w;
	   value = v;
   }
   
   public KnapsackItem(KnapsackItem k)
   {
	   name = k.getName();
	   weight = k.getWeight();
	   value = k.getValue();
   }
   
   
   public int getWeight()
   {
	   return weight;
   }
   
   protected String getName()
   {
	   return name;
   }
   
   public int getValue()
   {
	   return value;
   }
   
   public String toString()
   {
	   return name + " with weight: "+weight+" kg and value of: "+ value+"$";
   }
	
}
