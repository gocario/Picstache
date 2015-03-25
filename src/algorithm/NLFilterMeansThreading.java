package algorithm;

import model.GreyImage;

/**
 * @author Gocario
 * @since 25/03/2015
 */
public class NLFilterMeansThreading extends NLFilterMeans
{
	public NLFilterMeansThreading(GreyImage inputImage, int windowSize, int patchSize, float h)
	{
		super(inputImage, windowSize, patchSize, h);
	}

	@Override
	public void process()
	{
		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		// TODO Implement this method
		Thread f1 = new FilterThreaded(			0, 	sizeX / 2, 			0, 	sizeY / 2);
		Thread f2 = new FilterThreaded(	sizeX / 2, 		sizeX, 			0, 	sizeY / 2);
		Thread f3 = new FilterThreaded(			0, 	sizeX / 2, 	sizeY / 2, 		sizeY);
		Thread f4 = new FilterThreaded(	sizeX / 2, 		sizeX, 	sizeY / 2, 		sizeY);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		
		try
		{
			f1.join();
			f2.join();
			f3.join();
			f4.join();
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
	}
	
	private class FilterThreaded extends FilterThread
	{
		public FilterThreaded(int xMin, int xMax, int yMin, int yMax)
		{
			super(xMin, xMax, yMin, yMax);
		}

		@Override
		public void process()
		{
			for (int row = yMin; row < yMax; row++)
			{
				for (int col = xMin; col < xMax; col++)
				{
					int value = computeWindow(col, row);
					
					outputImage.setPixel(col, row, value);
				}
			}
		}
	}
}
