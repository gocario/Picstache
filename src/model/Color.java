package model;

public class Color
{
	private int rgb;
	
	public Color(int r, int g, int b)
	{
		this.rgb = (((r & 0xFF) << 0x10) | ((g & 0xFF) << 0x08) | ((b & 0xFF) << 0x00));
	}
	
	public Color(int rgb)
	{
		this.rgb = rgb;
	}
	
	public int getRGB()
	{
		return this.rgb;
	}
	
	public int getRed()
	{
		return ((this.getRGB() >> 0x10) & 0xFF);
	}
	
	public int getGreen()
	{
		return ((this.getRGB() >> 0x08) & 0xFF);
	}
	
	public int getBlue()
	{
		return ((this.getRGB() >> 0x00) & 0xFF);
	}
	
	
	public int getR()
	{
		return this.getRed();
	}
	public int getG()
	{
		return this.getGreen();
	}
	public int getB()
	{
		return this.getBlue();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getRed());
	    sb.append("-");
	    sb.append(this.getGreen());
	    sb.append("-");
	    sb.append(this.getBlue());
		
		return sb.toString();
	}
}
