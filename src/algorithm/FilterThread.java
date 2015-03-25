package algorithm;

/**
 * @author Gocario
 * @since 25/03/2015
 */
public abstract class FilterThread extends Thread
{
	protected int xMin;
	protected int xMax;
	protected int yMin;
	protected int yMax;
	
	public FilterThread(int xMin, int xMax, int yMin, int yMax)
	{
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}
	
	public void run()
	{
		this.process();
	}
	
	public abstract void process();
}
