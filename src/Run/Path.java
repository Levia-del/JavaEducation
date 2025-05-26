package Run;

import java.util.ArrayList;
import java.util.LinkedList;

public class Path {
	private LinkedList<MSTNode> my;
	private LinkedList<MSTNode> wrongNodes;
	private int[] defects3;

	public Path() {
		my = new LinkedList<MSTNode>();
		wrongNodes = new LinkedList<MSTNode>();
		defects3 = new int[1];
	}

	public Path(int[] d) {
		my = new LinkedList<MSTNode>();
		wrongNodes = new LinkedList<MSTNode>();
		defects3 = d;
	}

	public Path(ArrayList<MSTNode> toAdd) {
		my = new LinkedList<MSTNode>(toAdd);
		wrongNodes = new LinkedList<MSTNode>();
		defects3 = new int[1];
	}

	public Path(LinkedList<MSTNode> toAdd) {
		my = new LinkedList<MSTNode>(toAdd);
		wrongNodes = new LinkedList<MSTNode>();
		defects3 = new int[1];
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
				wrongNodes.add(my1);
				System.out.println("A wrong node: " + my1);
				c++;
			}
		}

		return c;
	}

	public boolean hypo1(AdjacencyMatrix my) {
		for (int k : defects3) {
			for (int m = 0; m < my.size; m++) {
				if (my.matrix[m][k] > 0) {
					MSTNode i = new MSTNode(m, k);

					for (MSTNode j : wrongNodes) {
						if (i.equals(j)) {
							MSTNode max = i;
							for (int r = 0; r < defects3.length; r++) {
								for (int p = 0; p < my.size; p++) {
									if (my.matrix[p][k] > 0) {
										MSTNode cur = new MSTNode(m, k);
										if (my.matrix[cur.node][cur.link] > my.matrix[max.node][max.link]) {
											max = cur;
										}
									}
								}
							}
							if (max.equals(i)) {
								return true;
							}

						}
					}
				}
			}
		}
		return false;
	}

}
