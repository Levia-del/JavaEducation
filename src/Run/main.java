package Run;

public class main {

	public static void main(String[] args) {
		AVLTree my = new AVLTree();
		   /*for(int i = 0;i<=10;i++)
		   {
		      my.add((int)((Math.random()*10)+1));
		    }
		    */
		    my.add(10);
		    my.add(11);
		    my.add(5);
		    my.add(4);
		    my.add(6);
		    my.add(8);
		    System.out.println(my);
		    //my.search((int)((Math.random()*10)+1));
	}

}
