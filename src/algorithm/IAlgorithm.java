package algorithm;

import model.GreyImage;

/**
 * @author Gocario
 * @since 10/03/2015
 */
public interface IAlgorithm
{
	public void process();

	public GreyImage getResult();
}
