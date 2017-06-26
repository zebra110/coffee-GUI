package yyd.coffee.model;

import yyd.coffee.view.body.left.MonitoringWarnPanel;

public class PowderMilktea extends Material {

	private static int weight;
	private final static int MAX_WEIGHT = 100;
	private final static int WEIGHT_PER_CUP = 10;

	public PowderMilktea() {
		PowderMilktea.weight = 0;
	}

	public PowderMilktea(int weight) {
		PowderMilktea.weight = weight;
	}

	public void useOneCupOfMilkteaPowder() {
		if (PowderMilktea.weight >= WEIGHT_PER_CUP) {
			PowderMilktea.weight -= WEIGHT_PER_CUP;
		}
		if (this.isNone()) {
			MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().setWarnOn();
		}
	}

	public void fill() {
		this.setWeight(MAX_WEIGHT);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		PowderMilktea.weight = weight;
	}

	@Override
	public String toString() {
		return "" + weight;
	}

	@Override
	public boolean isNone() {
		// TODO Auto-generated method stub
		return PowderMilktea.weight==0;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return PowderMilktea.weight;
	}
}
