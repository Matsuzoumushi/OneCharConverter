package io.github.matsuzoumushi.OneCharConverter.Converter;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.dom4j.XPathException;

public class Main {

	static String inputListName="";
	static String beforeStr="";
	static String afterStr="";


	public static void main(String[] args) {



		int ret = 0;

		try {
			//CorrespondenceList.propertiesを読み込む。(to load property file)
			ResourceBundle rb = ResourceBundle.getBundle("OneCharConverter");

			//CorrespondenceList.xmlを読み込む。(to load property file)
			ReadXml xml = new ReadXml(rb.getString("CorrespondenceList"));

			//コンソールから使用するListNameと変換したい文字列を入力する。(type the ListName and the string to convert with console)
			scanner();

			//converterに読み込んだXMLと入力情報を渡す。(Pass the loaded XML and input information to converter)
			Converter conv = new Converter();

			conv.setXml(xml);
			conv.setInputListName(inputListName);
			conv.setBeforeStr(beforeStr);

			//convert
			conv.convert();

			//Get the converted string
			afterStr = conv.getAfterStr();

			System.out.println(afterStr);
			System.exit(ret);

		}catch(IOException  e) {

			System.out.println("\"CorrespondenceList.xml\"の読み込みに失敗しました。(Failed to load \"CorrespondenceList.xml\")");
			System.out.println(e.getMessage());
			ret = 8;

		}catch(MissingResourceException  e) {
			System.out.println("\"CorrespondenceList.properties\"の読み込みに失敗しました。(Failed to load property file");
			System.out.println(e.getMessage());
			ret = 8;
		}catch(XPathException e){
			e.printStackTrace();
			ret = 8;
		}catch(Throwable e){
			e.printStackTrace();
			ret = 8;
		}

		finally {
			System.exit(ret);
		}
	}

	public static void scanner() {
		Scanner scan = new Scanner(System.in);

		while(inputListName.length() == 0) {
			System.out.println("\"CorrespondenceList.xml\"の中から使用したいListNameを入力してください。(Type ListName you wamt to use \"from CorrespondenceList.xml\".)");
			inputListName = scan.nextLine();
		}

		while(beforeStr.length() == 0) {
			System.out.println("変換したい文字列を入力してください。(Type string you want to convert)");
			beforeStr = scan.nextLine();
		}

		scan.close();

	}


}
