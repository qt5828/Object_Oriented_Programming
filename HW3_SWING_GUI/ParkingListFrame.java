import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

//주차차량보기를 위한 Frame
public class ParkingListFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;


	public ParkingListFrame() {
		
		Dimension dim = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPreferredSize(dim);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		//주차차량이 없을때
		if (ParkingProgram.count==0) {
			JOptionPane ans = new JOptionPane();
			ans.showMessageDialog(null,"주차된 차량이 없습니다.");
			setVisible(false);
			new ParkingFrame();
		}
		
		int a=0,b=0,c=0;
		Bus[] bus = new Bus[ParkingProgram.getSize()];
		Truck[] truck = new Truck[ParkingProgram.getSize()];
		Normal[] normal = new Normal[ParkingProgram.getSize()];
		
		for(int i=0;i<ParkingProgram.getSize();i++) {
			bus[i]=new Bus();
			truck[i]=new Truck();
			normal[i]=new Normal();
		}
			
		//Cars에 들어있는 차량 정보를 각각 차량 종류에 따라 분류해서 배열에 저장
		for(Car car : ParkingProgram.Cars) {
			if(car.getNow()) {
				if(car instanceof Bus)
					bus[a++]=(Bus)car;
				if(car instanceof Truck)
					truck[b++]=(Truck)car;
				if(car instanceof Normal)
					normal[c++]=(Normal)car;
			}
		}
		
		//입차시간 순서별로 sorting, bubble sort algorithm 사용
		int i,j;
		Car temp;
		for(i=0;bus[i].getNow();i++)
			for(j=0;bus[j+1].getNow();j++)
				if(ParkingProgram.compare(bus[j],bus[j+1])==1) {
					temp=bus[j]; bus[j]=bus[j+1]; bus[j+1]=(Bus)temp;
				}
		for(i=0;truck[i].getNow();i++)
			for(j=0;truck[j+1].getNow();j++)
				if(ParkingProgram.compare(truck[j],truck[j+1])==1) {
					temp=truck[j]; truck[j]=truck[j+1]; truck[j+1]=(Truck)temp;
				}
		for(i=0;normal[i].getNow();i++)
			for(j=0;normal[j+1].getNow();j++)
				if(ParkingProgram.compare(normal[j],normal[j+1])==1) {
					temp=normal[j]; normal[j]=normal[j+1]; normal[j+1]=(Normal)temp;
				}
		
		//주차차량정보를 담을 panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ParkingProgram.count,1));
		
		//출력
		for(i=0;normal[i].getNow();i++) {
			String s = "승용차 "+normal[i].getNum()+" "+normal[i].getIn().getYear()+"/"+normal[i].getIn().getMonth()+"/"+normal[i].getIn().getDay()+" "+normal[i].getIn().getHour()+":"+normal[i].getIn().getMin()+"\n";
			panel.add(new JLabel(s));
		}
		for(i=0;bus[i].getNow();i++) {
			String s = "버스 "+bus[i].getNum()+" "+bus[i].getIn().getYear()+"/"+bus[i].getIn().getMonth()+"/"+bus[i].getIn().getDay()+" "+bus[i].getIn().getHour()+":"+bus[i].getIn().getMin()+"\n";
			panel.add(new JLabel(s));
		}
		for(i=0;truck[i].getNow();i++) {
			String s = "트럭 "+truck[i].getNum()+" "+truck[i].getIn().getYear()+"/"+truck[i].getIn().getMonth()+"/"+truck[i].getIn().getDay()+" "+truck[i].getIn().getHour()+":"+truck[i].getIn().getMin()+"\n";
			panel.add(new JLabel(s));
		}
		
		add(panel, BorderLayout.CENTER);
	
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("확인");
		southPanel.add(insertButton); 
		add(southPanel, BorderLayout.SOUTH);
		pack();
		insertButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				new ParkingFrame();
			}
		});
		
		
	}
}