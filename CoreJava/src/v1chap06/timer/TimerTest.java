package v1chap06.timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


/**
 * @version 1.0 2019-01-10
 * @author Code
 *
 */
public class TimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListener listener = new TimePrinter();
		
		//construct a timer that calls the listener once every 10 seconds
		Timer t = new Timer(10000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TimePrinter implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		System.out.println("At the time is " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}
