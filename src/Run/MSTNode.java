package Run;

public class MSTNode {

	int node;
	int link;
	
	public MSTNode(int node, int link)
	{
		this.node = node;
		this.link = link;
	}
	
	public String toString()
	{
		return "The node: "+ node+" with the link to "+link;
	}
}
