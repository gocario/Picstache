package algorithm;

import model.GreyImage;
import model.StructElement;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoInternalGradient extends MorphoElement
{
	public MorphoInternalGradient(GreyImage inputImage, StructElement struct)
	{
		super(inputImage, struct);
	}

	@Override
	public void process()
	{
		IAlgorithm algo;
		GreyImage erodeImage;

		algo = new MorphoErode(inputImage, struct);
		algo.process();
		erodeImage = algo.getResult();


		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int value = inputImage.getPixel(col, row) - erodeImage.getPixel(col, row);

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
