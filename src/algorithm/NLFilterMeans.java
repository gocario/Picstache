package algorithm;

import model.GreyImage;

/**
 * @author Gocario
 * @since 24/03/2015
 */
public class NLFilterMeans extends Filter implements IComputeWindow
{
	private int windowSize;
	private int patchSize;
	private float h;

	/**
	 *
	 * @param inputImage
	 * @param windowSize RAYON
	 * @param patchSize RAYON
	 * @param h
	 */
	public NLFilterMeans(GreyImage inputImage, int windowSize, int patchSize, float h)
	{
		super(inputImage);

		this.windowSize = windowSize;
		this.patchSize = patchSize;
		this.h = h;
	}

	private int computeSimilarity(int x1, int y1, int x2, int y2)
	{
		int value = 0;

		int psize = patchSize;

		for (int prow = -psize; prow <= psize; prow++)
		{
			for (int pcol = -psize; pcol <= psize; pcol++)
			{
				int vA = inputImage.getPixel(x1+pcol,y1+prow);
				int vB = inputImage.getPixel(x2+pcol,y2+prow);

				value += (vA - vB) * (vA - vB);
			}
		}

		return value;
	}

	private double computeWeight(int x1, int y1, int x2, int y2)
	{
		double sim = computeSimilarity(x1, y1, x2, y2);
		double value = Math.exp(-1 * sim / (h * h));
		return value;
	}

	@Override
	public int computeWindow(int col, int row)
	{
		int value = 0;

		double sumWeights = 0;
		double sumValue = 0;

		int wsize = windowSize;
		for (int wrow = -wsize; wrow <= wsize; wrow++)
		{
			for (int wcol = -wsize; wcol <= wsize; wcol++)
			{
				if (wrow != 0 && wcol != 0)
				{
					double w = this.computeWeight(col, row, col+wcol, row+wrow);
					sumWeights += w;
					sumValue += w * inputImage.getPixel(col+wcol, row+wrow);
				}

			}
		}

		value = (int) (sumValue / sumWeights);

		return value;
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
				int value = computeWindow(col, row);
				outputImage.setPixel(col, row, value);
			}
		}
	}
}
