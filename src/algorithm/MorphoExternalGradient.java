package algorithm;

import model.GreyImage;
import model.StructElement;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoExternalGradient extends MorphoElement
{
	public MorphoExternalGradient(GreyImage inputImage, StructElement struct)
	{
		super(inputImage, struct);
	}

	@Override
	public void process()
	{
		IAlgorithm algo;
		GreyImage dilateImage;

		algo = new MorphoDilate(inputImage, struct);
		algo.process();
		dilateImage = algo.getResult();


		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int value = dilateImage.getPixel(col, row) - inputImage.getPixel(col, row);

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
