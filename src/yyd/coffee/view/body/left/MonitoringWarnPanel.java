package yyd.coffee.view.body.left;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MonitoringWarnPanel extends JPanel {
	private Indicator waterWarn;
	private Indicator powderCoffeeWarn;
	private Indicator powderMilkteaWarn;
	private Indicator sugarWarn;
	private Indicator cupWarn;

	private static MonitoringWarnPanel monitoringWarnPanel = null;
	
	private MonitoringWarnPanel() {
		this.setLayout(new GridLayout(5,1));
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		waterWarn = new Indicator("«Îº”ÀÆ     ");
		powderCoffeeWarn = new Indicator("«Îº”øß∑»");
		powderMilkteaWarn = new Indicator("«Îº”ƒÃ≤Ë");
		sugarWarn = new Indicator("«Îº”Ã«     ");
		cupWarn = new Indicator("«Îº”±≠     ");
		
		this.add(waterWarn);
		this.add(powderCoffeeWarn);
		this.add(powderMilkteaWarn);
		this.add(sugarWarn);
		this.add(cupWarn);
		
	}
	
	public static MonitoringWarnPanel getAnInstance(){
		if (monitoringWarnPanel == null){
			monitoringWarnPanel = new MonitoringWarnPanel();
		}
		return monitoringWarnPanel;
	}

	public Indicator getWaterWarn() {
		return waterWarn;
	}

	public Indicator getPowderCoffeeWarn() {
		return powderCoffeeWarn;
	}

	public Indicator getPowderMilkteaWarn() {
		return powderMilkteaWarn;
	}

	public Indicator getSugarWarn() {
		return sugarWarn;
	}

	public Indicator getCupWarn() {
		return cupWarn;
	}
}
