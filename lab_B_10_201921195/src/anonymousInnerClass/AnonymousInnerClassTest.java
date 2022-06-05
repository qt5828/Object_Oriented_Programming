package anonymousInnerClass;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import innerClass.TalkingClock;

public class AnonymousInnerClassTest {
	public static void main(String[] args) {
		TalkingClock3 clock = new TalkingClock3();
		clock.start(1000,true);
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
