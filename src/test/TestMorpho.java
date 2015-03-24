package test;

import algorithm.*;
import io.GreyImageIO;
import model.GreyImage;
import model.StructElement;
import view.GreyImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class TestMorpho
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

		StructElement struct = StructElement.makeCircle(4);


		algo = new MorphoDilate(inputImage, struct);
		algo.process();
		images.add(algo.getResult());

		algo = new MorphoErode(inputImage, struct);
		algo.process();
		images.add(algo.getResult());

		algo = new MorphoOpen(inputImage, struct);
		algo.process();
		images.add(algo.getResult());

		algo = new MorphoClose(inputImage, struct);
		algo.process();
		images.add(algo.getResult());


		algo = new MorphoGradient(inputImage, struct);
		algo.process();
		images.add(algo.getResult());

		algo = new MorphoInternalGradient(inputImage, struct);
		algo.process();
		images.add(algo.getResult());
		algo = new MorphoExternalGradient(inputImage, struct);
		algo.process();
		images.add(algo.getResult());


		GreyImageViewerExtended viewer = new GreyImageViewerExtended(images);
		viewer.show();
	}
}
