package model;

import java.util.ArrayList;
import java.util.Collection;

public class PixelList extends ArrayList<Pixel>
{
	public PixelList(Collection<? extends Pixel> collection)
	{
		super(collection);
	}

	public PixelList()
	{
		super();
	}

	public PixelList(int i)
	{
		super(i);
	}
}
