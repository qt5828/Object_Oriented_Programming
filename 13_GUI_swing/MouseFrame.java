package lab_b_13_201921195;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class MouseFrame extends JFrame {
	
	public MouseFrame()
	{
		JButton removeButton = new JButton("remove all");
		add(removeButton, BorderLayout.SOUTH);
		MouseComponent MouseComp = new MouseComponent();
		add(MouseComp);
		removeButton.addActionListener(event->MouseComp.removeall());
		pack();
	}
}
