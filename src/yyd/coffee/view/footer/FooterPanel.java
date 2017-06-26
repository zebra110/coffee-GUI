package yyd.coffee.view.footer;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import yyd.coffee.view.ImagePanel;

public class FooterPanel extends ImagePanel {

	public FooterPanel(String imgPath) {
		super(imgPath);
	}
	
	protected void paintComponent(Graphics g) {  
        Graphics2D g2 = (Graphics2D) g;  
        super.paintComponent(g);  
        // ªÊ÷∆Ω•±‰  
        g2.setPaint(new GradientPaint(getWidth()/2, 0, new Color(142, 54, 21),  getWidth()/2, getHeight(), new Color(142, 52, 33)));  
        g2.fillRect(0, 0, getWidth(), getHeight());  
    }
}
