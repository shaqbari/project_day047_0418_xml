/*DOM방식의 파서는 마치 javascript에서 DOM객체 접근하듯이, 
 * 메모리에 올려진 객체를 원하는 id나 태그명 만으로도 원하는 시점에 아무때나 접근할 수 있지만,
 * SAX방식의 파서는 자신이 해석하려는 xml파일을 이루는 태그가 발견될때마다 이벤트만 일으키기 때문에
 * 이 이벤트 타이밍을 놓치면, xml요소에 접근 할 수 없다. 따라서 이 이벤트가 일어날 때
 * 어떤 처리를 해줘야 할지를 관리하는 객체를 DefaultHandler라는 클래스로 제공해준다.
 * */

package xml.sax.practice;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	MyModel model;
	
	int count=0;
	
	Vector<Vector> data;
	Vector<String> vec;
	String colName;
	String name;
	String age; 
	String gender;
	
	public MyHandler(MyModel model) {
		this.model=model;
		this.data=model.data;
	}
	
	public void startDocument() throws SAXException {
		System.out.println("문서가 시작됐네요!!");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("<"+qName+">");
		
		if (qName=="member") {
			System.out.println("member발견");
		
			vec=new Vector<String>();
		}
	
		if (qName=="name") {
			colName="name";
		}
		if (qName=="age") {
			colName="age";
		}
		if (qName=="gender") {
			colName="gender";
		}
	}
	
	//태그와태그 사이의 텍스트가 발견된면 호출된다.
	public void characters(char[] ch, int start, int length) throws SAXException {
		count++;
		System.out.println("텍스트발견!!"+"길이:"+length+" 발견횟수"+count); //탭, 엔터도 길이와 발견횟수에 포함된다.
		System.out.println(new String(ch, start, length)); //ch배열의 처음부터 길이만큼 출력해준다.
		//공백들에대해서도 println이 작동한다.
		
		if (colName=="name") {
			name=new String(ch, start, length);
		}
		if (colName=="age") {
			age=new String(ch, start, length);
		}
		if (colName=="gender") {
			gender=new String(ch, start, length);
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
		
		if (qName=="name") {
			vec.add(name);
		}
		if (qName=="age") {
			vec.add(age);
		}
		if (qName=="gender") {
			vec.add(gender);
		}
		
		if (qName=="member") {
			data.addElement(vec);
		}
	}
	
	public void endDocument() throws SAXException {
		System.out.println("문서의 끝입니다.");
	}
}
