package yyd.coffee.view.body.left;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.security.auth.Subject;
import javax.swing.JPanel;

import yyd.coffee.model.PowderCoffee;

public class Indicator extends JPanel {

	private Light light;
	private IndicatorLabel indicatorLabel;
	
	
	
	public Indicator(String label) {
		
		indicatorLabel = new IndicatorLabel(label); 
		light = new Light();
		
		this.setLayout(new FlowLayout());
		this.add(light);
		this.add(indicatorLabel);
		this.setBackground(new Color(208,233,255));
	}
	
	public void setWarnOn(){
		light.turnOff();
		light.repaint();
	}
	
	public void setWarnOff(){
		light.turnOn();
		light.repaint();
	}
	
	public Light getLight() {
		return light;
	}

	public IndicatorLabel getIndicatorLabel() {
		return indicatorLabel;
	}

}
