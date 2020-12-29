package com.zz.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class createXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factory.newDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		Element kp = document.createElement("Kp");
		Element Version = document.createElement("Version");
		Element Fpxx = document.createElement("Fpxx");
		Element Zsl = document.createElement("Zsl");
		Element Fpsj = document.createElement("Fpsj");
		Element Fp = document.createElement("Fp");
		Element Djh = document.createElement("Djh");
		Element Gfmc = document.createElement("Gfmc");
		Element Gfsh = document.createElement("Gfsh");
		Element Gfyhzh = document.createElement("Gfyhzh");
		Element Gfdzdh = document.createElement("Gfdzdh");
		Element Bz = document.createElement("Bz");
		Element Fhr = document.createElement("Fhr");
		Element Skr = document.createElement("Skr");
		Element Spbmbbh = document.createElement("Spbmbbh");
		Element Hsbz = document.createElement("Hsbz");
		Element Spxx = document.createElement("Spxx");
		Element Sph = document.createElement("Sph");
		Element Xh = document.createElement("Xh");
		Element Spmc = document.createElement("Spmc");
		Element Ggxh = document.createElement("Ggxh");
		Element Jldw = document.createElement("Jldw");
		Element Spbm = document.createElement("Spbm");
		Element Qyspbm = document.createElement("Qyspbm");
		Element Syyhzcbz = document.createElement("Syyhzcbz");
		Element Lslbz = document.createElement("Lslbz");
		Element Yhzcsm = document.createElement("Yhzcsm");
		Element Dj = document.createElement("Dj");
		Element Sl = document.createElement("Sl");
		Element Je = document.createElement("Je");
		Element Slv = document.createElement("Slv");
		Element Kce = document.createElement("Kce");
		kp.appendChild(Version);
		kp.appendChild(Fpxx);
		Fpxx.appendChild(Zsl);
		Fpxx.appendChild(Fpsj);
		Fpsj.appendChild(Fp);
		Fp.appendChild(Djh);
		Fp.appendChild(Gfmc);
		Fp.appendChild(Gfsh);
		Fp.appendChild(Gfyhzh);
		Fp.appendChild(Gfdzdh);
		Fp.appendChild(Bz);
		Fp.appendChild(Fhr);
		Fp.appendChild(Skr);
		Fp.appendChild(Spbmbbh);
		Fp.appendChild(Hsbz);
		Fp.appendChild(Spxx);
		Spxx.appendChild(Sph);
		Sph.appendChild(Xh);
		Sph.appendChild(Spmc);
		Sph.appendChild(Ggxh);
		Sph.appendChild(Jldw);
		Sph.appendChild(Spbm);
		Sph.appendChild(Qyspbm);
		Sph.appendChild(Syyhzcbz);
		Sph.appendChild(Lslbz);
		Sph.appendChild(Yhzcsm);
		Sph.appendChild(Dj);
		Sph.appendChild(Sl);
		Sph.appendChild(Je);
		Sph.appendChild(Slv);
		Sph.appendChild(Kce);
		Version.setTextContent("2.0");
		document.appendChild(kp);
		/*
		 * 
		 * // 不显示内容 name.setNodeValue("不好使");
		 
		Version.setTextContent("");
		book.appendChild(name);
		// 为book节点添加属性
		book.setAttribute("id", "1");
		// 将book节点添加到bookstore根节点中
		bookstore.appendChild(book);
		// 将bookstore节点（已包含book）添加到dom树中
		document.appendChild(bookstore);
		*/
		TransformerFactory tff = TransformerFactory.newInstance();
		// 创建 Transformer对象
		Transformer tf = tff.newTransformer();
		// 输出内容是否使用换行
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		// 创建xml文件并写入内容
		tf.transform(new DOMSource(document), new StreamResult(new File("E://book1.xml")));
		System.out.println("生成book1.xml成功");
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
