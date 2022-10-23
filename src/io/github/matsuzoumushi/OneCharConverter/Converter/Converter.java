package io.github.matsuzoumushi.OneCharConverter.Converter;

public class Converter {
	private String inputListName = "";
	private String beforeStr = "";
	private StringBuffer afterStr = new StringBuffer();
	private ReadXml xml;
	public String getInputListName() {
		return inputListName;
	}
	public void setInputListName(String inputListName) {
		this.inputListName = inputListName;
	}
	public ReadXml getXml() {
		return xml;
	}
	public void setXml(ReadXml xml) {
		this.xml = xml;
	}
	public String getBeforeStr() {
		return beforeStr;
	}
	public void setBeforeStr(String beforeStr) {
		this.beforeStr = beforeStr;
	}
	public String getAfterStr() {
		return afterStr.toString();
	}
	public void setAfterStr(String afterStr) {
		this.afterStr.append(afterStr);
	}

	public void convert() {

		char[] CharArray = beforeStr.toCharArray();
		String result;
		try {
			xml.SearchListName(inputListName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(char chr : CharArray) {
			result = xml.SearchCorrespondenceCharacter(chr);
			afterStr.append(result) ;
		}

	}

}
