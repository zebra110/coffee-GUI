package yyd.coffee.model;

import java.util.Observable;

public class Coin extends Observable{
	private static int number = 0;
	private static boolean getatable = true;//用于判断当前是否可以退币

	public Coin() {
		// TODO Auto-generated constructor stub
	}

	public void putOneCoin() {
		Coin.number += 1;
	}

	public boolean hasCoin() {
		return (number > 0) ? true : false;
	}

	public void useOneCoin() {
		if (Coin.number > 0) {
			Coin.number -= 1;
		}
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		Coin.number = number;
	}
	

	public static boolean isGetatable() {
		return getatable;
	}

	public static void setGetatable(boolean getatable) {
		Coin.getatable = getatable;
	}

	@Override
	public String toString() {
		return "" + number;
	}
}
