package algorithm;

import model.GreyImage;
import model.StructElement;

/**
 * @author Gocario
 * @since 17/03/2015
 */
public abstract class MorphoElement extends Filter
{
	protected StructElement struct;

	public MorphoElement(GreyImage inputImage, StructElement struct)
	{
		super(inputImage);

		this.struct = struct;
	}
}
