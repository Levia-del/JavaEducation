package Run;

public class HNode {
	private String l;
	private int count;
	
	private HNode left;
	private HNode right;
	public HNode(String l,HNode left, HNode right)
	{
		this.l = l;
		this.left = left;
		this.right = right;
		if(l.length()>0)
		{
			
			count = 1;
		}
		else {
			
			count = left.getCount()+right.getCount();
		}
		
	}
	
	public void increment()
	{
		count++;
		
	}
	
	public String getLetter()
	{
		
		return l;
	}
	
	public int getCount()
	{
		
		return count;
	}

	
	
	public HNode left()
	{
		
		return left;
	}
	
	
	public HNode right()
	{
		
		return right;
	}
	public String toString()
	{
		
		return "Letter: "+l+" with count: "+count;
	}
}
