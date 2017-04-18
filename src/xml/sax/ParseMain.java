/*xml을 파싱하는 방법에는 크게 2가지가 있다.
 * 1. SAX파싱
 * 	-xml을 이루는 태그가 발견될때마다 적절한 이벤트를 발생시켜주기 때문에,
 * 개발자가 적절한 타이밍에 맞춰 데이터를 해석하는 방식* 
 * 메모리상에서 훨씬 효율적
 * 
 * 2. DOM(Document Object Model)파싱
 * 		SGML에서 태어난 HTML, XML은 프로그램언어가 아니기 때문에,
 * 		JS, JAVA등 일반적 프로그래밍언어에서 문서를 제어하려면,
 * 		프로그래밍 언어에서 이해할 수 있는 형식으로 존재해야 한다.
 * 		이에 따라 HTML이나 실행할 때 각 태그 요소마다 1:1대응하는 객체를
 * 		메모리에 올려 제어할 수 있도록 제공되는 API집합을 통틀어 DOM이라 한다.
 * 
 * 		결국 전자문서는 프로그램언어에서 제어하려면 객체화(변수, 메소드)되어 있어야 한다.
 * 		
 * 		특히 스마트폰과 같은 소형 단말기는 메모리가 언제나 부족하므로,
 * 		메모리 효율성을 위해서는 DOM보다는 SAX방식이 압도적으로 많이 쓰인다.
 * 		DOM은 무겁기 때문에 새로고침할때마다 쓰이는데
 * 		데스크탑에서는 괜찮지만, 스마트폰등에서는 버겁기 때문에 쓰지 말자.		
 * 
 * 		스마트폰은 오라클에 직접적으로 접근할 수 없고, 중간에 오라클에 접속할 수 있는
 * 서버 어플리케이션을 경유해야 한다. 스마트폰과 서버는 이기종간 접근이므로 XML이나
 * JSON을 이용해야 한다. 이때 XML의 DOM방식은 너무 무겁다.
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
		//자바언어로 SAX방식의 파싱을 시도하려면 SAXParser가 필요하다.
		//javaSE에 파서가 포함되어 있다. 그정도로 xml은 어플리케이션 개발시 많이 쓰인다.
		
		//추상클래스라서 인스턴스 못 만든다
		//따라서 팩토리 객체로 부터 인스턴스를 얻어와야 한다. api문서의 factory instance보이면 의심해보자
		//쓰기 어려우면 따로 api문서에 tutorial이 있는지 확인해보자.
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
