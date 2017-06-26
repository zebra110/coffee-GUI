package yyd.coffee.view.body.right;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import yyd.coffee.controller.Status;
import yyd.coffee.model.Cup;
import yyd.coffee.model.PowderCoffee;
import yyd.coffee.model.PowderMilktea;
import yyd.coffee.model.Sugar;
import yyd.coffee.model.Water;
import yyd.coffee.view.body.left.MonitoringWarnPanel;

public class MaintainPanel extends JPanel implements ActionListener {

	private JButton addWater;
	private JButton addCoffee;
	private JButton addSugar;
	private JButton addCup;
	private static MaintainPanel maintainPanel = null;

	private MaintainPanel() {
		this.setLayout(new GridLayout(4, 1));
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		addWater = new JButton("加水");
		addCoffee = new JButton("加粉");
		addSugar = new JButton("加糖");
		addCup = new JButton("加杯子");

		this.add(addWater);
		this.add(addCoffee);
		this.add(addSugar);
		this.add(addCup);

		addWater.addActionListener(this);
		addCoffee.addActionListener(this);
		addSugar.addActionListener(this);
		addCup.addActionListener(this);
	}

	public static MaintainPanel getAnInstance() {
		if (maintainPanel == null) {
			maintainPanel = new MaintainPanel();
		}
		return maintainPanel;
	}

	private Water water = new Water();
	private Sugar sugar = new Sugar();
	private Cup cup = new Cup();
	private PowderCoffee powderCoffee = new PowderCoffee();
	private PowderMilktea powderMilktea = new PowderMilktea();
	Status status = new Status();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addWater) {
			if (Status.isMaking()) {
				return;
			}
			water.fill();
			MonitoringWarnPanel.getAnInstance().getWaterWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getWaterWarn().getIndicatorLabel().setLabel("水："+water.getVolumn());
			status.updateMessage();
		}

		if (e.getSource() == addCoffee) {
			if (Status.isMaking()) {
				return;
			}
			powderCoffee.fill();
			powderMilktea.fill();
			MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().getIndicatorLabel().setLabel("咖啡："+powderCoffee.getWeight());
			MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().getIndicatorLabel().setLabel("奶茶："+powderMilktea.getWeight());
			status.updateMessage();
		}
		
		

		if (e.getSource() == addSugar) {
			if (Status.isMaking()) {
				return;
			}
			sugar.fill();
			MonitoringWarnPanel.getAnInstance().getSugarWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getSugarWarn().getIndicatorLabel().setLabel("糖："+sugar.getWeight());
			status.updateMessage();
		}

		if (e.getSource() == addCup) {
			if (Status.isMaking()) {
				return;
			}
			cup.fill();
			MonitoringWarnPanel.getAnInstance().getCupWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getCupWarn().getIndicatorLabel().setLabel("杯子："+cup.getQuantity());
			status.updateMessage();
		}
	}

}
