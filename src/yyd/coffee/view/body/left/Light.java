package yyd.coffee.view.body.left;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Light extends JPanel {
	private boolean lightOn = false;

	public Light() {
		this.setBackground(new Color(208, 233, 255));
	}

	public void turnOn() {
		lightOn = true;
	}

	public void turnOff() {
		lightOn = false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (lightOn) {
			g.setColor(new Color(51, 155, 51));
		} else {
			g.setColor(new Color(229, 26, 33));
		}
		g.fillOval(0, 0, 10, 10);
	}

	public boolean isLightOn() {
		return lightOn;
	}
}
