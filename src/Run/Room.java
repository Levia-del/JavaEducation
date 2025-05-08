package Run;

public class Room {

	protected int width;
    protected int height;
    
    public Room()
    {
    	width = 0;
    	height = 0;
    }
    
    public Room(int w, int h)
    {
    	width = w;
    	height = h;
    }
    
    
    public int getArea()
    {
    	return width*height;
    }
    
    
   
    
    public void test(int v)
    {
    	System.out.println(v);
    }
    
    
}

