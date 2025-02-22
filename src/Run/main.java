package Run;

public class main {

	public static void main(String[] args) {
		String print = "";
		AVLTree my = new AVLTree();
		for(int i = 0;i<10;i++)
		{
			int add = (int)((Math.random()*8)+1);
		    my.add(add);
		    print += add;
		    
		    //System.out.println(my);
		    //System.out.println("Next Step");
		}
		System.out.println(print);
		System.out.println(my);
		//my.search((int)((Math.random()*10)+1));
	}

}
