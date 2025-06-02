package Run;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Algorithms {

	private static String Hcode;
	private static ArrayList<Path> paths = new ArrayList<Path>();
	private static ArrayList<KnapsackBag> bags = new ArrayList<KnapsackBag>();

	private static int uc = 0;;

	public static int gcd(int a, int b) {
		if (b > a) {
			int t = a;
			a = b;
			b = t;
		}
		int p = a / (a / b);
		int r = b;
		while (r != 0) {
			r = a % r;
			if (r == 0) {
				break;

			}
			p = a / (a / r);

			r = b % r;
			if (r == 0) {
				break;

			}
			p = b / (b / r);

		}
		return p;

	}

	public static String huffman(String s) {
		Hcode = "";
		ArrayList<HNode> my = new ArrayList<HNode>();
		for (int i = 0; i < s.length(); i++) {

			boolean a = true;
			for (int j = 0; j < my.size(); j++) {
				if (my.get(j).getLetter().equals(s.substring(i, i + 1))) {
					my.get(j).increment();

					int k = j;
					while (k > 0 && my.get(k).getCount() < my.get(k - 1).getCount()) {

						HNode temp = my.get(k);
						my.set(k, my.get(k - 1));
						my.set(k - 1, temp);
						k--;
					}
					a = false;

					break;
				}
			}
			if (a) {

				my.add(new HNode(s.substring(i, i + 1), null, null));
				for (int j = 0; j < my.size(); j++) {
					int k = j;
					while (k > 0 && my.get(k).getCount() < my.get(k - 1).getCount()) {

						HNode temp = my.get(k);
						my.set(k, my.get(k - 1));
						my.set(k - 1, temp);
						k--;
					}
				}
			}

		}

		while (my.size() > 1) {
			for (int j = 0; j < my.size(); j++) {
				int k = j;
				while (k > 0 && my.get(k).getCount() < my.get(k - 1).getCount()) {

					HNode temp = my.get(k);
					my.set(k, my.get(k - 1));
					my.set(k - 1, temp);
					k--;
				}
			}
			HNode olde = my.remove(0);
			HNode left = olde;

			olde = my.remove(0);
			HNode right = olde;
			HNode merge = new HNode("", left, right);

			my.add(merge);
		}

		String resu = "";
		for (int i = 0; i < s.length(); i++) {

			preOrderTraversal(my.get(0), "", s.substring(i, i + 1));
			resu += Hcode + " ";

		}

		return resu;
	}

	private static void preOrderTraversal(HNode node, String code, String toSearch) {

		if (node == null) {

			// System.out.print("<\n");
			return;
		}

		if (node.getLetter().equals(toSearch)) {
			Hcode = code;
			return;

		}
		// System.out.print(node + "\n");
		preOrderTraversal(node.left(), code + "0", toSearch);
		preOrderTraversal(node.right(), code + "1", toSearch);

	}

	private static boolean done(boolean[] my) {

		for (int i = 0; i < my.length; i++) {

			if (!my[i]) {

				return false;
			}
		}
		return true;
	}

	public static int[] GreedyTSP(AdjacencyMatrix my) {
		int[] paths = new int[my.size + 1];
		int curr = 0;

		paths[0] = 0;
		boolean[] checked = new boolean[my.size];

		checked[0] = true;
		int count = 1;
		while (!done(checked)) {
			int m = Integer.MAX_VALUE;
			int mI = 0;
			for (int c = 0; c < my.size; c++) {

				if (c != curr && !checked[c] && my.matrix[curr][c] < m) {
					mI = c;
					m = my.matrix[curr][c];
				}
			}
			paths[count] = mI;

			curr = mI;

			checked[curr] = true;
			if (count == my.size - 1) {

				checked[my.size - 1] = true;
			}
			count++;
			/*
			 * Sorts.getAnyArray(paths); System.out.println("count = "+count);
			 * System.out.println("curr = "+curr); System.out.println(done(checked));
			 */
		}
		paths[my.size] = 0;
		return paths;
	}

	public static Path BruteTSP(AdjacencyMatrix my) {
		for (int i = 1; i < my.size; i++) {

			DFSTraversal(my, new boolean[my.size], new ArrayList<MSTNode>(), i);
		}

		/*
		 * for (int i = 0; i < paths.size(); i++) {
		 * System.out.println(paths.get(i)+" with length = "+calculatePathSumsTSP(my,
		 * paths.get(i))); }
		 */

		int maxix = Integer.MAX_VALUE;
		int k = 0;
		for (int i = 0; i < paths.size(); i++) {
			int sumss = calculatePathSumsTSP(my, paths.get(i));
			if (sumss < maxix) {
				maxix = sumss;
				k = i;
			}
		}

		System.out.println("Distance = " + maxix);
		return paths.get(k);

	}

	private static int calculatePathSumsTSP(AdjacencyMatrix my, Path mi) {
		int sumss = 0;
		for (MSTNode i : mi.getList()) {

			sumss += my.matrix[i.node][i.link];
		}
		return sumss;
	}

	private static void DFSTraversal(AdjacencyMatrix my, boolean[] checked, ArrayList<MSTNode> path, int curr) {

		if (path.size() == 0) {

			path.add(new MSTNode(0, curr));

			checked[0] = true;
			checked[curr] = true;
		} else {

			path.add(new MSTNode(path.get(path.size() - 1).link, curr));
			checked[curr] = true;
		}

		/*
		 * System.out.println(); System.out.print("checked =");
		 * 
		 * 
		 * 
		 * Sorts.getAnyArray(checked);
		 * 
		 * System.out.println("path = "+path);
		 * 
		 * System.out.println("curr = "+curr);
		 * 
		 * System.out.println("Is gonna finish = "+done(checked));
		 */
		if (done(checked)) {

			path.add(new MSTNode(curr, 0));
			paths.add(new Path(path));
			return;
		}

		for (int i = 0; i < my.size; i++) {

			if (i != curr && !checked[i]) {
				boolean[] nChecked = new boolean[my.size];
				for (int j = 0; j < my.size; j++) {

					nChecked[j] = checked[j];
				}

				ArrayList<MSTNode> mi = new ArrayList<MSTNode>(path);

				DFSTraversal(my, nChecked, mi, i);

				// System.out.println("i = "+i);
			}
		}
		return;

	}

	public static Path TravelingSalesman(AdjacencyMatrix my) {
		MSTNode[] shortest = new MSTNode[my.size];
		boolean[] checked = new boolean[my.size];
		for (int i = 0; i < my.size; i++) {
			shortest[i] = new MSTNode(0, 1);
			MSTNode m = shortest[i];
			for (int r = 0; r < my.size; r++) {

				for (int c = 0; c < my.size; c++) {

					if (r != c && my.matrix[r][c] < my.matrix[m.node][m.link]) {
						m.node = r;
						m.link = c;
					}
				}
			}

			my.matrix[m.node][m.link] = Integer.MAX_VALUE;
			my.matrix[m.link][m.node] = Integer.MAX_VALUE;
		}

		AdjacencyMatrix mi = new AdjacencyMatrix();
		for (int i = 1; i <= my.size; i++) {
			mi.add(0);
		}
		mi.matrix = new int[my.size][my.size];
		for (MSTNode i : shortest) {
			mi.matrix[i.node][i.link] = my.matrix[i.node][i.link];
			mi.matrix[i.link][i.node] = my.matrix[i.link][i.node];

		}

		MSTNode temp;

		for (int j = 0; j < shortest.length; j++) {
			int min = j;
			for (int k = j + 1; k < shortest.length; k++) {
				if (shortest[k].node < shortest[min].node) {
					min = k;
				}
			}
			if (min != j) {
				temp = shortest[min];
				shortest[min] = shortest[j];
				shortest[j] = temp;
			}
		}

		int[] defects3 = getDefects3(mi);
		int[] defects1 = getDefects1(mi);

		System.out.println("----Three Connections----");
		for (int i = 0; i < defects3.length; i++) {

			System.out.println(defects3[i]);
		}

		System.out.println();

		System.out.println();

		System.out.println();
		System.out.println();
		System.out.println("----One Connection----");
		for (int i = 0; i < defects1.length; i++) {

			System.out.println(defects1[i]);
		}

		Path m = new Path();
		System.out.println("before");
		for (int i = 0; i < shortest.length; i++) {

			m.add(shortest[i]);
			System.out.println(shortest[i]);
		}
		System.out.println();
		refractorDefect3(my, m, defects3[0]);
		System.out.println("after");
		for (int i = 0; i < shortest.length; i++) {

			m.add(shortest[i]);
			System.out.println(shortest[i]);
		}
		System.out.println();
		return m;
	}

	private static int[] getDefects3(AdjacencyMatrix my) {

		ArrayList<Integer> mi = new ArrayList<Integer>();

		for (int c = 0; c < my.size; c++) {
			int count = 0;
			for (int r = 0; r < my.size; r++) {
				if (my.matrix[r][c] > 0) {

					count++;
				}
			}
			if (count > 2) {

				mi.add(c);
			}

		}

		int[] mo = new int[mi.size()];

		for (int i = 0; i < mi.size(); i++) {

			mo[i] = mi.get(i);
		}

		return mo;
	}

	private static int[] getDefects1(AdjacencyMatrix my) {

		ArrayList<Integer> mi = new ArrayList<Integer>();

		for (int c = 0; c < my.size; c++) {
			int count = 0;
			for (int r = 0; r < my.size; r++) {
				if (my.matrix[r][c] > 0) {

					count++;
				}
			}
			if (count < 2) {

				mi.add(c);
			}

		}

		int[] mo = new int[mi.size()];

		for (int i = 0; i < mi.size(); i++) {

			mo[i] = mi.get(i);
		}

		return mo;
	}

	private static void refractorDefect3(AdjacencyMatrix my, Path mi, int d) {
		ArrayList<MSTNode> connections = findAllConnectionsTo(mi, d);

		int maxL = 0;
		int maxI = 0;
		MSTNode maxM = null;
		for (int i = 0; i < connections.size(); i++) {
			for (int r = 0; r < my.size; r++) {
				for (int c = 0; c < my.size; c++) {

					int indexInPath = mi.indexOf(new MSTNode(r, c));
					if (my.matrix[r][c] > 0 && indexInPath < 0) {
						Path copy = new Path(mi);
						copy.set(i, new MSTNode(r, c));
						int le = longestContinualPath(my.size, copy);
						if (le > maxL) {
							maxL = le;
							maxI = i;
							maxM = new MSTNode(r, c);
						}
					}
				}
			}
		}
		System.out.println("Node " + mi.get(maxI) + " changed to ");
		mi.set(maxI, maxM);
		System.out.println("Node " + mi.get(maxI));
	}

	private static int longestContinualPath(int size, Path path) {
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		for (MSTNode i : path.getList()) {
			if (i.node == 0) {
				lengths.add(longestContinualPathLocal(size, path, i.link));
			} else if (i.link == 0) {
				lengths.add(longestContinualPathLocal(size, path, i.node));
			}
		}
		Collections.sort(lengths);
		return lengths.getLast();
	}

	private static int longestContinualPathLocal(int size, Path path, int start) {

		path = new Path(path);
		int mC = 0;
		int c = 1;

		int lastLink = start;
		int lastIndex = 0;
		while (path.size() > mC) {
			boolean[] checkedCon = new boolean[path.size()];
			// System.out.println(start);
			checkedCon[path.indexOf(new MSTNode(0, start))] = true;
			boolean[] checkedNode = new boolean[size];
			checkedNode[0] = true;
			while (true) {
				boolean found = false;
				for (int i = 0; i < path.size(); i++) {
					if (!checkedCon[i]) {
						if (path.get(i).node == lastLink && !checkedNode[path.get(i).link]) {
							// System.out.println("From " + lastLink + " to " + path.get(i).link);
							checkedNode[lastLink] = true;
							lastLink = path.get(i).link;
							lastIndex = i;

							checkedCon[i] = true;
							found = true;
							c++;
						} else if (path.get(i).link == lastLink && !checkedNode[path.get(i).node]) {
							// System.out.println("From " + lastLink + " to " + path.get(i).node);
							lastLink = path.get(i).node;
							lastIndex = i;
							checkedCon[i] = true;
							found = true;
							c++;
						}
					}
				}
				if (!found) {
					break;
				}
			}
			if (c > mC) {
				mC = c;
			}
			c = 1;

			///System.out.println();
			// System.out.println();

			// System.out.println(lastIndex + " removed");
			if (path.get(lastIndex).equals(new MSTNode(0, start))) {
				lastIndex++;
			}
			path.remove(lastIndex);
			// System.out.println();
			// System.out.println();
			lastIndex = 0;
			lastLink = start;
		}

		return mC;
	}

	private static ArrayList<MSTNode> findAllConnectionsTo(Path path, int target) {
		ArrayList<MSTNode> result = new ArrayList<MSTNode>();
		for (MSTNode i : path.getList()) {
			if (i.link == target || i.node == target) {
				result.add(i);
			}
		}
		return result;
	}

	public static KnapsackBag knapsack(ArrayList<KnapsackItem> items, KnapsackBag k) {

		knapsackR(new ArrayList<KnapsackItem>(items), new KnapsackBag(k));

		int m = 0;
		int index =0;
		for(int i = 0;bags)
		{
			if(i.getTotalValue()>m)
			{
				m = i.getTotalValue()
			}
		}
		
		return null;
	}

	private static void knapsackR(ArrayList<KnapsackItem> items, KnapsackBag k)
	{
		boolean found = false;
		for(int i = 0;i< items.size();i++)
		{
		   if(k.getWeightLeft()+items.get(i).getWeight()>=0)
		   {
			   k.add(items.remove(i));
			   knapsackR(new ArrayList<KnapsackItem>(items), new KnapsackBag(k));
			   found = true;
		   }
		   
		}
		if(!found)
		{
			bags.add(k);
			return;
		}
	}
}
