package Run;
import java.util.ArrayList;
public class KnapsackBag {
    private int maxWeight;
    protected ArrayList<KnapsackItem> items;
    
    public KnapsackBag(int m)
    {
    	maxWeight = m;
    	items = new ArrayList<KnapsackItem>();
    }
    
    public KnapsackBag(KnapsackBag k)
    {
    	maxWeight = k.getMaxWeight();
    	items = new ArrayList<KnapsackItem>(k.getItems());
    }
    
    protected ArrayList<KnapsackItem> getItems()
    {
    	return items;
    }
    
    public int getMaxWeight()
    {
    	return maxWeight;
    }
    
    
    public String toString()
    {
    	return items.toString();
    }
    
    public int getTotalValue()
    {
    	int s =0;
    	for(KnapsackItem i : items)
    	{
    		s+=i.getValue();
    	}
    	return s;
    }
    
    public int getWeightLeft()
    {
    	int s =maxWeight;
    	for(KnapsackItem i : items)
    	{
    		s-=i.getWeight();
    	}
    	return s;
    }
    
    public void add(KnapsackItem k)
    {
    	items.add(k);
    }
}
