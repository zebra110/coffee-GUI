package yyd.coffee.view.body.right;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BodyRight extends JPanel {

	private MaintainPanel maintianPanel;
	private OperationPanel operationPanel;
	
	public BodyRight() {
		maintianPanel = MaintainPanel.getAnInstance();
		operationPanel = OperationPanel.getAnInstance();
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
		this.add(maintianPanel, BorderLayout.NORTH);
		this.add(operationPanel, BorderLayout.SOUTH);
	}
	
	protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;  
        super.paintComponent(g);  
        // ªÊ÷∆Ω•±‰  
        g2.setPaint(new GradientPaint(getWidth()/2, 0, new Color(70, 70, 70),  getWidth()/2, getHeight(), new Color(142, 52, 21)));  
        g2.fillRect(0, 0, getWidth(), getHeight());  
    }
}
