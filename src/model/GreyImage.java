package model;

/**
 * @author Naegel
 * @since 01/02/2015
 *
 * @author2 Gocario
 * @since2 17/03/2015
 */
public class GreyImage
{
	private static final int BORDER_VALUE = 0;
	private int sizeX;
	private int sizeY;
	private int nbPixels;
	private int data[];

	public GreyImage(int sizeX, int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbPixels = sizeX * sizeY;
		this.data = new int[this.nbPixels];
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

	public void setData(int[] data)
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
	 * @return the value of pixel at coordinates (x,y) ; BORDER_VALUE if (x,y) does not belong to the image domain
	 */

	public int getPixel(int x, int y)
	{
		if (isCoordValid(x, y))
		{
			return data[x + (y/* - 1*/) * sizeX];
		}
		else
		{
			return BORDER_VALUE;
		}
	}

	/**
	 * @author Gocario
	 * @param p
	 * @return la valeur du pixel aux coordonn??es (p.x, p.y) ; BORDER_VALUE si (p.x, p.y) n'est pas valide pour l'image
	 */
	public int getPixel(Point p)
	{
		return getPixel(p.getX(), p.getY());
	}

	/**
	 * @param x
	 * @param y
	 * @param value Set the value "value" to pixel at coordinates (x,y) ; does nothing if (x,y) does not belong to the image domain
	 */

	public void setPixel(int x, int y, int value)
	{
		if (isCoordValid(x, y))
		{
			data[x + (y/* - 1*/) * sizeX] = value;
		}
	}

	/**
	 * @author Gocario
	 * @param p
	 * @param value
	 * @return Mets ?? jour la valeur du pixel aux coordonn??es (p.x, p.y) ; ne fais rien si les coordonn??es sont invalides pour l'image
	 */
	public void setPixel(Point p, int value)
	{
		setPixel(p.getX(), p.getY(), value);
	}

	/**
	 * @param offset
	 * @return the value of pixel at position offset ; BORDER_VALUE if offset does not belong to the image domain
	 */
	public int getOffset(int offset)
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
	 * @param value  Set the value "value" to pixel at position "offset" ; does nothing if offset does not belong to the image domain
	 */
	public void setOffset(int offset, int value)
	{
		if (isOffsetValid(offset))
		{
			data[offset] = value;
		}
	}


	@Override
	public GreyImage clone()
	{
		GreyImage that = new GreyImage(this.sizeX, this.sizeY);
		
		int length = data.length;
		for (int i = 0; i < length; i++) 
		{
			that.data[i] = this.data[i];
		}
		
		return that;
	}
}
