package algorithm;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;

import model.GreyImage;
import model.Pixel;
import model.PixelList;

public class Inpainting
	extends Damaged
{
	private int windowSize;
	private int patchSize;

	public Inpainting(GreyImage greyImage, GreyImage maskImage, int windowSize, int patchSize)
	{
		super(greyImage, maskImage);

		this.windowSize = windowSize;
		this.patchSize = patchSize;
	}

	public PixelList getDamagedPixels()
	{
		PixelList pixels = new PixelList();

		int msizeY = maskImage.getSizeY();
		int msizeX = maskImage.getSizeX();
		for (int mrow = 0; mrow < msizeY; mrow++)
		{
			for (int mcol = 0; mcol < msizeX; mcol++)
			{
				int mvalue = maskImage.getPixel(mcol, mrow);

				if (mvalue == MIN_VALUE)
				{
					pixels.add(new Pixel(mcol, mrow, mvalue));
				}
			}
		}

		return pixels;
	}


	public Pixel computeWindow(int col, int row)
	{
		Pixel pixel = new Pixel(0, 0, -1);
		int value = 0;

		int wsize = windowSize;
		for (int wrow = -wsize; wrow <= wsize; wrow++)
		{
			for (int wcol = -wsize; wcol <= wsize; wcol++)
			{
				if (wrow != 0 && wcol != 0)
				{
					double val = this.computeSimilarity(col, row, col + wcol, row + wrow);

					if (val > pixel.getVal() || pixel.getVal() == -1)
					{
						pixel = new Pixel(col + wcol, row + wrow, (int) val);
					}
				}

			}
		}

		return pixel;
	}

	public double computeSimilarity(int x1, int y1, int x2, int y2)
	{
		//ArrayList<Double> values = new ArrayList<Double>();
		double value = 0;

		int psize = patchSize;
		for (int prow = -psize; prow < psize; prow++)
		{
			for (int pcol = -psize; pcol < psize; pcol++)
			{
				int vA = inputImage.getPixel(x1 + pcol, y1 + prow);
				int vB = inputImage.getPixel(x2 + pcol, y2 + prow);

				int vmA = inputImage.getPixel(x1 + pcol, y1 + pcol);
				int vmB = maskImage.getPixel(x2 + pcol, y2 + prow);

				if (vmA == MIN_VALUE || vmB == MIN_VALUE)
				{
					//values.add(255.0*255.0);
					value += 255.0 * 255.0;
				}
				else
				{
					//values.add((vA - vB) * (vA - vB) * 1.0);
					value += (vA - vB) * (vA - vB);
				}
			}
		}

		//Collections.sort(values);
		//return values.get(0);
		return value;
	}

	@Override
	public void process()
	{
		PixelList pixels = getDamagedPixels();

		outputImage = inputImage.clone();


		while (pixels.size() > 0)
		{
			Collections.sort(pixels);

			Pixel p = pixels.get(0);
			pixels.remove(0);


			Pixel patchCenter = computeWindow(p.getX(), p.getY());

			System.out.println(patchCenter);

			int psize = patchSize;
			for (int prow = -psize; prow < psize; prow++)
			{
				for (int pcol = -psize; pcol < psize; pcol++)
				{
					int col = p.getX() + pcol;
					int row = p.getY() + prow;

					if (inputImage.getPixel(col, row) == MIN_VALUE)
					{
						if (maskImage.getPixel(col, row) == MIN_VALUE)
						{
							int value = inputImage.getPixel(patchCenter.getX() + pcol, patchCenter.getY() + prow);

							outputImage.setPixel(col, row, value);
						}
					}
				}
			}
		}

	}
}
