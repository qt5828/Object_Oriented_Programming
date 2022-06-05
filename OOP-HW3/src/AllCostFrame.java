import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

//총수입보기를 위한 Frame
public class AllCostFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	public AllCostFrame() {
		
		Dimension dim = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPreferredSize(dim);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//총 수입을 팝업으로 표시
		JOptionPane ans = new JOptionPane();
		ans.showMessageDialog(null,"총 수입은 "+ParkingProgram.COST+"원 입니다.");
		
		setVisible(false);
		new ParkingFrame();
	}
}
