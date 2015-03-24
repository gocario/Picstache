package algorithm;

import model.GreyImage;
import model.Point;
import model.StructElement;

import java.util.Arrays;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoDilate extends MorphoElement
{
	public MorphoDilate(GreyImage inputImage, StructElement struct)
	{
		super(inputImage, struct);
	}

	@Override
	public void process()
	{
		int sSize = struct.getSize();
		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int[] data = new int[sSize];
				for (int i = 0; i < sSize; i++)
				{
					Point point = struct.getPoint(i);
					data[i] = inputImage.getPixel(col - point.getX(), row - point.getY());
				}

				Arrays.sort(data);

				int value = data[sSize -1];

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
