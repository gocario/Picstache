package algorithm;

import model.GreyImage;

import java.util.Random;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class NoiseImpulse extends Filter
{
	private float p;

	public NoiseImpulse(GreyImage inputImage, float p)
	{
		super(inputImage);

		this.p = p;
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

				value = (rand.nextFloat() < p ? (rand.nextFloat() < 0.5 ? MIN_VALUE : MAX_VALUE) : value);

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
