/*xml������ �ε�ɶ�����, �±׿� 1:1�����Ǵ� DOM��ü�� �޸𸮿� �ø��� �������,
 * ����Ʈ�� ���߿� �־�� �޸� ������ ���ϴ� ���� ����.*/

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

			//node�� �±׻Ӹ��ƴ϶� ���̵�, �Ӽ�, ������ ������ �����Ѵ�.
			NodeList nList=doc.getElementsByTagName("members");
			System.out.println(nList.getLength());
			
			NodeList nList2=doc.getChildNodes(); //doc�� ��ü�� ���� ��ü�̱� ������ getChildNodes�� �ϰԵǸ� members�ϳ��� �ν��Ѵ�. ��ü��members�� �ϰԵǸ� member�� 2���� ���´�.
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
