package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TalkingClock3 {
	public void start(int interval, boolean beep)
	{
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("At the tone, the time is "+ new Date());
				if(beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer t = new Timer(interval, event-> 
				{ 	System.out.println("At the tone, the time is "+ new Date());
					if(beep) Toolkit.getDefaultToolkit().beep();
				});
		t.start();
	}
}
