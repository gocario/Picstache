package test;

import algorithm.IAlgorithm;
import algorithm.NLFilterMeans;
import algorithm.NLFilterMeansThreading;
import algorithm.NoiseGaussian;
import io.GreyImageIO;
import model.GreyImage;
import model.Clock;
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
		args = new String[] {"sasha_grey.png"};

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
		int windowSize = 4;
		int patchSize = 4;
		float h = 150.0f;
		Clock clock = new Clock();

		algo = new NoiseGaussian(inputImage, mean, std);
		algo.process();
		images.add(algo.getResult());

		GreyImage gaussed = algo.getResult();


		clock.start();
		algo = new NLFilterMeans(gaussed, windowSize, patchSize, h);
		algo.process();
		images.add(algo.getResult());
		clock.stop();
		
		System.out.println("NLFilterMeans: " + clock.getElapsedSeconds() + "s");

		clock.start();
		algo = new NLFilterMeansThreading(gaussed, windowSize, patchSize, h);
		algo.process();
		images.add(algo.getResult());
		clock.stop();
		System.out.println("NLFilterMeansThreading: " + clock.getElapsedSeconds() + "s");
		
		GreyImageViewerExtended viewer = new GreyImageViewerExtended(images);
		viewer.show();
	}
}
