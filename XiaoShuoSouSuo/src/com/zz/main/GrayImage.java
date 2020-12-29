package com.zz.main;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class GrayImage {
	/**
	 * 表示一个不透明的以字节打包的 1、2 或 4 位图像。
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public BufferedImage binaryImage(BufferedImage image) throws IOException{
       
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for(int i= 0 ; i < width ; i++){
            for(int j = 0 ; j < height; j++){
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }
        return grayImage;
    }
	/**
	 * 灰度级图像
	 * @param file
	 * @return
	 * @throws IOException
	 */
    public BufferedImage grayImage(BufferedImage image) throws IOException{
        
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for(int i= 0 ; i < width ; i++){
            for(int j = 0 ; j < height; j++){
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }
        
        return grayImage;
    }
}
