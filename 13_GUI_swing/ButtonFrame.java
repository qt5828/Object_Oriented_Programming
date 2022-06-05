package lab_b_13_201921195;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//creat buttons
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		buttonPanel = new JPanel();
		//add buttons to panel
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		//add panel to frame
		add(buttonPanel);

		//associate actions with buttons
		yellowButton.addActionListener(event->buttonPanel.setBackground(Color.YELLOW));
		blueButton.addActionListener(event->buttonPanel.setBackground(Color.BLUE));
		redButton.addActionListener(event->buttonPanel.setBackground(Color.red));
	}

}
