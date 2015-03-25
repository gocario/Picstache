package model;

public class Clock
{
	private long tStart;
	private long tEnd;
	private long tDelta;
	
	private boolean isRunning;
	
	public Clock()
	{
		super();
		
		tStart = tEnd = tDelta = System.currentTimeMillis();
		isRunning = false;
	}
	
	public long start()
	{
		isRunning = true;
		return tStart = System.currentTimeMillis();
	}
	
	public long stop()
	{
		isRunning = false;
		return tEnd = System.currentTimeMillis();
	}
	
	public long elapsedTime()
	{
		return tDelta = (tEnd - tStart);
	}	
	
	public double elapsedSecond()
	{
		return elapsedTime() / 1000;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(elapsedTime());
		
		return sb.toString();
	}
}
