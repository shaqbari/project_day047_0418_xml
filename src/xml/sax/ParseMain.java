/*xml�� �Ľ��ϴ� ������� ũ�� 2������ �ִ�.
 * 1. SAX�Ľ�
 * 	-xml�� �̷�� �±װ� �߰ߵɶ����� ������ �̺�Ʈ�� �߻������ֱ� ������,
 * �����ڰ� ������ Ÿ�ֿ̹� ���� �����͸� �ؼ��ϴ� ���* 
 * �޸𸮻󿡼� �ξ� ȿ����
 * 
 * 2. DOM(Document Object Model)�Ľ�
 * 		SGML���� �¾ HTML, XML�� ���α׷��� �ƴϱ� ������,
 * 		JS, JAVA�� �Ϲ��� ���α׷��־��� ������ �����Ϸ���,
 * 		���α׷��� ���� ������ �� �ִ� �������� �����ؾ� �Ѵ�.
 * 		�̿� ���� HTML�̳� ������ �� �� �±� ��Ҹ��� 1:1�����ϴ� ��ü��
 * 		�޸𸮿� �÷� ������ �� �ֵ��� �����Ǵ� API������ ��Ʋ�� DOM�̶� �Ѵ�.
 * 
 * 		�ᱹ ���ڹ����� ���α׷����� �����Ϸ��� ��üȭ(����, �޼ҵ�)�Ǿ� �־�� �Ѵ�.
 * 		
 * 		Ư�� ����Ʈ���� ���� ���� �ܸ���� �޸𸮰� ������ �����ϹǷ�,
 * 		�޸� ȿ������ ���ؼ��� DOM���ٴ� SAX����� �е������� ���� ���δ�.
 * 		DOM�� ���̱� ������ ���ΰ�ħ�Ҷ����� ���̴µ�
 * 		����ũž������ ��������, ����Ʈ������� ���̱� ������ ���� ����.		
 * 
 * 		����Ʈ���� ����Ŭ�� ���������� ������ �� ����, �߰��� ����Ŭ�� ������ �� �ִ�
 * ���� ���ø����̼��� �����ؾ� �Ѵ�. ����Ʈ���� ������ �̱����� �����̹Ƿ� XML�̳�
 * JSON�� �̿��ؾ� �Ѵ�. �̶� XML�� DOM����� �ʹ� ���̴�.
 * */

package xml.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseMain {

	public static void main(String[] args) {
		//�ڹپ��� SAX����� �Ľ��� �õ��Ϸ��� SAXParser�� �ʿ��ϴ�.
		//javaSE�� �ļ��� ���ԵǾ� �ִ�. �������� xml�� ���ø����̼� ���߽� ���� ���δ�.
		
		//�߻�Ŭ������ �ν��Ͻ� �� �����
		//���� ���丮 ��ü�� ���� �ν��Ͻ��� ���;� �Ѵ�. api������ factory instance���̸� �ǽ��غ���
		//���� ������ ���� api������ tutorial�� �ִ��� Ȯ���غ���.
		SAXParserFactory factory=null;
		factory=SAXParserFactory.newInstance();
		String path="E:/git/java_workspace3/project_day047_0418_xml/data/member.xml";
		try {
			SAXParser parser=factory.newSAXParser();
			parser.parse(new File(path), new MyHandler(new MyModel()));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
