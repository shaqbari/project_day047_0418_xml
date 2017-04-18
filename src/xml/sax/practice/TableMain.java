/*파싱에 대한 이해를 높이기 위해 jtable에 파싱한 결과를 반영해보자!*/
package xml.sax.practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableMain extends JFrame{
	JButton bt;
	JTable table;
	JScrollPane scroll;
	MyModel model;
		
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
		table.setModel(model=new MyModel());
		table.updateUI();
	}
	
	public static void main(String[] args) {
		new TableMain();
	}
}
