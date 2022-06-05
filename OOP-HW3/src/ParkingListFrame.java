import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

//�����������⸦ ���� Frame
public class ParkingListFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;


	public ParkingListFrame() {
		
		Dimension dim = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPreferredSize(dim);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		//���������� ������
		if (ParkingProgram.count==0) {
			JOptionPane ans = new JOptionPane();
			ans.showMessageDialog(null,"������ ������ �����ϴ�.");
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
			
		//Cars�� ����ִ� ���� ������ ���� ���� ������ ���� �з��ؼ� �迭�� ����
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
		
		//�����ð� �������� sorting, bubble sort algorithm ���
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
		
		//�������������� ���� panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ParkingProgram.count,1));
		
		//���
		for(i=0;normal[i].getNow();i++) {
			String s = "�¿��� "+normal[i].getNum()+" "+normal[i].getIn().getYear()+"/"+normal[i].getIn().getMonth()+"/"+normal[i].getIn().getDay()+" "+normal[i].getIn().getHour()+":"+normal[i].getIn().getMin()+"\n";
			panel.add(new JLabel(s));
		}
		for(i=0;bus[i].getNow();i++) {
			String s = "���� "+bus[i].getNum()+" "+bus[i].getIn().getYear()+"/"+bus[i].getIn().getMonth()+"/"+bus[i].getIn().getDay()+" "+bus[i].getIn().getHour()+":"+bus[i].getIn().getMin()+"\n";
			panel.add(new JLabel(s));
		}
		for(i=0;truck[i].getNow();i++) {
			String s = "Ʈ�� "+truck[i].getNum()+" "+truck[i].getIn().getYear()+"/"+truck[i].getIn().getMonth()+"/"+truck[i].getIn().getDay()+" "+truck[i].getIn().getHour()+":"+truck[i].getIn().getMin()+"\n";
			panel.add(new JLabel(s));
		}
		
		add(panel, BorderLayout.CENTER);
	
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Ȯ��");
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