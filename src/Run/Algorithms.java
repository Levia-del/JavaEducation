package Run;

import java.util.ArrayList;

public class Algorithms {

	private static String Hcode;

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

	public static void preOrderTraversal(HNode node, String code, String toSearch) {

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

	
	
	
	
	
	
	
	
	private static boolean done(boolean[] my) 
	{
		
		for(int i=0;i<my.length;i++)
		{
			
			if(my[i])
			{
				
				return false;
			}
		}
		return true;
	}
	
	public static int[] GreedyTSP(AdjacencyMatrix my) {
		int[] paths = new int[my.size+1];
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
			count++;
			curr = mI;

			checked[curr] = true;
			if(count == my.size-1)
			{
				
				checked[my.size-1] = true;
			}
			Sorts.getAnyArray(paths);
		}
		paths[my.size] = 0;
		return paths;
	}

	public static int[] TravelingSalesman(AdjacencyMatrix my) {
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

		for (int i = 0; i < shortest.length; i++) {

			System.out.println(shortest[i]);
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

		return null;
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
}
