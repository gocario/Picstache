package model;

public class Pixel implements Comparable<Pixel>
{
	private int val;
	private int x;
	private int y;

	public Pixel(int x, int y, int val)
	{
		this.x = x;
		this.y = y;
		this.val = val;
	}

	public Pixel(int z, int val)
	{
		this(z, z, val);
	}

	public static final Pixel Zero = new Pixel(0, 0, 0);
	public static final Pixel One = new Pixel(1, 1, 0);


	public void setVal(int val)
	{
		this.val = val;
	}

	public int getVal()
	{
		return val;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}


	public boolean equals(Pixel that)
	{
		return (this.x == that.x && this.y == that.y);
	}


	@Override
	public int compareTo(Pixel that)
	{
		if (this.val < that.val)
		{
			return -1;
		}
		else if (this.val > that.val)
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
	    sb.append(this.x);
	    sb.append(",");
	    sb.append(this.y);
	    sb.append(")");
		
		return sb.toString();
	}
}
