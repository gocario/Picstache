package test;

import algorithm.IAlgorithm;
import algorithm.NLFilterMeans;
import algorithm.NoiseGaussian;
import io.GreyImageIO;
import model.GreyImage;
import view.GreyImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @since 24/03/2015
 */
public class TestNLFilter
{
	public static void main(String[] args)
	{
		args = new String[] {"lena_grey.png"};

		if (args.length != 1)
		{
			System.err.println("TestNLFilter of input image. Parameters : <inputImage>");
			System.exit(0);
		}


		IAlgorithm algo;
		ArrayList<GreyImage> images = new ArrayList<GreyImage>();
		GreyImage inputImage = GreyImageIO.readFile(args[0]);
		if (inputImage == null)
		{
			System.err.println("Input file not found!");
			System.exit(0);
		}

		// Params \\
		int mean = 0;
		int std = 15;
		int windowSize = 3;
		int patchSize = 5;
		float h = 150.0f;

		algo = new NoiseGaussian(inputImage, mean, std);
		algo.process();
		images.add(algo.getResult());

		GreyImage gaussed = algo.getResult();

		algo = new NLFilterMeans(gaussed, windowSize, patchSize, h);
		algo.process();
		images.add(algo.getResult());

		algo = new NLFilterMeans(gaussed, windowSize + 5, patchSize, h);
		algo.process();
		images.add(algo.getResult());

		GreyImageViewerExtended viewer = new GreyImageViewerExtended(images);
		viewer.show();
	}
}
