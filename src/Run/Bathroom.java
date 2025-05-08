package Run;

public class Bathroom extends Room{

	private String type;
	public Bathroom(int w, int h) {
		super(w, h);
	}

	public Bathroom(String t) {
		super();
		type = t;
	}
	
	public int getArea()
	{
		return width*height/2;
	}
}
