package xml.sax.solution;

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
	
	public MyModel() {
		colName.addElement("이름");
		colName.addElement("나이");
		colName.addElement("성별");

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
