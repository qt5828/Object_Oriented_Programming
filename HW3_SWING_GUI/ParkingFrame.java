import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;

import javax.swing.*;

//주차장 프로그램
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
		JButton in = new JButton("입차");
		JButton out = new JButton("출차");
		JButton parkingList = new JButton("주차차량 보기");
		JButton allCost = new JButton("총 수입 보기");
		JButton exit = new JButton("종료");
		
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
		
		//입차버튼 클릭시
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				UNVISIBLE();
				new InFrame();
				}
		});
		
		//출차버튼 클릭시
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				UNVISIBLE();
				new OutFrame();
				}
		});
		
		//주차차량보기 클릭시
		parkingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				UNVISIBLE();
				new ParkingListFrame();
				}
		});
		
		//총수입보기 클릭시
		allCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				UNVISIBLE();
				new AllCostFrame();
				}
		});
		
		//종료 클릭시
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				JOptionPane ans = new JOptionPane();
				ans.showMessageDialog(null,"프로그램을 종료합니다.");
				setVisible(false);
				System.exit(1);
			 }
		});
	}
	
	//Frame을 보이지 않게 설정
	public void UNVISIBLE() {		
		this.setVisible(false);

	}
	
	
}