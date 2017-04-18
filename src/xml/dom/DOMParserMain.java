/*xml문서가 로드될때마다, 태그와 1:1대응되는 DOM객체를 메모리에 올리는 방식으로,
 * 스마트폰 개발에 있어서는 메모리 문제상 피하는 것이 좋다.*/

package xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParserMain {
		
	public static void main(String[] args) {
		DocumentBuilderFactory factory=null;
		DocumentBuilder builder=null;
		String path="E:/git/java_workspace3/project_day047_0418_xml/data/member.xml";
		
		factory=DocumentBuilderFactory.newInstance();
		try {
			builder=factory.newDocumentBuilder();
			Document doc=builder.parse(new File(path));

			//node는 태그뿐만아니라 아이디, 속성, 문서등 모든것을 지정한다.
			NodeList nList=doc.getElementsByTagName("members");
			System.out.println(nList.getLength());
			
			NodeList nList2=doc.getChildNodes(); //doc의 주체는 문서 전체이기 때문에 getChildNodes를 하게되면 members하나만 인식한다. 주체를members로 하게되면 member인 2개가 나온다.
			System.out.println(nList2.getLength());
			
			NodeList member=doc.getElementsByTagName("member");
			System.out.println(member.getLength());
			
			Node[] memberChilds=new Node[member.getLength()];
			
			for (int i = 0; i < member.getLength(); i++) {
				memberChilds[i]=member.item(i);				
				System.out.println(memberChilds[i]);
			}
			
			NodeList name=doc.getElementsByTagName("name");
			System.out.println(name.getLength());
			Node[] nameChilds=new Node[name.getLength()];
			for (int i = 0; i < name.getLength(); i++) {
				nameChilds[i]=name.item(i);				
				System.out.println(nameChilds[i]);
			}
			
			System.out.println(nameChilds[0].getNodeName());
			System.out.println(nameChilds[0].getNodeValue());
			System.out.println(nameChilds[0].getTextContent());
			
	
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
