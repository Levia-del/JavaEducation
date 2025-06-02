package Run;

import java.util.ArrayList;

import java.util.LinkedList;

public class Path {
	private LinkedList<MSTNode> my;

	public Path() {
		my = new LinkedList<MSTNode>();

	}

	public Path(Path path) {
		my = new LinkedList<MSTNode>(path.my);

	}

	public Path(ArrayList<MSTNode> toAdd) {
		my = new LinkedList<MSTNode>(toAdd);

	}

	public Path(LinkedList<MSTNode> toAdd) {
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
		if (my.size() > 2) {
			for (int i = 1; i < my.size() - 1; i++) {

				re += " -> " + my.get(i).link;

			}
		}
		if (my.size() > 1) {

			re += " -> " + my.get(my.size() - 1).link;

		}

		return re;
	}

	public int compareTo(Path mi) {
		int c = 0;
		for (int i = 0; i < my.size(); i++) {
			if (i >= mi.size()) {
				break;
			}
			MSTNode my1 = my.get(i);

			boolean hasEqual = false;
			for (int j = 0; j < mi.size(); j++) {
				MSTNode my2 = mi.get(j);

				if (my1.equals(my2)) {
					hasEqual = true;
					break;
				}
			}
			if (!hasEqual) {
				System.out.println();
				System.out.println("A wrong node: " + my1);
				c++;
			}
		}

		return c;
	}

	public int indexOf(MSTNode other) {

		for (int i = 0; i<my.size(); i++) {
			if (my.get(i).equals(other))
				return i;
		}
		return -1;
		
	}
	
	
	public MSTNode set(int i, MSTNode other)
	{
		return my.set(i, other);
	}

}
