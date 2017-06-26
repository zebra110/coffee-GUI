package yyd.coffee.view.body.left;

import javax.swing.JLabel;

public class IndicatorLabel extends JLabel{
	
	private String label;

	public IndicatorLabel(String label) {
		this.label = label;
		this.setText(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		this.setText(label);
	}
	
}
