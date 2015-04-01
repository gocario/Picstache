package io;

import java.awt.image.BufferedImage;

import java.awt.image.DataBuffer;

import java.io.File;

import javax.imageio.ImageIO;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 01/04/2015
 */
public class ColorImageIO
{

    public static ColorImage readFile(String filename)
    {
        File file = new File(filename);
        ColorImage imResult = null;
        try
        {
            BufferedImage bufferedImage = ImageIO.read(file);
            imResult = convertBufferedImageToColorImage(bufferedImage);
        }
        catch (Exception e)
        {
            System.err.println("File : " + filename + " not found");
        }

        return imResult;
    }

    public static void writeFile(ColorImage colorImage, String filename)
    {
        File file = new File(filename);

        try
        {
            BufferedImage bufferedImage = convertColorImageToBufferedImage(colorImage);
            ImageIO.write(bufferedImage, "png", file);
        }
        catch (Exception e)
        {
            System.err.println("Unable to write file : " + filename);
        }

    }


    public static BufferedImage convertColorImageToBufferedImage(ColorImage colorImage)
    {
        int sizeX = colorImage.getSizeX();
        int sizeY = colorImage.getSizeY();
        BufferedImage bufferedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
        DataBuffer dataBuffer = bufferedImage.getRaster().getDataBuffer();
        for (int i = 0; i < dataBuffer.getSize(); i++)
        {
            Color value = colorImage.getOffset(i);
            dataBuffer.setElem(i, value.getRGB());
        }
        return bufferedImage;
    }

    public static ColorImage convertBufferedImageToColorImage(BufferedImage bufferedImage)
    {
        ColorImage colorImage;

        int sizeX = bufferedImage.getWidth();
        int sizeY = bufferedImage.getHeight();
        colorImage = new ColorImage(sizeX, sizeY);

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				Color value = new Color(bufferedImage.getRGB(col, row));

				System.out.println("(" + col + "," + row + "): " + value);

				colorImage.setPixel(col, row, value);
			}
		}

        return colorImage;
    }
}
