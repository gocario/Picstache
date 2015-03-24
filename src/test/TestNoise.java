package test;

import algorithm.IAlgorithm;
import algorithm.MedianFiltering;
import algorithm.NoiseGaussian;
import algorithm.NoiseImpulse;
import io.GreyImageIO;
import model.GreyImage;
import view.GreyImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class TestNoise
{
	public static void main(String[] args)
	{
		args = new String[] {"lena_grey.png", "0.1"};

		if (args.length != 2)
		{
			System.err.println("TestFilter of input image. Parameters : <inputImage> <N>");
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
		float noise = Float.parseFloat(args[1]);

		images.add(inputImage);

		/*
		algo = new GenerateImpulseNoise(inputImage, noise);
		algo.process();
		images.add(algo.getResult());

		algo = new GenerateGaussianNoise(inputImage, 0, 1);
		algo.process();
		images.add(algo.getResult());
		*/



		algo = new NoiseImpulse(inputImage, 0.15f);
		algo.process();
		algo = new MedianFiltering(algo.getResult(), 3);
		algo.process();
		images.add(algo.getResult());


		algo = new NoiseImpulse(inputImage, 0.40f);
		algo.process();
		algo = new MedianFiltering(algo.getResult(), 5);
		algo.process();
		images.add(algo.getResult());


		algo = new NoiseGaussian(inputImage, 0, 15);
		algo.process();
		images.add(algo.getResult());
		algo = new MedianFiltering(algo.getResult(), 5);
		algo.process();
		images.add(algo.getResult());


		GreyImageViewerExtended viewer = new GreyImageViewerExtended(images);
		viewer.show();
	}
}
