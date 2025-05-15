package Run;
import java.util.ArrayList;


public class Algorithms {

	
	public static int gcd(int a, int b)
	{
		if(b>a)
		{
			int t = a;
			a = b;
			b = t;
		}
		int p =a/(a/b);
		int r = b;
		while(r!=0)
		{ 
			r = a%r;
			if(r==0)
			{
				break;
				
			}
			p = a/(a/r);
			
			
			
			r = b%r;
			if(r==0)
			{
				break;
				
			}
			p = b/(b/r);
			
		}
		return p;
		
	}
	
	public static String huffman(String s)
	{
		final class HNode{
			private String l;
			private int count;
			
			public HNode(String l)
			{
				this.l = l;
				count = 1;
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
		
			public String toString()
			{
				
				return "Letter: "+l+" with count: "+count;
			}
		}
		
		
		
	  ArrayList<HNode> my = new ArrayList<HNode>();
	  for(int i  = 0; i<s.length();i++)
	  {
		  boolean a = true;
		  for(int j = 0; j<my.size();j++)
		  {
			  
			  if(my.get(j).getLetter().equals(s.substring(i,i+1)))
			  {
				  
				  my.get(j).increment();
				  int k = j;
				  while(k>0&&my.get(k).getCount()>my.get(k-1).getCount())
				  {
					  
					  HNode temp = my.get(k);
					  my.set(k, my.get(k-1));
					  my.set(k-1, temp);
					  k--;
				  }
				  a = false;
				  
				  break;
			  }
		  }
		  if(a)
		  {
			  
			  my.add(new HNode(s.substring(i,i+1)));
		  }
		  
	  }
	  
	  
	  String resu = "";
	  for(int i = 0; i<s.length();i++)
	  {
		  
		  String t ="";
		  for(HNode j : my)
		  {
			  if(j.getLetter().equals(s.substring(i,i+1))&&j!=my.get(my.size()-1))
			  {
				  t+="0";
				  break;
			  }
			  else
			  {
				  t+="1";
			  }
		  }
		  resu += t+" ";
	  }
	  
	  
	return resu;
	}
	
	
}
