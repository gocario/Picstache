package model;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class Point
{
	private int x;
	private int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Point(int z)
	{
		this(z, z);
	}

	public static final Point Zero = new Point(0, 0);
	public static final Point One = new Point(1, 1);


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


	public boolean equals(Point p)
	{
		return (this.x == p.x && this.y == p.y);
	}
}