package innerClass;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000,true);
		
		TalkingClock.TimePrinter listener = clock.new TimePrinter();
		clock.start(listener);
		
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
	}
}
