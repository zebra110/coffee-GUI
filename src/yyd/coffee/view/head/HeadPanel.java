package yyd.coffee.view.head;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import yyd.coffee.view.ImagePanel;

public class HeadPanel extends ImagePanel {

	public HeadPanel(String imgPath) {
		super(imgPath);
	}
	
	// 绘制渐变
	protected void paintComponent(Graphics g) {  
        Graphics2D g2 = (Graphics2D) g;  
        super.paintComponent(g);  
        // 设置俩点
        g2.setPaint(new GradientPaint(getWidth()/2, 0, new Color(142, 54, 33),  getWidth()/2, getHeight(), new Color(70, 70, 70)));  
        // 填充绘制
        g2.fillRect(0, 0, getWidth(), getHeight());  
    }
}
