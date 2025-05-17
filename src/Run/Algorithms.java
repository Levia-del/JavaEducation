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
			resu+=Hcode+" ";
			
		}

		return resu;
	}

	public static void preOrderTraversal(HNode node, String code, String toSearch) {

		if (node==null) {
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int TravelingSalesman(AdjacencyMatrix my)
	{
		MSTNode[] shortest = new MSTNode[my.size];
		for(int i = 0; i<my.size;i++)
		{
			shortest[i] = new MSTNode(0,1);
			MSTNode m = shortest[i];
			for(int r=0;r<my.size;r++)
			{
				
				for(int c = 0;c<my.size;c++)
				{
					
					if(r!=c&&my.matrix[r][c]<my.matrix[m.node][m.link])
					{
						m.node = r;
						m.link = c;
					}
				}
			}
			
			my.matrix[m.node][m.link] =Integer.MAX_VALUE;
			my.matrix[m.link][m.node] =Integer.MAX_VALUE;
		}
		for(int i = 0; i<my.size;i++)
		{
		
			System.out.println(shortest[i]);
		}
		
		
		return 0;
	}
	
}
