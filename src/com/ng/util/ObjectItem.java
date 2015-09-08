package com.ng.util;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.io.*;

public class ObjectItem {

	// Document可以看作是XML在内存中的一个镜像,那么一旦获取这个Document 就意味着可以通过对

	// 内存的操作来实现对XML的操作,首先第一步获取XML相关的Document

	private Document doc = null;

	public void init(String map_url) throws Exception {

		// 很明显该类是一个单例,先获取产生DocumentBuilder工厂

		// 的工厂,在通过这个工厂产生一个DocumentBuilder,

		// DocumentBuilder就是用来产生Document的

		String xmlFile = map_url;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		// 这个Document就是一个XML文件在内存中的镜像

		doc = db.parse(new File(xmlFile));

	}

	// 该方法负责把XML文件的内容显示出来

	public Leaf viewXML(String node, String map_url) throws Exception {
		
		String propertyName = "propertyName";

		String propertyNameValue;

		String value;

		Leaf leaf;

		this.init(map_url);

		// 在xml文件里,只有一个根元素,先把根元素拿出来看看

		Element element = doc.getDocumentElement();

		System.out.println("根元素为:" + element.getTagName());

		NodeList nodeList = doc.getElementsByTagName(node);

		System.out.println("节点链的长度:" + nodeList.getLength());

		Node fatherNode = nodeList.item(0);

		System.out.println("父节点为:" + fatherNode.getNodeName());

		// 把父节点的属性拿出来

		NamedNodeMap attributes = fatherNode.getAttributes();

		propertyNameValue = attributes.getNamedItem(propertyName).getNodeValue();

		value = attributes.getNamedItem(propertyNameValue).getNodeValue();

		leaf = new Leaf(node, propertyNameValue, value);

		return leaf;

	}

}

/**
 * xml节点数据结构
 */
class Leaf {
	// 节点名称
	private String node;
	
	//节点属性
	private String propertyNameValue;	

	// 节点值
	private String value;
	


	public Leaf(String node, String propertyNameValue, String value) {
		this.node = node;
		this.propertyNameValue = propertyNameValue;
		this.value = value;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	
	public String getPropertyNameValue() {
		return propertyNameValue;
	}

	public void setPropertyNameValue(String propertyNameValue) {
		this.propertyNameValue = propertyNameValue;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}
