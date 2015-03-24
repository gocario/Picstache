package io;

import model.GreyImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.io.File;

/**
 * Created by naegel on 01/02/15.
 * - Read greyscale image and convert to class GreyImage
 * - Write greyscale image to PNG file
 */
public class GreyImageIO
{

	public static GreyImage readFile(String filename)
	{
		File file = new File(filename);
		GreyImage imResult = null;
		try
		{
			BufferedImage bufferedImage = ImageIO.read(file);
			imResult = convertBufferedImageToGreyImage(bufferedImage);
		}
		catch (Exception e)
		{
			System.err.println("File : " + filename + " not found");
		}

		return imResult;
	}

	public static void writeFile(GreyImage greyImage, String filename)
	{
		File file = new File(filename);

		try
		{
			BufferedImage bufferedImage = convertGreyImageToBufferedImage(greyImage);
			ImageIO.write(bufferedImage, "png", file);
		}
		catch (Exception e)
		{
			System.err.println("Unable to write file : " + filename);
		}

	}

	public static BufferedImage convertGreyImageToBufferedImage(GreyImage greyImage)
	{
		int sizeX = greyImage.getSizeX();
		int sizeY = greyImage.getSizeY();
		BufferedImage bufferedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_BYTE_GRAY);
		DataBuffer dataBuffer = bufferedImage.getRaster().getDataBuffer();
		for (int i = 0; i < dataBuffer.getSize(); i++)
		{
			int value = greyImage.getOffset(i);
			dataBuffer.setElem(i, value);
		}
		return bufferedImage;
	}

	public static GreyImage convertBufferedImageToGreyImage(BufferedImage bufferedImage)
	{
		GreyImage greyImage;

		int sizeX = bufferedImage.getWidth();
		int sizeY = bufferedImage.getHeight();
		greyImage = new GreyImage(sizeX, sizeY);
		DataBuffer dataBuffer = bufferedImage.getRaster().getDataBuffer();
		//System.out.println("Size X : " + bufferedImage.getRaster().getWidth() + " Size Y : " + raster.getHeight());
		//System.out.println("Channels : " + bufferedImage.getRaster().getNumBands());

		for (int i = 0; i < dataBuffer.getSize(); i++)
		{
			int value = dataBuffer.getElem(i);
			greyImage.setOffset(i, value);
		}

		return greyImage;
	}
}
