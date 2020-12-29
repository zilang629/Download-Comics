package com.zz.main;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Sobel {
	/**
	 * 
	 * @param image
	 * @return
	 */
	public BufferedImage getSobel(BufferedImage image){
		int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage Pic = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR); 
        float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.0f, -1.0f, 0.0f,-1.0f, 0.0f };   
        Kernel kernel = new Kernel(3, 3, elements); 
        ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
        cop.filter(image, Pic); 
        return image;
	}

}
