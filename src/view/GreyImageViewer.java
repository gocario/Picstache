package view;

import io.GreyImageIO;
import model.GreyImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by naegel on 01/02/15.
 */
public class GreyImageViewer
{
	GreyImage inputImage;
	GreyImage outputImage;

	public GreyImageViewer(GreyImage inputImage, GreyImage outputImage)
	{
		this.inputImage = inputImage;
		this.outputImage = outputImage;
	}

	/**
	 * Show input image
	 */
	public void showInput()
	{
		BufferedImage inputBufferedImage = GreyImageIO.convertGreyImageToBufferedImage(inputImage);
		JFrame inputFrame = new JFrame("Input image");
		inputFrame.setLayout(new FlowLayout());
		inputFrame.add(new JLabel(new ImageIcon(inputBufferedImage)));
		inputFrame.pack();
		inputFrame.setVisible(true);
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Show output image
	 */
	public void showOutput()
	{
		BufferedImage outputBufferedImage = GreyImageIO.convertGreyImageToBufferedImage(outputImage);
		JFrame outputFrame = new JFrame("Output image");
		outputFrame.setLayout(new FlowLayout());
		outputFrame.add(new JLabel(new ImageIcon(outputBufferedImage)));
		outputFrame.pack();
		outputFrame.setVisible(true);
		outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Show input and output image on the same frame
	 */
	public void showInputOutput()
	{
		BufferedImage inputBufferedImage = GreyImageIO.convertGreyImageToBufferedImage(inputImage);
		BufferedImage outputBufferedImage = GreyImageIO.convertGreyImageToBufferedImage(outputImage);
		JFrame frame = new JFrame("Input image - Output image");
		frame.setLayout(new FlowLayout());
		frame.add(new JLabel(new ImageIcon(inputBufferedImage)));
		frame.add(new JLabel(new ImageIcon(outputBufferedImage)));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
