package algorithm;

import model.GreyImage;
import model.StructElement;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoClose extends MorphoElement
{
	public MorphoClose(GreyImage inputImage, StructElement struct)
	{
		super(inputImage, struct);
	}

	@Override
	public void process()
	{
		IAlgorithm algo;

		algo = new MorphoDilate(inputImage, struct);
		algo.process();
		outputImage = algo.getResult();
		algo = new MorphoErode(outputImage, struct);
		algo.process();
		outputImage = algo.getResult();
	}
}
