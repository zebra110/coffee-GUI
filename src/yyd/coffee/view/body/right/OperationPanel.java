package yyd.coffee.view.body.right;

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
import yyd.coffee.util.AudioPlayer;
import yyd.coffee.view.body.center.AnimationPanel;
import yyd.coffee.view.body.center.MonitoringShowPanel;

public class OperationPanel extends JPanel implements ActionListener{
	private JButton putCoin;
	private JButton getCoin;
	private JButton takeCoffee;

	private static OperationPanel operationPanel = null;
	
	private OperationPanel() {
		
		putCoin = new JButton("Í¶    ±Ò");
		getCoin = new JButton("ÍË    ±Ò");
		takeCoffee = new JButton("È¡    ³ö");
		
		this.setLayout(new GridLayout(3,1));
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.add(putCoin);
		this.add(getCoin);
		this.add(takeCoffee);
		
		putCoin.addActionListener(this);
		getCoin.addActionListener(this);
		takeCoffee.addActionListener(this);
	}

	public static OperationPanel getAnInstance(){
		if (operationPanel == null){
			operationPanel = new OperationPanel();
		}
		return operationPanel;
	}

	Coin coin;
	Cup cup = new Cup();
	Status status = new Status();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == putCoin) {
			AudioPlayer audioPlayer = new AudioPlayer("/resource/audio/putCoin.wav");
			audioPlayer.playAudio();
			coin = MonitoringShowPanel.getAnInstance().getCoinNumber().getCoin();
			coin.putOneCoin();
			MonitoringShowPanel.getAnInstance().getCoinNumber().setCoinText(coin.getNumber());
			if(Status.isMaking() == false) {
				status.updateMessage();
			}
		}
		
		if (e.getSource() == getCoin) {
			coin = MonitoringShowPanel.getAnInstance().getCoinNumber().getCoin();
			if (coin.hasCoin() && Coin.isGetatable()) {
				AudioPlayer audioPlayer = new AudioPlayer("/resource/audio/getCoin.wav");
				audioPlayer.playAudio();
				coin.setNumber(0);
				MonitoringShowPanel.getAnInstance().getCoinNumber().setCoinText(coin.getNumber());
			}
		}
		
		if (e.getSource() == takeCoffee) {
			if(Status.isMaking()){
				coin = MonitoringShowPanel.getAnInstance().getCoinNumber().getCoin();
				Coin.setGetatable(true);
				cup.useOneCup();
				AnimationPanel.getAnInstance().takeOut();
				Status.setIsMaking(false);
				status.updateMonitoringWarnPanel();
				status.updateMessage();
			} else {
				status.updateMessage();
				return;
			}
		}
	}
}
