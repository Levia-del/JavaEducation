package Run;

public class main {

	public static void main(String[] args) {
		AVLTree my = new AVLTree();
		   /*for(int i = 0;i<=10;i++)
		   {
		      my.add((int)((Math.random()*10)+1));
		    }
		    */
		    my.add(5);
		    my.add(4);
		    my.add(2);
		    my.add(1);
		    my.RotateRight(my.root);
		    //my.RotateRight(my.root);
		    System.out.println(my);
		    //my.search((int)((Math.random()*10)+1));
	}

}
