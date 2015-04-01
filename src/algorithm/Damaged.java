package algorithm;

import model.GreyImage;

public class Damaged extends Filter
{
	protected GreyImage maskImage;
	
	public Damaged(GreyImage inputImage, GreyImage maskImage)
	{
		super(inputImage);
		
		this.maskImage = maskImage;
	}

	@Override
	public void process()
	{
	    int sizeX = outputImage.getSizeX();
	    int sizeY = outputImage.getSizeY();

	    for (int row = 0; row < sizeY; row++)
	    {
	        for (int col = 0; col < sizeX; col++)
	        {
				int value;
				int mvalue = maskImage.getPixel(col, row);
				
				if (mvalue == 0) 
				{
					value = 0;
				}
				else
				{
					value = inputImage.getPixel(col, row);
				}
				
				outputImage.setPixel(col, row, value);
	        }
	    }
	}
}
