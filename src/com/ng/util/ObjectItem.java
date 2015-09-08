package com.ng.util;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.io.*;

public class ObjectItem {

	// Document���Կ�����XML���ڴ��е�һ������,��ôһ����ȡ���Document ����ζ�ſ���ͨ����

	// �ڴ�Ĳ�����ʵ�ֶ�XML�Ĳ���,���ȵ�һ����ȡXML��ص�Document

	private Document doc = null;

	public void init(String map_url) throws Exception {

		// �����Ը�����һ������,�Ȼ�ȡ����DocumentBuilder����

		// �Ĺ���,��ͨ�������������һ��DocumentBuilder,

		// DocumentBuilder������������Document��

		String xmlFile = map_url;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		// ���Document����һ��XML�ļ����ڴ��еľ���

		doc = db.parse(new File(xmlFile));

	}

	// �÷��������XML�ļ���������ʾ����

	public Leaf viewXML(String node, String map_url) throws Exception {
		
		String propertyName = "propertyName";

		String propertyNameValue;

		String value;

		Leaf leaf;

		this.init(map_url);

		// ��xml�ļ���,ֻ��һ����Ԫ��,�ȰѸ�Ԫ���ó�������

		Element element = doc.getDocumentElement();

		System.out.println("��Ԫ��Ϊ:" + element.getTagName());

		NodeList nodeList = doc.getElementsByTagName(node);

		System.out.println("�ڵ����ĳ���:" + nodeList.getLength());

		Node fatherNode = nodeList.item(0);

		System.out.println("���ڵ�Ϊ:" + fatherNode.getNodeName());

		// �Ѹ��ڵ�������ó���

		NamedNodeMap attributes = fatherNode.getAttributes();

		propertyNameValue = attributes.getNamedItem(propertyName).getNodeValue();

		value = attributes.getNamedItem(propertyNameValue).getNodeValue();

		leaf = new Leaf(node, propertyNameValue, value);

		return leaf;

	}

}

/**
 * xml�ڵ����ݽṹ
 */
class Leaf {
	// �ڵ�����
	private String node;
	
	//�ڵ�����
	private String propertyNameValue;	

	// �ڵ�ֵ
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
