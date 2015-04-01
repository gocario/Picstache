package model;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class ColorImage
{
	private static final Color BORDER_VALUE = null;
	private int sizeX;
	private int sizeY;
	private int nbPixels;
	private Color data[];

	public ColorImage(int sizeX, int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbPixels = sizeX * sizeY;
		this.data = new Color[this.nbPixels];
	}

	public int getSizeX()
	{
		return sizeX;
	}

	public int getSizeY()
	{
		return sizeY;
	}

	public int getNbPixels()
	{
		return nbPixels;
	}

	public void setData(Color[] data)
	{
		if (data.length == nbPixels)
		{
			this.data = data;
		}
	}

	public boolean isCoordValid(int x, int y)
	{
		return (x >= 0 && x < sizeX && y >= 0 && y < sizeY);
	}

	public boolean isOffsetValid(int offset)
	{
		return (offset >= 0 && offset < nbPixels);
	}

	/**
	 * @param x
	 * @param y
	 * @return La valeur du pixel en fonction de ses coordonn??es.
	 */

	public Color getPixel(int x, int y)
	{
		if (isCoordValid(x, y))
		{
			return data[x + (y) * sizeX];
		}
		else
		{
			return BORDER_VALUE;
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param value La nouvelle valeur du pixel en fonction de ses coordonn??es.
	 */

	public void setPixel(int x, int y, Color value)
	{
		if (isCoordValid(x, y))
		{
			data[x + (y) * sizeX] = value;
		}
	}

	/**
	 * @param offset
	 * @return La valeur du pixel en fonction de son offset.
	 */
	public Color getOffset(int offset)
	{
		if (isOffsetValid(offset))
		{
			return data[offset];
		}
		else
		{
			return BORDER_VALUE;
		}
	}

	/**
	 * @param offset
	 * @param value La nouvelle valeur du pixel en fonction de son offset.
	 */
	public void setOffset(int offset, Color value)
	{
		if (isOffsetValid(offset))
		{
			data[offset] = value;
		}
	}
}
