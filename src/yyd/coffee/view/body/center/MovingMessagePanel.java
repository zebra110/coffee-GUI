package yyd.coffee.view.body.center;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingMessagePanel extends JPanel {

	private String message = "";
	private int xCoordinate = 0;
	private int yCoordinate = 14;
	
	private static MovingMessagePanel movingMessagePanel = null;

	private MovingMessagePanel() {
		this.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		this.setForeground(Color.decode("#dddddd"));
		this.setBackground(Color.decode("#8B3517"));
		
		Timer timer = new Timer(25, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (xCoordinate > getWidth()) {
			xCoordinate = -100;
		}
		xCoordinate += 1;
		g.drawString(message, xCoordinate, yCoordinate);
	}

	public static MovingMessagePanel getAnInstance(){
		if (movingMessagePanel == null) {
			movingMessagePanel = new MovingMessagePanel();
		}
		return movingMessagePanel;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		repaint();
	}
}
