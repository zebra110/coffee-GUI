package yyd.coffee.model;

import yyd.coffee.view.body.left.MonitoringWarnPanel;

public class Water extends Material {

	private static int volumn;
	private final int MAX_VOLUMN = 2000;
	private final int VOLUMN_PER_CUP = 200;

	public Water() {
		// TODO Auto-generated constructor stub
		Water.volumn = 0;
	}

	public Water(int volumn) {
		Water.volumn = volumn;
	}

	public void useOneCupOfWater(){
		if (Water.volumn >= VOLUMN_PER_CUP) {
			Water.volumn -= VOLUMN_PER_CUP;
		}
		if (this.isNone()) {
			MonitoringWarnPanel.getAnInstance().getWaterWarn().setWarnOn();
		}
	}

	public void fill(){
		setVolumn(MAX_VOLUMN);
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		Water.volumn = volumn;
	}

	@Override
	public boolean isNone() {
		// TODO Auto-generated method stub
		return volumn==0;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return ""+volumn;
	}
}
