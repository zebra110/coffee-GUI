package yyd.coffee.model;

import yyd.coffee.view.body.left.MonitoringWarnPanel;

public class Sugar extends Material {

	private static int weight;
	private final static int MAX_WEIGHT = 50;
	private final static int WEIGHT_PER_CUP = 5;

	public Sugar() {
		// TODO Auto-generated constructor stub
		Sugar.weight = 0;
	}

	public Sugar(int weight) {
		Sugar.weight = weight;
	}

	public void useOneCupOfSugar(){
		if (Sugar.weight >= WEIGHT_PER_CUP) {
			Sugar.weight -= WEIGHT_PER_CUP;
		}
		if (this.isNone()) {
			MonitoringWarnPanel.getAnInstance().getSugarWarn().setWarnOn();
		}
	}

	public void fill(){
		setWeight(MAX_WEIGHT);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		Sugar.weight = weight;
	}

	@Override
	public boolean isNone() {
		// TODO Auto-generated method stub
		return weight==0;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public String toString() {
		return ""+weight;
	}
}
