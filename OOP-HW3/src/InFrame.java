import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

//�������� ������
public class InFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	//�¿���, Ʈ��, ���� ���� ���� JRadioButton
	private JRadioButton Rad1;
	private JRadioButton Rad2;
	private JRadioButton Rad3;
	private JPanel buttonPanel;
	
	//�����ð��������� JComboBox
	private JComboBox<Integer> Combo1;
	private JComboBox<Integer> Combo2;
	private JComboBox<Integer> Combo3;
	private JComboBox<Integer> Combo4;
	private JComboBox<Integer> Combo5;
	
	private String name; //��������
	private int n;  //�����뷮
	private int num; //������ȣ
	private int y; private int m; private int d; private int h; private int mm; //�����ð�����
	
	public InFrame() {
		
		//�����϶� �˾�
		if (ParkingProgram.count>ParkingProgram.getSize()) {
			JOptionPane war = new JOptionPane();
			war.showMessageDialog(null,"�������� ��á���ϴ�.");
			setVisible(false);
			new ParkingFrame();
		}
		//�������� �� ����
		ParkingProgram.count++;
		
		setTitle("������ ������ ������ �뷮, �����ð��� ������ּ���!");
		Dimension dim = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPreferredSize(dim);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(3,2));
		
		//add the radio buttons
		buttonPanel = new JPanel();
		
		Rad1=new JRadioButton("�¿���");
		Rad2=new JRadioButton("Ʈ��");
		Rad3=new JRadioButton("����");
		buttonPanel.add(Rad1);
		buttonPanel.add(Rad2);
		buttonPanel.add(Rad3);
		
		add(buttonPanel,BorderLayout.CENTER);
		pack();
		
		//���� ��,��,��,��,��
		Combo1 = new JComboBox<>();
		Combo2 = new JComboBox<>();
		Combo3 = new JComboBox<>();
		Combo4 = new JComboBox<>();
		Combo5 = new JComboBox<>();
		for(int i=2010;i<2021;i++)
			Combo1.addItem(i);
		for(int i=1;i<13;i++)
			Combo2.addItem(i);
		for(int i=1;i<32;i++)
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
		
		JTextField textField1 = new JTextField(20);
		JTextField textField2 = new JTextField(20);
			
		JPanel Panel = new JPanel();
		Panel.add(new JLabel("���� �뷮: ",SwingConstants.CENTER));
		Panel.add(textField1);
		add(Panel, BorderLayout.CENTER);
		
		JPanel Panel2 = new JPanel();
		Panel2.add(new JLabel("������ȣ: ",SwingConstants.CENTER));
		Panel2.add(textField2);
		add(Panel2,BorderLayout.CENTER);
		
	
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("���");
		southPanel.add(insertButton); 
		add(southPanel, BorderLayout.SOUTH);
		pack();
		insertButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				int idx=ParkingProgram.check();
				setN(Integer.parseInt(textField1.getText()));
				setNum(Integer.parseInt(textField2.getText()));
				setTime((int)Combo1.getSelectedItem(),(int)Combo2.getSelectedItem(),(int)Combo3.getSelectedItem(),(int)Combo4.getSelectedItem(),(int)Combo5.getSelectedItem());
				Time in = new Time(y,m,d,h,mm);
				
				boolean TF=Time.isValid(y, m, d, h, mm);
				//�Է¹��� �ð��� ���� ��ȿ�� üũ
				if(!TF) {
					JOptionPane ans = new JOptionPane();
					ans.showMessageDialog(null,"��ȿ���� ���� ��¥�� �ԷµǾ����ϴ�. \nó������ ���ư��ϴ�.");
					setVisible(false);
					new ParkingFrame();
					return;
				}
				
				if(Rad1.isSelected()) {
					setName("c");
					if(n==0)
						ParkingProgram.Cars[idx]=new Normal(num, in);
					else
						ParkingProgram.Cars[idx]=new Electric(num,in,n);
					setVisible(false);
					new ParkingFrame();
				}
				else if(Rad2.isSelected()) {
					setName("t");
					if(n>=10) 
						ParkingProgram.Cars[idx]=new TruckL(num,in);
					else if(n<10 && n>=5) 
						ParkingProgram.Cars[idx]=new TruckM(num,in);				
					else 
						ParkingProgram.Cars[idx]=new TruckS(num,in);
					setVisible(false);
					new ParkingFrame();
				}
				else {
					setName("b");
					if(n>=40)
						ParkingProgram.Cars[idx]=new BusL(num,in);
					else if(n<40 && n>=24)
						ParkingProgram.Cars[idx]=new BusM(num,in);
					else
						ParkingProgram.Cars[idx]=new BusS(num,in);
					setVisible(false);
					new ParkingFrame();
				}
			JOptionPane ans = new JOptionPane();
			ans.showMessageDialog(null,"��ϵǾ����ϴ�.");
			}
		});
		
	}
	
	public void setName(String nn)
	{
		name=nn;
	}
	public void setN(int nn)
	{
		n=nn;
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
	public String getName() { return name; }
	public int getNum() { return num; }
	public int getN() { return n; }
	public int getYear() { return y; }
	public int getMonth() { return m; }
	public int getDay() { return d; }
	public int getHour() { return h; }
	public int getMin() { return mm; }
}