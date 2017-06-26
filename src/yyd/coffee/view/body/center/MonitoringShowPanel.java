package yyd.coffee.view.body.center;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonitoringShowPanel extends JPanel {
	
	private JLabel waterTemperatureLabel;
	private JLabel waterTemperature;
	private CoinNumberLabel coinNumber;
	private JLabel coinNumberLabel;

	private static MonitoringShowPanel monitoringShowPanel = null;

	private MonitoringShowPanel() {
		this.setLayout(new GridLayout(1, 4));
		this.setBackground(Color.decode("#4C4442"));

		waterTemperatureLabel = new JLabel("Ë®ÎÂ:");
		waterTemperature = new JLabel("95¡æ");
		coinNumberLabel = new JLabel("±ÒÖµ:");
		coinNumber = new CoinNumberLabel();
		
		waterTemperatureLabel.setForeground(Color.decode("#46A7CB"));
		waterTemperature.setForeground(Color.decode("#46A7CB"));
		coinNumberLabel.setForeground(Color.decode("#FFC423"));
		coinNumber.setForeground(Color.decode("#FFC423"));

		this.add(waterTemperatureLabel);
		this.add(waterTemperature);
		this.add(coinNumberLabel);
		this.add(coinNumber);
	}

	public static MonitoringShowPanel getAnInstance() {
		if (monitoringShowPanel == null) {
			monitoringShowPanel = new MonitoringShowPanel();
		}
		return monitoringShowPanel;
	}

	public CoinNumberLabel getCoinNumber() {
		return coinNumber;
	}
}
