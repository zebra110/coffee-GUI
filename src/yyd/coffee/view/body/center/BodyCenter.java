package yyd.coffee.view.body.center;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BodyCenter extends JPanel {

	private MonitoringShowPanel monitoringShowPanel;

	public BodyCenter() {
		monitoringShowPanel = MonitoringShowPanel.getAnInstance();
		AnimationPanel animationPanel = AnimationPanel.getAnInstance();
		MovingMessagePanel messagePanel = MovingMessagePanel.getAnInstance();
		messagePanel.setMessage("欢迎使用咖啡机");

		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
		this.add(monitoringShowPanel, BorderLayout.NORTH);
		this.add(animationPanel, BorderLayout.CENTER);
		this.add(messagePanel, BorderLayout.SOUTH);
	}

	protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        // 绘制渐变
        g2.setPaint(new GradientPaint(getWidth()/2, 0, new Color(70, 70, 70),  getWidth()/2, getHeight(), new Color(142, 52, 21)));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
