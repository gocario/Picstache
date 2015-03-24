package test;

import algorithm.IAlgorithm;
import algorithm.MedianFiltering;

import io.GreyImageIO;

import java.util.ArrayList;

import model.GreyImage;

import view.GreyImageViewerExtended;

/**
 * @author Gocario
 * @since 10/02/2015
 */
public class TestFilter
{
	public static void main(String[] args)
	{
		args = new String[] {"lena_grey.png", "5"};
		
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
		
		images.add(inputImage);
		
	    
	    algo = new MedianFiltering(inputImage, 6);
	    algo.process();
	    images.add(algo.getResult());
		
		
		GreyImageViewerExtended viewer = new GreyImageViewerExtended(images);
		viewer.show();
	}
}
