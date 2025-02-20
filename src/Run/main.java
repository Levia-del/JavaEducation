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
		    my.add(9);
		    my.add(8);
		    //my.RotateLeft(my.root.left);
		    my.RotateRight(my.root.left);
		    System.out.println(my.root.left);
		    //my.search((int)((Math.random()*10)+1));
	}

}
