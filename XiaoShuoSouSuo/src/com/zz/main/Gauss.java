package com.zz.main;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Gauss {
	
	/**
	 * 
	 * @param image
	 * @return
	 */
	public static BufferedImage gaussFiltering(BufferedImage image) {  
		int size=8;  //8位
		float[] elements = getGaussTemplate(1,size);  
		
		Kernel kernel = new Kernel(size, size, elements);  
		
		ConvolveOp blur = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
		image= blur.filter(image, null);  return image; 
	} 
	
	/**
	 * 
	 * @param sigma
	 * @param size
	 * @return
	 */
	public static float[] getGaussTemplate(int sigma,int size){  
		float[] temp=new float[size*size];  
		double[][] Gaussian_Temp = new double[size][size];    
		int i,j;    
		double sum = 0;    
		double weight= 2*Math.PI*sigma*sigma; 
		for(i =0;i <size;i++){    
			for(j = 0;j < size;j++){    
				Gaussian_Temp[i][j] =weight* Math.exp(-((i-size/2)*(i-size/2)+(j-size/2)*(j-size/2))/(2.0*sigma*sigma));      
				sum += Gaussian_Temp[i][j];    
			}    
		}  
		int k=0;  
		for(i = 0; i < size;i++){    
			for(j = 0;j < size;j++){    
				Gaussian_Temp[i][j] = Gaussian_Temp[i][j]/sum; 
				temp[k++]=Float.parseFloat(String.valueOf(Gaussian_Temp[i][j]));  
				temp[k-1]=Float.parseFloat(String .format("%.8f",temp[k-1])); //保留八位
			}    
		} 
		return temp;  
	}

}
