package algorithm;

import model.GreyImage;

import java.util.Random;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class NoiseGaussian extends Filter
{
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 255;

	private float mean;
	private float std;

	public NoiseGaussian(GreyImage inputImage, float mean, float std)
	{
		super(inputImage);

		this.mean = mean;
		this.std = std;
	}

	@Override
	public void process()
	{
		Random rand = new Random();
		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int value = inputImage.getPixel(col, row);

				value = (int) (value + (rand.nextGaussian() * std) + mean);

				if (value > MAX_VALUE)
					value = MAX_VALUE;
				if (value < MIN_VALUE)
					value = MIN_VALUE;

				outputImage.setPixel(col, row, value);
			}
		}
	}
}