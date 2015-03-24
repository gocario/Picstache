package algorithm;

import java.util.ArrayList;

import java.util.Collections;

import model.GreyImage;

/**
 * @author Gocario
 * @since 10/02/2015
 */
public class MedianFiltering extends Filter
{
	private int N;
	
	public MedianFiltering(GreyImage inputImage, int N)
	{
		super(inputImage);
		
		this.N = N;
	}


	@Override
	public void process()
	{
		ArrayList<Integer> values = new ArrayList<Integer>();
		int value = 0;
		int msize = N / 2;
		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();
		
		for (int row = 0; row < sizeY; row++)
		{
		    for (int col = 0; col < sizeX; col++)
		    {
				values.clear();
				for (int mrow = -msize; mrow < msize; mrow++)
				{
				    for (int mcol = -msize; mcol < msize; mcol++)
				    {
				        values.add(inputImage.getPixel(col+mcol, row+mrow));
				    }
				}
				
				
				Collections.sort(values);
				
				value = values.get(values.size() / 2);
				outputImage.setPixel(col, row, value);
		    }
		}
	}
}
