package xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MyModel extends AbstractTableModel{
	Vector<String> colName=new Vector<String>();
	Vector<Vector> data=new Vector<Vector>();
	
	MyHandler handler;
	SAXParserFactory factory;
	SAXParser parser;
	String path="E:/git/java_workspace3/project_day047_0418_xml/data/member.xml";
	
	public MyModel() {
		colName.addElement("이름");
		colName.addElement("나이");
		colName.addElement("성별");
		
		handler=new MyHandler(this);		
		try {
			factory=SAXParserFactory.newInstance();
			parser=factory.newSAXParser();
			parser.parse(new File(path), handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getColumnName(int column) {
		return colName.get(column);
	}
	
	public int getColumnCount() {
		return colName.size();
	}

	public int getRowCount() {
		return data.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}
	
}
