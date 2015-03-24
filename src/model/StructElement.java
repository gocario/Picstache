package model;

import java.util.ArrayList;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class StructElement
{
	private ArrayList<Point> points = new ArrayList<Point>();
	
	public StructElement()
	{
		super();
	}

	public int getSize()
	{
		return this.points.size();
	}

	public Point getPoint(int idx)
	{
		if (isValid(idx))
		{
			return this.points.get(idx);
		}
		else
		{
			return Point.Zero;
		}
	}

	public void addPoint(Point p)
	{
		this.points.add(p);
	}

	public boolean isValid(int idx)
	{
		return (idx > -1 && idx < getSize());
	}

	/**
	 * Le côté du carré correspond à (2n + 1)
	 * @param n Demi côté d'un carré
	 * @return
	 */
	public static StructElement makeSquare(int n)
	{
		StructElement elem = new StructElement();
		
		for (int row = -n; row <= n; row++)
		{
		    for (int col = -n; col <= n; col++)
		    {
		        elem.points.add(new Point(row, col));
		    }
		}
		
		return elem;
	}

	/**
	 * Le diamètre de la sphère correspond à (2n + 1)
	 * @param n Rayon de la sphère
	 * @return
	 */
	public static StructElement makeCircle(int n)
	{
		StructElement elem = new StructElement();
		
		for (int row = -n; row <= n; row++)
		{
		    for (int col = -n; col <= n; col++)
		    {
				if (row*row + col*col <= n*n)
				{
					elem.points.add(new Point(row, col));
				}
		    }
		}
		
		return elem;
	}
}
