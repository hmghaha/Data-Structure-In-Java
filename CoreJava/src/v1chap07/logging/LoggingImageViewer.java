package v1chap07.logging;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A modification of the image viewer program that logs various events.
 * @version 1.1 2019-01-13
 * @author Code
 *
 */

public class LoggingImageViewer {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.home")); //为了确认日志位置 C:\Users\Code
		// TODO Auto-generated method stub
		if(System.getProperty("java.util.logging.config.class") == null
				&& System.getProperty("java.util.loggingconfig.file") == null) {
			try {
				Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL); //建立该日志记录器，设置这个日志记录器的级别为ALL
				final int LOG_ROTATION_COUNT = 10;  //循环文件数量
				Handler handler = new FileHandler("%h/Javalog/LoggingImagerViewer.log", 0, LOG_ROTATION_COUNT);
				/*构造一个文件处理器  %h：系统属性user.home的值
				 * windowHandle 无需设置？ */
				Logger.getLogger("com.horstmann.corejava").addHandler(handler); //为日志记录器添加处理器
			}catch(IOException e) {
				Logger.getLogger("com.horstmann.core.java").log(Level.SEVERE, "Can't creat log file handler", e);
			}
		}
		
		EventQueue.invokeLater(() ->{
			Handler windowHandler = new WindowHandler(); //多态 WindowHandler <- StreamHandler <- Handler
			windowHandler.setLevel(Level.ALL);
			Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);
			
			JFrame frame = new ImageViewerFrame();
			frame.setTitle("LoggingImageViewer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
			frame.setVisible(true);
		});
	}

}

/**
 * The frame that shows the image
 */
class ImageViewerFrame extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	private JLabel label;
	private static Logger logger = Logger.getLogger("com.horstmann.corejava");
	
	public ImageViewerFrame() {
		logger.entering("ImageViewerFrame", "<init>"); //记录一个描述进入方法的日志记录
		logger.info("to test log info"); //will show in console
		logger.fine("to test log fine");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File"); //添加菜单
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListener());
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() { //匿名类
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logger.fine("Exiting.");
				System.exit(0);
			}
		});
		
		//use a label to display the image
		label = new JLabel();
		add(label);
		logger.exiting("ImageViewerFrame", "<init>"); //记录一个描述退出方法的日志记录
	}
	
	private class FileOpenListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			logger.entering("ImageViewerFram.FielOpenListener", "actionPerformed", event);
			
			//set up file chooser
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			//accept all file ending with .gif
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File f) {
					return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
				}
				
				public String getDescription() {
					return "GIF Images";
				}
			});
			//show file chooser dialog
			int r = chooser.showOpenDialog(ImageViewerFrame.this);
			
			//if image file accept, set it as icon of label
			if(r == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getPath();
				logger.log(Level.FINE, "Reading file file {0}", name);
				label.setIcon(new ImageIcon(name));
			}else logger.fine("File open dialog canceled.");
			logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
		}
	}
}

/**
 * A handler for displaying log records in a window.
 */
class WindowHandler extends StreamHandler{
	private JFrame frame;
	
	public WindowHandler() {
		frame = new JFrame();
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		setOutputStream(new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
				// TODO Auto-generated method stub
				
			}// not called
			
			public void write(byte[] b, int off, int len) {
				output.append(new String(b, off, len));
			}
		});
	}
	
	public void publish(LogRecord record) {
		if(!frame.isVisible()) return;
		super.publish(record); //将日志记录发送到希望的目的地
		flush(); //刷新所有已经缓冲的数据
	}
}
































