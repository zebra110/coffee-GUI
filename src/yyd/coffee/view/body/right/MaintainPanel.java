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

		addWater = new JButton("��ˮ");
		addCoffee = new JButton("�ӷ�");
		addSugar = new JButton("����");
		addCup = new JButton("�ӱ���");

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
			MonitoringWarnPanel.getAnInstance().getWaterWarn().getIndicatorLabel().setLabel("ˮ��"+water.getVolumn());
			status.updateMessage();
		}

		if (e.getSource() == addCoffee) {
			if (Status.isMaking()) {
				return;
			}
			powderCoffee.fill();
			powderMilktea.fill();
			MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().getIndicatorLabel().setLabel("���ȣ�"+powderCoffee.getWeight());
			MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().getIndicatorLabel().setLabel("�̲裺"+powderMilktea.getWeight());
			status.updateMessage();
		}
		
		

		if (e.getSource() == addSugar) {
			if (Status.isMaking()) {
				return;
			}
			sugar.fill();
			MonitoringWarnPanel.getAnInstance().getSugarWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getSugarWarn().getIndicatorLabel().setLabel("�ǣ�"+sugar.getWeight());
			status.updateMessage();
		}

		if (e.getSource() == addCup) {
			if (Status.isMaking()) {
				return;
			}
			cup.fill();
			MonitoringWarnPanel.getAnInstance().getCupWarn().setWarnOff();
			MonitoringWarnPanel.getAnInstance().getCupWarn().getIndicatorLabel().setLabel("���ӣ�"+cup.getQuantity());
			status.updateMessage();
		}
	}

}
