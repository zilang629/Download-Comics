package com.zz.main;

import java.io.IOException;
import java.util.Properties;

public class Util {
	
		public static void main(String[] args) throws IOException  {
			Util util = new Util();
			System.out.println(util.readProperties("Kp","xml.properties"));
		}
		/**
		 * 读取配置文件
		 * @param property 需要读取的节点
		 * @param fileName 需要读取的文件名称
		 * @return 节点的值
		 * @throws IOException
		 */
		public String readProperties(String property,String fileName) throws IOException {
			Properties properties = new Properties();
			properties.load(Test.class.getClassLoader().getResourceAsStream(fileName));
			String rote = properties.getProperty(property);
			return rote;
		}
}
