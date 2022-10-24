# OneCharConverter

・Abstract<br>
The typed string is converted to the corresponding other string.<br>
Character conversion correspondence table can be set in CorrespondenceList.xml.<br>
Multiple conversion correspondence tables can be prepared in advance in CorrespondenceList.xml.<br>
When using it, typing the List name attribute to decide which conversion correspondence table to use.<br>
As preparation, please change the description of the path of CorrespondenceList.xml in OneCharConverter.properties.<br>
And please load the two libraries (dom4j-2.1.3.jar,jaxen-1.1.6.jar).<br>

・処理内容<br>
入力した文字列を一文字ずつ解析して対応する他の文字に変換します。<br>
文字の変換対応表はCorrespondenceList.xml内で設定できます。<br>
CorrespondenceList.xmlには予め変換対応表を複数用意することができます。<br>
使用時にはList nameの属性を入力して、どの変換対応表を使用するか決めます。<br>
OneCharConverter.properties内にCorrespondenceList.xmlのパスを記載しjarと同じフォルダに配置する必要があります。<br>

・処理詳細<br>
入力されたList nameを元にCorrespondenceList.xml内を検索、使用する変換対応表を決定。
入力された文字列を一文字ずつ分割して変換対応表内を検索。<br>
属性:charが一致するものが見つかった場合は要素:correspondenceの値を戻す。<br>
見つからなかった場合は元の文字のまま。<br>
上記の各文字を結合しコンソールに表示する。<br>

・前提
（１）以下２ファイルのimportが必要になります。
・dom4j-2.1.3.jar
・jaxen-1.1.6.jar
（２）OneCharConverter.propertiesのCorrespondenceListの値は、
　　　CorrespondenceList.xmlを格納したパスに記載変更してください。

ex)<br>
java -jar .\OneCharConverter.jar<br>
"CorrespondenceList.xml"の中から使用したいListNameを入力してください。(Type ListName you wamt to use "from CorrespondenceList.xml".)<br>
test<br>
変換したい文字列を入力してください。(Type string you want to convert)<br>
aabbccdd<br>
１１２２３３dd<br>
