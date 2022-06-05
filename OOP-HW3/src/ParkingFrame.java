import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;

import javax.swing.*;

//������ ���α׷�
public class ParkingFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JLabel label;
	private JTextField volume;
	private ButtonGroup group;
	private JPanel buttonPanel;

	
	public ParkingFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setVisible(true);
		
		//creat buttons
		JButton in = new JButton("����");
		JButton out = new JButton("����");
		JButton parkingList = new JButton("�������� ����");
		JButton allCost = new JButton("�� ���� ����");
		JButton exit = new JButton("����");
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1));
		//add buttons to panel
		buttonPanel.add(in);
		buttonPanel.add(out);
		buttonPanel.add(parkingList);
		buttonPanel.add(allCost);
		buttonPanel.add(exit);
		
		//add panel to frame
		add(buttonPanel);
		
		//create button actions
		
		//������ư Ŭ����
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				UNVISIBLE();
				new InFrame();
				}
		});
		
		//������ư Ŭ����
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				UNVISIBLE();
				new OutFrame();
				}
		});
		
		//������������ Ŭ����
		parkingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				UNVISIBLE();
				new ParkingListFrame();
				}
		});
		
		//�Ѽ��Ժ��� Ŭ����
		allCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				UNVISIBLE();
				new AllCostFrame();
				}
		});
		
		//���� Ŭ����
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				JOptionPane ans = new JOptionPane();
				ans.showMessageDialog(null,"���α׷��� �����մϴ�.");
				setVisible(false);
				System.exit(1);
			 }
		});
	}
	
	//Frame�� ������ �ʰ� ����
	public void UNVISIBLE() {		
		this.setVisible(false);

	}
	
	
}