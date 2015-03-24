package algorithm;

import model.GreyImage;
import model.StructElement;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoHMT extends Filter
{
	private StructElement struct1;
	private StructElement struct2;

	public MorphoHMT(GreyImage inputImage, StructElement struct1, StructElement struct2)
	{
		super(inputImage);

		this.struct1 = struct1;
		this.struct2 = struct2;
	}

	@Override
	public void process()
	{
		IAlgorithm algo;
		GreyImage dilateImage1, dilateImage2;

		algo = new MorphoDilate(inputImage, struct1);
		algo.process();
		dilateImage1 = algo.getResult();

		algo = new MorphoDilate(inputImage, struct2);
		algo.process();
		dilateImage2 = algo.getResult();

		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int value = dilateImage1.getPixel(col, row) - dilateImage2.getPixel(col, row);

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
