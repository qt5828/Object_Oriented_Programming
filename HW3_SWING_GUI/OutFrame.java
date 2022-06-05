import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JOptionPane;

//���� ���� Frame
public class OutFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	//�����ð��������� JComboBox
	private JComboBox<Integer> Combo1;
	private JComboBox<Integer> Combo2;
	private JComboBox<Integer> Combo3;
	private JComboBox<Integer> Combo4;
	private JComboBox<Integer> Combo5;

	private int num; //������ȣ
	private int y; private int m; private int d; private int h; private int mm; //�����ð�����
	
	public OutFrame() {
		
		setTitle("������ ������ ������ȣ�� �����ð��� �Է����ּ���!");
		Dimension dim = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPreferredSize(dim);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(3,1));
		
		Combo1 = new JComboBox<>();
		Combo2 = new JComboBox<>();
		Combo3 = new JComboBox<>();
		Combo4 = new JComboBox<>();
		Combo5 = new JComboBox<>();
		for(int i=2000;i<2021;i++)
			Combo1.addItem(i);
		for(int i=1;i<13;i++)
			Combo2.addItem(i);
		for(int i=1;i<31;i++)
			Combo3.addItem(i);
		for(int i=0;i<24;i++)
			Combo4.addItem(i);
		for(int i=0;i<61;i++)
			Combo5.addItem(i);
		
		JPanel Panel3 = new JPanel();
		Panel3.add(new JLabel("�����ð�: ",SwingConstants.CENTER));
		Panel3.add(Combo1);
		Panel3.add(Combo2);
		Panel3.add(Combo3);
		Panel3.add(Combo4);
		Panel3.add(Combo5);
		add(Panel3,BorderLayout.CENTER);
		pack();
		
		JTextField textField = new JTextField(20);
		
		JPanel Panel = new JPanel();
		Panel.add(new JLabel("������ȣ: ",SwingConstants.CENTER));
		Panel.add(textField);
		add(Panel,BorderLayout.CENTER);
		
	
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton); 
		add(southPanel, BorderLayout.SOUTH);
		pack();
		insertButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				int idx=ParkingProgram.check();
				setNum(Integer.parseInt(textField.getText()));
				setTime((int)Combo1.getSelectedItem(),(int)Combo2.getSelectedItem(),(int)Combo3.getSelectedItem(),(int)Combo4.getSelectedItem(),(int)Combo5.getSelectedItem());
				
				//����������ȣ�� ������Ͽ� �����ϴ��� üũ
				boolean Check=false;
				while(!Check) {
					int i=0;
					while(i<ParkingProgram.getSize()) {
						if(ParkingProgram.Cars[i].getNow()==true && ParkingProgram.Cars[i].getNum()==num) {
							Check=true;
							break;
						}
						i++;
					}
					if(Check)
						break;
					
					//�����Ǿ����� ���� ������ȣ�� �Է����� ���
					JOptionPane ans = new JOptionPane();
					ans.showMessageDialog(null,"�������� �ʴ� ������ȣ�Դϴ�. \nó������ ���ư��ϴ�.");
					setVisible(false);
					new ParkingFrame();
					return;
				}
				int cost=0, min=0;
				for(Car car : ParkingProgram.Cars)
				{
					if(car.getNum() == num) {
						car.setOut(y,m,d,h,mm);
						
						boolean TF=Time.isValid(y, m, d, h, mm);
						
						//�Է¹��� �ð��� ���� ��ȿ�� üũ
						if(!TF) {
							JOptionPane ans = new JOptionPane();
							ans.showMessageDialog(null,"��ȿ���� �ʴ� �ð�(��¥)�� �Է��Ͽ����ϴ�. \nó������ ���ư��ϴ�.");
							setVisible(false);
							new ParkingFrame();
							return;
						}
						
						//�����ð��� �����ð��� ���� ��ȿ�� üũ
						boolean TF2=Time.isValid2(car.getIn(), car.getOut());
						if(!TF2) {
							JOptionPane ans = new JOptionPane();
							ans.showMessageDialog(null,"�����ð��� �����ð����� �����ϴ�. \nó������ ���ư��ϴ�.");
							setVisible(false);
							new ParkingFrame();
							return;
						}
						car.outNow();
						cost=car.CalCost();
						min=car.getDuration();
						break;
						}
				}
				//�ѿ�� ����
				ParkingProgram.COST+=cost;
				
				String t = "�����ð��� "+min/60+"�ð� "+min%60+"���Դϴ�.";
				String c = "��������� "+cost+"���Դϴ�.";
				
				//�˾�
				JOptionPane ans = new JOptionPane();
				ans.showMessageDialog(null,t+"\n"+c);
				
				//���������� ����
				ParkingProgram.count--;
				
				setVisible(false);
				new ParkingFrame();
			}
		});
		
		
	}
	

	public void setNum(int nn)
	{
		num=nn;
	}
	public void setTime(int y, int m, int d, int h, int mm)
	{
		this.y=y;
		this.m=m;
		this.d=d;
		this.h=h;
		this.mm=mm;
	}

}