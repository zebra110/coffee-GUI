package yyd.coffee.view.body.left;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import yyd.coffee.controller.Status;
import yyd.coffee.model.Coin;
import yyd.coffee.model.Cup;
import yyd.coffee.model.Sugar;
import yyd.coffee.model.Water;
import yyd.coffee.view.body.center.MovingMessagePanel;

public class ChoicePanel extends JPanel implements ActionListener {

	private JButton weakcoffee;
	private JButton espresso;
	private JButton milktea;
	private static ChoicePanel choicePanel = null;

	private ChoicePanel() {

		this.setLayout(new GridLayout(3, 1));
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		weakcoffee = new JButton("µ­¿§·È1$");
		espresso = new JButton("Å¨¿§·È2$");
		milktea = new JButton("ÄÌ ²è1$");

		weakcoffee.addActionListener(this);
		espresso.addActionListener(this);
		milktea.addActionListener(this);

		this.add(weakcoffee);
		this.add(espresso);
		this.add(milktea);
	}

	public static ChoicePanel getAnInstance() {
		if (choicePanel == null) {
			choicePanel = new ChoicePanel();
		}
		return choicePanel;
	}

	Coin coin = new Coin();
	Cup cup = new Cup();
	Water water = new Water();
	Sugar sugar = new Sugar();
	Status status = new Status();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if (b == weakcoffee){
			if (Status.isMaking() == true) {
				return;
			} else {
				status.prepareMaking(Status.WEAKCOFFEE);
				MovingMessagePanel.getAnInstance().setMessage("µ­¿§·È");
				status.updateMessage();
			}
		}

		if (b == espresso){
			if (Status.isMaking() == true) {
				return;
			} else {
				status.prepareMaking(Status.ESPRESSO);
				MovingMessagePanel.getAnInstance().setMessage("Å¨¿§·È");
				status.updateMessage();
			}
		}

		if (b == milktea){
			if (Status.isMaking() == true) {
				return;
			} else {
				status.prepareMaking(Status.MILKTEA);
				MovingMessagePanel.getAnInstance().setMessage("ÄÌ    ²è");
				status.updateMessage();
			}
		}
	}
}
