package model;

public class Clock
{
	private long tStart = 0;
	private long tOld = 0;
	private long tElapsed = 0;

	private boolean isRunning;

	public Clock()
	{
		this.tOld = this.tStart = System.currentTimeMillis();

		this.isRunning = false;
	}


	public void start()
	{
		this.reset();
		this.isRunning = true;
	}

	public void stop()
	{
		this.getDelta();
		this.isRunning = false;
	}

	public void reset()
	{
		this.tStart = this.tOld = System.currentTimeMillis();
		this.tElapsed = 0;
	}

	public long getElapsedTime()
	{
		return this.getElapsedMillis();
	}

	public long getElapsedMillis()
	{
		this.getDelta();
		return this.tElapsed;
	}

	public double getElapsedSeconds()
	{
		return ((double) this.getElapsedMillis()) / 1000;
	}

	public long getDelta()
	{
		long diff = 0;

		if (this.isRunning)
		{
			long tNew = System.currentTimeMillis();

			diff = (tNew - this.tOld);

			this.tOld = tNew;
			this.tElapsed += diff;
		}


		return diff;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(this.getElapsedTime());

		return sb.toString();
	}
}
