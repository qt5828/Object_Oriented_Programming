import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

//�Ѽ��Ժ��⸦ ���� Frame
public class AllCostFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	public AllCostFrame() {
		
		Dimension dim = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPreferredSize(dim);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�� ������ �˾����� ǥ��
		JOptionPane ans = new JOptionPane();
		ans.showMessageDialog(null,"�� ������ "+ParkingProgram.COST+"�� �Դϴ�.");
		
		setVisible(false);
		new ParkingFrame();
	}
}
