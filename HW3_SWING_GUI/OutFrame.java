import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JOptionPane;

//출차 위한 Frame
public class OutFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	//출차시간설정위한 JComboBox
	private JComboBox<Integer> Combo1;
	private JComboBox<Integer> Combo2;
	private JComboBox<Integer> Combo3;
	private JComboBox<Integer> Combo4;
	private JComboBox<Integer> Combo5;

	private int num; //차량번호
	private int y; private int m; private int d; private int h; private int mm; //출차시간정보
	
	public OutFrame() {
		
		setTitle("출차할 차량의 차량번호와 출차시간을 입력해주세요!");
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
		Panel3.add(new JLabel("출차시간: ",SwingConstants.CENTER));
		Panel3.add(Combo1);
		Panel3.add(Combo2);
		Panel3.add(Combo3);
		Panel3.add(Combo4);
		Panel3.add(Combo5);
		add(Panel3,BorderLayout.CENTER);
		pack();
		
		JTextField textField = new JTextField(20);
		
		JPanel Panel = new JPanel();
		Panel.add(new JLabel("차량번호: ",SwingConstants.CENTER));
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
				
				//출차차량번호가 차량목록에 존재하는지 체크
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
					
					//입차되어있지 않은 차량번호를 입력했을 경우
					JOptionPane ans = new JOptionPane();
					ans.showMessageDialog(null,"존재하지 않는 차량번호입니다. \n처음으로 돌아갑니다.");
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
						
						//입력받은 시간에 대한 유효성 체크
						if(!TF) {
							JOptionPane ans = new JOptionPane();
							ans.showMessageDialog(null,"유효하지 않는 시간(날짜)를 입력하였습니다. \n처음으로 돌아갑니다.");
							setVisible(false);
							new ParkingFrame();
							return;
						}
						
						//입차시간과 출차시간에 대한 유효성 체크
						boolean TF2=Time.isValid2(car.getIn(), car.getOut());
						if(!TF2) {
							JOptionPane ans = new JOptionPane();
							ans.showMessageDialog(null,"출차시간이 입차시간보다 빠릅니다. \n처음으로 돌아갑니다.");
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
				//총요금 증가
				ParkingProgram.COST+=cost;
				
				String t = "주차시간은 "+min/60+"시간 "+min%60+"분입니다.";
				String c = "주차요금은 "+cost+"원입니다.";
				
				//팝업
				JOptionPane ans = new JOptionPane();
				ans.showMessageDialog(null,t+"\n"+c);
				
				//주차차량수 감소
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