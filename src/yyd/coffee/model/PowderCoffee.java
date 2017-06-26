package yyd.coffee.model;

import yyd.coffee.view.body.left.MonitoringWarnPanel;

public class PowderCoffee extends Material {

	private static int weight;
	private final static int MAX_WEIGHT = 100;
	private final static int WEIGHT_PER_ESPRESSO_CUP = 10;
	private final static int WEIGHT_PER_WEAK_CUP = 5;

	public PowderCoffee() {
		PowderCoffee.weight = 0;
	}

	public PowderCoffee(int weight){
		PowderCoffee.weight = weight;
	}

	public void useOneCupOfEspressPowder(){
		if (PowderCoffee.weight >= WEIGHT_PER_ESPRESSO_CUP) {
			PowderCoffee.weight -= WEIGHT_PER_ESPRESSO_CUP;
		}
		if (this.isNone()) {
			MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().setWarnOn();
		}
	}

	public void useOneCupOfWeakPower(){
		if (PowderCoffee.weight >= WEIGHT_PER_WEAK_CUP) {
			PowderCoffee.weight -= WEIGHT_PER_WEAK_CUP;
		}
		if (this.isNone()) {
			MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().setWarnOn();
		}
	}

	public void fill(){
		this.setWeight(MAX_WEIGHT);
	}

	public int getWeight(){
		return weight;
	}

	public void setWeight(int weight){
		PowderCoffee.weight = weight;
	}

	@Override
	public String toString() {
		return ""+ weight;
	}

	@Override
	public boolean isNone() {
		// TODO Auto-generated method stub
		return PowderCoffee.weight==0;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return PowderCoffee.weight;
	}

}
