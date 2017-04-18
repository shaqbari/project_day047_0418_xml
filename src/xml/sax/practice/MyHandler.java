/*DOM����� �ļ��� ��ġ javascript���� DOM��ü �����ϵ���, 
 * �޸𸮿� �÷��� ��ü�� ���ϴ� id�� �±׸� �����ε� ���ϴ� ������ �ƹ����� ������ �� ������,
 * SAX����� �ļ��� �ڽ��� �ؼ��Ϸ��� xml������ �̷�� �±װ� �߰ߵɶ����� �̺�Ʈ�� ����Ű�� ������
 * �� �̺�Ʈ Ÿ�̹��� ��ġ��, xml��ҿ� ���� �� �� ����. ���� �� �̺�Ʈ�� �Ͼ ��
 * � ó���� ����� ������ �����ϴ� ��ü�� DefaultHandler��� Ŭ������ �������ش�.
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
		System.out.println("������ ���۵Ƴ׿�!!");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("<"+qName+">");
		
		if (qName=="member") {
			System.out.println("member�߰�");
		
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
	
	//�±׿��±� ������ �ؽ�Ʈ�� �߰ߵȸ� ȣ��ȴ�.
	public void characters(char[] ch, int start, int length) throws SAXException {
		count++;
		System.out.println("�ؽ�Ʈ�߰�!!"+"����:"+length+" �߰�Ƚ��"+count); //��, ���͵� ���̿� �߰�Ƚ���� ���Եȴ�.
		System.out.println(new String(ch, start, length)); //ch�迭�� ó������ ���̸�ŭ ������ش�.
		//����鿡���ؼ��� println�� �۵��Ѵ�.
		
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
		System.out.println("������ ���Դϴ�.");
	}
}
