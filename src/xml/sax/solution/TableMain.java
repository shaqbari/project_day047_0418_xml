/*파싱에 대한 이해를 높이기 위해 jtable에 파싱한 결과를 반영해보자!*/
package xml.sax.solution;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class TableMain extends JFrame{
	JButton bt;
	JTable table;
	JScrollPane scroll;
	
	MyModel model;	
	SAXParserFactory factory;
	SAXParser parser;
	Handler handler;
	String path="E:/git/java_workspace3/project_day047_0418_xml/data/member.xml";
		
	public TableMain() {
		bt=new JButton("xml로드");
		table=new JTable();
		scroll=new JScrollPane(table);
		
		add(bt, BorderLayout.NORTH);
		add(scroll);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadXML();
			}
		});
		
		setSize(500, 300);
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public void loadXML(){
		model=new MyModel();
		factory=SAXParserFactory.newInstance(); //일종의 싱글톤 패턴
		
		try {
			parser=factory.newSAXParser();
			parser.parse(new File(path), handler=new Handler(model));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		table.setModel(model);
		table.updateUI();
	}
	
	public static void main(String[] args) {
		new TableMain();
	}
}
