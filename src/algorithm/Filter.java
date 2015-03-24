package algorithm;

import model.GreyImage;

/**
 * @author Gocario
 * @since 10/03/2015
 *
 * @see GreyImage
 */
public abstract class Filter implements IAlgorithm
{
	protected GreyImage inputImage;
	protected GreyImage outputImage;
	
	public Filter(GreyImage inputImage)
	{
		this.inputImage = inputImage;
		this.outputImage = new GreyImage(inputImage.getSizeX(), inputImage.getSizeY());
	}

	@Override
	public GreyImage getResult()
	{
		return this.outputImage;
	}
}
