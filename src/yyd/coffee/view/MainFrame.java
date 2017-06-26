package yyd.coffee.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import yyd.coffee.util.ScreenUtil;
import yyd.coffee.view.body.BodyPanel;
import yyd.coffee.view.footer.FooterPanel;
import yyd.coffee.view.head.HeadPanel;

public class MainFrame  {
	 
	private JFrame mainFrame1;
	final int WINDOW_WIDTH = 400;
	final int WINDOW_HEIGHT = ScreenUtil.getScreenHeight() - 220;
//	final int a=BodyPanel.T();
	private static MainFrame mainFrame = null;

	private MainFrame() {
		mainFrame1 = new JFrame();
		mainFrame1.setTitle("咖啡机");
		mainFrame1.setLayout(new BorderLayout());
		mainFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame1.setResizable(false);
		mainFrame1.setLocation((ScreenUtil.getScreenWidth() - WINDOW_WIDTH)/2, 0);
		mainFrame1.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		BodyPanel bodyPanel = new BodyPanel();
		HeadPanel headPanel = new HeadPanel("/resource/image/top.png");
		FooterPanel footerPanel = new FooterPanel("/resource/image/bottom.png");

		this.mainFrame1.add(headPanel, BorderLayout.NORTH);
		this.mainFrame1.add(bodyPanel, BorderLayout.CENTER);
		this.mainFrame1.add(footerPanel, BorderLayout.SOUTH);
		this.mainFrame1.setVisible(true);
		
		//时时刷新界面
		Timer timer = new Timer(550, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame1.repaint();
			}
		});
		timer.start();
	}
	
	public static MainFrame getAnInstance() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
		}
		return mainFrame;
	}
}
