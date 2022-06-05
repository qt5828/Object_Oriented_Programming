package lab_b_13_201921195;

import java.awt.*;
import javax.swing.*;

public class ButtonTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(()->{
			JFrame frame = new ButtonFrame();
			frame.setTitle("ButtonTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
