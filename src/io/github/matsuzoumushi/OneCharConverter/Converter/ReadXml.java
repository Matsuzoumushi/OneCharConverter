package io.github.matsuzoumushi.OneCharConverter.Converter;


import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ReadXml {

	private SAXReader reader = new SAXReader();
	private Document doc; //All information from XML
	private List<Node> nodes; //nodes extracted by ListName from XML
	private Node Target; //node extracted by char from nodes
	private String ret = "";

	//constructor
	public ReadXml(String path) throws IOException {
		try {

			doc = reader.read(path);

		} catch (DocumentException e) {

			e.printStackTrace();

		}

	}

	//extract nodes from XML by List Name
	public void SearchListName(String ListName) {
		try {
			nodes = doc.selectNodes("/correspondenceList/List[@name='"+ ListName +"']");

			if(nodes.isEmpty()) {
				System.out.println("ListNameが存在しません。(ListName does not exist.)");;
			}

		}catch(Throwable e){
			e.printStackTrace();
			System.out.println("ListNameの検索に失敗しました。(failed to search ListName)");
			throw e;}
	}

	//extract node from nodes by character
	public String SearchCorrespondenceCharacter(char character) {
		try {

			Target = doc.selectSingleNode("/correspondenceList/List/character[@char='"+ character +"']/correspondence");

			try {
				ret = Target.getText();
				ret = ret.substring(1, ret.length()-1);
			}catch(NullPointerException e){
				ret = String.valueOf(character);
			}

			return ret;
		}catch(Throwable e){
			e.printStackTrace();
			System.out.println("characterの検索に失敗しました。(failed to search character)");
			throw e;}
	}


}
