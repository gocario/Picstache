package algorithm;

import model.GreyImage;
import model.StructElement;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public class MorphoOpen extends MorphoElement
{
	public MorphoOpen(GreyImage inputImage, StructElement struct)
	{
		super(inputImage, struct);
	}

	@Override
	public void process()
	{
		IAlgorithm algo;

		algo = new MorphoErode(inputImage, struct);
		algo.process();
		outputImage = algo.getResult();
		algo = new MorphoDilate(outputImage, struct);
		algo.process();
		outputImage = algo.getResult();
	}
}
