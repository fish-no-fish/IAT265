package util;

//Final Project Implementation 
//IAT 265 
//Christine Lo - 301064064
//Date of modification: November 15
//Lecture notes on loading images

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	//method to load images
	public static BufferedImage loadImage(String imgFile) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgFile));
		}catch (IOException e) {
		}
	return img;
}
}
