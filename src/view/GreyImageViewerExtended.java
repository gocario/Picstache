package view;

import io.GreyImageIO;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.GreyImage;

/**
 * @author Gocario
 * @since 17/03/2015
 *
 * @see GreyImage
 */
public class GreyImageViewerExtended
{
	private ArrayList<GreyImage> images;

	public GreyImageViewerExtended(ArrayList<GreyImage> images)
	{
		this.images = images;
	}

	public void show()
	{
		JFrame frame = new JFrame("GreyImage Viewer - Extended Edition Gold 2008 Collector");
		frame.setLayout(new FlowLayout());

		int size = images.size();
		for (int i = 0; i < size; i++)
		{
			BufferedImage bufferedImage = GreyImageIO.convertGreyImageToBufferedImage(images.get(i));
			frame.add(new JLabel(new ImageIcon(bufferedImage)));
		}

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
