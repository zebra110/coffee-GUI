package yyd.coffee.model;

import yyd.coffee.view.body.left.MonitoringWarnPanel;

public class Cup extends Material {

	private static int quantity;
	private final int MAX_QUANTITY = 10;
	private final int QUANTITY_PER_CUP = 1;
	
	public Cup() {
		Cup.quantity = 0;
	}
	
	public Cup(int quantity){
		Cup.quantity = quantity;
	}
	
	public void fill(){
		Cup.quantity = MAX_QUANTITY;
	}
	
	public void useOneCup(){
		if (Cup.quantity >= QUANTITY_PER_CUP) {
			Cup.quantity -= QUANTITY_PER_CUP;
		}
		if (this.isNone()) {
			MonitoringWarnPanel.getAnInstance().getCupWarn().setWarnOn();
		}
	}
	
	@Override
	public boolean isNone() {
		// TODO Auto-generated method stub
		return quantity==0;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		Cup.quantity = quantity;
	}

}
