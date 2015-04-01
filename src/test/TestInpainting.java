package test;

import algorithm.Damaged;
import algorithm.IAlgorithm;
import algorithm.Inpainting;
import algorithm.MedianFiltering;

import io.GreyImageIO;

import java.util.ArrayList;

import model.GreyImage;

import view.GreyImageViewerExtended;

/**
 * @author Gocario
 * @since 10/02/2015
 */
public class TestInpainting
{
	public static void main(String[] args)
	{
		args = new String[] {"lena_grey.png", "mask.png", "5", "2"};
		
		if (args.length != 4)
		{
			System.err.println("TestFilter of input image. Parameters : <inputImage> <maskImage> <windowSize> <patchSize>");
			System.exit(0);
		}
		

	    IAlgorithm algo;
		ArrayList<GreyImage> images = new ArrayList<GreyImage>();
		GreyImage inputImage, maskImage, damagedImage;
		
		int windowSize = Integer.parseInt(args[2]);
		int patchSize = Integer.parseInt(args[3]);
		
		inputImage = GreyImageIO.readFile(args[0]);
		if (inputImage == null)
		{
			System.err.println("Input file not found!");
			System.exit(0);
		}
		maskImage = GreyImageIO.readFile(args[1]);
		if (maskImage == null)
		{
			System.err.println("Mask file not found!");
			System.exit(0);
		}
		
		images.add(inputImage);
		
		algo = new Damaged(inputImage, maskImage);
		algo.process();
		images.add(algo.getResult());
		
		damagedImage = algo.getResult();
		
	    algo = new Inpainting(damagedImage, maskImage, windowSize, patchSize);
		algo.process();
		images.add(algo.getResult());	
		
		
		
		GreyImageViewerExtended viewer = new GreyImageViewerExtended(images);
		viewer.show();
	}
}
