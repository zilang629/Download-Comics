package com.zz.main;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.util.Arrays;


public class MedianFilter {

	public BufferedImage medianFiltering(BufferedImage img) throws IOException {
		int w = img.getWidth();
		int h = img.getHeight();
		int[] pix = new int[w*h];
		img.getRGB(0, 0, w, h, pix, 0, w);		
		int newpix[] = medianFiltering(pix, w, h);
		img.setRGB(0, 0, w, h, newpix, 0, w);
		return img;
	}
	
	public static int[] medianFiltering(int pix[], int w, int h) {
		int newpix[] = new int[w*h];
		int[] temp = new int[9];
		ColorModel cm = ColorModel.getRGBdefault();
		int r=0;
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				if(x!=0 && x!=w-1 && y!=0 && y!=h-1) {
					//g = median[(x-1,y-1) + f(x,y-1)+ f(x+1,y-1)
					//  + f(x-1,y) + f(x,y) + f(x+1,y)
					//  + f(x-1,y+1) + f(x,y+1) + f(x+1,y+1)]					
					temp[0] = cm.getRed(pix[x-1+(y-1)*w]); 
					temp[1] = cm.getRed(pix[x+(y-1)*w]);
					temp[2] = cm.getRed(pix[x+1+(y-1)*w]);
					temp[3] = cm.getRed(pix[x-1+(y)*w]);
					temp[4] = cm.getRed(pix[x+(y)*w]);
					temp[5] = cm.getRed(pix[x+1+(y)*w]);
					temp[6] = cm.getRed(pix[x-1+(y+1)*w]);
					temp[7] = cm.getRed(pix[x+(y+1)*w]);
					temp[8] = cm.getRed(pix[x+1+(y+1)*w]);
					Arrays.sort(temp);
					r = temp[4];
					newpix[y*w+x] = 255<<24 | r<<16 | r<<8 |r;
				} else {
					newpix[y*w+x] = pix[y*w+x];
				}
			}
		}
		return newpix;
	}
}
