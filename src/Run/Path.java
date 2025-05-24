package Run;

import java.util.ArrayList;
import java.util.LinkedList;

public class Path {
	private LinkedList<MSTNode> my;

	public Path() {
		my = new LinkedList<MSTNode>();
	}

	public Path(ArrayList<MSTNode> toAdd) {
		my = new LinkedList<MSTNode>(toAdd);
	}

	public void add(MSTNode value) {
		my.add(value);

	}

	public MSTNode remove(int index) {
		return my.remove(index);
	}

	public LinkedList<MSTNode> getList() {
		return my;
	}

	public void clear() {
		my = new LinkedList<MSTNode>();

	}

	public int size() {
		return my.size();

	}

	public MSTNode get(int i) {
		return my.get(i);

	}

	public String toString() {
		String re = "";
		re += my.get(0).node + " -> " + my.get(0).link;
		if(my.size()>2) {
		for (int i = 1; i < my.size() - 1; i++) {
			
			re += " -> " + my.get(i).link;

		}
		}
		if(my.size()>1)
		{
			
			re += " -> "+my.get(my.size() - 1).link;
			
			
		}
		

		return re;
	}
}
