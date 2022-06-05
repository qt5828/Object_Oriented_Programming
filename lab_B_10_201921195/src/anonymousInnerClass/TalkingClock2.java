package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

class TalkingClock2 {
	
	public void start(int interval, final boolean beep) 
	{
		class TimePrinter implements ActionListener{
			public void actionPerformed(ActionEvent event){
				System.out.println("At the tone, the time is "+new Date());
				if(beep)Toolkit.getDefaultToolkit().beep();
			}
		}
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
}


