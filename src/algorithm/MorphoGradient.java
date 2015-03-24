package algorithm;

import model.GreyImage;
import model.StructElement;


/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoGradient extends MorphoElement
{
	public MorphoGradient(GreyImage inputImage, StructElement struct)
	{
		super(inputImage, struct);
	}

	@Override
	public void process()
	{
		IAlgorithm algo;
		GreyImage erodeImage, dilateImage;

		algo = new MorphoErode(inputImage, struct);
		algo.process();
		erodeImage = algo.getResult();
		algo = new MorphoDilate(inputImage, struct);
		algo.process();
		dilateImage = algo.getResult();


		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int value = dilateImage.getPixel(col, row) - erodeImage.getPixel(col, row);

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
